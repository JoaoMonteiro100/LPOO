package raiden.logic;

import java.awt.Toolkit;
import java.util.ArrayList;

/**
 * Classe que representa o jogo.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */

public class Game {
	private Ship player1 = null;
	private Ship player2 = null;
	private ArrayList<Enemy> mobs = new ArrayList<Enemy>();
	private ArrayList<Asteroid> obstacles = new ArrayList<Asteroid>();
	private ArrayList<PowerUp> boosts = new ArrayList<PowerUp>();
	private boolean gameOver = false;
	private boolean victory = false;
	
	public enum Allegiance {
		PLAYER1, PLAYER2, ENEMY
	}
	
	private int[][] pos = { 
		    
		    {0,0}
		};
	
	public Game(GameConfigurations gconfigs) {
		assert gconfigs != null : "Configuration error.";
		
		Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());
        
        player1 = new Ship(1200, 100, 0, 0, Allegiance.PLAYER1);
        player2 = new Ship(1300, 600, 0, 0, Allegiance.PLAYER1);
        
        if(gconfigs.getNumberOfPlayers() == 1) {
        	player1.setPosX(xSize/2);
        	player1.setPosX(ySize);

        }
        else {
        	player1.setPosX(xSize/3);
        	player1.setPosX(ySize);
        	
        	player2.setPosX((2*xSize)/3);
        	player2.setPosX(ySize);
        }
	}
	
    public void initEnemies() {
        for (int i=0; i<pos.length; i++ ) {
        	mobs.add(new Enemy(12, 12, pos[i][0], pos[i][1], 12, 11));
        }
    }

	public Ship getPlayer1() {
		return player1;
	}

	public void setPlayer1(Ship player1) {
		this.player1 = player1;
	}

	public Ship getPlayer2() {
		return player2;
	}

	public void setPlayer2(Ship player2) {
		this.player2 = player2;
	}

	public ArrayList<Enemy> getMobs() {
		return mobs;
	}

	public void setMobs(ArrayList<Enemy> mobs) {
		this.mobs = mobs;
	}
	
	public void removeMob(int index) {
		this.mobs.remove(index);
	}

	public ArrayList<Asteroid> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Asteroid> obstacles) {
		this.obstacles = obstacles;
	}

	public ArrayList<PowerUp> getBoosts() {
		return boosts;
	}

	public void setBoosts(ArrayList<PowerUp> boosts) {
		this.boosts = boosts;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void gameOver() {
		this.gameOver = true;
	}

	public boolean isVictory() {
		return victory;
	}

	public void setVictory(boolean victory) {
		this.victory = victory;
	}
	

}
