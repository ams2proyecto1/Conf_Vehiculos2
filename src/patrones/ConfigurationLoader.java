package patrones;

import manageXML.Leer_XML_Conf;

public class ConfigurationLoader {

	private static ConfigurationLoader config;
	private String car_configuration_path;
	private String car_configuration_file_name;

	public String getSpecifications_file_name() {
		return specifications_file_name;
	}

	private String[] employee_list;
	private String[] employee_password;
	private boolean employee_version;
	private String specifications_file_path;
	private String specifications_file_name;
	private String version;

	private ConfigurationLoader() {
		Leer_XML_Conf lxml = new Leer_XML_Conf();
		rellenarDatos(lxml);
	}

	public static ConfigurationLoader getConfig() {
		if (config == null) {
			return config = new ConfigurationLoader();
		}
		return config;
	}

	public void rellenarDatos(Leer_XML_Conf lxml) {
		Leer_XML_Conf.leerConfig();

		car_configuration_file_name = lxml.getCarConfigName();
		car_configuration_path = lxml.getCarConfigPath();
		employee_list = lxml.getUser();
		employee_password = lxml.getPass();
		employee_version = lxml.isEmpVersion();
		specifications_file_path = lxml.getSpecFilePath();
		specifications_file_name = lxml.getSpecFileName();
		version = lxml.getVersion();

	}

	public String getCar_configuration_path() {
		return car_configuration_path;
	}

	public String getCar_configuration_file_name() {
		return car_configuration_file_name;
	}

	public String[] getEmployee_list() {
		return employee_list;
	}

	public String[] getEmployee_password() {
		return employee_password;
	}

	public boolean isEmployee_version() {
		return employee_version;
	}

	public String getSpecifications_file_path() {
		return specifications_file_path;
	}

	public String getVersion() {
		return version;
	}

}
