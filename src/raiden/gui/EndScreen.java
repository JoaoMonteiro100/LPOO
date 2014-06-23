package raiden.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * Classe que cria a janela de diálogo que assinala o fim do jogo
 */
public class EndScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Função de representação da janela
	 * @param victory - true se tiver sido uma vitória, false se tiver sido uma derrota
	 */
	public EndScreen(boolean victory) {
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//painel da vitória
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblVitria = new JLabel("Victory!!");
		panel.add(lblVitria);

		//painel da derrota
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		JLabel lblDerrota = new JLabel("Defeat!");
		panel_1.add(lblDerrota);

		//se tiver sido vitória, esconde-se o painel da derrota
		if (victory) {
			lblVitria.setVisible(true);
			lblDerrota.setVisible(false);
		} else { //e vice-versa
			lblVitria.setVisible(false);
			lblDerrota.setVisible(true);
		}

		//botão para começar novo jogo
		JButton btnJogarOutraVez = new JButton("Play again!");
		contentPane.add(btnJogarOutraVez, BorderLayout.SOUTH);
		btnJogarOutraVez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Menu m = new Menu();
				m.setVisible(true);
				setVisible(false);
			}
		});
	}

}
