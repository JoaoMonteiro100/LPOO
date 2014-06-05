package raiden.logic;

/**
 * Tipo de míssil em linha reta, ininterrupto.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public class Ray extends Projectile {

	private static final String IMAGE_PATH_PLAYER1 = "C:/xampp/htdocs/LPOO/resources/ray_player1.png";
	private static final String IMAGE_PATH_PLAYER2 = "C:/xampp/htdocs/LPOO/resources/ray_player2.png";
	private static final String IMAGE_PATH_ENEMY = "C:/xampp/htdocs/LPOO/resources/ray_enemy.png";
	
	public Ray(int dimX, int dimY, int posX, int posY, int damage, Allegiance a){
		super(dimX, dimY, posX, posY, damage, a, "C:/xampp/htdocs/LPOO/resources/missile_" + a + ".png");
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}