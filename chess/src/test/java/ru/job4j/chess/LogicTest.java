package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenThrowsFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenThrowsOccupiedCellException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.E7));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.F8, Cell.E7);
        });
        assertThat(exception.getMessage()).isNull();
    }

    @Test
    public void whenMoveThenThrowsImpossibleMoveException() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.F8, Cell.E6);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from F8 to E6");
    }
}
