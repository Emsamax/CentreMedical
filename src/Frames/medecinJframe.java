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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import Code.*;
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
		
		JButton modifier = new JButton("modifier");
		modifier.setBounds(10, 146, 102, 47);
		contentPane.add(modifier);
		modifier.setEnabled(false);
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baseConsultation baseCons = new baseConsultation("consultation.txt");
				basePatient basePat = new basePatient("ListePatient.txt");
				try{
					basePat.load();
					baseCons.load(basePat);
				}catch(FileNotFoundException ev){
					System.out.println(ev.toString());
				}catch(IOException ev){
					System.out.println(ev.toString());
				}catch(KeyException evn){
					System.out.println(evn.toString());
				}
				String nbconsRecup = textField.getText();
				int ID = Integer.parseInt(nbconsRecup);
				Consultation recup = new Consultation();
				try {
					recup = baseCons.rechercherConsultation(ID);
				} catch (KeyException e1) {
					e1.printStackTrace();
				}
				String nomAppMedic = recup.appareilMedical.nom;
				modifier_consultation modifierconsultation = new modifier_consultation(ID, nomAppMedic);
				modifierconsultation.setVisible(true);
			}
		});
		
			
		
		JButton suppr = new JButton("supprimer");
		suppr.setBounds(151, 146, 102, 47);
		contentPane.add(suppr);
		suppr.setEnabled(false);
		suppr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			baseConsultation baseCons = new baseConsultation("consultation.txt");
			basePatient basePat = new basePatient("ListePatient.txt");
				try{
					basePat.load();
					baseCons.load(basePat);
				}catch(FileNotFoundException ev){
					System.out.println(ev.toString());
				}catch(IOException ev){
					System.out.println(ev.toString());
				}catch(KeyException evn){
					System.out.println(evn.toString());
				}

				String idS = textField.getText();
				int ID = Integer.parseInt(idS);
				
				baseCons.supprimerConsultation(ID);
				textField_1.setText("la consultation " + ID + " à été suprimé");
				try{
					basePat.save();
					baseCons.save();
				}catch(IOException event){
					System.out.println(event.toString());
				}
				
			}
		});
		
		JButton ajouter = new JButton("ajouter");
		ajouter.setBounds(300, 146, 102, 47);
		contentPane.add(ajouter);
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter_consultation ajouterconsultation = new ajouter_consultation();
				ajouterconsultation.setVisible(true);
			}
		});
		


		JButton rechercher = new JButton("Rechercher");
		rechercher.setBounds(205, 19, 221, 54);
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
							textField_1.setText(" Consultation : " + cons.toString() );
							
							
						}catch(KeyException event){
							System.out.println((event.toString()));
						}
						modifier.setEnabled(true);
						suppr.setEnabled(true);
						ajouter.setEnabled(false);
					}		
				});
		
		
		
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
	
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(0, 88, 414, 47);
		contentPane.add(textField_1);
	}
}
