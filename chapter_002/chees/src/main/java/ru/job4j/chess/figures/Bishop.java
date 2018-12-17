package ru.job4j.chess.figures;

import ru.job4j.chess.ImposibleMoveException;

public  abstract class Bishop extends Figure {
    /**
     * @param position позиция фигуры
     */
    public Bishop(Cell position) {
        super(position);
    }

    private boolean isDiagnal(int dX, int dY) {
        return Math.abs(dX) == Math.abs(dY);
    }
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int deltaX = source.x - dest.x;
        int deltaY = source.y - dest.y;
        Cell[] result = null;
        int index = 0;
        if (this.isDiagnal(deltaX, deltaY)) {
            int countCell = Math.abs(deltaX);
            deltaX = deltaX / Math.abs(deltaX);
            deltaY = deltaY / Math.abs(deltaY);
            result = new Cell[countCell];
            for (int i = 0; i < countCell; i++) {
                int posX = source.x - deltaX * (i + 1);
                int posY = source.y - deltaY * (i + 1);
                int lengthBoard = (int) Math.sqrt(Cell.values().length);
                result[i] = Cell.values()[posX * lengthBoard + posY];
            }
        }
        return result;
    }

    public abstract Figure copy(Cell dest);
}
