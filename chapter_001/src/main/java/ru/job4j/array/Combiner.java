package ru.job4j.array;

/**
 * Тестовое задание к Вопросы.[#83038][#91879]
 * Объдинить 2 остортированных массива, получить отсортированный массив
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.25
 */
public class Combiner {
    /**
     * @param arrayFirst  отсортированный массив 1
     * @param arraySecond отсортированный массив 2
     * @return объединение двух отсортированных массивов ( отсортированный массив)
     */
    public int[] toCombine(int[] arrayFirst, int[] arraySecond) {
        int[] result = new int[arrayFirst.length + arraySecond.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < arrayFirst.length && k < arraySecond.length) {
            if (arrayFirst[i] <= arraySecond[k]) {
                result[j] = arrayFirst[i];
                i++;
            } else {
                result[j] = arraySecond[k];
                k++;
            }
            j++;
        }
        System.arraycopy(arrayFirst, i, result, j, arrayFirst.length - i);
        System.arraycopy(arraySecond, k, result, j, arraySecond.length - k);
        return result;
    }
}
