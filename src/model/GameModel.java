package model;

import java.util.ArrayList;

//GameModel handle the game logic.
//GameModel is unique (singleton).

public class GameModel {

	//List of level
	private ArrayList<Level> levels = new ArrayList<Level>();
	//Current level
	private Level currentLevel;
	//Current room
	private Room currentRoom;
	
	private static GameModel instance = null;
	
	private GameModel() {
		buildLevels();
		currentLevel = levels.get(0);
		currentRoom = currentLevel.getCurrentRoom();
	}
	
	public static GameModel getInstance() {
		if(instance == null) {
			instance = new GameModel();
		}
		return instance;
	}
	
	private void buildLevels() {
		levels.add(new Level(0, 5));
		levels.add(new Level(1, 3));
		levels.add(new Level(2, 1));
	}

	//riguarda il settaggio dei livelli ogni volta che ne passi uno
	public void move(int direction) {
		if(currentRoom.checkDoorExit() && direction == Direction.MOVE_RIGHT) {
			if(currentLevel.nextRoom()) {
				currentRoom = currentLevel.getCurrentRoom();
			}
			else {
				currentLevel = levels.get(1);
				currentRoom = currentLevel.getCurrentRoom();
				System.out.println("Level 1");
			}
		}
		
		if(currentRoom.checkDoorEntry() && direction == Direction.MOVE_LEFT) {
			if(currentLevel.previousRoom()) {
				currentRoom = currentLevel.getCurrentRoom();
			}
			else {
				
				/*
				currentLevel = levels.get(0);
				currentRoom = currentLevel.getCurrentRoom();
				System.out.println("Level 0");
				*/
			}
		}
		
		currentRoom.movePlayerPosition(direction);
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public Level getCurrentLevel() {
		return currentLevel;
	}
	
}
