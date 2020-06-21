package ru.job4j.collection;

import java.util.Calendar;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 21.06.2020
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
