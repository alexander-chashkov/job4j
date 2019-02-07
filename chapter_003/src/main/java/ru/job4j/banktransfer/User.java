package ru.job4j.banktransfer;

import java.util.Objects;
/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.02.04
 * class User
 */
public class User {
    /**
     * имя
     */
    private String name;
    /**
     * паспорт
     */
    private String pasport;
    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(pasport, user.pasport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pasport);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name  + ", pasport=" + pasport + '}';
    }
}
