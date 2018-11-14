package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.Compra_Accesorios;
import interfaces.Datos_Cliente;
import interfaces.Login;
import interfaces.Seleccion_Coche;
import interfaces.Seleccion_Submodelo;
import patrones.ConfigurationLoader;
import validaciones.ValUserPass;

class ConfVehiculos {
	private static File f;

	public static void main(String[] args) throws IOException {

		// llamando al patron de diseño SINGLETON.
		ConfigurationLoader config = ConfigurationLoader.getConfig();
		crearArchivoTemp();

	}

	private static void iniciarVentanaLogin() {
		Login l1 = new Login();
		l1.getFrame().setVisible(true);
	}

	private static void crearArchivoTemp() {
		f = new File("./ficheros/temp/fs_employee.txt");
		if (f.exists()) {
			int optionPaneSalir = JOptionPane.showConfirmDialog(null,
					"Fichero temporal encontrado : Quieres cargar los datos?");

			if (optionPaneSalir == JOptionPane.YES_OPTION) {
				try {
					FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr);
					String cadena;
					ArrayList<String> palabra = new ArrayList<>();
					while ((cadena = br.readLine()) != null) {
						palabra.add(cadena);
					}
					String[] ultimaPalabra = palabra.get(palabra.size() - 1).split(" ");
					System.out.println(ultimaPalabra[0]);

					if (ultimaPalabra[0].equals("[Login]")) {
						Login l = new Login();
						l.getFrame().setVisible(true);
					}

					if (ultimaPalabra[0].equals("[Cliente]")) {
						Datos_Cliente dc = new Datos_Cliente();
						dc.getFrame().setVisible(true);
					}
					if (ultimaPalabra[0].equals("[Modelo]")) {
						Seleccion_Coche sc = new Seleccion_Coche();
						sc.setVisible(true);
					}

					if (ultimaPalabra[0].equals("[SubModelo]")) {
						Seleccion_Submodelo sm = new Seleccion_Submodelo();
						sm.getFrame().setVisible(true);
					}
					if (ultimaPalabra[0].equals("[Accesorios]")) {
						Compra_Accesorios ca = new Compra_Accesorios();
						ca.setVisible(true);
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					iniciarVentanaLogin();
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("Dato temporal");
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			try {
				iniciarVentanaLogin();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Dato temporal");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
