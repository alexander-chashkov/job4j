package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *  @version 0.0.0.1
 *  @since 2019.01.16
 *  @author Chashkov Alexander
 *  test class
 */
public class SortUserTest {
    /**
     * test three users
     */
    @Test
    public void whenSortThreeUsers() {
        User user1 = new User("Alexandro", 21);
        User user2 = new User("Pete", 35);
        User user3 = new User("Petr", 24);
        List list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        SortUser su = new SortUser();
        su.sort(list);
        Set ts = new TreeSet<User>();
        ts.add(user1);
        ts.add(user3);
        ts.add(user2);
        assertThat(su.sort(list).toString(), is(ts.toString()));
    }

    @Test
    public void whenSortFiveUsers() {
        User user1 = new User("Alexandro", 21);
        User user2 = new User("Pete", 35);
        User user3 = new User("Petr", 24);
        User user4 = new User("Serg", 18);
        User user5 = new User("Vlad", 22);
        List list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        SortUser su = new SortUser();
        su.sort(list);
        Set ts = new TreeSet<User>();
        ts.add(user4);
        ts.add(user1);
        ts.add(user5);
        ts.add(user3);
        ts.add(user2);
        assertThat(su.sort(list).toString(), is(ts.toString()));
    }
}
