package raiden.logic;

import java.awt.Toolkit;
import java.util.ArrayList;

import raiden.logic.GameConfigurations.Difficulty;

/**
 * Classe que representa o jogo.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */

public class Game {
	public GameConfigurations conf;
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
			{100,-102}, {500, -103}, 
			{120, -207}, {540, -209}, {900, -219},
	        {300, -500}, {760, -515}, {1009, -520}, {1200, -509}, 
	        /*{560, -45}, {510, -70},
	        {930, -159}, {590, -80}, {530, -70},
	        {940, -59},  {990, -30}, {920, -200},
	        {900, -259}, {660, -50}, {540, -90},
	        {810, -220}, {860, -20}, {740, -180},
	        {820, -128}, {490, -170}, {700, -30}*/
		};
	
	private int[][] pos_boosts = { 
	        {560, -45}, {510, -70},
	        {930, -159}/*, {590, -80}, {530, -70},
	        {940, -59},  {990, -30}, {920, -200},
	        {900, -259}, {660, -50}, {540, -90},
	        {810, -220}, {860, -20}, {740, -180},
	        {820, -128}, {490, -170}, {700, -30}*/
		};
	
	public Game(GameConfigurations gconfigs) {
		assert gconfigs != null : "Configuration error.";
		
		Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());
        
        if(gconfigs.getDifficulty() == Difficulty.EASY) {
        	player1 = new Ship(1200, 100, gconfigs.easy_playerHP, gconfigs.easy_playerDamage, Allegiance.PLAYER1);
        	player2 = new Ship(1300, 600, gconfigs.easy_playerHP, gconfigs.easy_playerDamage, Allegiance.PLAYER2);
        }
        else if(gconfigs.getDifficulty() == Difficulty.MEDIUM) {
        	player1 = new Ship(1200, 100, gconfigs.medium_playerHP, gconfigs.medium_playerDamage, Allegiance.PLAYER1);
        	player2 = new Ship(1300, 600, gconfigs.medium_playerHP, gconfigs.medium_playerDamage, Allegiance.PLAYER2);
        }
        else if(gconfigs.getDifficulty() == Difficulty.HARD) {
        	player1 = new Ship(1200, 100, gconfigs.hard_playerHP, gconfigs.hard_playerDamage, Allegiance.PLAYER1);
        	player2 = new Ship(1300, 600, gconfigs.hard_playerHP, gconfigs.hard_playerDamage, Allegiance.PLAYER2);
        }
        
        if(gconfigs.getNumberOfPlayers() == 1) {
        	player1.setPosX(xSize/2);
        	player1.setPosY(ySize);
        	
        	player2.setPosX(-1000);
        	player2.setPosY(-1000);

        }
        else {
        	player1.setPosX(xSize/3);
        	player1.setPosY(ySize);
        	
        	player2.setPosX((2*xSize)/3);
        	player2.setPosY(ySize);
        }
        
        conf = gconfigs;
        
        initEnemies();
	}
	
    public void initEnemies() {
        for (int i=0; i<pos.length; i++ ) {
        	mobs.add(new Enemy(12, 12, pos[i][0], pos[i][1], 12, 11));
        }
    }
    
    public void initBoosts() {
        for (int i=0; i<pos_boosts.length; i++ ) {
        	boosts.add((PowerUp) new Coin(pos[i][0], pos[i][1], 50));
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
		if(player2.getPosX() == -1000) {
			if(player1.getHP() <= 0) {
				gameOver();
				setVictory(false);
			}
		}
		else {
			if(player1.getHP() <= 0 && player2.getHP() <= 0) {
				gameOver();
				setVictory(false);
			}
		}
		
		if(mobs.isEmpty()) {
			gameOver();
			setVictory(true);
		}
			
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

	public void removeBoost(int i) {
		this.boosts.remove(i);
	}
	

}
