package multidioma;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import patrones.ConfigurationLoader;

public class LectorLanguage {
	public static void main(String[] args) {
		seleccionarIdioma();
		getLanguage();
	}
	
	
	private static String seleccionarIdioma() {
		ConfigurationLoader conf = ConfigurationLoader.getConfig();
		String[] languages = conf.getLanguage();
		for (int i = 0; i < languages.length; i++) {
			if (new File("./ficheros/"+languages[i].concat(conf.getPostfix_language_file_name())).exists()) {
				return "./ficheros/"+languages[i].concat(conf.getPostfix_language_file_name());
			}
		}
		return conf.getLanguage_default();
	}

	public static Language getLanguage() {
		Language language = new Language();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(seleccionarIdioma()));
			while ((line = br.readLine()) != null) {
				String variableName = line.split("=")[0], variableText = line.split("=")[1];
				switch (variableName) {
				case "frameLogin":
					language.setFrameLogin(variableText);
					break;

				case "lblLogin":
					language.setLblLogin(variableText);
					break;

				case "lblPassword":
					language.setLblPassword(variableText);
					break;

				case "btnLogin":
					language.setBtnLogin(variableText);
					break;

				case "frameDatosCliente":
					language.setFrameDatosCliente(variableText);
					break;

				case "labelNombre":
					language.setLabelNombre(variableText);
					break;

				case "labelPrimerApellido":
					language.setLabelPrimerApellido(variableText);
					break;

				case "labelSegundoApellido":
					language.setLabelSegundoApellido(variableText);
					break;

				case "labelDireccion":
					language.setLabelDireccion(variableText);
					break;

				case "labelCorreo":
					language.setLabelCorreo(variableText);
					break;

				case "labelGenero":
					language.setLabelGenero(variableText);
					break;

				case "labelFecha":
					language.setLabelFecha(variableText);
					break;

				case "rbHombre":
					language.setRbHombre(variableText);
					break;

				case "rbMujer":
					language.setRbMujer(variableText);
					break;

				case "rbNoDeterminado":
					language.setRbNoDeterminado(variableText);
					break;

				case "botonGuardar":
					language.setBotonGuardar(variableText);
					break;

				case "botonSiguiente":
					language.setBotonSiguiente(variableText);
					break;

				case "labelDatosCliente":
					language.setLabelDatosCliente(variableText);
					break;

				case "labelUsuario":
					language.setLabelUsuario(variableText);
					break;

				case "titulo":
					language.setTitulo(variableText);
					break;

				case "btnAnterior":
					language.setBtnAnterior(variableText);
					break;

				case "btnSiguiente":
					language.setBtnSiguiente(variableText);
					break;

				case "usuario":
					language.setUsuario(variableText);
					break;

				case "lblTitulo":
					language.setLblTitulo(variableText);
					break;

				case "frameSubmodelo":
					language.setFrameSubmodelo(variableText);
					break;

				case "datosCoche":
					language.setDatosCoche(variableText);
					break;

				case "textArg":
					language.setTextArg(variableText);
					break;

				case "btnAtras":
					language.setBtnAtras(variableText);
					break;

				case "btnFinalizar":
					language.setBtnFinalizar(variableText);
					break;

				case "frameResumen":
					language.setFrameResumen(variableText);
					break;

				case "titulo_Resumen":
					language.setTitulo_Resumen(variableText);
					break;

				case "vueltaLogin":
					language.setVueltaLogin(variableText);
					break;

				default:
					break;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return language;
	}

}
