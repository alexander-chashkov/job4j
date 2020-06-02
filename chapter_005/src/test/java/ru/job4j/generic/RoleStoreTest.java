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
        rs.add(new Role("role5"));
        rs.add(new Role("role2"));
    }

    @Test
    public void whenAdd2ElThen2El() {
        Role role1 = rs.findById("role1");
        Role role2 = rs.findById("role2");
        var expected = "role1role2";
        assertEquals(role1.getId() + role2.getId(), expected);
    }

    @Test
    public void whenAdd2ElAndReplaceElThenRole3() {
        rs.replace("role1", new Role("role3"));
        Role role3 = rs.findById("role3");
        rs.delete("role2");
        var expected = "role3";
        assertEquals(role3.getId(), expected);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAdd2ElAndDeleteElThen1El() {
        rs.delete("role1");
        rs.findById("role1");
    }
}
