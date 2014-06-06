package raiden.logic;

import raiden.logic.Game.Allegiance;

/**
 * Proj�til. Pode ser enviado por jogadores ou inimigos. A vari�vel "allegiance"
 * determina a quem pertence o proj�til (jogador 1, jogador 2, ou inimigos).
 * @author Jo�o
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public abstract class Projectile extends Entity {

	public Projectile(int dimX, int dimY, int posX, int posY, int damage, Allegiance a, String path){
		super(dimX, dimY, posX, posY, 0, damage, path,a);
	}

	public void move() {
	
	}
}