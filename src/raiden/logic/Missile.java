package raiden.logic;

import raiden.logic.Game.Allegiance;

/**
 * Tipo de míssil tradicional, intercalado.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public class Missile extends Projectile {

	private static final String IMAGE_PATH_PLAYER1 = "C:/xampp/htdocs/LPOO/resources/missile_player1.png";
	private static final String IMAGE_PATH_PLAYER2 = "C:/xampp/htdocs/LPOO/resources/missile_player2.png";
	private static final String IMAGE_PATH_ENEMY = "C:/xampp/htdocs/LPOO/resources/missile_enemy.png";
	
	private static int MISSILE_SPEED = 4;
	
	public Missile(int posX, int posY, int damage, Allegiance a){
		super(5, 5, posX, posY, damage, a, "C:/xampp/htdocs/LPOO/resources/missile_" + a + ".png");
		this.dy = MISSILE_SPEED;
	}
	
	public void move() {
	    this.posY -= dy;
	    if (this.posY < 0)
	        this.isDead = true;
	}
}