package raiden.logic;

import java.util.ArrayList;

/**
 * N�vel atual de jogo. Ter� de existir pelo menos um n�vel. Um determinado n�vel
 * s� poder� ser jogado depois de se vencer o n�vel anterior (se existir).
 * @author Jo�o
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */

public class Level {

	public Ship player1;
	public Ship player2;
	public ArrayList<Enemy> mobs;
	public ArrayList<Asteroid> obstacles;
	public ArrayList<PowerUp> boosts;

	public Level(){

	}
}