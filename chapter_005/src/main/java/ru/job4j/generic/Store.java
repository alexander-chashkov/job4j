package ru.job4j.generic;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2020.06.01
 *
 */

public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
