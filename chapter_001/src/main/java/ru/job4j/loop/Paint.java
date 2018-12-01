package ru.job4j.loop;
import java.util.function.BiPredicate;
/**
 * Рисование пирамиды
 *
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.19
 */
public class Paint {

    /**
     * @param height Высота пирамиды
     * @param weight Ширина пирамиды
     * @param predict условие построения
     * @return часть готовой пирамиды
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * @param height высота пирамиды
     * @return правая часть пирамиды
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * @param height высота пирамиды
     * @return левая часть пирамиды
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * @param height высота пирамиды
     * @return пирамида
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }


}
