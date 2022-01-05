package Frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class StatistiquesJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistiquesJframe frame = new StatistiquesJframe();
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
	public StatistiquesJframe() {
		setTitle("Statistiques");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de patients ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 176, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de consultations ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 97, 210, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("pourcentage de patient avec consultation ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 195, 282, 45);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(304, 195, 282, 45);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("nombre d'appareil medical octroye ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 293, 282, 45);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(304, 293, 282, 45);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("pourcentage d'appareil medical octroye ");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 374, 282, 45);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_1.setBounds(304, 374, 282, 45);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("New label");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_2.setBounds(304, 97, 282, 45);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("New label");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1_3.setBounds(304, 10, 282, 45);
		contentPane.add(lblNewLabel_1_1_1_1_3);
	}
}
