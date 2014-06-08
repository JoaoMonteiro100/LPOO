package raiden.logic;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import raiden.logic.Game.Allegiance;

/**
 * Naves espaciais inimigas, com a capacidade de lançar projéteis e se
 * movimentarem.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */
public class Enemy extends Entity {

	private static final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/enemy.png";
	private int AI_level;

	public Enemy(int dimX, int dimY, int posX, int posY, int HP, int baseDamage){
		super(posX, posY, HP, baseDamage, IMAGE_PATH, Allegiance.ENEMY);
		
        dimX = image.getWidth(null);
        dimY = image.getHeight(null);
        visible = true;
        this.posX = posX;
        this.posY = posY;
		
	}
	
	public void move() {
        if (posY > 1125) //achar o limite superior
            posY = 0;
        posY += 1;
    }

	public void finalize() throws Throwable {
		super.finalize();
	}

}