package view;

import javax.swing.JFrame;

//GameWindow host GameView.
//GameWindow is unique (singleton).

public class GameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static GameWindow instance = null;
	
	private GameWindow() {	
		add(GameView.getIstance());
	
		//to remove window bar.
		setUndecorated(true);                               
		//set window to the same size of his components.
		pack();                                   
		//To center the window.
		setLocationRelativeTo(null);                           
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static GameWindow getInstance() {
		if(instance == null) {
			instance = new GameWindow();
		}
		return instance;
	}
	
}
