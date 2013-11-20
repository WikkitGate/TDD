package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TicTacToeTest{
	@Test
	public void genTableTest(){
		TicTacToe game = new TicTacToe();
		game.genTable();
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				assertEquals("Default value of squares should be 100", 100, game.table[row][column]);
			}
		}
	}
}