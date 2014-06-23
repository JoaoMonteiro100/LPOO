package raiden.logic;

import java.awt.Toolkit;
import java.util.ArrayList;

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
	
	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}


	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}
	
	public void fire() {
        projectiles.add(new Missile(posX + (dimX/2), posY, damage, allegiance));
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