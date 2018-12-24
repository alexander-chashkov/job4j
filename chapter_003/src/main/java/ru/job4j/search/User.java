package ru.job4j.search;
/**
 * class User
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.24
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{id = " + id + ", name = " + name + " city = " + city + "}";
    }
    @Override
    public boolean equals(Object object) {
        boolean result = true;
        if (!this.toString().equals(object.toString())) {
            result = false;
        }
        return result;
    }
    @Override
    public int hashCode() {
        return this.getId();
    }
}
