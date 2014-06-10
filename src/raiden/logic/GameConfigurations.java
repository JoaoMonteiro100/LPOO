package raiden.logic;

import java.util.ArrayList;

public class GameConfigurations {

	public int easy_playerHP = 500;
	public int easy_playerDamage = 100;
	public int easy_enemyHP = 100;
	public int easy_enemyDamage = 50;
	public int easy_asteroidHP = 150;
	
	public int medium_playerHP = 500;
	public int medium_playerDamage = 100;
	public int medium_enemyHP = 200;
	public int medium_enemyDamage = 150;
	public int medium_asteroidHP = 250;
	
	public int hard_playerHP = 400;
	public int hard_playerDamage = 100;
	public int hard_enemyHP = 300;
	public int hard_enemyDamage = 50;
	public int hard_asteroidHP = 150;
	
	private int NumberOfPlayers = 1;
	private Difficulty difficulty = Difficulty.EASY;	
	private ArrayList<Enemy> mobs;
	private ArrayList<Asteroid> obstacles;
	private ArrayList<PowerUp> boosts;
	
	public enum Difficulty {
		EASY, MEDIUM, HARD
	}
	
	public ArrayList<Enemy> getMobs() {
		return mobs;
	}
	
	public void setMobs(ArrayList<Enemy> mobs) {
		this.mobs = mobs;
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

	public int getNumberOfPlayers() {
		return NumberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		NumberOfPlayers = numberOfPlayers;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty dif) {
		this.difficulty = dif;
	}
}
