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





import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import raiden.gui.EndScreen;
import raiden.logic.Coin;
import raiden.logic.Enemy;
import raiden.logic.Game;
import raiden.logic.Health;
import raiden.logic.Missile;
import raiden.logic.Game.Allegiance;
import raiden.logic.PowerUp;
import raiden.logic.Projectile;
import raiden.logic.Shield;
import raiden.logic.Ship;
import raiden.logic.Turbo;

public class Board extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Game game;
    private final String IMAGE_PATH = "C:/xampp/htdocs/LPOO/resources/background.png";
	private Image background;
	private int B_WIDTH;
    private int B_HEIGHT;
	
    public Board(Game g) {

    	game = g;
    	Timer timer;
    	
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

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


    public void paint(Graphics g) {
        super.paint(g);
        
        if(!game.isGameOver())
        {
        	Graphics2D g2d = (Graphics2D) g;
        
	        g2d.drawImage(background, 0, 0, null);
	        
	        if(!game.getPlayer1().isDead())
            	g2d.drawImage(game.getPlayer1().getImage(), game.getPlayer1().getPosX(), game.getPlayer1().getPosY(), this);
	        
	        ArrayList<Projectile> ms = game.getPlayer1().getProjectiles();
	
	        for (int i = 0; i < ms.size(); i++ ) {
	            Projectile m = (Missile) ms.get(i);
	            g2d.drawImage(m.getImage(), m.getPosX(), m.getPosY(), this);
	        }
	        
	        if(game.getPlayer2().getPosX() != -1000) {
	        	
	        	if(!game.getPlayer2().isDead())
	            	g2d.drawImage(game.getPlayer2().getImage(), game.getPlayer2().getPosX(), game.getPlayer2().getPosY(), this);
		        
		        ArrayList<Projectile> ms2 = game.getPlayer2().getProjectiles();
		
		        for (int i = 0; i < ms2.size(); i++ ) {
		            Projectile m = (Missile) ms2.get(i);
		            g2d.drawImage(m.getImage(), m.getPosX(), m.getPosY(), this);
		        }
		        
	        }
	        
	        for (int i = 0; i < game.getMobs().size(); i++) {
                Enemy e = (Enemy) game.getMobs().get(i);
                if (!e.isDead()) {
                    g2d.drawImage(e.getImage(), e.getPosX(), e.getPosY(), this);
                }
            }
	        
	        for (int i = 0; i < game.getBoosts().size(); i++) {
                PowerUp e = (PowerUp) game.getBoosts().get(i);
                if (!e.isTaken()) {
                    g2d.drawImage(e.getImage(), e.getPosX(), e.getPosY(), this);
                }
            }
	        
	        g2d.setColor(Color.WHITE);
            g2d.drawString("Enemys left: " + game.getMobs().size(), 5, 15);
            g2d.drawString("Player 1 HP: " + game.getPlayer1().getHP(), 5, 35);
            g2d.drawString("Player 1 Score: " + game.getPlayer1().getScore(), 150, 35);
            if(game.getPlayer2().getPosX() != -1000) {
            	g2d.drawString("Player 2 HP: " + game.getPlayer2().getHP(), 5, 55);
            	g2d.drawString("Player 2 Score: " + game.getPlayer2().getScore(), 150, 55);
            }
        
        }
        else {
        	/*
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2,
                         B_HEIGHT / 2);
            */
        	EndScreen end = new EndScreen(game.isVictory());
        	end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	end.setVisible(true);
			setVisible(false);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
            
        ArrayList<Projectile> projectiles = game.getPlayer1().getProjectiles();

        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = (Projectile) projectiles.get(i);
            if (!p.isDead()) 
                p.move();
            else projectiles.remove(i);
        }
        
        if(game.getPlayer2().getPosX() != -1000) {
        	ArrayList<Projectile> projectiles2 = game.getPlayer2().getProjectiles();

            for (int i = 0; i < projectiles2.size(); i++) {
                Projectile p = (Projectile) projectiles2.get(i);
                if (!p.isDead()) 
                    p.move();
                else projectiles2.remove(i);
            }
        }
        
        for (int i = 0; i < game.getMobs().size(); i++) {
            Enemy en = (Enemy) game.getMobs().get(i);
            if (!en.isDead()) {
                en.move();
            }
            else game.removeMob(i);
        }

        for (int i = 0; i < game.getBoosts().size(); i++) {
        	PowerUp en = (PowerUp) game.getBoosts().get(i);
            if (!en.isTaken()) {
                en.move();
            }
            else game.removeBoost(i);
        }
        
        game.getPlayer1().move();
        
        if(game.getPlayer2().getPosX() != -1000) {
        	game.getPlayer2().move();
        }
        
        checkCollisions();
        repaint();  
    }
    
    public void checkCollisions() {
        Rectangle p1 = game.getPlayer1().getBounds();
        Rectangle p2 = null;
        
        if(game.getPlayer2().getPosX() != -1000) {
        	p2 = game.getPlayer2().getBounds();
        }
        
        //Ship with enemy
        for (int j = 0; j<game.getMobs().size(); j++) {
            Enemy e = (Enemy) game.getMobs().get(j);
            Rectangle mob = e.getBounds();

            if (p1.intersects(mob)) {
            	game.getPlayer1().collide(game.conf.getDifficulty());
                e.kill();
            }
            
            if (p2 != null) {
            	if (p2.intersects(mob)) {
                	game.getPlayer2().collide(game.conf.getDifficulty());
                    e.kill();
                }
                
            }
        }

        //Ship with boost
        for (int j = 0; j<game.getBoosts().size(); j++) {
        	if(game.getBoosts().get(j).getSprite() == "C:/xampp/htdocs/LPOO/resources/coin.png") {
	        	Coin e = (Coin) game.getBoosts().get(j);
	            Rectangle b = e.getBounds();
	
	            if (p1.intersects(b)) {
	            	game.getPlayer1().increaseScore(e.getScore());
	                e.take();
	            }
	            
	            if (p2 != null) {
	            	if (p2.intersects(b)) {
	                	game.getPlayer2().increaseScore(e.getScore());
	                    e.take();
	                }
	                
	            }
        	}
        	
        	if(game.getBoosts().get(j).getSprite() == "C:/xampp/htdocs/LPOO/resources/health.png") {
	        	Health e = (Health) game.getBoosts().get(j);
	            Rectangle b = e.getBounds();
	
	            if (p1.intersects(b)) {
	            	game.getPlayer1().increaseHP(e.HP());
	                e.take();
	            }
	            
	            if (p2 != null) {
	            	if (p2.intersects(b)) {
	                	game.getPlayer2().increaseHP(e.HP());
	                    e.take();
	                }
	                
	            }
        	}
        	
        	if(game.getBoosts().get(j).getSprite() == "C:/xampp/htdocs/LPOO/resources/turbo.png") {
	        	Turbo e = (Turbo) game.getBoosts().get(j);
	            Rectangle b = e.getBounds();
	
	            if (p1.intersects(b)) {
	            	game.getPlayer1().setSpeed(e.getSpeedBoost());
	            	game.getPlayer1().acquiredTurbo();
	                e.take();
	            }
	            
	            if (p2 != null) {
	            	if (p2.intersects(b)) {
	                	game.getPlayer2().setSpeed(e.getSpeedBoost());
	                	game.getPlayer2().acquiredTurbo();
	                    e.take();
	                }
	                
	            }
        	}
        }
        
       ArrayList<Projectile> ms = game.getPlayer1().getProjectiles();

        for (int i = 0; i < ms.size(); i++) {
            Projectile m = (Projectile) ms.get(i);

            Rectangle r1 = m.getBounds();

            for (int j = 0; j<game.getMobs().size(); j++) {
                Enemy e = (Enemy) game.getMobs().get(j);
                Rectangle mob = e.getBounds();

                if (r1.intersects(mob)) {
                    m.kill();
                    e.kill();
                }
            }
        }
        
       if(game.getPlayer2().getPosX() != -1000) {
        	ArrayList<Projectile> ms2 = game.getPlayer2().getProjectiles();

            for (int i = 0; i < ms2.size(); i++) {
                Projectile m = (Projectile) ms2.get(i);

                Rectangle r1 = m.getBounds();

                for (int j = 0; j<game.getMobs().size(); j++) {
                    Enemy e = (Enemy) game.getMobs().get(j);
                    Rectangle mob = e.getBounds();

                    if (r1.intersects(mob)) {
                        m.kill();
                        e.kill();
                    }
                }
            }
        }
    }


    private class TAdapter extends KeyAdapter {

    	private boolean shooting1, shooting2;
    	
        public void keyReleased(KeyEvent e) {
        	int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && key != KeyEvent.VK_RIGHT) {
                game.getPlayer1().stopHorizontally();
            }

            if (key == KeyEvent.VK_RIGHT && key != KeyEvent.VK_LEFT) {
            	game.getPlayer1().stopHorizontally();
            }

            if (key == KeyEvent.VK_UP && key != KeyEvent.VK_DOWN) {
            	game.getPlayer1().stopVertically();
            }

            if (key == KeyEvent.VK_DOWN && key != KeyEvent.VK_UP) {
            	game.getPlayer1().stopVertically();
            }
            
            if (key == KeyEvent.VK_SPACE && key != KeyEvent.VK_UP && key != KeyEvent.VK_DOWN && key != KeyEvent.VK_LEFT && key != KeyEvent.VK_RIGHT) {
                shooting1 = false;
            }
            
            if (shooting1) {
            	game.getPlayer1().fire();
            }
            
            if (key == KeyEvent.VK_A && key != KeyEvent.VK_D) {
                game.getPlayer2().stopHorizontally();
            }

            if (key == KeyEvent.VK_D && key != KeyEvent.VK_A) {
            	game.getPlayer2().stopHorizontally();
            }

            if (key == KeyEvent.VK_W && key != KeyEvent.VK_S) {
            	game.getPlayer2().stopVertically();
            }

            if (key == KeyEvent.VK_S && key != KeyEvent.VK_W) {
            	game.getPlayer2().stopVertically();
            }
            
            if (key == KeyEvent.VK_Z && key != KeyEvent.VK_W && key != KeyEvent.VK_S && key != KeyEvent.VK_A && key != KeyEvent.VK_D) {
                shooting2 = false;
            }
            
            if (shooting2) {
            	game.getPlayer1().fire();
            }
        }

        public void keyPressed(KeyEvent e) {
        	Toolkit tk = Toolkit.getDefaultToolkit();
            int xSize = ((int) tk.getScreenSize().getWidth());
            int ySize = ((int) tk.getScreenSize().getHeight());
            
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
            	if (game.getPlayer1().getPosX() >= 0) {
            		game.getPlayer1().moveLeft();
            	}
            }

            if (key == KeyEvent.VK_RIGHT) {
            	if (game.getPlayer1().getPosX() <= xSize) {
            		game.getPlayer1().moveRight();
            	}
            }

            if (key == KeyEvent.VK_UP) {
            	if (game.getPlayer1().getPosY() >= 0) {
            		game.getPlayer1().moveUp();
            	}
            }

            if (key == KeyEvent.VK_DOWN) {
            	if (game.getPlayer1().getPosY() < ySize) {
            		game.getPlayer1().moveDown();
            	}
            }
            
            if (key == KeyEvent.VK_SPACE) {
                shooting1 = true;
            }
            
            if (shooting1) {
            	game.getPlayer1().fire();
            }
            
            if (key == KeyEvent.VK_A) {
            	if (game.getPlayer2().getPosX() >= 0) {
            		game.getPlayer2().moveLeft();
            	}
            }

            if (key == KeyEvent.VK_D) {
            	if (game.getPlayer2().getPosX() <= xSize) {
            		game.getPlayer2().moveRight();
            	}
            }

            if (key == KeyEvent.VK_W) {
            	if (game.getPlayer2().getPosY() >= 0) {
            		game.getPlayer2().moveUp();
            	}
            }

            if (key == KeyEvent.VK_S) {
            	if (game.getPlayer2().getPosY() < ySize) {
            		game.getPlayer2().moveDown();
            	}
            }
            
            if (key == KeyEvent.VK_Z) {
                shooting2 = true;
            }
            
            if (shooting2) {
            	game.getPlayer2().fire();
            }
        }
    }
}
