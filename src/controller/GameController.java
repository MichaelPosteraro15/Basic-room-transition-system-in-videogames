package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import application.KillEmAll;
import model.Direction;
import model.GameModel;
import view.GameView;


//GameController handle relation between model e view
//GameController is unique (singleton).
//It contains instance of GameModel and GameView

public class GameController extends KeyAdapter{
	
	private GameModel gameModel;
	private GameView gameView;

	private static GameController instance = null;
	
	private GameController(GameModel gameModel, GameView gameView) {
		this.gameModel = gameModel;
		this.gameView = gameView;
	}
	
	public static GameController getInstance(GameModel gameModel, GameView gameView) {
		if(instance == null) {
			instance = new GameController(gameModel, gameView);
		}
		return instance;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) { gameModel.move(Direction.MOVE_UP); }
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) { gameModel.move(Direction.MOVE_DOWN); }
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) { gameModel.move(Direction.MOVE_RIGHT); }
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) { gameModel.move(Direction.MOVE_LEFT); }
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) { KillEmAll.quit(); }
		
		gameView.repaint();
	}

}
