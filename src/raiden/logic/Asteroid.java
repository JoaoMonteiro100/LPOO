package raiden.logic;

import raiden.logic.Game.Allegiance;

/**
 * Corpo com as propriedades de Entidade. Não pode lançar projéteis. Serve para
 * atrapalhar o jogador, uma vez que ao chocar com este lhe causa dano.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */

public class Asteroid extends Entity {
	
	private static final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/asteroid.png";

	public Asteroid(int dimX, int dimY, int posX, int posY, int HP){
		super(posX, posY, HP, 0, IMAGE_PATH, Allegiance.ENEMY);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}