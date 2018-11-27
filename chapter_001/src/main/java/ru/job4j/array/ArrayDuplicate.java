package ru.job4j.array;
import java.util.Arrays;
/**
 * класс удаления дупликатов в массиве
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.27
 */
public class ArrayDuplicate {
    /**
     * @param array массив с дупликатами
     * @return массив без дупликатов
     */
    public String[] remove(String[] array) {
        int k = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length - k; i++) {
                if (array[j].equals(array[i])) {
                    String tmp = array[i];
                    array[i] = array[array.length - k - 1];
                    array[array.length - k - 1] = tmp;
                    k++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - k);
    }
}
