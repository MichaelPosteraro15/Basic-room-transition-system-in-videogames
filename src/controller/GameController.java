package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import application.KillEmAll;


//GameController handle relation between model e view
//GameController is unique (singleton).
//It contains instance of GameModel and GameView

public class GameController extends KeyAdapter{

	private static GameController instance = null;
	
	public static GameController getInstance() {
		if(instance == null) {
			instance = new GameController();
		}
		return instance;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			KillEmAll.quit();
		}
	}

}
