package raiden.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

import raiden.logic.GameConfigurations;
import raiden.logic.GameConfigurations.Difficulty;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe para criação da janela inicial onde se configuram as opções do jogo
 */
public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Função onde se representa a janela
	 */
	public Menu() {
		//configurações da janela
		setResizable(false);
		setFont(new Font("Calibri Light", Font.PLAIN, 13));
		setTitle("Raiden");
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//frase de boas-vindas
		JLabel label_welcomeMessage = new JLabel(
				"Welcome to Raiden");
		label_welcomeMessage.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		label_welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label_welcomeMessage, BorderLayout.NORTH);

		final JComboBox<String> comboBox = new JComboBox<String>();
		final JSpinner spinner_1 = new JSpinner();

		//opções
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[189px][]",
				"[14px][14px][20px][23px][]"));

		JLabel label_numberOfPlayers = new JLabel(
				"Number of players");
		panel_2.add(label_numberOfPlayers, "cell 0 0,alignx left,aligny center");

		spinner_1.setEnabled(true);
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1),
				new Integer(1), new Integer(2), new Integer(1)));
		panel_2.add(spinner_1, "cell 1 0");

		JLabel label_difficulty = new JLabel(
				"What's the game difficulty?");
		panel_2.add(label_difficulty, "cell 0 2,alignx left,aligny bottom");

		comboBox.setEnabled(true);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Easy", "Medium", "Hard" }));
		panel_2.add(comboBox, "cell 0 3,growx,aligny top");

		//botão de iniciar jogo
		JButton button_play = new JButton("PLAY");
		button_play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//transportam-se as configurações escolhidas para a classe GameConfigurations
				final GameConfigurations configurations = new GameConfigurations();
				int difficulty;

				configurations.setNumberOfPlayers((Integer) spinner_1.getValue());
				difficulty = comboBox.getSelectedIndex();
				switch(difficulty) {
				case(0):
					configurations.setDifficulty(Difficulty.EASY);
					break;
					
				case(1):
					configurations.setDifficulty(Difficulty.MEDIUM);
					break;
					
				case(2):
					configurations.setDifficulty(Difficulty.HARD);
					break;
					
				default:
					configurations.setDifficulty(Difficulty.EASY);
					break;
				}
				
				Display frame = new Display(configurations);
				frame.setVisible(true);
				setVisible(false);
			}
		});
		button_play.setFont(new Font("Gadugi", Font.PLAIN, 18));
		contentPane.add(button_play, BorderLayout.SOUTH);
	}
}