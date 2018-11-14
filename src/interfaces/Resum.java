package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import datos.Presupuesto;
import manageXML.Leer_XML_Cars;
import manageXML.Leer_XML_Conf;
import multidioma.Language;
import multidioma.LectorLanguage;
import objetos.Engine;
import objetos.Model;
import javax.swing.JButton;

public class Resum {

	private JFrame frameResumen;

	private static Language texts = LectorLanguage.getLanguage();
	public Resum() {
		File f = new File("./ficheros/temp/fs_employee.txt");
		frameResumen = new JFrame();
		frameResumen.setTitle(texts.getFrameResumen());
		frameResumen.setBounds(100, 100, 450, 312);
		frameResumen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel titulo_Resumen = new JLabel("Resumen:");
		titulo_Resumen.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);

		// Lee el fichero y lo introduce en el text area
		leer_fichero(textArea);
		borrarLineaTemporal();
		JButton vueltaLogin = new JButton(texts.getVueltaLogin());
		vueltaLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Datos_Cliente dc = new Datos_Cliente();
				dc.getFrame().setVisible(true);
				getFrame().setVisible(false);
			}
		});

		GroupLayout groupLayout = new GroupLayout(frameResumen.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(titulo_Resumen))
						.addGroup(groupLayout.createSequentialGroup().addGap(123).addComponent(vueltaLogin))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(textArea,
								GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(titulo_Resumen)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE).addGap(18)
						.addComponent(vueltaLogin).addContainerGap()));
		frameResumen.getContentPane().setLayout(groupLayout);

	}

	// leer txt
	public void leer_fichero(JTextArea textArea) {
		File fichero = new File("./ficheros/temp/fs_employee.txt");
		try {
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			String linea;

			while ((linea = br.readLine()) != null) {

				textArea.append(linea);
			}

		} catch (Exception e) {
			System.out.println("No puede leer el fichero " + fichero + ": " + e);
		}
	}

	public void borrarLineaTemporal() {
		try {
			File f = new File("./ficheros/temp/fs_employee.txt");
			String cadena;
			int cont = 0;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			ArrayList<String> texto = new ArrayList<>();
			while ((cadena = br.readLine()) != null) {
				texto.add(cadena);
				cont++;
			}

			FileWriter fw = new FileWriter("./ficheros/temp/fs_employee.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			texto.remove(0);
			for (String string : texto) {
				bw.write(string);
				bw.newLine();
			}

			bw.close();
			fw.close();
			fr.close();
			br.close();

			crearFicheroFinal(texto);

			String datosCliente = texto.get(1).replace("[Cliente] ", "");

			String[] separado = datosCliente.split(",");
			String modelo = texto.get(2).replace("[Modelo] ", "");
			String submodelo = texto.get(3).replace("[SubModelo] ", "");
			String accesorios = texto.get(4).replace("[Accesorios] ", "");

			try {
				Presupuesto p = new Presupuesto(separado[0], modelo, submodelo, accesorios,
						Double.toString(Compra_Accesorios.precio));
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder build;
				build = factory.newDocumentBuilder();
				Document doc = build.newDocument();
				Element rootElement = doc.createElement("Presupuesto");
				doc.appendChild(rootElement);

				Element cliente = doc.createElement(p.getClass().getSimpleName());
				rootElement.appendChild(cliente);

				Element nombre = doc.createElement("NombreCliente");
				nombre.appendChild(doc.createTextNode(p.getNombreCliente()));
				cliente.appendChild(nombre);

				Element model = doc.createElement("Modelo");
				model.appendChild(doc.createTextNode(p.getModelo()));
				cliente.appendChild(model);

				Element submodel = doc.createElement("SubModelo");
				submodel.appendChild(doc.createTextNode(p.getSubmodelo()));
				cliente.appendChild(submodel);

				Element acc = doc.createElement("Accesorios");
				acc.appendChild(doc.createTextNode(p.getAccesorios()));
				cliente.appendChild(acc);

				Element precioFinal = doc.createElement("PrecioTotal");
				precioFinal.appendChild(doc.createTextNode(p.getPrecioTotal()));
				cliente.appendChild(precioFinal);

				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer trans = tf.newTransformer();
				DOMSource dom = new DOMSource(doc);
				File ffinal = new File("./ficheros/temp/fs_employee.xml");
				StreamResult sr = new StreamResult(ffinal);
				trans.transform(dom, sr);
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearFicheroFinal(ArrayList<String> palabras) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		String fechaActual = formatoFecha.format(new Date());
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH;mm");
		String hora = formatoHora.format(new Date());

		File fichero = new File("./ficheros/temp/fs_employee.txt");

		try {
			FileWriter fw = new FileWriter("./ficheros/compras/fs_employee" + fechaActual + "_" + hora + ".txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (String string : palabras) {
				bw.write(string);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileWriter fw2 = new FileWriter(fichero);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write("Datos Temporales");
			bw2.newLine();
			bw2.write("[Login] " + Login.user);
			bw2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String[] StringAString(String lin) {
		String[] coma = lin.split(",");
		return coma;
	}

	public JFrame getFrame() {
		return frameResumen;
	}
}
