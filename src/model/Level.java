package model;

import java.util.HashMap;

//Level host many rooms.
//It is an abstract class and other levels inherit from it.
//It is characterized by a list of room.

public class Level {
	//level name
	private int name;
	
	//number of room.
	private int roomsNumber;
	
	//hashMap of room.Each number identifies a room.
	private HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
	
	//Current room.Where the player is placed.
	private Room currentRoom;
	
	//Current room key.
	public int currentKey;
	
	//Path of the level to load (the folder contains all room project)
	private String levelPath = "/resources/levels/level";
	
	public Level(int name, int roomsNumber) {
		this.name = name;
		this.roomsNumber = roomsNumber;
	    levelPath = levelPath.concat(Integer.toString(name));
	    buildRooms();
	    currentKey = 0;
	    currentRoom = rooms.get(currentKey);
	}
	
	//using levelPath this method, build new room with the path of every room structure (txt file)
	private void buildRooms() {
		for(int i = 0; i < roomsNumber; i++) {
			rooms.put(i, new Room(levelPath + "/Room" + i + ".txt"));
		}
	}

	//get level name.
	public int getName() {
		return name;
	}

	//get current room.
	public Room getCurrentRoom() {
		return currentRoom;
	}

	//to set next room. If the are no more room, the level is finished.
	public boolean nextRoom() {
		currentKey++;
		if(currentKey == roomsNumber) {
			currentKey = roomsNumber;
			return false;
		}
		
		System.out.println("ROOM: " + currentKey);
		
		currentRoom = rooms.get(currentKey);
		return true;
	}
	
	//to set previous room
	public boolean previousRoom() {
		currentKey--;
		if(currentKey < 0) {
			currentKey = 0;
			return false;
		}
		
		System.out.println("ROOM: " + currentKey);
		
		currentRoom = rooms.get(currentKey);
		return true;
	}

}
