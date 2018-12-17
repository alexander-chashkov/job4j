package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack extends Bishop {

    public BishopBlack(Cell dest) {
        super(dest);
    }

    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
