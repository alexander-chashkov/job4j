package ru.job4j.list;

import java.util.List;
/**
 * class ConvertList2Array
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.12.19
 */
public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = 0;
        if  (!list.isEmpty()) {
            cells = (list.size() % rows != 0) ? (list.size() + rows) / rows : list.size() / rows;
        }
        int[][] array = new int[rows][cells];
        int idx = 0;
        int idx2 = 0;
        for (int i : list) {
            array[idx][idx2++] = i;
            if (idx2 >= cells) {
                idx2 = 0;
                idx++;
            }
        }
        return array;
    }
}
