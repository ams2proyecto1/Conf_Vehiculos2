package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import patrones.ConfigurationLoader;
import validaciones.ValUserPass;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login {

	private JFrame frameLogin;
	private JTextField tfLogin;
	private JPasswordField passwordField;
	private String user;
	private String pass;

	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		File f = new File("./ficheros/temp/datosCliente.txt");
		File coches = new File("./ficheros/temp/cocheSelected.txt");
		if (f.exists()) {
			f.delete();
		}
		if (coches.exists()) {
			f.delete();
		}

		frameLogin = new JFrame();

		// titulo Ventana
		frameLogin.setTitle("Login Concesionario");

		// Icono seat
		frameLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("./imagenes/seat-icono.png"));

		frameLogin.setBounds(100, 100, 347, 227);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblLogin = new JLabel("Usuario:");
		frameLogin.setLocationRelativeTo(null);
		tfLogin = new JTextField();
		tfLogin.setColumns(10);

		JLabel lblPassword = new JLabel("Contrase\u00F1a:");

		JButton btnLogin = new JButton("Entrar");
		// btnLogin.addActionListener(l);;

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user = tfLogin.getText();
				pass = new String(passwordField.getPassword());
				ValUserPass v1 = new ValUserPass();
				if (v1.valUserPass(user, pass)) {
					frameLogin.setVisible(false);
					Datos_Cliente d1 = new Datos_Cliente();
					d1.getFrame().setVisible(true);

					
				} else {

				}

			}
		});

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					user = tfLogin.getText();
					pass = new String(passwordField.getPassword());
					ValUserPass v1 = new ValUserPass();
					if (v1.valUserPass(user, pass)) {
						frameLogin.setVisible(false);
						Datos_Cliente d1 = new Datos_Cliente();
						d1.getFrame().setVisible(true);
						anadirLogin();
					} else {
						JOptionPane.showMessageDialog(null, "Error en el login", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frameLogin.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(32)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addGap(46)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addComponent(passwordField)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfLogin, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
				.addContainerGap(100, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(32)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblPassword)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(btnLogin).addContainerGap(42, Short.MAX_VALUE)));
		frameLogin.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrame() {
		return frameLogin;
	}

	public void anadirLogin() {
		try {
			FileWriter fw = new FileWriter(new File("./ficheros/temp/fs_employee.txt"),true);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write("[Login] " + tfLogin.getText());

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
