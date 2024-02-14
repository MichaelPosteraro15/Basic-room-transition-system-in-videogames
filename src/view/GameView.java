package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.GameController;
import model.Block;
import model.GameModel;
import model.Level;
import model.Room;
import utilities.Settings;

//GameView handle game graphics.
//GameView is unique (singleton).
//It is inlaid in GameWindow

public class GameView extends JPanel{

	private static final long serialVersionUID = 1860979716621182121L;
	
	private GameController gameController;
	private static GameView instance = null;
	
	private GameView() {	
		setPreferredSize(new Dimension(Settings.GAMEVIEW_SIZE, Settings.GAMEVIEW_SIZE));
		setFocusable(true);
		requestFocus();
	}
	
	public void setController(GameController gameController) {
		this.gameController = gameController;
		addKeyListener(gameController);
	}
	
	public static GameView getIstance() {
		if(instance == null) {
			instance = new GameView();
		}
		return instance;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Room room = GameModel.getInstance().getCurrentRoom();
		Level level = GameModel.getInstance().getCurrentLevel();
		
		Block[][] mapRoom = room.getMap();
		int nameLevel = level.getName();
		
		switch (nameLevel) {
		case 0:
			drawLevel0(g, mapRoom);
			break;
		case 1:
			drawLevel1(g, mapRoom);
			break;
		case 2:
			drawLevel2(g, mapRoom);
		
		}
				
	}
	
	//TO FIX
	
	private void drawLevel0(Graphics g, Block[][] map) {
		for (int i = 0; i < Settings.MAP_SIZE; i++) {
			for (int j = 0; j < Settings.MAP_SIZE; j++) {
				switch (map[i][j].getType()) {
				case Block.FLOOR:
					g.setColor(Color.LIGHT_GRAY);
					//first get x and then y
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.EMPTY:
					g.setColor(Color.BLACK);
					//first get x and then y
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.WALL:
					g.setColor(Color.DARK_GRAY);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.DOOR_ENTRY: 
					g.setColor(Color.GREEN);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.DOOR_EXIT:
					g.setColor(Color.YELLOW);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
					
				case Block.PLAYER:
					g.setColor(Color.RED);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				}
			}
		}
	}
	
	private void drawLevel1(Graphics g, Block[][] map) {
		for (int i = 0; i < Settings.MAP_SIZE; i++) {
			for (int j = 0; j < Settings.MAP_SIZE; j++) {
				switch (map[i][j].getType()) {
				case Block.FLOOR:
					g.setColor(Color.WHITE);
					//first get x and then y
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.EMPTY:
					g.setColor(Color.BLACK);
					//first get x and then y
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.WALL:
					g.setColor(Color.ORANGE);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.DOOR_ENTRY: 
					g.setColor(Color.GREEN);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.DOOR_EXIT:
					g.setColor(Color.YELLOW);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
					
				case Block.PLAYER:
					g.setColor(Color.RED);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				}
			}
		}
	}
	
	private void drawLevel2(Graphics g, Block[][] map) {
		for (int i = 0; i < Settings.MAP_SIZE; i++) {
			for (int j = 0; j < Settings.MAP_SIZE; j++) {
				switch (map[i][j].getType()) {
				case Block.FLOOR:
					g.setColor(Color.WHITE);
					//first get x and then y
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.EMPTY:
					g.setColor(Color.BLACK);
					//first get x and then y
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.WALL:
					g.setColor(Color.RED);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.DOOR_ENTRY: 
					g.setColor(Color.GREEN);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				case Block.DOOR_EXIT:
					g.setColor(Color.YELLOW);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
					
				case Block.PLAYER:
					g.setColor(Color.RED);
					g.fillRect(j * Settings.BLOCK_SIZE, i * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
							Settings.BLOCK_SIZE);
					break;
				}
			}
		}
	}
	
}
