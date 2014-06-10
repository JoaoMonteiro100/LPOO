package raiden.logic;

/**
 * Configura��es pr�-definidas para enviar ao construtor de aster�ides. Deste modo
 * poder-se-�o rapidamente criar diversos tipos de aster�ides e duplic�-los sem
 * dificuldade.
 * @author Jo�o
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */

public class AsteroidConfigurations {

	private int HP;
	private int speed;
	
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}