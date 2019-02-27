package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *  @version 0.0.0.1
 *  @since 2019.02.27
 *  @author Chashkov Alexander
 *  тесты
 */
public class ProfilesTest {
    @Test
    public void whenAddTwoProfileThenGetTwoAddress() {
        Profiles profiles = new Profiles();
        List<Profile> lp = new ArrayList<>();
        lp.add(new Profile(new Address("Oren", "Gagarina", 18, 12)));
        lp.add(new Profile(new Address("Ufa", "Mira", 1, 2)));
        List<Address> res = profiles.collect(lp);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Oren", "Gagarina", 18, 12));
        expected.add(new Address("Ufa", "Mira", 1, 2));
        assertEquals(res.toString(), expected.toString());
    }
}
