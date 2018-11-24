package ru.job4j.array;
/**
 * class FindLoop
 * @version 0.0.0.1
 * @author Chashkov Alexander
 * @since 2018.11.24
 */

public class FindLoop {
    /**
     *
     * @param data array for search
     * @param el number to search
     * @return index within data array of the first occurrence, else - 1
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
