package ru.job4j.banktransfer;

import java.util.Objects;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.02.04
 * class Account
 */
public class Account {
    /**
     * колво денег на аккаунте
     */
    private double value;
    /**
     * реквизиты аккаунта
     */
    private String requisites;

    public Account(String requisites, double value) {
        this.setValue(value);
        this.setRequisites(requisites);
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
