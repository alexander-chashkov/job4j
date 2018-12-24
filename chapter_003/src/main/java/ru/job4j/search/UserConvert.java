package ru.job4j.search;

import java.util.HashMap;
import java.util.List;
/**
 * class UserConvert
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.24
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
