package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class medecinJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_4;
	private JTextField textField_4;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medecinJframe frame = new medecinJframe();
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
	public medecinJframe() {
		setTitle("M\u00E9decin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setBounds(245, 150, 181, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter_consultation ajouterconsultation = new ajouter_consultation();
				ajouterconsultation.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(20, 196, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(182, 196, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifier");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_consultation modifierconsultation = new modifier_consultation();
				modifierconsultation.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(337, 196, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(38, 150, 167, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_4 = new JButton("ajouterPathologie");
		btnNewButton_4.setBounds(116, 240, 119, 23);
		contentPane.add(btnNewButton_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 241, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(245, 240, 181, 22);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(38, 11, 362, 128);
		contentPane.add(lblNewLabel);
	}
}
