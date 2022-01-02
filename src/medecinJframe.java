import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;

public class medecinJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_4;
	private JTextField textField_4;
	private JList list;

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
		btnNewButton.setBounds(116, 154, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBounds(116, 196, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(344, 154, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modifier");
		btnNewButton_3.setBounds(344, 196, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(10, 155, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 197, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(238, 155, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(238, 197, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_4 = new JButton("ajouterPathologie");
		btnNewButton_4.setBounds(116, 240, 119, 23);
		contentPane.add(btnNewButton_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 241, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		list = new JList();
		list.setBounds(28, 11, 398, 132);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(245, 240, 181, 22);
		contentPane.add(comboBox);
	}
}
