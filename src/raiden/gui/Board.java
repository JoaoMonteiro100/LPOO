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
import raiden.logic.Ship;

public class Board extends JPanel implements ActionListener{

	private Timer timer;
    private Ship ship;
    final String IMAGE_PATH = "resources/background.png";
	Image background;

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        ship = new Ship(500,100);

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
        ArrayList ms = ship.getProjectiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (!m.isDead()) 
                m.move();
            else ms.remove(i);
        }

        ship.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            ship.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            ship.keyPressed(e);
        }
    }
}
