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

    private int findIndexById(String id) {
        var idx = -1;
        var i = idx;
        for (var m : mem) {
            i++;
            if (m.getId().equals(id)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    @Override
    public boolean replace(String id, T model) {
        int idx = findIndexById(id);
        return (idx == -1) ? false : mem.set(idx, model) == model;
    }

    @Override
    public boolean delete(String id) {
        int idx = findIndexById(id);
        return (idx == -1) ? false : mem.remove(idx) != null;
    }

    @Override
    public T findById(String id) {
        int idx = findIndexById(id);
        return (idx == -1) ? null : mem.get(idx);
    }
}
