package is.ru.tictactoe;

import java.util.Scanner;

public class TicTacToe{
	private boolean player;
	private int[][] table;
	private int movesLeft;

	//Constructor
	public TicTacToe(){
		this.player = true; //X always starts
		this.table = new int[3][3];
		this.movesLeft = 9;
		this.genTable();
	}

	//Generates a new table
	public void genTable(){
		int counter = 1;
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				//default value for squares is 100
				this.table[row][column] = 100;
				counter++;
			}
		}
	}

	//Returns the number player should place into this.table
	public int setMarker(){
		if(this.player)	{ return 1; }//X marks 1
		else			{ return 0; }//O marks 0
	}

	//Tries to alter the players chosen square
	//Returns false if occupied or out of bounds
	public boolean makeMove(int chosenSquare){
		int counter = 1;
		int marker = this.setMarker();

		//If out of bounds
		if(chosenSquare < 1 || chosenSquare > 9){
			return false;
		}

		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				//if we reached the correct square
				if(counter == chosenSquare){
					//if square has default value, mark it and return true
					if(this.table[row][column] == 100){
						this.table[row][column] = marker;
						return true;
					}
					else{
						return false;
					}
				}
				counter++;
			}
		}
		return false;//cell not found
	}

	//Returns true if winner is found
	//If the sum of three squares 3 then the winner is X
	//if the sum if 0 the the winner is O
	public boolean findWinner(){
		//check columns for a winner
		for(int column = 0; column < 3; column++){
			if(this.table[0][column] + this.table[1][column] + this.table[2][column] == 3){
				return true;
			}
			if(this.table[0][column] + this.table[1][column] + this.table[2][column] == 0){
				return true;
			}
		}

		//check rows for a winner
		for(int row = 0; row < 3; row++){
			if(this.table[row][0] + this.table[row][1] + this.table[row][2] == 3){
				return true;
			}
			if(this.table[row][0] + this.table[row][1] + this.table[row][2] == 0){
				return true;
			}
		}

		//check diagonal for a winner
		if(this.table[0][0] + this.table[1][1] + this.table[2][2] == 3){
			return true;
		}
		if(this.table[0][0] + this.table[1][1] + this.table[2][2] == 0){
			return true;
		}
		if(this.table[0][2] + this.table[1][1] + this.table[2][0] == 3){
			return true;
		}
		if(this.table[0][2] + this.table[1][1] + this.table[2][0] == 0){
			return true;
		}
		return false;
	}

	//Swaps the value of this.player and returns his character('X', 'O')
	public char swapPlayer(){
		if(this.player){	this.player = false; return 'O';}
		else{				this.player = true; return 'X';}
	}

	//Handles the general gameplay
	public void playGame(){
		Scanner input;
		int chosenSquare;

		//X always starts the game
		char playerTurn = 'X';

		while(this.movesLeft > 0){
			System.out.println("Player " + playerTurn + ", make your move.");
			this.printTable();

			try{
				//Get the chosen square from command line
				input = new Scanner(System.in);
				chosenSquare = input.nextInt();

				//If a legal square has been chosen
				if(this.makeMove(chosenSquare)){
					//If the move resulted in victory
					if(this.findWinner()){
						System.out.println(playerTurn + " WINS!!");
						break;
					}
					else{
						//Swap players for next turn
						playerTurn = this.swapPlayer();
					}
					movesLeft--;
					System.out.println("");
				}
				else{
					System.out.println("Illegal move, try again!");
				}
			}
			catch(Exception e){
				System.out.println("ERROR: try again");
			}
		}
		if(this.movesLeft == 0){
			this.printTable();
			System.out.println("We have a tie!!");
		}
	}

	//Prints the table to terminal
	public void printTable(){
		System.out.println("-------------");
		int counter = 1;

		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				if(this.table[row][column] == 100){
					System.out.print(counter);
				}
				else{
					if(this.table[row][column] == 1){	System.out.print("X");}
					else{								System.out.print("O");}
				}
				counter++;
			}
			System.out.println("");
		}
		System.out.println("-------------");
	}
}