package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicTacToeTest{
	@Test
	public void makeMoveTest(){
		TicTacToe game = new TicTacToe();
		assertEquals(false, game.makeMove(10));
	}
}