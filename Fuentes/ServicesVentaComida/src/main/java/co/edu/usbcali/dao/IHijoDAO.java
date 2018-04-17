package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Hijo;

public interface IHijoDAO {

	public void crear(Hijo entity);
	public void modificar(Hijo entity);
	public void borrar(Hijo entity);
	public Hijo consultarPorId(Long hijoId);
	public List<Hijo> consultarTodos();
	
	
}
