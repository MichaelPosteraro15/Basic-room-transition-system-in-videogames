package model;

public class Player extends Character {
	
	private Player instance = null;
	
	public Player getInstance() {
		if(instance == null) {
			instance = new Player();
		}
		return instance;
	}

	public void setPosition(int direction) {
		if(direction == Direction.MOVE_UP) {
			getPosition().y++;
		}
		else if(direction == Direction.MOVE_DOWN) {
			getPosition().y--;
		}
        else if(direction == Direction.MOVE_RIGHT) {
			getPosition().x++;
		}
        else if(direction == Direction.MOVE_LEFT) {
        	getPosition().y--;
        }
	}
}
