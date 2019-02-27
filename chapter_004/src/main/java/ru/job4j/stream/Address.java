package ru.job4j.stream;
/**
 *  @version 0.0.0.1
 *  @since 2019.02.27
 *  @author Chashkov Alexander
 *  класс адрес
 */
public class Address {
        private String city;
        private String street;
        private int home;
        private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Address{" + "city='" + city + '\'' + ", street='" + street + '\'' + ", home=" + home + ", apartment=" + apartment + '}';
    }
}
