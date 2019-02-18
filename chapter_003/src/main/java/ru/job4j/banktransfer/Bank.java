package ru.job4j.banktransfer;

import java.util.*;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.02.04
 * class Bank
 */
public class Bank {
    private Map<User, List<Account>> userAccounts;

    public Bank() {
        this.userAccounts = new HashMap<>();
    }

    /**
     * поиск по паспорту
     * @param passport пасспорт для поиска
     * @return найденый юзер иначе null
     */
    public User findUserByPassport(String passport) {
        User usrResult;
        usrResult = this.userAccounts.keySet().stream().filter(usr -> usr.getPasport().equals(passport)).findAny().orElse(null);
        return usrResult;
    }

    /**
     * поиск по паспорту и реквизитам
     * @param requisite реквизиты для поиска
     * @param passport пасспорт для поиска
     * @return найденый Аккаунт иначе null
     */
    public Account findAccountByReq(String passport, String requisite) {
        User usr = this.findUserByPassport(passport);
        Account result = null;
        if (usr != null) {
            List<Account> accs = this.userAccounts.get(usr);
            result = accs.stream().filter(acc -> acc.getRequisites().equals(requisite)).findAny().orElse(null);
        }
        return result;
    }
    /**
     * Добавляет пользователя
     * @param user пользователь
     */
    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя
     * @param user пользователь
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    /**
     * Добавляет пользователю аккаунт
     * @param passport паспорт
     * @param account аккаунт
     */
    public void addAccountToUser(String passport, Account account) {
        User usr = this.findUserByPassport(passport);
        if (usr == null) {
            usr = new User(passport);
            this.addUser(usr);
        }
        this.userAccounts.get(usr).add(account);
    }

    /**
     * Удаляет у пользователя аккаут
     * @param passport паспорт
     * @param account аккаунт
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accs = this.userAccounts.get(this.findUserByPassport(passport));
        if (accs != null && accs.indexOf(account) > -1) {
            accs.remove(accs.indexOf(account));
        }
    }

    /**
     * Возвращает аккаунты пользователя
     * @param passport паспорт
     * @return аккаунты пользователя
     */
    public List<Account> getUserAccounts(String passport) {
        return this.userAccounts.get(this.findUserByPassport(passport));
    }

    /**
     * @param srcPassport Паспорт откуда переводят
     * @param srcRequisite реквизиты откуда переводят
     * @param destPassport Паспорт куда переводят
     * @param dstRequisite реквизиты куда переводят
     * @param amount колво
     * @return true - перевод состоялся иначе false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAcc = this.findAccountByReq(srcPassport, srcRequisite);
        Account dstAcc = this.findAccountByReq(destPassport, dstRequisite);
        if (srcAcc != null && dstAcc != null && srcAcc.getValue() >= amount) {
            double amSrc = srcAcc.getValue();
            double amDst = dstAcc.getValue();
            srcAcc.setValue(amSrc - amount);
            dstAcc.setValue(amDst + amount);
            result = true;
        }
        return result;
    }
}
