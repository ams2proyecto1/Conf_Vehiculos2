package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import interfaces.Login;
import patrones.ConfigurationLoader;
import validaciones.ValUserPass;

class ConfVehiculos {
	private static File f;

	public static void main(String[] args) throws IOException {

		// llamando al patron de diseño SINGLETON.
		ConfigurationLoader config = ConfigurationLoader.getConfig();
		crearArchivoTemp();
		iniciarVentanaLogin();

	}

	private static void iniciarVentanaLogin() {
		Login l1 = new Login();
		l1.getFrame().setVisible(true);
	}

	private static void crearArchivoTemp() {
		f = new File("./ficheros/temp/fs_employee.txt");
		if (f.exists()) {
			f.delete();
			try {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Dato temporal");
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
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
