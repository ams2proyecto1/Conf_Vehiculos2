package interfaces;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import datos.Cliente;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Datos_Cliente {

	private JFrame frameDatosCliente;
	private JTextField txtNombre;
	private JTextField txtPrimerApellido;
	private JTextField txtSegundoApellido;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JLabel labelUsuario;
	private JRadioButton rbMujer;
	private JRadioButton rbHombre;
	private JRadioButton rbNoDeterminado;
	private JDateChooser dcFechaNacimiento;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCalendar calendar;

	public Datos_Cliente() {
		initialize();
		// leerLogin();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDatosCliente = new JFrame();

		// titulo Ventana
		frameDatosCliente.setTitle("Datos del Cliente");

		// Icono seat
		frameDatosCliente.setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/seat-icono.png"));

		frameDatosCliente.setBounds(100, 100, 597, 619);
		frameDatosCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDatosCliente.setLocationRelativeTo(null);
		JLabel labelDatosCliente = new JLabel("DATOS DEL CLIENTE");
		labelDatosCliente.setFont(new Font("Tahoma", Font.BOLD, 24));

		JLabel labelNombre = new JLabel("Nombre *");

		txtNombre = new JTextField();
		txtNombre.setColumns(10);

		JLabel labelPrimerApellido = new JLabel("Primer Apellido *");

		JLabel labelSegundoApellido = new JLabel("Segundo Apellido *");

		JLabel labelDireccion = new JLabel("Direccion *");

		JLabel labelCorreo = new JLabel("Correo Electronico *");

		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setColumns(10);

		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);

		JLabel labelGenero = new JLabel("Genero");

		rbHombre = new JRadioButton("Hombre");
		buttonGroup.add(rbHombre);

		rbMujer = new JRadioButton("Mujer");
		buttonGroup.add(rbMujer);

		rbNoDeterminado = new JRadioButton("No determinado");
		buttonGroup.add(rbNoDeterminado);

		JLabel labelFecha = new JLabel("Fecha Nacimiento");

		dcFechaNacimiento = new JDateChooser();
		dcFechaNacimiento.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calendar = new JCalendar();
				frameDatosCliente.getContentPane().add(calendar);
			}
		});

		JButton botonGuardar = new JButton("Guardar");
		// 27. Hacer las mismas comprobacionesque se hace con el boton siguiente con el
		// boton guardar
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				String email = txtCorreo.getText();
				Matcher mather = pattern.matcher(email);
				if (txtNombre.getText().equals("") || txtPrimerApellido.getText().equals("")
						|| txtSegundoApellido.getText().equals("") || txtDireccion.getText().equals("")
						|| txtCorreo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin rellenar", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (!txtCorreo.getText().equals("") && (mather.find() == false)) {
					JOptionPane.showMessageDialog(null, "El campo Correo esta mal escrito", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Se han guardado todos los datos", "Bieen",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		frameDatosCliente.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				int optionPaneSalir = JOptionPane.showConfirmDialog(null, "Quieres salir sin guardar??");

				if (optionPaneSalir == JOptionPane.YES_OPTION) {
					frameDatosCliente.dispose();
				} else if (optionPaneSalir == JOptionPane.NO_OPTION) {
					guardarDatos();
				} else if (optionPaneSalir == JOptionPane.CANCEL_OPTION) {
					frameDatosCliente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

				}

			}
		});

		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				String email = txtCorreo.getText();
				Matcher mather = pattern.matcher(email);
				if (txtNombre.getText().equals("") || txtPrimerApellido.getText().equals("")
						|| txtSegundoApellido.getText().equals("") || txtDireccion.getText().equals("")
						|| txtCorreo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin rellenar", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (!txtCorreo.getText().equals("") && (mather.find() == false)) {
					JOptionPane.showMessageDialog(null, "El campo Correo esta mal escrito", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Seleccion_Coche sc = new Seleccion_Coche();
					guardarDatos();
					sc.setVisible(true);
					frameDatosCliente.setVisible(false);
				}
			}
		});

		labelUsuario = new JLabel("Usuario:");
		GroupLayout groupLayout = new GroupLayout(frameDatosCliente.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, groupLayout
						.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelNombre).addComponent(labelPrimerApellido)
								.addComponent(labelSegundoApellido).addComponent(labelDireccion)
								.addComponent(labelCorreo).addComponent(labelGenero).addComponent(labelFecha))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addGap(73)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtPrimerApellido).addComponent(txtSegundoApellido)
										.addComponent(txtDireccion).addComponent(txtCorreo).addComponent(txtNombre,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(18).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dcFechaNacimiento, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup().addComponent(rbHombre)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(rbMujer)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(rbNoDeterminado)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(botonGuardar, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
								.addComponent(botonSiguiente, GroupLayout.PREFERRED_SIZE, 160,
										GroupLayout.PREFERRED_SIZE)
								.addGap(25))))
				.addGroup(groupLayout.createSequentialGroup().addGap(91).addComponent(labelDatosCliente)
						.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE).addComponent(labelUsuario)
						.addGap(97)));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(28)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(labelDatosCliente, GroupLayout.PREFERRED_SIZE, 36,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(labelUsuario))
										.addGap(59)
										.addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING).addComponent(labelNombre)
												.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(35)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(labelPrimerApellido)
												.addComponent(txtPrimerApellido, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(36)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(labelSegundoApellido)
												.addComponent(txtSegundoApellido, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(34)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(labelDireccion).addComponent(
														txtDireccion, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(31)
										.addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING).addComponent(labelCorreo)
												.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(41)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(labelGenero).addComponent(rbHombre).addComponent(rbMujer)
												.addComponent(rbNoDeterminado))
										.addGap(25)
										.addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING).addComponent(labelFecha)
												.addComponent(dcFechaNacimiento, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(33)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(botonGuardar, GroupLayout.DEFAULT_SIZE, 43,
														Short.MAX_VALUE)
												.addComponent(botonSiguiente, GroupLayout.DEFAULT_SIZE, 43,
														Short.MAX_VALUE))
										.addGap(36)));
		frameDatosCliente.getContentPane().setLayout(groupLayout);

		File f = new File("./ficheros/temp/fs_employee.txt");
		if (f.exists()) {
			BufferedWriter bw = null;
			try {
				String[] cadenaArray = new String[3];

				BufferedReader br = new BufferedReader(new FileReader(f));

				String cadena;
				int contador = 0;
				int i = 0;
				while ((cadena = br.readLine()) != null) {
					cadenaArray[i] = cadena;
					contador++;
					i++;

				}

				if (contador == 3) {
					cargarDatos();
					bw = new BufferedWriter(new FileWriter("./ficheros/temp/fs_employee.txt"));
					bw.write(cadenaArray[0]);
					bw.newLine();
					bw.write(cadenaArray[1]);
					bw.close();
				}

				br.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// try {
			// String cadena;
			// FileReader fr = new FileReader(f);
			// BufferedReader br = new BufferedReader(fr);
			// int contador = 1;
			// while(br.readLine()!=null) {
			// if(contador==3) {
			// FileWriter fw = new FileWriter(f);
			// BufferedWriter bw = new BufferedWriter(fw);
			// cadena = br.readLine();
			// String[] datos = cadena.split(",");
			// txtNombre.setText(datos[0]);
			// txtPrimerApellido.setText(datos[1]);
			// txtSegundoApellido.setText(datos[2]);
			// txtDireccion.setText(datos[3]);
			// txtCorreo.setText(datos[4]);
			//
			// if (datos[5].equals("No determinado")) {
			// rbNoDeterminado.setSelected(true);
			// } else if (datos[5].equals("Mujer")) {
			// rbMujer.setSelected(true);
			// } else {
			// rbHombre.setSelected(true);
			// }
			// bw.write("");
			// bw.close();
			// br.close();
			// }else {
			// contador++;
			// }
			// }
			//
			// } catch (IOException e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
		}
	}

	public JFrame getFrame() {
		return frameDatosCliente;
	}

	// public void obtenerUsuario(String usuario) {
	//
	// labelUsuario.setText(labelUsuario.getText() + ": " + usuario);
	// }

	public void guardarDatos() {
		try {
			FileWriter fw = new FileWriter(new File("./ficheros/temp/fs_employee.txt"), true);
			Cliente c1 = new Cliente(txtNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(),
					txtDireccion.getText(), txtCorreo.getText(), genero(rbHombre, rbMujer, rbNoDeterminado),
					dcFechaNacimiento.getDate());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("[Cliente] " + c1.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String genero(JRadioButton rdbtnHombre, JRadioButton rdbtnMujer, JRadioButton rdbtnNewRadioButton) {
		if (rdbtnHombre.isSelected()) {
			return rdbtnHombre.getLabel();
		} else if (rdbtnMujer.isSelected()) {
			return rdbtnMujer.getLabel();
		} else if (rdbtnNewRadioButton.isSelected()) {
			return rdbtnNewRadioButton.getLabel();
		}
		return null;
	}

	// public void leerLogin() {
	// String cadena = null;
	// try {
	// File f = new File("./ficheros/temp/fs_employee.txt");
	// FileReader fr = new FileReader(f);
	// BufferedReader br = new BufferedReader(fr);
	// int contador = 0;
	// while (br.readLine() != null) {
	// if (contador == 1) {
	// cadena = br.readLine();
	// System.out.println(cadena);
	// } else {
	// contador++;
	// }
	// }
	// br.close();
	// labelUsuario.setText(labelUsuario.getText() + cadena.replaceAll("[Login]",
	// ""));
	// labelUsuario.setText(labelUsuario.getText() + "hola");
	//
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	public void cargarDatos() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("./ficheros/temp/fs_employee.txt"));
			int contador = 1;
			String cadena;
			while ((cadena = br.readLine()) != null) {
				System.out.println(contador);
				if (contador == 3) {
					cadena = cadena.replace("[Cliente] ", "");
					String[] datos = cadena.split(",");
					txtNombre.setText(datos[0]);
					txtPrimerApellido.setText(datos[1]);
					txtSegundoApellido.setText(datos[2]);
					txtDireccion.setText(datos[3]);
					txtCorreo.setText(datos[4]);

					if (datos[5].equals("No determinado")) {
						rbNoDeterminado.setSelected(true);
					} else if (datos[5].equals("Mujer")) {
						rbMujer.setSelected(true);
					} else {
						rbHombre.setSelected(true);
					}
				} else {
					contador++;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
