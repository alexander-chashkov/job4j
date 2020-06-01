package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2020.06.01
 *
 */
public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return mem.set(Integer.parseInt(id), model).getId().equals(model.getId());
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(Integer.parseInt(id)) != null;
    }

    @Override
    public T findById(String id) {
        return mem.get(Integer.parseInt(id));
    }
}
