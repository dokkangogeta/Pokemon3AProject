package start;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.*;
import javax.swing.Timer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class jFrameMain extends JFrame {

	private JPanel contentPane;
	private String []images = { "1.png", "10.png", "11.png", "12.png", "13.png", "14.png", "15.png" ,"16.png", "18.png", "19.png", "20.png" };

	private String []img = { "2.png", "5.png", "9.png","6.png","64.png", "3.png", "4.png","7.png","8.png", "30.png", "21.png","34.png" };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameMain frame = new jFrameMain();
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
	public jFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setBorder(new LineBorder(new Color(255, 255, 153)));
		lblPhoto.setBounds(27, 13, 158, 427);
		contentPane.add(lblPhoto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(365, 13, 178, 427);
		contentPane.add(lblNewLabel);
		
		JLabel lblCombat = new JLabel("Pokemon1");
		lblCombat.setBounds(68, 59, 85, 43);
		contentPane.add(lblCombat);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Combat");
		tglbtnNewToggleButton.setBounds(177, 86, 116, 56);
		contentPane.add(tglbtnNewToggleButton);
		
		JLabel lblPokemon = new JLabel("Pokemon2");
		lblPokemon.setBounds(377, 65, 85, 30);
		contentPane.add(lblPokemon);
		
		JLabel lblNewLabel_1 = new JLabel("Force");
		lblNewLabel_1.setBounds(160, 333, 71, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Defense");
		lblNewLabel_2.setBounds(160, 290, 71, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Defense");
		lblNewLabel_3.setBounds(336, 290, 71, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Force");
		lblNewLabel_4.setBounds(336, 333, 71, 22);
		contentPane.add(lblNewLabel_4);
		
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
			int n = (int) Math.floor(Math.random() * 10);
			String image = images[n];
			String imag = img[n];
			lblPhoto.setIcon(new ImageIcon("src\\image\\" + image));
			lblNewLabel.setIcon(new ImageIcon("src\\image\\" + imag));
			
			
				}
		});
		timer.start();
	}
}
