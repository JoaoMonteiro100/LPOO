package raiden.logic;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Representa todas as entidades do jogo, que têm em comum propriedades físicas
 * (posição, dimensões, velocidade, direção), bem como HP (hit points, ou vida),
 * um indicator do dano que causam (damage) e um boleano a indicar se está vivo ou
 * morto (isDead).
 * @author João
 * @version 1.0
 * @created 02-jun-2014 16:29:11
 */

public abstract class Entity {

	protected int damage;
	protected int dimX;
	protected int dimY;
	protected Direction direction;
	protected int HP;
	protected boolean isDead;
	protected int posX;
	protected int posY;
	protected int speed;
	protected int dx;
	protected int dy;
	protected String sprite;
	protected Image image;

	public enum Direction {
		LEFT, RIGHT, UP, DOWN, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT
	}
	
	public Entity(int dimX, int dimY, int posX, int posY, int HP, int baseDamage, String sprite){
		this.isDead = false;
		this.speed = 1;
		this.direction = Direction.UP;
		this.dx = 0;
		this.dy = 0;
		
		this.dimX = dimX;
		this.dimY = dimY;
		this.posX = posX;
		this.posY = posY;
		this.HP = HP;
		this.damage = baseDamage;
		this.sprite = sprite;
		ImageIcon ii = new ImageIcon(sprite);
		image = ii.getImage();
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
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
}