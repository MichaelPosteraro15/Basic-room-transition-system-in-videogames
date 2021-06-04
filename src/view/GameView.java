package view;

import java.awt.Dimension;
import javax.swing.JPanel;

import controller.GameController;
import utilities.Settings;

//GameView handle game graphics.
//GameView is unique (singleton).
//It is inlaid in GameWindow

public class GameView extends JPanel{

	private static final long serialVersionUID = 1860979716621182121L;
	
	private GameController gameController = null;
	private static GameView instance = null;
	
	private GameView() {
		gameController = GameController.getInstance();
		addKeyListener(gameController);
		
		setPreferredSize(new Dimension(Settings.GAMEVIEW_SIZE, Settings.GAMEVIEW_SIZE));
		setFocusable(true);
		requestFocus();
	}
	
	public static GameView getIstance() {
		if(instance == null) {
			instance = new GameView();
		}
		return instance;
	}
	
}
