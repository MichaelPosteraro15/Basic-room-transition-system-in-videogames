package model;

//GameModel handle the game logic.
//GameModel is unique (singleton).

public class GameModel {
	
	//Controls(send notification to the current level room)
	Controls controls;
	//List of level
	//Current level
	//Current room
	
	
	private static GameModel instance = null;
	
	private GameModel() {}
	
	public static GameModel getInstance() {
		if(instance == null) {
			instance = new GameModel();
		}
		return instance;
	}

	public void move(int direction) {
		
	}
	
	
}
