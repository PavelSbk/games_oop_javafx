package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenCorrectPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertThat(bishopBlack.position()).isEqualTo(Cell.F8);
    }

    @Test
    void whenCorrectCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Figure expected = new BishopBlack(Cell.B4);
        assertThat(bishopBlack.copy(Cell.B4).position()).isEqualTo(expected.position());
    }

    @Test
    void whenMoveFromC1toG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell dist = Cell.G5;
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] rst = bishopBlack.way(dist);
        assertThat(rst).containsExactly(expected);
    }
}