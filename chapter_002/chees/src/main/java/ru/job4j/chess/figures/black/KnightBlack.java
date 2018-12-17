package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack extends Figure{
    public KnightBlack(Cell dest) {
        super(dest);
    }
    @Override
    public Cell[] way(Cell source, Cell dest) {
        return new Cell[] { dest };
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
