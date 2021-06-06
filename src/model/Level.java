package model;

import java.io.File;
import java.util.HashMap;

//Level host many rooms.
//It is an abstract class and other levels inherit from it.
//It is characterized by a list of room.

public abstract class Level {
	//level name
	private String name;
	
	//number of room.
	private int roomsNumber;
	
	//hash of room.Each number identifies a room.
	private HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
	
	//Path of the level to load (the folder contains all room project)
	private String levelPath = "resources.LevelRoomMaps.Level";
	
	public Level(String name, int roomsNumber) {
		this.name = name;
		this.roomsNumber = roomsNumber;
	    levelPath = levelPath.concat(name);
	    buildRooms();
	}
	
	//using levelPath this method, build new room with the path of every room structure (txt file)
	private void buildRooms() {
		for(int i = 0; i < roomsNumber; i++) {
			rooms.put(i, new Room(levelPath + File.separator + "Room" + i));
		}
	}
	
	/*
	 * Per gestire quando vado da una stanza all'altra devo tenermi 
	 * la stanza corrente(quella in cui si trova il mio player) e ogni 
	 * volta che mi avvicino ad un blocco porta devo segnalarlo al livello che cambia 
	 * la stanza attuale
	 */
	

}
