package Frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


import java.io.IOException;
import java.security.KeyException;


import Code.*;



public class technicienJframe extends JFrame {

	private JPanel contentPane;
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
	public technicienJframe() {
		setTitle("Technicien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton rechercher = new JButton("rechercher");
		rechercher.setBounds(241, 64, 185, 85);
		contentPane.add(rechercher);
		rechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				basePatient basePat = new basePatient("ListePatient.txt");
				baseConsultation baseCons = new baseConsultation("consultation.txt");
				try{
					basePat.load();
					baseCons.load(basePat);
				}catch(IOException event){
					System.out.println((event.toString()));
				}catch(KeyException event){
					System.out.println((event.toString()));
				}
				
				String idS = textField.getText();
				int ID = Integer.parseInt(idS);
				
				try{
					Consultation cons = baseCons.rechercherConsultation(ID);
					System.out.println(cons.toString());
					textField.setText(cons.toString() );
					
					
				}catch(KeyException event){
					System.out.println((event.toString()));
				}

			}		
		});

		JButton octroyer = new JButton("octroyer");
		octroyer.setBounds(241, 172, 185, 80);
		contentPane.add(octroyer);
		octroyer.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				basePatient basePat = new basePatient("ListePatient.txt");
				baseConsultation baseCons = new baseConsultation("consultation.txt");
				try{
					basePat.load();
					baseCons.load(basePat);
				}catch(IOException ev){
					System.out.println((ev.toString()));
				}catch(KeyException ev){
					System.out.println(ev.toString());
				}
				String line = textField.getText();
				String [] Mots = line.split("/");
				int ID = Integer.parseInt(Mots[0]); 
				Consultation cons = new Consultation();
				try {
					cons = baseCons.rechercherConsultation(ID);	
				} catch (KeyException e1) {
					e1.printStackTrace();
				}
				appareilMedical app = cons.getAppareilMedical();
				app.valider();
				try {
					baseCons.save();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textField.setText("appareil medical n'est plus en attente");

			}
		});

		textField = new JTextField();
		textField.setBounds(10, 64, 221, 85);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 172, 221, 80);
		contentPane.add(lblNewLabel);
		
	

	
}
}
