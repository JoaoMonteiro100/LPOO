package raiden.logic;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import raiden.logic.Game.Allegiance;

/**
 * Representa o jogador. Contém um contador do boost (apenas pode ter um boost de
 * cada vez; se apanhar outro boost com temporizador, este substitui o mais
 * antigo) e boleanos para determinar se tem os vários tipos de boost. Pode lançar
 * projéteis. O seu score depende de quantos inimigos/asteróides tiver destruído.
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:12
 */

public class Ship extends Entity {

	private static final String IMAGE_PATH_PLAYER1 = "C:/xampp/htdocs/LPOO/resources/ship_player1.png";
	private static final String IMAGE_PATH_PLAYER2 = "C:/xampp/htdocs/LPOO/resources/ship_player2.png";
	private static final int baseSpeed = 3;
	private int boostTimer;
	private boolean hasDamageBoost;
	private boolean hasShield;
	private boolean hasTurbo;
	private int score;
	private ArrayList<Projectile> projectiles;

	public Ship(int HP, int baseDamage, Allegiance a){
		super(128, 128, 40, 60, HP, baseDamage, "C:/xampp/htdocs/LPOO/resources/ship_" + a + ".png", a);
		
		hasDamageBoost = false;
		hasShield = false;
		hasTurbo = false;
		score = 0;
		boostTimer = 0;
		
		projectiles = new ArrayList<Projectile>();
	}

	public int getBoostTimer() {
		return boostTimer;
	}


	public void setBoostTimer(int boostTimer) {
		this.boostTimer = boostTimer;
	}


	public boolean hasDamageBoost() {
		return hasDamageBoost;
	}


	public void acquiredDamageBoost(boolean hasDamageBoost) {
		this.hasDamageBoost = hasDamageBoost;
	}


	public boolean hasShield() {
		return hasShield;
	}


	public void acquiredShield(boolean hasShield) {
		this.hasShield = hasShield;
	}


	public boolean HasTurbo() {
		return hasTurbo;
	}


	public void acquiredTurbo(boolean hasTurbo) {
		this.hasTurbo = hasTurbo;
	}


	public int getScore() {
		return score;
	}


	public void increaseScore(int score) {
		this.score += score;
	}


	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}


	public void addProjectile(Projectile projectile) {
		this.projectiles.add(projectile);
	}


    public void move() {
        this.posX += dx * this.speed;
        this.posY += dy * this.speed;
    }

    public Image getImage() {
        return image;
    }

    public void moveRight() {
    	dx = baseSpeed;
    }
    
    public void moveLeft() {
    	dx = -baseSpeed;
    }
    
    public void moveUp() {
    	dy = -baseSpeed;
    }
    
    public void moveDown() {
    	dy = baseSpeed;
    }

    public void fire() {
        projectiles.add(new Missile(posX + (dimX/2), posY, damage, allegiance));
    }

    public void stopHorizontally() {
    	dx = 0;
    }
    
    public void stopVertically() {
    	dy = 0;
    }
}