package raiden.logic;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Representa os itens que um jogador pode apanhar para ganhar benef�cios. Os
 * inimigos e aster�ides n�o os podem apanhar. Para apanhar um PowerUp basta
 * deslocar-se por cima deste. Alguns PowerUps t�m um "decayTime", ap�s o qual
 * deixam de se aplicar (ex: o escudo tem tempo limitado). O boleano "isTaken"
 * determina se ele ainda existe ou se j� foi consumido por um jogador.
 * @author Jo�o
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */
public abstract class PowerUp {

	private int decayTime;
	private int dimX;
	private int dimY;
	private boolean isTaken;
	private int posX;
	private int posY;
	protected String sprite;
	protected Image image;

	public PowerUp(int posX, int posY, String sprite){
		this.isTaken = false;
		this.posX = posX;
		this.posY = posY;
		this.sprite = sprite;
		ImageIcon ii = new ImageIcon(sprite);
		image = ii.getImage();
	}
}