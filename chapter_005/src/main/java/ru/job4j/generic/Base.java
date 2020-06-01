package ru.job4j.generic;
/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2019.04.24
 *
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
