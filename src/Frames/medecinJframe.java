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
	private JTextField textField_1;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rechercher_consultation rechercherconsultation = new rechercher_consultation();
				rechercherconsultation.setVisible(true);
			}
		});
		btnNewButton.setBounds(205, 19, 221, 54);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 167, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_4 = new JButton("Pathologie");
		btnNewButton_4.setBounds(219, 210, 150, 42);
		contentPane.add(btnNewButton_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(86, 211, 109, 40);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2_1 = new JButton("modifier");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_consultation modifierconsultation = new modifier_consultation();
				modifierconsultation.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(10, 146, 102, 47);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("supprimer");
		btnNewButton_2_1_1.setBounds(151, 146, 102, 47);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("ajouter");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter_consultation ajouterconsultation = new ajouter_consultation();
				ajouterconsultation.setVisible(true);
			}
		});
		btnNewButton_2_1_2.setBounds(300, 146, 102, 47);
		contentPane.add(btnNewButton_2_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 88, 414, 47);
		contentPane.add(textField_1);
	}
}
