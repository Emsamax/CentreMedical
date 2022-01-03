package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rechercher_consultation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rechercher_consultation frame = new rechercher_consultation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public rechercher_consultation() {
		setTitle("rechercher consultation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(41, 11, 347, 79);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("supprimer");
		btnNewButton_1.setBounds(297, 133, 129, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_consultation modifierconsultation = new modifier_consultation();
				modifierconsultation.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 133, 117, 58);
		contentPane.add(btnNewButton);
	}

}
