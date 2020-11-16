package ru.job4j;


import java.util.*;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 10.11.2020
 */
public class Example {
    public static void main(String[] args) {
        List<String> ar = new ArrayList();
        ar.add("test1 test1");
        ar.add("test2");
        ar.add("test3");
        ar.add("test4");
        ar.add("test1 test1");
        Map<String, Integer> map = new HashMap();
        ar.stream().forEach(el -> {
            map.computeIfPresent(el, (key, value) -> ++value);
            map.putIfAbsent(el, 1);
        });
        final int[] max = {Integer.MIN_VALUE};
        final String[] keyMax = new String[1];
        map.keySet().stream().forEach(el -> {
            if (max[0] < map.get(el)) {
                max[0] = map.get(el);
                keyMax[0] = el;
            }
        });
        System.out.println(keyMax[0].split(" +").length);
    }
}
