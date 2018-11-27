package ru.job4j.array;
/**
 * Сортировка пузырьком
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.26
 */
public class BubbleSort {
    /**
     * @param array массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }
}
