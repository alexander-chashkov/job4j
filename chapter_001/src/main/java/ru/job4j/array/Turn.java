package ru.job4j.array;
/**
 * class Turn
 * @version 0.0.0.1
 * @author Chashkov Alexander
 * @since 2018.11.24
 */
public class Turn {
    /**
     * @param array in
     * @return turned array
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int buf = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = buf;
        }
        return array;
    }
}
