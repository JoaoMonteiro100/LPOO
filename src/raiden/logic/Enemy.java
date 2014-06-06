package raiden.logic;

import raiden.logic.Game.Allegiance;

/**
 * Naves espaciais inimigas, com a capacidade de lançar projéteis e se
 * movimentarem.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */
public class Enemy extends Entity {

	private static final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/enemy.png";
	private int AI_level;

	public Enemy(int dimX, int dimY, int posX, int posY, int HP, int baseDamage){
		super(dimX, dimY, posX, posY, HP, baseDamage, IMAGE_PATH, Allegiance.ENEMY);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}