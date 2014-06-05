package raiden.logic;

/**
 * Aumenta o score de um jogador.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */

public class Coin extends PowerUp {

	private static final String IMAGE_PATH = "resources/coin.png";
	private int scoreIncrease;

	public Coin(int posX, int posY, int scoreIncrease){
		super(posX, posY, IMAGE_PATH);
		this.scoreIncrease = scoreIncrease;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}