package raiden.logic;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * Representa os itens que um jogador pode apanhar para ganhar benefícios. Os
 * inimigos e asteróides não os podem apanhar. Para apanhar um PowerUp basta
 * deslocar-se por cima deste. Alguns PowerUps têm um "decayTime", após o qual
 * deixam de se aplicar (ex: o escudo tem tempo limitado). O boleano "isTaken"
 * determina se ele ainda existe ou se já foi consumido por um jogador.
 * @author João
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
		this.dimX = image.getWidth(null);
		this.dimY = image.getHeight(null);
	}
	
	public boolean isTaken() {
		return isTaken;
	}
	
	public void take() {
		isTaken = true;
	}
	
	public int getDimX() {
		return dimX;
	}

	public void setDimX(int dimX) {
		this.dimX = dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public void setDimY(int dimY) {
		this.dimY = dimY;
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public Rectangle getBounds() {
        return new Rectangle(posX, posY, dimX, dimY);
    }
	
public void move() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
        //int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        
        if (posY > ySize) //achar o limite superior
            posY = -100;
        posY += 1;
		
    }
}