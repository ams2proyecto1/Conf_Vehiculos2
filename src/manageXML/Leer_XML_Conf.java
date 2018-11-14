package manageXML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Leer_XML_Conf {

	private static String[] user = null;
	private static String[] pass = null;
	private static String carConfigPath;
	private static String carConfigName;
	private static String specFilePath;
	private static String specFileName;
	private static String version;
	private static boolean empVersion;
	private static String[] language;
	private static String language_default;
	private static String postfix_language_file_name;
	private static String language_files_path;
	private static String descompte;

	public static void leerConfig() {
		// ConfigXML conf1 = new ConfigXML();
		try {
			File archivo = new File("./ficheros/cv_config.xml");

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();

			NodeList nList = document.getElementsByTagName("configuracion");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					carConfigPath = eElement.getElementsByTagName("car_configuration_path").item(0).getTextContent();
					carConfigName = eElement.getElementsByTagName("car_configuration_file_name").item(0).getTextContent();

					NodeList nUser = document.getElementsByTagName("login");
					NodeList nPass = document.getElementsByTagName("password");
					NodeList nLanguage = document.getElementsByTagName("idioma");

					user = new String[nUser.getLength()];
					pass = new String[nPass.getLength()];

					for (int temp2 = 0; temp2 < nUser.getLength(); temp2++) {
						Node nNode2 = nUser.item(temp2);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement2 = (Element) nNode2;
							getUser()[temp2] = eElement2.getTextContent();
						}
					}

					for (int temp3 = 0; temp3 < nPass.getLength(); temp3++) {
						Node nNode3 = nPass.item(temp3);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement3 = (Element) nNode3;
							getPass()[temp3] = eElement3.getTextContent();
						}
					}

					specFilePath = eElement.getElementsByTagName("specifications_file_path").item(0).getTextContent();
					specFileName = eElement.getElementsByTagName("specifications_file_name").item(0).getTextContent();
					version = eElement.getElementsByTagName("version").item(0).getTextContent();
					empVersion = Boolean.parseBoolean(eElement.getElementsByTagName("employee_version").item(0).getTextContent().toLowerCase());
					
					language = new String[nLanguage.getLength()];
					
					for (int temp4 = 0; temp4 < nLanguage.getLength(); temp4++) {
						Node nNode4 = nLanguage.item(temp4);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement4 = (Element) nNode4;
							getLanguage()[temp4] = eElement4.getTextContent();
						}
					}
					
					language_default = eElement.getElementsByTagName("language_default").item(0).getTextContent();
					postfix_language_file_name = eElement.getElementsByTagName("postfix_language_file_name").item(0).getTextContent();
					language_files_path = eElement.getElementsByTagName("language_files_path").item(0).getTextContent();
					descompte = eElement.getElementsByTagName("descompte").item(0).getTextContent();
					
					
					

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getSpecFileName() {
		return specFileName;
	}

	public static String[] getUser() {
		return user;
	}

	public static String[] getPass() {
		return pass;
	}

	public String getCarConfigPath() {
		return carConfigPath;
	}

	public String getCarConfigName() {
		return carConfigName;
	}

	public static String getSpecFilePath() {
		return specFilePath;
	}

	public String getVersion() {
		return version;
	}

	public boolean isEmpVersion() {
		return empVersion;
	}

	public static String[] getLanguage() {
		return language;
	}

	public static String getLanguage_default() {
		return language_default;
	}

	public static String getPostfix_language_file_name() {
		return postfix_language_file_name;
	}

	public static String getLanguage_files_path() {
		return language_files_path;
	}

	public static String getDescompte() {
		return descompte;
	}
	
	 public static boolean isNumeric(String cadena) {
	        boolean resultado;
	        try {
	            Integer.parseInt(cadena);
	            resultado = true;
	        } catch (NumberFormatException excepcion) {
	            resultado = false;
	        }
	        return resultado;
	    }

	public static void setDescompte(String descompte) {
		if (isNumeric(descompte) == true && Integer.parseInt(descompte) < 22 && Integer.parseInt(descompte) > 0 ) {
			Leer_XML_Conf.descompte = descompte;
//			System.out.println("Descuento valido");
		} else {
			Leer_XML_Conf.descompte = ("0");
//			System.out.println("Descuento invalido");
		}
	}
	
	
}
