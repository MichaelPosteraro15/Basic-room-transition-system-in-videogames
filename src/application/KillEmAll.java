package application;

import controller.GameController;
import model.GameModel;

import view.GameView;
import view.GameWindow;

public class KillEmAll {
	
	//Method to start game (show the main Window)
	private static void start() {
		GameModel gameModel = GameModel.getInstance();
		GameView gameView = GameView.getIstance();
		GameController gameController = GameController.getInstance(gameModel, gameView);
		
		gameView.setController(gameController);
		
		GameWindow.getInstance();
	}
	
	//Method to quit the game
	public static void quit() {
		 System.exit(0);
	}
		
	public static void main(String[] args) {
		start();
	}

}
