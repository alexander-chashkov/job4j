package ru.job4j.list;

import java.util.Comparator;

/**
 *  @version 0.0.0.1
 *  @since 2019.01.20
 *  @author Chashkov Alexander
 */
public class ListCompare implements Comparator<String> {
    /**
     * @param left строка1
     * @param right строка 2
     * @return 0 равны, -1 прав больше, 1 левая больше
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < Math.min(left.length(), right.length()) && result == 0; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (result == 0 && left.length() != right.length()) {
            result = left.length() > right.length() ? 1 : -1;
        }
        return result;
    }
}
