package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 02.07.2020
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            map.putIfAbsent(left.charAt(i), 0);
            map.computeIfPresent(left.charAt(i), (key, value) -> value + 1);
        }
        for (int i = 0; i < right.length(); i++) {
            Integer count = map.get(right.charAt(i));
            if (count == null || --count < 0)
                return false;
            map.put(right.charAt(i), count);
        }
        return true;
    }
}
