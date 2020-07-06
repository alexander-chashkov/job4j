package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 02.07.2020
 */
public class UserMergerTest {

    @Test
    public void whenAddExample() {
        List<UserMerger.User> listUsers = new ArrayList<>();
        listUsers.add(new UserMerger.User("user1").addEmails("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        listUsers.add(new UserMerger.User("user2").addEmails("foo@gmail.com", "ups@pisem.net"));
        listUsers.add(new UserMerger.User("user3").addEmails("xyz@pisem.net", "vasya@pupkin.com"));
        listUsers.add(new UserMerger.User("user4").addEmails("ups@pisem.net", "aaa@bbb.ru"));
        listUsers.add(new UserMerger.User("user5").addEmails("xyz@pisem.net"));
        Map<UserMerger.User, Set<String>> mergUsers = UserMerger.User.getMergedListUsers(listUsers);
        mergUsers.keySet().stream().forEach(u -> {
            if (u.getName().equals("user1")) {
                assertThat(u.getName() + " ->" + mergUsers.get(u).toString(), is("user1 ->[aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com]"));
            }
            if (u.getName().equals("user3")) {
                assertThat(u.getName() + " ->" + mergUsers.get(u).toString(), is("user3 ->[vasya@pupkin.com, xyz@pisem.net]"));
            }
        });
    }

    @Test
    public void whenAddExample2() {
        List<UserMerger.User> listUsers = new ArrayList<>();
        listUsers.add(new UserMerger.User("user1").addEmails("1@ya.ru", "2o@gmail.com", "3@mail.ru"));
        listUsers.add(new UserMerger.User("user2").addEmails("4@gmail.com", "5s@pisem.net"));
        listUsers.add(new UserMerger.User("user3").addEmails("6@pisem.net", "7@pupkin.com"));
        listUsers.add(new UserMerger.User("user4").addEmails("8@pisem.net", "9@bbb.ru"));
        listUsers.add(new UserMerger.User("user5").addEmails("9@bbb.ru"));
        Map<UserMerger.User, Set<String>> mergUsers = UserMerger.User.getMergedListUsers(listUsers);
        mergUsers.keySet().stream().forEach(u -> {
            if (u.getName().equals("user2")) {
                assertThat(u.getName() + " ->" + mergUsers.get(u).toString(), is("user2 ->[5s@pisem.net, 4@gmail.com]"));
            }
            if (u.getName().equals("user1")) {
                assertThat(u.getName() + " ->" + mergUsers.get(u).toString(), is("user1 ->[1@ya.ru, 3@mail.ru, 2o@gmail.com]"));
            }
        });
    }
}
