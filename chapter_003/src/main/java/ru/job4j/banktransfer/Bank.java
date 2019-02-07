package ru.job4j.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User usr = new User("", passport);
        if (this.userAccounts.get(usr) == null) {
            this.addUser(usr);
        }
        this.userAccounts.get(usr).add(account);
    }

    /**
     * Удаляет у пользователя аккаут
     * @param passport паспорт
     * @param account аккаунт
     */
    public void deleteAccountFromUser(String passport, Account account){
        List<Account> accs = this.userAccounts.get(new User("", passport));
        accs.remove(accs.indexOf(account));
    }

    /**
     * Возвращает аккаунты пользователя
     * @param passport паспорт
     * @return аккаунты пользователя
     */
    public List<Account> getUserAccounts (String passport) {
        return this.userAccounts.get(new User("", passport));
    }

    /**
     * @param srcPassport Паспорт откуда переводят
     * @param srcRequisite реквизиты откуда переводят
     * @param destPassport Паспорт куда переводят
     * @param dstRequisite реквизиты куда переводят
     * @param amount колво
     * @return true - перевод состоялся иначе false
     */
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        List<Account> accsSrc = this.getUserAccounts(srcPassport);
        List<Account> accsDst = this.getUserAccounts(destPassport);
        Account srcAcc = new Account(srcRequisite, 0);
        Account dstAcc = new Account(dstRequisite, 0);
        if (accsSrc != null && accsDst != null && accsSrc.indexOf(srcAcc) != -1 && accsDst.indexOf(dstAcc) != -1 &&
                accsSrc.get(accsSrc.indexOf(new Account(srcRequisite, 0))).getValue() >= amount) {
            double amSrc = accsSrc.get(accsSrc.indexOf(srcAcc)).getValue();
            double amDst = accsDst.get(accsDst.indexOf(dstAcc)).getValue();
            accsSrc.get(accsSrc.indexOf(srcAcc)).setValue(amSrc - amount);
            accsDst.get(accsDst.indexOf(dstAcc)).setValue(amDst + amount);
            result = true;
        }
        return result;
    }
}
