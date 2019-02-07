package ru.job4j.banktransfer;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.07
 *  @author Chashkov Alexander
 *  тесты для Bank test
 */
public class BankTest {

    /**
     * тест перевод 10
     */
    @Test
    public void whenTransfer10() {
        Bank bnk = new Bank();
        bnk.addAccountToUser("56", new Account("01", 90));
        bnk.addAccountToUser("63", new Account("09", 40));
        bnk.transferMoney("56", "01", "63", "09", 10);
        assertEquals(80, bnk.getUserAccounts("56").get(0).getValue(), 0.001);
    }


    /**
     * тесты перевод несуществующий аккаунт
     */
    @Test
    public void whenTransferNotFoundAcc() {
        Bank bnk = new Bank();
        bnk.addAccountToUser("56", new Account("01", 90));
        bnk.addAccountToUser("63", new Account("09", 40));
        assertEquals(false,  bnk.transferMoney("56", "02", "63", "09", 10));
    }


    /**
     * тесты перевод несуществующий паспорт
     */
    @Test
    public void whenTransferNotFoundPasp() {
        Bank bnk = new Bank();
        bnk.addAccountToUser("56", new Account("01", 90));
        bnk.addAccountToUser("63", new Account("09", 40));
        assertEquals(false,  bnk.transferMoney("59", "02", "63", "09", 10));
    }

    /**
     * тесты перевод несуществующий паспорт
     */
    @Test
    public void whenTransferInsufficient() {
        Bank bnk = new Bank();
        bnk.addAccountToUser("56", new Account("01", 90));
        bnk.addAccountToUser("63", new Account("09", 40));
        assertEquals(false,  bnk.transferMoney("56", "02", "63", "09", 100));
    }





}
