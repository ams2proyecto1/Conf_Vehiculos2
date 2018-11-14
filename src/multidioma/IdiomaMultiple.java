package multidioma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import manageXML.Leer_XML_Cars;
import manageXML.Leer_XML_Conf;
import patrones.ConfigurationLoader;

public class IdiomaMultiple {
	// CLASE INTENTO LEER MULTIIDIOMA POR HASHTABLE, ESTA IMPLEMENTADO DE OTRA FORMA
	// PERO QUIERO CONSERVAR EL CODIGO PARA EL FUTURO
	// NO ES UNA CLASE UTIL EN ESTE PUNTO, NECESITO RESOLVER DUDAS
	static Hashtable<String, String> Hashtb = new Hashtable<String, String>();
	static Leer_XML_Cars cars = new Leer_XML_Cars();
	static Leer_XML_Conf conf = new Leer_XML_Conf();
	static ConfigurationLoader cl = ConfigurationLoader.getConfig();
	static FileReader fr;
	static BufferedReader br;
	static String cadena;
	static int numero;
	static String clave;

	public static void main(String[] args) throws IOException {
		leerTXT();
	}

	public static boolean conseguirIdioma() {
		cl.rellenarDatos(conf);
		if (cl.getLanguage()[0].equals("ca")) {
			return true;
		} else
			return false;
	}

	public static void leerTXT() throws IOException {
		conseguirIdioma();
		if (conseguirIdioma() == true) {
			File f = new File("./ficheros/ca_cv.language/");
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
				while ((cadena = br.readLine()) != null) {
					String[] aux = cadena.split(":");
					for (int i = 0; i < aux.length - 1; i++) {
						Hashtb.put(aux[i], aux[i + 1]);
					}
				}
				Enumeration<String> valores = Hashtb.keys();
				while (valores.hasMoreElements()) {
					clave = valores.nextElement();
					System.out.println("Clave: " + clave + " & Valor: " + Hashtb.get(clave));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				fr.close();
				br.close();
			}
		} else {
			System.out.println("TUPAC SHAKUR");
		}

	}

}
