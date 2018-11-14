package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manageXML.Leer_XML_Cars;
import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Compra_Accesorios extends JFrame {
	private JPanel contentPane;
	JCheckBox acc1;
	JCheckBox acc2;
	JCheckBox acc3;
	JCheckBox acc4;
	JCheckBox acc5;
	JCheckBox acc6;
	String accesoriesSelecteds = "";
	static int suma = 0;
	private double precio;
	ArrayList<String> accesoriosModelo;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Compra_Accesorios frame = new Compra_Accesorios();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public Compra_Accesorios() {
		obtenerAccesorios();
		setTitle("Seleccion de accesorios");

		// Imagen Icono
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/seat-icono.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		JLabel CompraAccesorio = new JLabel("Compra de Accesorios");
		CompraAccesorio.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel datosCoche = new JLabel("Informacion del coche");
		datosCoche.setFont(new Font("Tahoma", Font.PLAIN, 14));

		acc1 = new JCheckBox("AutoRadio");

		acc2 = new JCheckBox("SistemaMultimedia");

		acc3 = new JCheckBox("KitManosLibres");

		acc4 = new JCheckBox("Altavoces");

		acc5 = new JCheckBox("Tapacubos");

		acc6 = new JCheckBox("CadenasDeNieve");
		
		

		acc1.setEnabled((accesoriosModelo.contains("AutoRadio")));
		acc2.setEnabled((accesoriosModelo.contains("SistemaMultimedia")));
		acc3.setEnabled((accesoriosModelo.contains("KitManosLibres")));
		acc4.setEnabled((accesoriosModelo.contains("Altavoces")));
		acc5.setEnabled((accesoriosModelo.contains("Tapacubos")));
		acc6.setEnabled((accesoriosModelo.contains("CadenasDeNieve")));
		

		JLabel textArg = new JLabel("Total precio:");
		textArg.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTextArea ArgPrecio = new JTextArea();
		Leer_XML_Cars lcars = new Leer_XML_Cars();
		ArrayList<Model> modelos = lcars.getModelAll();
		ArrayList<Accesory> accesories = lcars.getAccesoryAll();
		precio = Integer.parseInt(modelos.get(Seleccion_Coche.cocheSeleccionado).getPrice());
		ArgPrecio.setText(Double.toString(precio));
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Seleccion_Submodelo sb = new Seleccion_Submodelo();
				sb.getFrame().setVisible(true);
				dispose();

			}
		});
		
		acc1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precio = acc1.isSelected() ? precio + Integer.parseInt(accesories.get(0).getPrice())
						: precio - Integer.parseInt(accesories.get(0).getPrice());
				ArgPrecio.setText(String.valueOf(precio));
				accesoriesSelecteds  = accesoriesSelecteds + accesories.get(0).getPrice();
			}
		});
		acc2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precio = acc2.isSelected() ? precio + Integer.parseInt(accesories.get(1).getPrice())
						: precio - Integer.parseInt(accesories.get(1).getPrice());
				ArgPrecio.setText(String.valueOf(precio));
				accesoriesSelecteds  = accesoriesSelecteds + accesories.get(1).getPrice();
			}
		});
		acc3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precio = acc3.isSelected() ? precio + Integer.parseInt(accesories.get(2).getPrice())
						: precio - Integer.parseInt(accesories.get(2).getPrice());
				ArgPrecio.setText(String.valueOf(precio));
				accesoriesSelecteds  = accesoriesSelecteds + accesories.get(2).getPrice();
			}
		});
		acc4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precio = acc4.isSelected() ? precio + Integer.parseInt(accesories.get(3).getPrice())
						: precio - Integer.parseInt(accesories.get(3).getPrice());
				ArgPrecio.setText(String.valueOf(precio));
				accesoriesSelecteds  = accesoriesSelecteds + accesories.get(3).getPrice();
			}
		});
		acc5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precio = acc5.isSelected() ? precio + Integer.parseInt(accesories.get(4).getPrice())
						: precio - Integer.parseInt(accesories.get(4).getPrice());
				ArgPrecio.setText(String.valueOf(precio));
				accesoriesSelecteds  = accesoriesSelecteds + accesories.get(4).getPrice();
			}
		});
		acc6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				precio = acc6.isSelected() ? precio + Integer.parseInt(accesories.get(5).getPrice())
						: precio - Integer.parseInt(accesories.get(5).getPrice());
				ArgPrecio.setText(String.valueOf(precio));
				accesoriesSelecteds  = accesoriesSelecteds + accesories.get(5).getPrice();
			}
		});

		JButton btnFinalizar = new JButton("Finalizar");
		// Este boton se va a la clase de resumen
		btnFinalizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String cadena = "";
					for (String string : accesoriosModelo) {
						cadena = cadena + ", " + string;
					}
					boolean AutoRadio = acc1.isSelected();
					boolean SistemaMultimedia = acc2.isSelected();
					boolean KitManosLibres = acc3.isSelected();
					boolean Altavoces = acc4.isSelected();
					boolean Tapacubos = acc5.isSelected();
					boolean CadenasDeNieve = acc6.isSelected();
					FileWriter fw = new FileWriter("./ficheros/temp/fs_employee.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.newLine();
					bw.write("[Accesorios] ");
					if (AutoRadio) {
						bw.write("AutoRadio ");
					}
					if (SistemaMultimedia) {
						bw.write("SistemaMultimedia ");
					}
					if (KitManosLibres) {
						bw.write("KitManosLibres ");
					}
					if (Altavoces) {
						bw.write("Altavoces ");
					}
					if (Tapacubos) {
						bw.write("Tapacubos ");
					}
					if (CadenasDeNieve) {
						bw.write("CadenasDeNieve ");
					}

					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Resum re = new Resum();
				re.getFrame().setVisible(true);
				setVisible(false);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(datosCoche, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE).addGap(136))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(39).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING).addComponent(textArg)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(acc3)
										.addComponent(acc2).addComponent(acc1))
								.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(CompraAccesorio)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(acc5, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(acc6, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(acc4).addComponent(ArgPrecio,
																GroupLayout.PREFERRED_SIZE, 177,
																GroupLayout.PREFERRED_SIZE))
												.addGap(31)))))
						.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addGap(55).addComponent(btnAtras)
						.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE).addComponent(btnFinalizar)
						.addGap(103)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(CompraAccesorio)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(datosCoche, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addGap(25)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(acc5).addGap(18)
										.addComponent(acc6).addGap(18).addComponent(acc4))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(acc1).addGap(18)
										.addComponent(acc2).addGap(18).addComponent(acc3)))
						.addGap(58)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(textArg)
								.addComponent(ArgPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(42).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAtras).addComponent(btnFinalizar))
						.addContainerGap(49, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	public void obtenerAccesorios() {

		Leer_XML_Cars lcars = new Leer_XML_Cars();
		int coche = Seleccion_Coche.cocheSeleccionado;

		ArrayList<Model> modelos = lcars.getModelAll();
		ArrayList<Accesory> accesorios = lcars.getAccesoryAll();

		accesoriosModelo = new ArrayList<>();

		for (Accesory acc : accesorios) {
			String accAv = acc.getModel_available();
			String[] array = accAv.split(",");
			for (int i = 0; i < array.length; i++) {
				if (modelos.get(coche).getId().equals(array[i])) {
					accesoriosModelo.add(acc.getName());
				}
			}
		}

	}

}
