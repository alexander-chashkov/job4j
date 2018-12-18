package ru.job4j.chess.figures;

import ru.job4j.chess.ImposibleMoveException;

/**
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.12.17
 * Figure
 */
public abstract class Figure implements IFigure {
    private final int lengthBoard = (int) Math.sqrt(Cell.values().length);
    /**
     * позиция фигуры
     */
    final Cell position;

    public Cell position() {
        return this.position;
    }
    public int getLengthBoard() {
        return this.lengthBoard;
    }

    /**
     * @param position позиция фигуры
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * @param source начальная позиция фигуры
     * @param dest конечная позиция
     * @return путь из позиций, от начальной до конечной позиции
     * @throws ImposibleMoveException - отказ, невозможно передвинуть фигуру
     */
    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public String icon() {
        return String.format("%s.png", this.getClass().getSimpleName());
    }

    /**
     * @param dest новая позиция фигуры
     * @return фигура
     */
    public abstract Figure copy(Cell dest);

}
