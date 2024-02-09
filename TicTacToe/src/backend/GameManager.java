package backend;
import java.awt.Color;
import java.util.*;

import javax.swing.JButton;

import frontend.boardManager;


public class GameManager implements IGameManager {
	
	Random random = new Random();
	private JButton[] buttons;
	private int finished;
	
	
	public int getFinished() {		
		return finished;
	}
	
	@Override
	public void firstTurn(boardManager board) {
		
		
		if(random.nextInt(2) == 0) {
			board.setText("X Turn");
			board.setTurn(true);
		}
		board.setText("O Turn");
		board.setTurn(false);
		
	}
	
	public void turn(boardManager board) {
		
		if(board.getTurn() == true) {
			board.setText("O Turn");
			board.setTurn(false);
		}
		else {
			board.setText("X Turn");
			board.setTurn(true);
		}
		
	}

	@Override
	public void winCondition(boardManager board) {
		
		this.buttons = board.getButtons();
		
		if(
				buttons[0].getText() == "X" && 
				buttons[1].getText() == "X" && 
				buttons[2].getText() == "X") {
			xWins(0,1,2);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[3].getText() == "X" && 
				buttons[4].getText() == "X" && 
				buttons[5].getText() == "X") {
			xWins(3,4,5);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[6].getText() == "X" && 
				buttons[7].getText() == "X" && 
				buttons[8].getText() == "X") {
			xWins(6,7,8);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[0].getText() == "X" && 
				buttons[3].getText() == "X" && 
				buttons[6].getText() == "X") {
			xWins(0,3,6);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[1].getText() == "X" && 
				buttons[4].getText() == "X" && 
				buttons[7].getText() == "X") {
			xWins(1,4,7);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[2].getText() == "X" && 
				buttons[5].getText() == "X" && 
				buttons[8].getText() == "X") {
			xWins(2,5,8);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[0].getText() == "X" && 
				buttons[4].getText() == "X" && 
				buttons[8].getText() == "X") {
			xWins(0,4,8);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[2].getText() == "X" && 
				buttons[4].getText() == "X" && 
				buttons[6].getText() == "X") {
			xWins(2,4,6);
			board.setText("X Wins");
			board.getText().setForeground(Color.GREEN);
		}
		

		if(
				buttons[0].getText() == "O" && 
				buttons[1].getText() == "O" && 
				buttons[2].getText() == "O") {
			oWins(0,1,2);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[3].getText() == "O" && 
				buttons[4].getText() == "O" && 
				buttons[5].getText() == "O") {
			oWins(3,4,5);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[6].getText() == "O" && 
				buttons[7].getText() == "O" && 
				buttons[8].getText() == "O") {
			oWins(6,7,8);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[0].getText() == "O" && 
				buttons[3].getText() == "O" && 
				buttons[6].getText() == "O") {
			oWins(0,3,6);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[1].getText() == "O" && 
				buttons[4].getText() == "O" && 
				buttons[7].getText() == "O") {
			oWins(1,4,7);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[2].getText() == "O" && 
				buttons[5].getText() == "O" && 
				buttons[8].getText() == "O") {
			oWins(2,5,8);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[0].getText() == "O" && 
				buttons[4].getText() == "O" && 
				buttons[8].getText() == "O") {
			oWins(0,4,8);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		if(
				buttons[2].getText() == "O" && 
				buttons[4].getText() == "O" && 
				buttons[6].getText() == "O") {
			oWins(2,4,6);
			board.setText("O Wins");
			board.getText().setForeground(Color.GREEN);
		}
		
	}

	public void oWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			
			buttons[i].setEnabled(false);
		}
		finished = 1;
	}
	public void xWins(int a,int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			
			buttons[i].setEnabled(false);
		}
		finished = 1;
		
	}
	

}
