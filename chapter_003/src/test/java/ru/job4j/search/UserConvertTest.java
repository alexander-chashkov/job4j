package ru.job4j.search;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * class UserConvertTest
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.24
 */
public class UserConvertTest {
    /**
     * 2user = 2 userNew
     */
    @Test
    public void whenListTwoUser() {
        List<User> l = new LinkedList<>();
        User user1 = new User(1, "Alex", "Orenburg");
        User user2 = new User(2, "Petr", "Bryansk");
        l.add(user1);
        l.add(user2);
        UserConvert uc = new UserConvert();
        HashMap<Integer, User>  expected = new HashMap<>();
        User user1New = new User(1, "Alex", "Orenburg");
        User user2New = new User(2, "Petr", "Bryansk");
        expected.put(user1New.getId(), user1New);
        expected.put(user2New.getId(), user2New);
        assertTrue(uc.process(l).equals(expected));
    }

    /**
     * 2user != 2 userNew
     */
    @Test
    public void whenListTwoOtherUser() {
        List<User> l = new LinkedList<>();
        User user1 = new User(1, "Alex", "Orenburg");
        User user2 = new User(2, "Petr", "Bryansk");
        l.add(user1);
        l.add(user2);
        UserConvert uc = new UserConvert();
        HashMap<Integer, User>  expected = new HashMap<>();
        User user1New = new User(1, "Alex", "Orenburg");
        User user2New = new User(2, "Sergey", "Bryansk");
        expected.put(user1New.getId(), user1New);
        expected.put(user2New.getId(), user2New);
        assertFalse(uc.process(l).equals(expected));
    }
}
