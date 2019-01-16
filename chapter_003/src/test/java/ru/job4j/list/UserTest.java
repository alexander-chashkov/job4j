package ru.job4j.list;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 *  @version 0.0.0.1
 *  @since 2019.01.16
 *  @author Chashkov Alexander
 *  класс тестов
 */
public class UserTest {

    /**
     * test1 user1 less user2
     */
    @Test
    public void whenUser1LessUser2ThenMinus1() {
        User user1 = new User("Alexandro", 22);
        User user2 = new User("Pete", 33);
        assertThat(user1.compareTo(user2), is(-1));
    }

    /**
     * test2 user1 equally user2
     */
    @Test
    public void whenUser1EquallyUser2ThenZero() {
        User user1 = new User("Alexandro", 33);
        User user2 = new User("Pete", 33);
        assertThat(user1.compareTo(user2), is(0));
    }

    /**
     * test2 user1 larger user2
     */
    @Test
    public void whenUser1LargerUser2ThenZero() {
        User user1 = new User("Alexandro", 33);
        User user2 = new User("Pete", 22);
        assertThat(user1.compareTo(user2), is(1));
    }


}
