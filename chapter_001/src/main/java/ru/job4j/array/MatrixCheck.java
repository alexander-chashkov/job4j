package ru.job4j.array;
/**
 * Матрица, булев
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.27
 */
public class MatrixCheck {
    /**
     * @param data массив
     * @return true если на диаганалях все элементы true или false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0][0] != data[i][i] || data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
            }
        }
        return result;
    }
}
