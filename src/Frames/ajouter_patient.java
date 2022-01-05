package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import Code.*;
import javafx.scene.control.TextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ajouter_patient extends JFrame{


	
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
					ajouter_patient frame = new ajouter_patient();
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
	public ajouter_patient() {
		setTitle("Ajouter patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//creation des textfields pour ajouter un patient
		textField = new JTextField();
		textField.setBounds(301, 14, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(301, 56, 158, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(301, 99, 158, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(301, 149, 158, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		//assimilation des labels aux textfields pour savoir quelle informations on marque
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(70, 14, 176, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(70, 56, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("numero securite social");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(70, 99, 221, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("date de naissancce");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(70, 149, 176, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(21, 274, 555, 76);
		contentPane.add(lblNewLabel_4);
		
		//le bouton valider et ses events:
		JButton valider = new JButton("Valider");
		valider.setBounds(100, 198, 332, 51);
		contentPane.add(valider);
		valider.addActionListener (new ActionListener() {
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
				lblNewLabel_4.setText(" le patient "+ pat+ "  a bien ete cree" );

				try{
					basePat.ajouterPatient(pat);
					basePat.save();
				}catch(IOException e){
					System.out.println(event.toString());
				}
			}

		});
	}

}
