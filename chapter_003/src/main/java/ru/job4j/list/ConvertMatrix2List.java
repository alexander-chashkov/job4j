package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * class ConvertMatrix2List
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.19
 */
public class ConvertMatrix2List {
    /**
     * @param array массив двумерный
     * @return массив на основе списка
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] rows : array) {
            for (int elem : rows) {
                list.add(elem);
            }
        }
        return list;
    }
}
