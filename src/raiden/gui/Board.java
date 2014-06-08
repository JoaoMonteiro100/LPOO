package raiden.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
//import java.util.concurrent.BlockingQueue;





import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import raiden.logic.Enemy;
import raiden.logic.Missile;
import raiden.logic.Game.Allegiance;
import raiden.logic.Projectile;
import raiden.logic.Ship;

public class Board extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
    private Ship ship;
    private final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/background.png";
	private Image background;
	private ArrayList<Enemy> enemys;
	private boolean ingame;
	private int B_WIDTH;
    private int B_HEIGHT;
	
	private int[][] pos = { 
		    {2000, 29}, {1900, 59}, {1380, 89},
		    {780, 109}, {580, 139}, {680, 239}, 
		    {790, 259}, {760, 50}, {790, 150},
		    {980, 209}, {560, 45}, {510, 70},
		    {930, 159}, {590, 80}, {530, 60},
		    {940, 59}, {990, 30}, {920, 200},
		    {900, 259}, {660, 50}, {540, 90},
		    {810, 220}, {860, 20}, {740, 180},
		    {820, 128}, {490, 170}, {700, 30}
		};

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        ingame = true;

        ship = new Ship(500,100,Allegiance.PLAYER1);
        
        initAliens();

        timer = new Timer(5, this);
        timer.start();
        
        ImageIcon ii = new ImageIcon(IMAGE_PATH);
        background = ii.getImage();
    }
    
    public void addNotify() {
        super.addNotify();
        B_WIDTH = getWidth();
        B_HEIGHT = getHeight();   
    }

    public void initAliens() {
        enemys = new ArrayList<Enemy>();

        for (int i=0; i<pos.length; i++ ) {
            enemys.add(new Enemy(12, 12, pos[i][0], pos[i][1], 12, 11));
        }
    }
    public void paint(Graphics g) {
        super.paint(g);
        
        if(ingame)
        {
        	Graphics2D g2d = (Graphics2D) g;
        
	        g2d.drawImage(background, 0, 0, null);
	        
	        if(ship.isVisible())
            	g2d.drawImage(ship.getImage(), ship.getPosX(), ship.getPosY(), this);
	        
	        ArrayList<Projectile> ms = ship.getProjectiles();
	
	        for (int i = 0; i < ms.size(); i++ ) {
	            Projectile m = (Missile) ms.get(i);
	            g2d.drawImage(m.getImage(), m.getPosX(), m.getPosY(), this);
	        }
	        
	        for (int i = 0; i < enemys.size(); i++) {
                Enemy e = (Enemy)enemys.get(i);
                if (e.isVisible())
                    g2d.drawImage(e.getImage(), e.getPosX(), e.getPosY(), this);
            }
	        
	        g2d.setColor(Color.WHITE);
            g2d.drawString("Enemys left: " + enemys.size(), 5, 15);
        
        }
        else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2,
                         B_HEIGHT / 2);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
    	
    	if (enemys.size()==0) 
            ingame = false;
            
        ArrayList<Projectile> projectiles = ship.getProjectiles();

        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = (Projectile) projectiles.get(i);
            if (!p.isDead()) 
                p.move();
            else projectiles.remove(i);
        }
        
        for (int i = 0; i < enemys.size(); i++) {
            Enemy en = (Enemy) enemys.get(i);
            if (en.isVisible()) 
                en.move();
            else enemys.remove(i);
        }

        ship.move();
        checkCollisions();
        repaint();  
    }
    
    public void checkCollisions() {

        Rectangle r3 = ship.getBounds();

        for (int j = 0; j<enemys.size(); j++) {
            Enemy e = (Enemy) enemys.get(j);
            Rectangle r2 = e.getBounds();

            if (r3.intersects(r2)) {
                ship.setInvisible();
                e.setInvisible();
                ingame = false;
            }
        }

        ArrayList<Projectile> ms = ship.getProjectiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);

            Rectangle r1 = m.getBounds();

            for (int j = 0; j<enemys.size(); j++) {
                Enemy a = (Enemy) enemys.get(j);
                Rectangle r2 = a.getBounds();

                if (r1.intersects(r2)) {
                    m.setInvisible();
                    a.setInvisible();
                }
            }
        }
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
