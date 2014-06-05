package raiden.logic;

/**
 * Permite que o jogador se desloque mais depressa durante um período de tempo.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public class Turbo extends PowerUp {

	private static final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/turbo.png";
	private int speedBoost;

	public Turbo(int posX, int posY, int speedBoost){
		super(posX, posY, IMAGE_PATH);
		this.speedBoost = speedBoost;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}