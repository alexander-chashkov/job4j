package ru.job4j.chess.figures;

import ru.job4j.chess.ImposibleMoveException;

public interface IFigure {
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;
}
