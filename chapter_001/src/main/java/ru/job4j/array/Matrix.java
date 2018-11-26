package ru.job4j.array;
/**
 * Матрица, таблица умножения
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.11.26
 */
public class Matrix {
    /**
     * @param size размер таблицы умножения
     * @return таблица умножения
     */
    int[][] multiple(int size){
        int[][] table = new int[size][size];
        for (int i = 1; i <= table.length; i++) {
            for (int j = 1; j <= table.length; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
