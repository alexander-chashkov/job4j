package ru.job4j.collection;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 02.07.2020
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        for (int i = 0; i < right.length(); i++) {
            if (left.indexOf(right.charAt(i)) < 0) {
                return false;
            } else {
                left = left.replaceFirst(right.charAt(i) + "", "");
            }
        }
        return true;
    }
}
