package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Code.*;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyException;
import java.awt.event.ActionEvent;

public class modifier_patient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifier_patient frame = new modifier_patient();
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
	public modifier_patient() {
		setTitle("modifier patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(73, 11, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 63, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 11, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 60, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 14, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(10, 66, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" meme numero securite social");
		lblNewLabel_2.setBounds(179, 14, 128, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("date de naissancce");
		lblNewLabel_3.setBounds(211, 63, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(46, 176, 332, 87);
		contentPane.add(lblNewLabel_4);

		JButton modif = new JButton("Valider");
		modif.setBounds(46, 114, 332, 51);
		contentPane.add(modif);
		modif.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				basePatient basePat = new basePatient("ListePatient.txt");
				try{
					basePat.load();
				}catch(IOException e){
					System.out.println((e.toString()));
				}
				String nom = textField.getText();
				String prenom = textField_1.getText();
				String nbSS = textField_2.getText();
				String dateNaissance = textField_3.getText();
				Patient pat = new Patient(nom.trim(), prenom.trim(), nbSS.trim(), dateNaissance.trim());

				try{
					basePat.modifierPatient(nom, prenom, nbSS, dateNaissance);
					basePat.save();
					lblNewLabel_4.setText(" le patient "+ pat+ "  a bien ete modife" );
				}catch(IOException e){
					System.out.println(e.toString());
				}catch(KeyException e){
					System.out.println(e.toString());
				}
			}
				
		});
		
		
	}

}
