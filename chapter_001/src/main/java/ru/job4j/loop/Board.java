package ru.job4j.loop;
/**
 * Board
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @since 2018.11.19
 */
public class Board {
    /**
     * @param width ширина доски
     * @param height высота доски
     * @return разметка доски
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
