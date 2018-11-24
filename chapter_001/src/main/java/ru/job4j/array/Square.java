package ru.job4j.array;


/**
 * class square
 */
public class Square {
    /**
     * @param bound кол-во элементов
     * @return массив квадратов от 1.. до bound
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
