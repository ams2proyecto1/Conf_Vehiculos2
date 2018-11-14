package patrones;

import java.util.ArrayList;


import objetos.Accesory;
import objetos.Engine;
import objetos.Model;

public class CocheDAOImpl implements ICoches{

	private static ArrayList<Model> models;
	private static ArrayList<Engine> engines;
	private static ArrayList<Accesory> accesories;
	
	public CocheDAOImpl() {
		
		
		
	}
	
	
	@Override
	public void addModel(Model Model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEngine(Engine Engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccesory(Accesory Accesory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actualizarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarModel(Model model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarEngine(Engine engine) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarAccesory(Accesory accesory) {
		// TODO Auto-generated method stub
		
	}
/*	
	@Override
	public void actualizarCliente(Cliente cliente) {
		clientes.get(cliente.getId()).setNombre(cliente.getNombre());
		clientes.get(cliente.getId()).setApellido(cliente.getApellido());
		System.out.println("Cliente con id: "+cliente.getId()+" actualizado satisfactoriamente");
	}
	
	//eliminar un cliente por el id
	@Override
	public void eliminarCliente(Cliente cliente) {
		clientes.remove(cliente.getId());
		System.out.println("Cliente con id: "+cliente.getId()+" elimnado satisfactoriamente");
	}
*/


	@Override
	public ArrayList<Model> getModelAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Engine> getEngineAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void actualizarModel(Model model) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<Accesory> getAccesoryAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
