package raiden.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

import raiden.logic.*;

public class Display extends JFrame {

	public Display() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(800, 600);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());  
        int ySize = ((int) tk.getScreenSize().getHeight());  
        setSize(xSize,ySize);  
        setLocationRelativeTo(null);
        setTitle("Raiden");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Display();
    }
}