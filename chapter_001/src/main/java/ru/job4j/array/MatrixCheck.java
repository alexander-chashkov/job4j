package ru.job4j.array;
/**
 * Матрица, булев
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.27
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i] || data[0][0] != data[i][data.length - 1 - i]) {
                return false;
            }
        }
        return result;
    }
}
