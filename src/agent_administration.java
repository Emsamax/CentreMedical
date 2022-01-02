import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;

public class agent_administration extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_3;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agent_administration frame = new agent_administration();
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
	public agent_administration() {
		setTitle("Agent administration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter_patient ajouterpatient = new ajouter_patient();
				ajouterpatient.setVisible(true);
			}
		});
		btnNewButton.setBounds(309, 233, 117, 24);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("rechercher");
		btnNewButton_1.setBounds(244, 142, 152, 58);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifier_patient modifierpatient = new modifier_patient();
				modifierpatient.setVisible(true);
			}
		});
		
				
	
		btnNewButton_2.setBounds(166, 233, 117, 24);
		contentPane.add(btnNewButton_2);
		
		
		btnNewButton_3 = new JButton("supprimer");
		btnNewButton_3.setBounds(32, 233, 101, 24);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(32, 152, 167, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 24, 364, 107);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	}
}
