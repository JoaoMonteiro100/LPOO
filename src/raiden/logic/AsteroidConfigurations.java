package raiden.logic;

/**
 * Configurações pré-definidas para enviar ao construtor de asteróides. Deste modo
 * poder-se-ão rapidamente criar diversos tipos de asteróides e duplicá-los sem
 * dificuldade.
 * @author João
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