package application;

import view.GameWindow;

public class KillEmAll {
	
	//Method to start game (show the main Window)
	private static void start() {
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
