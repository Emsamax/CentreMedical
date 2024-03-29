package Frames;
import java.io.IOException;
import java.security.KeyException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Code.*;
import java.awt.Font;

public class modifier_consultation extends JFrame {

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
					modifier_consultation frame = new modifier_consultation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public modifier_consultation(int ID, String nomAppMedic) {

		basePatient basePat = new basePatient("ListePatient.txt");
		baseConsultation baseCons = new baseConsultation("consultation.txt");
		Consultation cons = new Consultation();
	
		
		try{
			basePat.load();
			baseCons.load(basePat);
			cons = baseCons.rechercherConsultation(ID);
		}catch(KeyException e){
			System.out.println(e.toString());
		}catch(IOException e){
			System.out.println((e.toString()));
		}

		//titre de la frame
		setTitle("modifier consultation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//textfield pour mettre les informations de la consultation pour la modifier
		textField = new JTextField();
		textField.setBounds(291, 11, 158, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.setText(cons.patient.getNbSS());
		textField.setEnabled(false);
		
		textField_1 = new JTextField(cons.appareilMedical.nom);
		textField_1.setBounds(291, 108, 158, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(cons.getDetailsCiniques());
		textField_2.setBounds(291, 42, 158, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(cons.getDate());
		textField_3.setBounds(291, 73, 158, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		//créations des differents labels associers aux différents textfields
		JLabel lblNewLabel = new JLabel("numero Securite Sociale");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(51, 14, 230, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("appareil medical");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(51, 108, 191, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("detail clinique");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(51, 47, 191, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("date ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(51, 72, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(21, 274, 533, 76);
		contentPane.add(lblNewLabel_4);
		
		//creation du bouton valider et assimilation au code
		JButton modif = new JButton("Valider");
		modif.setBounds(128, 176, 332, 51);
		contentPane.add(modif);
		modif.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				basePatient basePat = new basePatient("ListePatient.txt");
				baseConsultation baseCons = new baseConsultation("consultation.txt");
				try{
					basePat.load();
					baseCons.load(basePat);
				}catch(IOException e){
					System.out.println((e.toString()));
				}catch(KeyException e){
					System.out.println(e.toString());
				}

				String nbSS = textField.getText();
				String detailCliniques = textField_2.getText();
				String nom = textField_1.getText();
				appareilMedical appMedic = new appareilMedical(nom);
				Patient pat =new Patient();
				try {
					pat = basePat.rechercherPatient(nbSS);
				} catch (KeyException e1) {
					e1.printStackTrace();
				}
				Consultation consModif = new Consultation(ID, nbSS, pat, detailCliniques, appMedic);
				try{
					baseCons.modifierConsultation(consModif);
					baseCons.save();
				}catch(KeyException e){
					System.out.println(e.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
				lblNewLabel_4.setText(" le patient "+ consModif+ "  a bien ete modife" );
			}
				
		});
	}
		
		
}
