package Frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



import Code.*;
public class agent_administration extends JFrame {

	private JPanel contentPane;
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

		// creation des boutons supprimer et modifier
		JButton btnNewButton_1 = new JButton("supprimer");
		JButton btnNewButton_2 = new JButton("modifier");

		// création du bouton ajouter et assimilation avec le code
		JButton btnNewButton = new JButton("ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter_patient ajouterpatient = new ajouter_patient();
				ajouterpatient.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 142, 189, 50);
		contentPane.add(btnNewButton);
		
		//création et assimilation du bouton rechercher avec le code
		JButton rechercher = new JButton("rechercher");
		rechercher.setBounds(236, 17, 152, 58);
		contentPane.add(rechercher);
		rechercher.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
				basePatient basePat = new basePatient("ListePatient.txt");
				try{
					basePat.load();
				}catch(IOException e){
					System.out.println((e.toString()));
				}
				String nbSS = textField.getText();
				
				try{
				    Patient patR = basePat.rechercherPatient(nbSS);
					System.out.println(patR.toString());
					textField_1.setText(" patient : " + patR.toString());
				}catch(KeyException e){
					System.out.println((e.toString()));
				}
				btnNewButton_1.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				btnNewButton.setEnabled(false);
			}		
		});
		
		textField = new JTextField();
		textField.setBounds(32, 27, 167, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// assimilation du bouton supprimer avec le code
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(224, 142, 189, 50);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			basePatient basePat = new basePatient("ListePatient.txt");
				try{
					basePat.load();
				}catch(FileNotFoundException ev){
					System.out.println(ev.toString());
				}
				String nbSS = textField.getText();
				basePat.supprimerPatient(nbSS);
				textField_1.setText("le patient " + nbSS + " a ete suprime");
				try{
					basePat.save();
				}catch(IOException event){
					System.out.println(event.toString());
				}
				
			}
		});
		
		
		//assimilation du bouton modifier avec le code
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(115, 202, 189, 50);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientRecup = textField_1.getText();
				String [] mots  = patientRecup.split("/");
				String nbSS = mots[2];
				modifier_patient modifierpatient = new modifier_patient(nbSS);
				modifierpatient.setVisible(true);
			}
		});
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 77, 356, 54);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
	}
}
