package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import utilities.Settings;

//Room is an abstract class.
//It contains map,enemies and the players

public class Room {
	//map
	private Block[][] map = new Block[Settings.MAP_SIZE][Settings.MAP_SIZE];
	private int[][] mapStructure = new int[Settings.MAP_SIZE][Settings.MAP_SIZE];
	
	//player
	private Player player;
	
	//Room costructor's build the map based on map structure and then place the player
	public Room(String mapPath) {
		readMapStructure(mapPath);
		buildMap();
		placePlayer();
	}
	
	//to place the player
	private void placePlayer() {
		player = player.getInstance();
		player.initializePosition(new Position(3, Settings.MAP_SIZE/2));
		map[Settings.MAP_SIZE/2][3] = new Block(Block.PLAYER);
	}
	
	//to move player inside the map
	public void movePlayer(int direction) {
		Position oldPosition = player.getPosition();
		player.setPosition(direction);
		map[oldPosition.y][oldPosition.x] = new Block(Block.FLOOR);
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
	private void readMapStructure(String mapPath) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(mapPath));
		} catch (FileNotFoundException e1) {
			System.out.println("Cannot find file path.");
		}
		try {
			while(reader.ready()) {
				String line = reader.readLine();
				fillMapStructure(line);
			}
		} catch (IOException e) {
			System.out.println("Cannot read map structure.");
		}
	}
	
	//This method fill each row of map structure
	//The method split the line(in function parameter) in many integer that rappresent the block type
	private void fillMapStructure(String line) {
		for(int i = 0; i < Settings.MAP_SIZE; i++) {
			String[] values = line.split(" ");
			for(int j = 0; j < Settings.MAP_SIZE; j++) {
				mapStructure[i][j] = Integer.parseInt(values[j]);
			}
		}
	}
	
}
