package model;

public abstract class Character {
	//character position
	private Position position;
	
	//other stuff
	
	public Character() {
		position.x = 0;
		position.y = 0;
	}
	
	public void initializePosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

}
