package backend;

import frontend.boardManager;

public interface IGameManager {
	
	
	public void firstTurn(boardManager board);
	
	
	public void turn(boardManager board);
	
	
	public void winCondition(boardManager board);
	
	

}
