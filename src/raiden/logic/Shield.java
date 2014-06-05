package raiden.logic;

/**
 * Torna o jogador invulnerável durante um período de tempo.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public class Shield extends PowerUp {

	private static final String IMAGE_PATH = "resources/shield.png";
	int damageReduction;
	
	public Shield(int posX, int posY, int damageReduction){
		super(posX, posY, IMAGE_PATH);
		this.damageReduction = damageReduction;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}