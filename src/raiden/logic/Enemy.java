package raiden.logic;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

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
	private ArrayList<Projectile> projectiles;

	public Enemy(int dimX, int dimY, int posX, int posY, int HP, int baseDamage){
		super(posX, posY, HP, baseDamage, IMAGE_PATH, Allegiance.ENEMY);
		
        dimX = image.getWidth(null);
        dimY = image.getHeight(null);
        this.posX = posX;
        this.posY = posY;
		
	}
	
	public void move() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        
        if (posY < 0) //achar o limite superior
            posY = -dimY;
        posY += 1;
        /*
		if (posY < 0) 
			posY = 400;
		posY -= 1;
		*/
    }

	public void finalize() throws Throwable {
		super.finalize();
	}

}