package ru.job4j.chess.figures;

import ru.job4j.chess.ImposibleMoveException;

public abstract class Figure implements IFigure {

    /**
     * позиция фигуры
     */
    final Cell position;

    public Cell position() {
        return this.position;
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
