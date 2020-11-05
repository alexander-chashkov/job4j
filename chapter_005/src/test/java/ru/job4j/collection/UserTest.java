package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 21.06.2020
 */
public class UserTest {

    @Test
    public void whenAdd2IdentUsrThenHashEqual() {
        User usr = new User("Alex", 2, new GregorianCalendar(2020, 5 , 21));
        User usr2 = new User("Alex", 2, new GregorianCalendar(2020, 5 , 21));
        assertEquals(usr.hashCode(), usr2.hashCode());
    }

    @Test
    public void whenAdd2NotIdentUsrThenHashNotEqual() {
        User usr = new User("Alex", 2, new GregorianCalendar(2020, 5 , 21));
        User usr2 = new User("Sasha", 2, new GregorianCalendar(2020, 5 , 21));
        assertNotEquals(usr.hashCode(), usr2.hashCode());
    }

    @Test
    public void whenAdd2() {
        User usr = new User("Alex", 2, new GregorianCalendar(2020, 5 , 21));
        User usr2 = new User("Alex", 2, new GregorianCalendar(2020, 5 , 21));
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(usr, "1");
        map.put(usr2, "2");

        System.out.println(map.toString());
        System.out.println(1000000 >> 16);
        System.out.println(Math.pow(2, 16));
        System.out.println((1000000 - (1000000 % Math.pow(2, 16))) / Math.pow(2, 16));
        System.out.println(10 << 1);
        assertEquals(usr.hashCode(), usr2.hashCode());
    }
}
