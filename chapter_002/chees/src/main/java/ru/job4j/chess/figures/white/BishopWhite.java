package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Bishop {
    public BishopWhite(final Cell dest) {
        super(dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
