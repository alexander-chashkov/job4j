package ru.job4j.collection;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 01.07.2020
 */
public class UserMerger {
    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();
        listUsers.add(new User("user1").addEmails("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        listUsers.add(new User("user2").addEmails("foo@gmail.com", "ups@pisem.net"));
        listUsers.add(new User("user3").addEmails("xyz@pisem.net", "vasya@pupkin.com"));
        listUsers.add(new User("user4").addEmails("ups@pisem.net", "aaa@bbb.ru"));
        listUsers.add(new User("user5").addEmails("xyz@pisem.net"));
        Map<User, Set<String>> mergUsers = User.getMergedListUsers(listUsers);
        mergUsers.keySet().stream().forEach(System.out::println);
    }

    public static class User implements Comparable {
        private String name;
        private Set<String> emails;

        public User(String name) {
            this.name = name;
            this.emails = new HashSet<>();
        }

        public User addEmails(String... newEmails) {
            for (String email : newEmails) {
                this.emails.add(email);
            }
            return this;
        }

        public User addEmails(Set<String> newEmails) {
            emails.addAll(newEmails);
            return this;
        }

        public void addEmail(String email) {
            this.emails.add(email);
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<String> getEmails() {
            return this.emails;
        }

        public String getName() {
            return this.name;
        }

        public static Map<User, Set<String>> getMergedListUsers(List<User> listUsers) {
            Map<User, Set<String>> result = new HashMap<>();
            Map<String, User> emails = new HashMap<>();
            listUsers.forEach(us -> {
                us.getEmails().stream().forEach(em -> {
                    User usr = emails.get(em);
                    if (usr != null && !usr.equals(us)) {
                        us.setName(usr.getName());
                    }
                    else {
                        emails.put(em, us);
                    }

                });
                result.putIfAbsent(us, us.getEmails());
                result.computeIfPresent(us, (key, value) -> us.addEmails(value).getEmails());
            });

            return result;
        }

        @Override
        public int compareTo(Object o) {
            if (o == this) return 0;
            if (o == null) return 1;
            User tmp = (User) o;
            return this.name.compareTo(tmp.getName());
        }

        @Override
        public String toString() {
            return  name + " ->" + emails;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
