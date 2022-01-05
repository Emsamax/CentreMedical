package Frames;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyException;

import Code.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatistiquesJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatistiquesJframe frame = new StatistiquesJframe();
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
	public StatistiquesJframe() {

		basePatient basePat = new basePatient("ListePatient.txt");
		baseConsultation baseCons = new baseConsultation("consultation.txt");
		try{
			basePat.load();
			baseCons.load(basePat);
		}catch(KeyException e){
			System.out.println(e.toString());
		}catch(IOException e){
			System.out.println((e.toString()));
		}

		setTitle("Statistiques");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de patients ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 176, 45);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("nombre de patient : " + basePat.getNbPAtient());
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de consultations ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 97, 210, 45);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setText("nombre de consultations : " + baseCons.getNbConsultation());
		
		
		JLabel lblNewLabel_2_1 = new JLabel("pourcentage de patient avec consultation ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 195, 500, 45);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setText("pourcentage de patient avec consultation(arrondi) : " + (baseCons.getNbConsultation()*100)/ basePat.getNbPAtient() + " %");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("nombre d'appareils medicaux octroyés et validés par le technicien ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(10, 293, 500, 45);
		contentPane.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setText("nombre d'appareils medicaux octroyés et validés par le technicien " + baseCons.getnbAppMedicValides());
	
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("pourcentage d'appareil medical valides par le technicien ");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1_1.setBounds(10, 374, 500, 45);
		contentPane.add(lblNewLabel_2_1_1_1);
		lblNewLabel_2_1_1_1.setText("pourcentage d'appareil medical validés par le technicien " + (baseCons.getnbAppMedicValides()*100)/baseCons.getnbAppMedic() + " %");
		
		


		JButton actu = new JButton("actualiser");
		actu.setBounds(400, 176, 100, 51);
		contentPane.add(actu);
		actu.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				basePat.setnombreDePatient(0);
				baseCons.setNbConsultation(0);
				baseCons.setnbAppMedicValides(0);
				try {
				
					basePat.load();
					baseCons.load(basePat);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (KeyException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				lblNewLabel.setText("nombre de patient : " + basePat.getNbPAtient());
				lblNewLabel_2.setText("nombre de consultations : " + baseCons.getNbConsultation());
				lblNewLabel_2_1_1.setText("nombre d'appareils medicaux octroyés et validés par le technicien " + baseCons.getnbAppMedicValides());
				lblNewLabel_2_1_1_1.setText("pourcentage d'appareil medical validés par le technicien " + (baseCons.getnbAppMedicValides()*100)/baseCons.getnbAppMedic() + " %");


			}
				
		});
	}	
	
}
