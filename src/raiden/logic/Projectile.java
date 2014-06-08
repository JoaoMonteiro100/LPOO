package raiden.logic;

import javax.swing.ImageIcon;

import raiden.logic.Game.Allegiance;

/**
 * Projétil. Pode ser enviado por jogadores ou inimigos. A variável "allegiance"
 * determina a quem pertence o projétil (jogador 1, jogador 2, ou inimigos).
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public abstract class Projectile extends Entity {

	public Projectile(int dimX, int dimY, int posX, int posY, int damage, Allegiance a, String path){
		super(posX, posY, 0, damage, path,a);

	        /*ImageIcon ii =
	            new ImageIcon(this.getClass().getResource("missile.png"));
	        image = ii.getImage();*/
	        /*visible = true;
	        dimX = image.getWidth(null);
	        dimY = image.getHeight(null);
	        this.posX = posX;
	        this.posY = posY;*/
	}

	public void move() {
	
	}
}