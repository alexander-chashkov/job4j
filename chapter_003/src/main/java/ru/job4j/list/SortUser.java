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
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        });
        return new TreeSet<>(list);
    }
}
