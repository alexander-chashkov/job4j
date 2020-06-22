package ru.job4j.collection;

import java.util.Calendar;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = 1;
        return 31 * result + (name == null ? 0 : name.hashCode()) + children + (birthday == null ? 0 : birthday.hashCode());
    }

}
