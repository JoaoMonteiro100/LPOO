package raiden.logic;

/**
 * Regenera a vida de um jogador.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public class Health extends PowerUp {

	private static final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/health.png";
	private int HP_Increase;

	public Health(int posX, int posY, int HP_increase){
		super(posX, posY, IMAGE_PATH);
		this.HP_Increase = HP_increase;
	}
	
	public int HP() {
		return HP_Increase;
	}
}