package com.pokedex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pokedex {

	private JFrame frmPokdex;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frmPokdex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokdex = new JFrame();
		frmPokdex.setTitle("Pok\u00E9dex");
		frmPokdex.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\pokedex.png"));
		frmPokdex.setBounds(100, 100, 480, 725);
		frmPokdex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmPokdex.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblHola_1 = new JLabel("Numero:");
		lblHola_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHola_1.setBounds(26, 270, 88, 47);
		panel.add(lblHola_1);
		
		JLabel lblHola = new JLabel("Nombre:");
		lblHola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHola.setBounds(26, 225, 88, 47);
		panel.add(lblHola);
		
		JLabel lblHola_1_1 = new JLabel("Tipos:");
		lblHola_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHola_1_1.setBounds(26, 361, 88, 47);
		panel.add(lblHola_1_1);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSexo.setBounds(26, 316, 88, 47);
		panel.add(lblSexo);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnHombre.setBounds(99, 323, 103, 32);
		panel.add(rdbtnHombre);
		
		JRadioButton rdbtnHembra = new JRadioButton("Hembra");
		rdbtnHembra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnHembra.setBounds(213, 323, 103, 32);
		panel.add(rdbtnHembra);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acero", "Agua \t", "Bicho \t", "Drag\u00F3n", "El\u00E9ctrico", "Fantasma", "Fuego", "Hada", "Hielo", "Lucha", "Normal", "Planta", "Ps\u00EDquico", "Roca", "Siniestro", "Tierra", "Veneno", "Volador", "???"}));
		comboBox.setBounds(99, 375, 104, 21);
		panel.add(comboBox);
		
		JLabel lblF = new JLabel("Fondo\r\n");
		lblF.setIcon(new ImageIcon("C:\\Users\\ingdi\\OneDrive\\Desktop\\Pokedex fondo.jpg"));
		lblF.setBounds(0, -1, 466, 688);
		panel.add(lblF);
	}
}
