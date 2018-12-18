package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImposibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;

import static org.junit.Assert.*;
/**
 * Класс тестирования проверки хода фигур
 *
 * @author Chashkov Alexander
 * @version 0.0.0.1
 * @since 2018.12.18
 */

public class LogicTest {

    /**
     * test fail occupied way
     */
    @Test(expected = OccupiedWayException.class)
    public void moveBishopMoveFailOccupiedWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new BishopBlack(Cell.E7));
        logic.move(Cell.F8, Cell.C5);
    }

    /**
     * test fail not bishop way
     */
    @Test(expected = ImposibleMoveException.class)
    public void moveBishopMoveFailNotBishopWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.F8, Cell.H8);
    }

    /**
     * test fail not found bishop
     */
    @Test(expected = FigureNotFoundException.class)
    public void moveBishopMoveFailNotFoundBishop() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.move(Cell.F7, Cell.H8);
    }

    /**
     * test success bishop
     */
    @Test
    public void moveBishopMoveSuccess() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        assertTrue(logic.move(Cell.F8, Cell.C5));
    }
}