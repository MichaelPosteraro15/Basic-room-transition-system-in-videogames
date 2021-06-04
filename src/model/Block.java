package model;

//Block to represent all objects in the level such as players, enemies, floor etc...

public class Block {
	public static final int FLOOR = 0;
	public static final int PLAYER = 1;
	
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
