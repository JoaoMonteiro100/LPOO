package raiden.logic;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import raiden.logic.Projectile.Allegiance;

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

	private static final String IMAGE_PATH = "resources/ship.png";
	private static final int baseSpeed = 5;
	private int boostTimer;
	private boolean hasDamageBoost;
	private boolean hasShield;
	private boolean hasTurbo;
	private int score;
	private ArrayList<Projectile> projectiles;

	public Ship(int HP, int baseDamage){
		super(128, 128, 40, 60, HP, baseDamage, IMAGE_PATH);
		
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


	public boolean isHasDamageBoost() {
		return hasDamageBoost;
	}


	public void setHasDamageBoost(boolean hasDamageBoost) {
		this.hasDamageBoost = hasDamageBoost;
	}


	public boolean isHasShield() {
		return hasShield;
	}


	public void setHasShield(boolean hasShield) {
		this.hasShield = hasShield;
	}


	public boolean isHasTurbo() {
		return hasTurbo;
	}


	public void setHasTurbo(boolean hasTurbo) {
		this.hasTurbo = hasTurbo;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public ArrayList<Projectile> getProjectiles() {
		return projectiles;
	}


	public void setProjectiles(ArrayList<Projectile> projectiles) {
		this.projectiles = projectiles;
	}


    public void move() {
        this.posX += dx * this.speed;
        this.posY += dy * this.speed;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -baseSpeed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = baseSpeed;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -baseSpeed;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = baseSpeed;
        }
    }

    public void fire() {
        projectiles.add(new Missile(posX + (dimX/2), posY, damage, Allegiance.PLAYER1));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}