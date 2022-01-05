package Frames;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Code.*;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class modifier_patient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public modifier_patient(String nbSS) {
		
		basePatient basePat = new basePatient("ListePatient.txt");
		Patient pat = new Patient();
		try{
			basePat.load();
			pat = basePat.rechercherPatient(nbSS);
		}catch(KeyException e){
			System.out.println(e.toString());
		}catch(IOException e){
			System.out.println((e.toString()));
		}
		
			
		
		//titre de la frame
		setTitle("modifier patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//creation des différents textfielsds
		textField = new JTextField(pat.getNom());
		textField.setBounds(325, 11, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(pat.getPrenom());
		textField_1.setBounds(325, 42, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(pat.getNbSS());
		textField_2.setBounds(325, 129, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		textField_3 = new JTextField(pat.getDateNaissance());
		textField_3.setBounds(325, 82, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		//créations des differents labels associers aux différents textfields

		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(105, 14, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(105, 45, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("numero securite social");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(105, 132, 186, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setEnabled(false);
		
		JLabel lblNewLabel_3 = new JLabel("date de naissance");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(105, 85, 156, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 259, 566, 87);
		contentPane.add(lblNewLabel_4);


		//creation du bouton valider et assimilation au code
		JButton modif = new JButton("Valider");
		modif.setBounds(105, 197, 332, 51);
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
