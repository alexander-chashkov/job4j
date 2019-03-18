package ru.job4j.stream;
/**
 *  @version 0.0.0.1
 *  @since 2019.02.27
 *  @author Chashkov Alexander
 *  класс профиль
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
