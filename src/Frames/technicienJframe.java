package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class technicienJframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					technicienJframe frame = new technicienJframe();
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

	 //titre de la frame
	public technicienJframe() {
		setTitle("Technicien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//creations des du bouton octroyer et assimilation au code
		JButton btnNewButton = new JButton("octroyer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(241, 172, 185, 80);
		contentPane.add(btnNewButton);
		

		//creation du bouton rechercher et assimilation au code

		JButton btnNewButton_1 = new JButton("rechercher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(241, 64, 185, 85);
		contentPane.add(btnNewButton_1);
		

		//creation du textfield pour rechercher
		textField = new JTextField();
		textField.setBounds(10, 64, 221, 85);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
	}
}
