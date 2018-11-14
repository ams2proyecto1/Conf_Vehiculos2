package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import manageXML.Leer_XML_Cars;
import objetos.Engine;
import objetos.Model;

public class Seleccion_Submodelo {
	private JFrame frameSubmodelo;
	private JLabel lblTitulo;
	private static JList listaSbm;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private String datosSeleccioandos;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Seleccion_Submodelo window = new Seleccion_Submodelo();
//					
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Seleccion_Submodelo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSubmodelo = new JFrame();
		
		frameSubmodelo.setTitle("Seleccion del submodelo");
		
		//Icono seat
		frameSubmodelo.setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/seat-icono.png"));
		frameSubmodelo.setBounds(100, 100, 450, 350);
		frameSubmodelo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSubmodelo.setVisible(true);
		lblTitulo = new JLabel("Seleccion de caracteristicas del modelo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));

		DefaultListModel<String> dlm = new DefaultListModel<String>();
		listaSbm = new JList<>(dlm);
		try {
			leerArchivo(listaSbm, dlm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Seleccion_Coche sc = new Seleccion_Coche();
				sc.setVisible(true);
				frameSubmodelo.dispose();
				
			}
		});
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				datosSeleccioandos = (String) listaSbm.getSelectedValue();
				
				try {
					FileWriter fw = new FileWriter("./ficheros/temp/fs_employee.txt",true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.newLine();
					bw.write("[SubModelo] " + datosSeleccioandos);
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Compra_Accesorios ca = new Compra_Accesorios();
				ca.setVisible(true);
				frameSubmodelo.dispose();
				
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frameSubmodelo.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(67).addComponent(lblTitulo))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(listaSbm,
										GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)))
						.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addGap(38).addComponent(btnAnterior)
						.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE).addComponent(btnSiguiente)
						.addGap(33)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblTitulo).addGap(29)
				.addComponent(listaSbm, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE).addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(btnAnterior).addComponent(btnSiguiente))
				.addGap(48)));
		frameSubmodelo.getContentPane().setLayout(groupLayout);
	}

	public static void leerArchivo(JList<String> listaSbm, DefaultListModel<String> dlm) throws IOException {
		String cadena;
		int numero;
		File f = new File("./ficheros/temp/cocheSelected.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		cadena = br.readLine();
		numero = Integer.parseInt(cadena);
		System.out.println(numero);
		fr.close();
		br.close();
		Leer_XML_Cars coches = new Leer_XML_Cars();
		ArrayList<Model> modelos = coches.getModelAll();
		ArrayList<Engine> motores = coches.getEngineAll();
		for (Engine motor : motores) {
			String motav = motor.getModelsAvailable();
			String[] array = motav.split(",");
			for (int i = 0; i < array.length; i++) {
				if (modelos.get(numero).getId().equals(array[i])) {
					dlm.addElement(motor.getDescript());
				}
			}
		}
		
	}
	
	public JFrame getFrame() {
		return frameSubmodelo;
	}

}
