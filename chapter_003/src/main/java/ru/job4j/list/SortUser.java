package ru.job4j.list;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *  @version 0.0.0.1
 *  @since 2019.01.16
 *  @author Chashkov Alexander
 */
public class SortUser {
    /**
     * @param list список объектов
     * @return отсортированый по возрасту TreeSet
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
