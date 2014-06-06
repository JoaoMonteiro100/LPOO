package raiden.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import raiden.logic.Missile;
import raiden.logic.Game.Allegiance;
import raiden.logic.Projectile;
import raiden.logic.Ship;

public class Board extends JPanel implements ActionListener{

	private Timer timer;
    private Ship ship;
    final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/background.png";
	Image background;

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        ship = new Ship(500,100,Allegiance.PLAYER1);

        timer = new Timer(5, this);
        timer.start();
        
        ImageIcon ii = new ImageIcon(IMAGE_PATH);
        background = ii.getImage();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(background, 10, 10, null); 
        
        ArrayList ms = ship.getProjectiles();

        for (int i = 0; i < ms.size(); i++ ) {
            Missile m = (Missile) ms.get(i);
            g2d.drawImage(m.getImage(), m.getPosX(), m.getPosY(), this);
        }
        
        g2d.drawImage(ship.getImage(), ship.getPosX(), ship.getPosY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        ArrayList projectiles = ship.getProjectiles();

        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = (Projectile) projectiles.get(i);
            if (!p.isDead()) 
                p.move();
            else projectiles.remove(i);
        }

        ship.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

    	private boolean shooting;
    	
        public void keyReleased(KeyEvent e) {
        	int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && key != KeyEvent.VK_RIGHT) {
                ship.stopHorizontally();
            }

            if (key == KeyEvent.VK_RIGHT && key != KeyEvent.VK_LEFT) {
            	ship.stopHorizontally();
            }

            if (key == KeyEvent.VK_UP && key != KeyEvent.VK_DOWN) {
                ship.stopVertically();
            }

            if (key == KeyEvent.VK_DOWN && key != KeyEvent.VK_UP) {
            	ship.stopVertically();
            }
            
            if (key == KeyEvent.VK_SPACE && key != KeyEvent.VK_UP && key != KeyEvent.VK_DOWN && key != KeyEvent.VK_LEFT && key != KeyEvent.VK_RIGHT) {
                shooting = false;
            }
            
            if (shooting) {
            	ship.fire();
            }
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                ship.moveLeft();
            }

            if (key == KeyEvent.VK_RIGHT) {
            	ship.moveRight();
            }

            if (key == KeyEvent.VK_UP) {
            	ship.moveUp();
            }

            if (key == KeyEvent.VK_DOWN) {
            	ship.moveDown();
            }
            
            if (key == KeyEvent.VK_SPACE) {
                shooting = true;
            }
            
            if (shooting) {
            	ship.fire();
            }
        }
    }
}
