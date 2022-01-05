package Frames;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Font;

public class Frame extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("agent administration");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(154, 11, 208, 59);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agent_administration agentadministration = new agent_administration();
				agentadministration.setVisible(true);
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("medecin");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medecinJframe medecin = new medecinJframe();
				medecin.setVisible(true);
			}
		});
		
		btnNewButton_1.setBounds(154, 91, 208, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("technicien");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				technicienJframe technicien = new technicienJframe();
				technicien.setVisible(true);
			}
		});
		
		btnNewButton_2.setBounds(154, 172, 208, 59);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("statistiques");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatistiquesJframe Statistique = new StatistiquesJframe();
				Statistique.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(154, 256, 208, 59);
		contentPane.add(btnNewButton_3);
	}
}
