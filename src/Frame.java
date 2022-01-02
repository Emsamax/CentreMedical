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
		btnNewButton.setBounds(23, 31, 111, 59);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agent_administration agentadministration = new agent_administration();
				agentadministration.setVisible(true);
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("medecin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medecinJframe medecin = new medecinJframe();
				medecin.setVisible(true);
			}
		});
		
		btnNewButton_1.setBounds(208, 31, 111, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("technicien");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				technicienJframe technicien = new technicienJframe();
				technicien.setVisible(true);
			}
		});
		
		btnNewButton_2.setBounds(415, 31, 111, 59);
		contentPane.add(btnNewButton_2);
	}
}
