package main.com.RJ.tddjava.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TicTacToeTest {
    @Rule
    public ExpectedException exception =
            ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void Before() {
        ticTacToe = new TicTacToe();
    }



    @Test
    public void WhenXIsOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(5,1);
    }
    @Test
    public void WhenYIsOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }
    @Test
    public void WhenOccupiedThenFalse() {
        ticTacToe.play(2,2);
        exception.expect(RuntimeException.class);
        ticTacToe.play(2,2);
    }
    @Test
    public void WhenNextPlayerThenPlayerIsX() {
        assertEquals('X',ticTacToe.NextPlayer());
    }
    @Test
    public void WhenPlayAndNextPlayerThenPlayerIsO(){
        ticTacToe.play(2,2);
        assertEquals('O',ticTacToe.NextPlayer());
    }
    @Test
    public void WhenWholeRowIsFilledWithXThenXWin () {
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,2);
        ticTacToe.play(2,3);
        ticTacToe.play(3,2);
        ticTacToe.play(3,3);
        ticTacToe.play(4,2);
        assertEquals("X Win!",ticTacToe.IsWin());
    }
    @Test
    public void WhenWholeRowIsFilledWithOThenOWin () {
        ticTacToe.play(1,2);
        ticTacToe.play(1,3);
        ticTacToe.play(2,2);
        ticTacToe.play(2,3);
        ticTacToe.play(3,2);
        ticTacToe.play(3,3);
        ticTacToe.play(4,1);
        ticTacToe.play(4,3);
        assertEquals("O Win!",ticTacToe.IsWin());
    }
    @Test
    public void WhenWholeColumnsIsFilledWithOThenXWin() {
        ticTacToe.play(2,1);
        ticTacToe.play(1,3);
        ticTacToe.play(2,2);
        ticTacToe.play(3,3);
        ticTacToe.play(2,3);
        ticTacToe.play(3,4);
        ticTacToe.play(2,4);
        ticTacToe.play(4,3);
        assertEquals("O Win!",ticTacToe.IsWin());
    }
    @Test
    public void WhenWholeDiagonalIsFilledWithXThenXWin() {
        ticTacToe.play(1,1);
        ticTacToe.play(1,3);
        ticTacToe.play(2,2);
        ticTacToe.play(2,3);
        ticTacToe.play(3,3);
        ticTacToe.play(3,4);
        ticTacToe.play(4,4);
        assertEquals("X Win!",ticTacToe.IsWin());
    }
    @Test
    public void WhenDrawThenTrue() {
        ticTacToe.play(1,1);
        ticTacToe.play(2,1);
        ticTacToe.play(4,1);
        ticTacToe.play(3,1);
        ticTacToe.play(1,2);
        ticTacToe.play(3,2);
        ticTacToe.play(2,2);
        ticTacToe.play(4,2);
        ticTacToe.play(4,3);
        ticTacToe.play(1,3);
        ticTacToe.play(2,3);
        ticTacToe.play(3,3);
        ticTacToe.play(2,4);
        ticTacToe.play(3,4);
        ticTacToe.play(1,4);
        ticTacToe.play(4,4);
        assertFalse(ticTacToe.IsDraw());
    }
}
