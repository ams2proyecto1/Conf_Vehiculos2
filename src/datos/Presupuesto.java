package datos;

public class Presupuesto {

	private String nombreCliente;
	private String modelo;
	private String submodelo;
	private String accesorios;
	private String precioTotal;
	 


	public Presupuesto(String nombreCliente, String modelo, String submodelo, String accesorios, String precioTotal) {
		this.nombreCliente = nombreCliente;
		this.modelo = modelo;
		this.submodelo = submodelo;
		this.accesorios = accesorios;
		this.precioTotal = precioTotal;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getModelo() {
		return modelo;
	}

	public String getSubmodelo() {
		return submodelo;
	}

	public String getAccesorios() {
		return accesorios;
	}

	public String getPrecioTotal() {
		return precioTotal;
	}

	
	
}
