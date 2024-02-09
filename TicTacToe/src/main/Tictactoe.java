package main;

import frontend.boardManager;

public class Tictactoe {
	
	public void run() {
		
		boardManager board = new boardManager();
		board.createTable();
		board.createMenu();
		
	}
	
	public static void main(String[] args) {
		
		Tictactoe game = new Tictactoe();
		game.run();
		
	
		
		
		
		
		
	}

}
