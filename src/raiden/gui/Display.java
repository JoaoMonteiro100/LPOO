package raiden.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Display extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Display() {

        add(new Board());

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

    public static void main(String[] args) {
        new Display();
    }
}