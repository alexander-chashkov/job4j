package ru.job4j.generic;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2020.06.01
 *
 */

public class User extends Base {
    private String name;

    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
