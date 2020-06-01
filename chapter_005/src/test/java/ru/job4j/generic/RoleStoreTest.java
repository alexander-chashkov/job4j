package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2020.06.01
 *
 */

public class RoleStoreTest {
    private RoleStore rs;

    @Before
    public void initTest() {
        rs = new RoleStore();
        rs.add(new Role("role1"));
        rs.add(new Role("role2"));
    }

    @Test
    public void whenAdd2ElThen2El() {
        Role role0 = rs.findById("0");
        Role role1 = rs.findById("1");
        var expected = "role1role2";
        assertEquals(role0.getId() + role1.getId(), expected);
    }

    @Test
    public void whenAdd2ElAndReplaceElThenRole3() {
        rs.replace("0", new Role("role3"));
        Role role3 = rs.findById("0");
        rs.delete("1");
        var expected = "role3";
        assertEquals(role3.getId(), expected);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAdd2ElAndDeleteElThen1El() {
        rs.delete("1");
        rs.findById("1");
    }
}
