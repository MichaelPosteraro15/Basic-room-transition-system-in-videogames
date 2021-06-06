package model;

//Block to represent all objects in the level such as players, enemies, floor etc...

public class Block {
	public static final int FLOOR = 0;
	public static final int EMPTY = 1;
	public static final int WALL = 2;
	public static final int DOOR = 3;
	public static final int PLAYER = 4;
	
	private int type;
	
	public Block(int type) {
		this.setType(type);
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
