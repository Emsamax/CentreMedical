package Frames;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyException;
import java.awt.event.ActionEvent;

import Code.*;
import java.awt.Font;

public class ajouter_consultation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouter_consultation frame = new ajouter_consultation();
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
	public ajouter_consultation() {
		setTitle("ajouter consultation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// creation de tous les textfields qui permette d'écrire une consultation
		textField = new JTextField();
		textField.setBounds(304, 34, 147, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField1  = new JTextField();
		textField1.setBounds(304, 75, 147, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(304, 106, 147, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(304, 151, 147, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		// creation des label pour indiquer quelle information il faut mettre dans les textfield
		JLabel lblNewLabel = new JLabel("no securite sociale patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(68, 26, 218, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("appareil medical");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(64, 68, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("detail clinique");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(64, 105, 147, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("date ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(68, 151, 67, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 252, 566, 155);
		contentPane.add(lblNewLabel_4);
		
		// creation du bouton valider et assimilation avec le code
		JButton valider = new JButton("Valider");
		valider.setBounds(119, 190, 332, 51);
		contentPane.add(valider);
		valider.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				basePatient basePat = new basePatient("ListePatient.txt");
				baseConsultation baseCons = new baseConsultation("consultation.txt");
				Medecin medoc = new Medecin("dr Martino");
				try{
					basePat.load();
					baseCons.load(basePat);
				}catch(IOException e){
					System.out.println((e.toString()));
				}catch(KeyException e){
					System.out.println(e.toString());
				}

				String nbSS = textField.getText();
				String detailCliniques = textField2.getText();
				String appMedic = textField1.getText();
				String date = textField3.getText();
				Patient patRecherche =new Patient();
				try {
					patRecherche = basePat.rechercherPatient(nbSS);
				} catch (KeyException e1) {
					e1.printStackTrace();
				}
				
				appareilMedical appareilMedical = new appareilMedical(appMedic);
				Consultation cons = new Consultation(date, patRecherche, detailCliniques, appareilMedical);
				medoc.ajoutConsultation(baseCons, cons);
				lblNewLabel_4.setText("la consultation "+ cons.toString() + "  a bien ete cree" );
				try{
					baseCons.save();
				}catch(IOException e){
					System.out.println(e.toString());
				}
				
			}
				
		 });
	
	 }

}
