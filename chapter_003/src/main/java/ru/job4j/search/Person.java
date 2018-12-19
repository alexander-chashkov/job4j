package ru.job4j.search;

/**
 * class person
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.18
 */

public class Person {
    /**
     * имя
     */
    private String name;
    /**
     * фамилия
     */
    private String surname;
    /**
     * номер тел
     */
    private String phone;
    /**
     * адрес
     */
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAllInfo() {
        StringBuilder result = new StringBuilder();
        result.append(this.surname);
        result.append(" ");
        result.append(this.phone);
        result.append(" ");
        result.append(this.name);
        result.append(" ");
        result.append(this.address);
        return result.toString();
    }
}
