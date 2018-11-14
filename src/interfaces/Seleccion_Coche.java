package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import manageXML.Leer_XML_Cars;
import multidioma.Language;
import multidioma.LectorLanguage;
import objetos.Model;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Seleccion_Coche extends JFrame {
	
	JLabel usuario;
	private JPanel contentPane;
	private JTextArea info;
	public static int cocheSeleccionado;
	private File cocheSelected;
	private JLabel ImagenSelect;
	ArrayList<Model> modelos;
	private static Language texts = LectorLanguage.getLanguage();
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// Seleccion_Coche frame = new Seleccion_Coche();
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
	public Seleccion_Coche() {

		setTitle(texts.getTitulo());

		// Imagen Icono
		setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/seat-icono.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JLabel titulo = new JLabel(texts.getTitulo());
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		ImagenSelect = new JLabel();
		// ImagenSelect.setIcon(new ImageIcon("./imagenes/seat-alhambra.jpg"));
		info = new JTextArea();
		// info.setText(
		// "El SEAT Alhambra es el buque insignia \nde la gama SEAT por tamaño y
		// \ncapacidad de transporte.");
		// info.setLineWrap(true);

		JButton btnSiguiente = new JButton(texts.getBtnSiguiente());
		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Compra_Accesorios ca = new Compra_Accesorios();
				// ca.setVisible(true);
				try {
					System.out.println("hola");
					FileWriter fw = new FileWriter("./ficheros/temp/fs_employee.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.newLine();
					bw.write("[Modelo] " + modelos.get(cocheSeleccionado).getId());
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Seleccion_Submodelo ss = new Seleccion_Submodelo();
				ss.getFrame().setVisible(true);
				dispose();
			}
		});
		JButton btnAnterior = new JButton(texts.getBtnAnterior());
		btnAnterior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Datos_Cliente datos = new Datos_Cliente();
				dispose();
				datos.getFrame().setVisible(true);
			}
		});
		Leer_XML_Cars cars = new Leer_XML_Cars();
		modelos = cars.getModelAll();
		cargarDefecto();

		usuario = new JLabel(texts.getLabelUsuario() + Login.user);
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton ImageSEAT1 = new JButton("");
		ImageSEAT1.setIcon(new ImageIcon("./imagenes/seat-alhambra-min.jpg"));
		ImageSEAT1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("0");
					cocheSeleccionado = 0;
					fw.close();

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(0).getImage_name()));
				info.setText(modelos.get(0).getDescript());
			}
		});

		JButton ImageSEAT2 = new JButton("");
		ImageSEAT2.setIcon(new ImageIcon("./imagenes/seat-arona-min.jpg"));
		ImageSEAT2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("1");
					cocheSeleccionado = 1;
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(1).getImage_name()));
				info.setText(modelos.get(1).getDescript());
			}
		});

		JButton ImageSEAT3 = new JButton("");
		ImageSEAT3.setIcon(new ImageIcon("./imagenes/seat-ateca-min.jpg"));
		ImageSEAT3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("2");
					cocheSeleccionado = 2;
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(2).getImage_name()));
				info.setText(modelos.get(2).getDescript());
			}
		});

		JButton ImageSEAT4 = new JButton("");
		ImageSEAT4.setIcon(new ImageIcon("./imagenes/seat-ibiza-min.jpg"));
		ImageSEAT4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("3");
					cocheSeleccionado = 3;
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(3).getImage_name()));
				info.setText(modelos.get(3).getDescript());
			}
		});

		JButton ImageSEAT5 = new JButton("");
		ImageSEAT5.setIcon(new ImageIcon("./imagenes/seat-leon-min.jpg"));
		ImageSEAT5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("4");
					cocheSeleccionado = 4;
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(4).getImage_name()));
				info.setText(modelos.get(4).getDescript());
			}
		});

		JButton ImageSEAT6 = new JButton("");
		ImageSEAT6.setIcon(new ImageIcon("./imagenes/seat-panda-min.jpg"));
		ImageSEAT6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("5");
					cocheSeleccionado = 5;
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(5).getImage_name()));
				info.setText(modelos.get(5).getDescript());
			}
		});

		JButton ImageSEAT7 = new JButton("");
		ImageSEAT7.setIcon(new ImageIcon("./imagenes/seat-tarraco-min.jpg"));
		ImageSEAT7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cocheSelected = new File("./ficheros/temp/cocheSelected.txt");
					FileWriter fw = new FileWriter(cocheSelected);
					fw.write("6");
					cocheSeleccionado = 6;
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(6).getImage_name()));
				info.setText(modelos.get(6).getDescript());
			}
		});

		// ---------------------------------------------------------------------INTERFAZ---------------------------------------------------------------------------
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(ImageSEAT1)
						.addComponent(ImageSEAT2).addComponent(ImageSEAT3).addComponent(ImageSEAT4)
						.addComponent(ImageSEAT5).addComponent(ImageSEAT6).addComponent(ImageSEAT7))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(56)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(titulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(61))
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnAnterior)
										.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
										.addComponent(btnSiguiente))
								.addComponent(ImagenSelect, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 337,
										Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(info, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
				.addGap(12).addComponent(usuario).addGap(18)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(titulo)
						.addComponent(usuario))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(ImageSEAT1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ImageSEAT2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ImageSEAT3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ImageSEAT4, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ImageSEAT5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
						.addComponent(ImagenSelect, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
								.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ImageSEAT6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(ImageSEAT7, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAnterior)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(52))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(6)
								.addComponent(info, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSiguiente)
								.addGap(55)))));
		contentPane.setLayout(gl_contentPane);

		// ---------------------------------------------------------------------INTERFAZ---------------------------------------------------------------------------
		borrarLastLine();
	}

	public void cargarDefecto() {
		File f = new File("./ficheros/temp/cocheSelected.txt");
		if (!f.exists()) {
			ImagenSelect = new JLabel();
			ImagenSelect.setIcon(new ImageIcon("./imagenes/seat-alhambra.jpg"));

			info = new JTextArea();
			info.setText(
					"El SEAT Alhambra es el buque insignia \nde la gama SEAT por tamaño y \ncapacidad de transporte.");
			info.setLineWrap(true);
		} else {
			String cadena;
			FileReader fr;
			try {
				fr = new FileReader(f);
				BufferedReader b = new BufferedReader(fr);
				cadena = b.readLine();
				cocheSeleccionado = Integer.parseInt(cadena);

				b.close();
				ImagenSelect = new JLabel();
				ImagenSelect.setIcon(new ImageIcon("./imagenes/" + modelos.get(cocheSeleccionado).getImage_name()));

				info = new JTextArea();
				info.setText(modelos.get(cocheSeleccionado).getDescript());
				info.setLineWrap(true);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void borrarLastLine() {
		File f = new File("./ficheros/temp/fs_employee.txt");
		if (f.exists()) {
			BufferedWriter bw = null;
			try {
				String[] cadenaArray = new String[4];

				BufferedReader br = new BufferedReader(new FileReader(f));

				String cadena;
				int contador = 0;
				int i = 0;
				while ((cadena = br.readLine()) != null) {
					cadenaArray[i] = cadena;
					contador++;
					i++;

				}

				if (contador == 4) {
					bw = new BufferedWriter(new FileWriter("./ficheros/temp/fs_employee.txt"));
					bw.write(cadenaArray[0]);
					bw.newLine();
					bw.write(cadenaArray[1]);
					bw.newLine();
					bw.write(cadenaArray[2]);
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

		}
	}
}
