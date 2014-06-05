package raiden.logic;

/**
 * Permite que o jogador faça mais dano com os seus projéteis durante um período
 * de tempo.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */
public class DamageBoost extends PowerUp {

	private static final String IMAGE_PATH = "resources/damage boost.png";
	private int damageBoost;

	public DamageBoost(int posX, int posY, int damageBoost){
		super(posX, posY, IMAGE_PATH);
		this.damageBoost = damageBoost;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}