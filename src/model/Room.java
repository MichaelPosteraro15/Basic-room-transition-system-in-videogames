package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import utilities.Settings;

//Room is an abstract class.
//It contains map,enemies and the players

public class Room {
	//map
	private Block[][] map = new Block[Settings.MAP_SIZE][Settings.MAP_SIZE];
	private int[][] mapStructure = new int[Settings.MAP_SIZE][Settings.MAP_SIZE];
	
	//player
	private Position playerPosition = new Position(0,0);
	
	//Room costructor's build the map based on map structure and then place the player
	public Room(String mapPath) {	
		InputStream is = Room.class.getResourceAsStream(mapPath);
			
		readMapStructure(is);
		buildMap();
		setPlayerPosition();
	}
	
	//to place player entry position ----------------->TO FIX
	public void setPlayerPosition() {
		playerPosition.x = 3;
		playerPosition.y = (Settings.MAP_SIZE/2)-4;
		map[playerPosition.y][playerPosition.x] = new Block(Block.PLAYER);
	}
	
	/*
	// to place player exit position ------------------>TO FIX
	public void setLastPlayerPosition() {
		playerPosition.x = 32;
		playerPosition.y = (Settings.MAP_SIZE/2)-4;
		map[playerPosition.y][playerPosition.x] = new Block(Block.PLAYER);
	}
	*/
	
	//to move player inside the map
	public void movePlayerPosition(int direction) {
		int newX = moveX(playerPosition.x, direction);
		int newY = moveY(playerPosition.y, direction);
		
		if(!checkCollision(newX, newY)) { 
			map[playerPosition.y][playerPosition.x].setType(Block.FLOOR);
			
			playerPosition.x = newX;
			playerPosition.y = newY;
			
			map[playerPosition.y][playerPosition.x].setType(Block.PLAYER);
		}
	}
	
	//check collision
	private boolean checkCollision(int x, int y) {
		if(map[y][x].getType() == Block.WALL || map[y][x].getType() == Block.EMPTY) {
			return true;
		}
		return false;
	}
	
	public boolean checkDoorExit() {	
		if(map[playerPosition.y][playerPosition.x+1].getType() == Block.DOOR_EXIT) {
			//movePlayerPosition(Direction.MOVE_LEFT);
			//map[playerPosition.y][playerPosition.x].setType(Block.DOOR_EXIT);
			
			return true;
		}
		return false;
	}
	
	public boolean checkDoorEntry() {			
		if(map[playerPosition.y][playerPosition.x-1].getType() == Block.DOOR_ENTRY) {
			//movePlayerPosition(Direction.MOVE_LEFT);
			//map[playerPosition.y][playerPosition.x].setType(Block.DOOR_ENTRY);
			
			return true;
		}
		return false;
	}
	
	//move on X
	private int moveX(int x, int direction) {
		if(direction == Direction.MOVE_LEFT) { x--; }
		else if(direction == Direction.MOVE_RIGHT) { x++; }
		
		return x;
	}
	
	//move on Y 
	private int moveY(int y, int direction) {
		if(direction == Direction.MOVE_UP) { y--; }
		else if(direction == Direction.MOVE_DOWN) { y++; }
		
		return y;
	}
	
	//This method build the map by "scanning" each row of the map structure
	private void buildMap() {
		for(int i = 0; i < Settings.MAP_SIZE; i++) {
			for(int j = 0; j < Settings.MAP_SIZE; j++) {
				map[i][j] = new Block(mapStructure[i][j]);
			}
		}	
	}
	
	//useful to read map structure from text file. Each room has is own structure.
	//The method split the text file in many line.
	private void readMapStructure(InputStream mapPath) {
		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(mapPath));
		try {
			fillMapStructure(reader);
		} catch (IOException e) {
			System.out.println("Cannot read map structure.");
		}
	}
	
	//This method fill each row of map structure
	//The method split the line(in function parameter) in many integer that rapresent the block type
	private void fillMapStructure(BufferedReader reader) throws IOException {
		for(int i = 0; i < Settings.MAP_SIZE; i++) {
			String line = reader.readLine();
			
			//matrix of 1 column and n row
			String[] values = line.split(" ");
			
			for(int j = 0; j < Settings.MAP_SIZE; j++) {
				mapStructure[i][j] = Integer.parseInt(values[j]);	
			}
		}
	}
	
	//get the whole map
	public Block[][] getMap(){
		return map;
	}
}
