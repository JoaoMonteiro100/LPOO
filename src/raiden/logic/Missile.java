package raiden.logic;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Tipo de míssil tradicional, intercalado.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public class Missile extends Projectile {

	private static final String IMAGE_PATH_PLAYER1 = "resources/missile_player1.png";
	private static final String IMAGE_PATH_PLAYER2 = "resources/missile_player2.png";
	private static final String IMAGE_PATH_ENEMY = "resources/missile_enemy.png";
	
	public Missile(int posX, int posY, int damage, Allegiance a){
		super(5, 5, posX, posY, damage, a, "resources/missile_" + a + ".png");
	}
}