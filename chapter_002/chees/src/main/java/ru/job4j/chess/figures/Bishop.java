package ru.job4j.chess.figures;

import ru.job4j.chess.ImposibleMoveException;
/**
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.12.17
 * Bishop
 */
public  abstract class Bishop extends Figure {
    /**
     * @param position позиция фигуры
     */
    public Bishop(Cell position) {
        super(position);
    }

    private boolean isDiagonal(int dX, int dY) {
        return Math.abs(dX) == Math.abs(dY);
    }
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (!this.isDiagonal(source.x - dest.x, source.y - dest.y)) {
            throw new ImposibleMoveException("Ошибка. Слон так не ходит!");
        }
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX = (source.x - dest.x) / Math.abs(source.x - dest.x);
        int deltaY = (source.y - dest.y) / Math.abs(source.y - dest.y);
        for (int i = 0; i < steps.length; i++) {
            steps[i] = Cell.values()[(source.x - deltaX * (i + 1)) * this.getLengthBoard() + (source.y - deltaY * (i + 1))];
        }
        return steps;
    }

    public abstract Figure copy(Cell dest);
}
