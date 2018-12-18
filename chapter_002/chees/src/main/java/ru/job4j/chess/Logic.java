package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс проверки хода фигур
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    private boolean isOccupiedWay(Cell[] way) {
        boolean result = false;
        for (Cell cell : way) {
            if (this.findBy(cell) != -1) {
                result = true;
                break;
            }
        }
        return result;
    }


    public boolean move(Cell source, Cell dest)  throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("Фигура не найдена!");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (this.isOccupiedWay(steps)) {
            throw new OccupiedWayException("Путь занят фигурами! Ход не возможен.");
        }
        if (!(steps.length > 0 && steps[steps.length - 1].equals(dest))) {
            throw new ImposibleMoveException("Фигура " + figures.getClass() + " не может так ходить!");
        }
        this.figures[index] = this.figures[index].copy(dest);
        return true;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
