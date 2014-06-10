package raiden.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

import raiden.logic.Game;
import raiden.logic.GameConfigurations;

public class Display extends JFrame {

	public Display(GameConfigurations configs) {
		Game g = new Game(configs);
        add(new Board(g));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        setSize(xSize,ySize);  
        setLocationRelativeTo(null);
        setTitle("Raiden");
        setResizable(false);
        setVisible(true);
    }
}