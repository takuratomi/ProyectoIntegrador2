package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Hijo;

public interface IHijoLogica {

	public void crear(Hijo entity) throws Exception;
	public void modificar(Hijo entity) throws Exception;
	public void borrar(Hijo entity) throws Exception;
	public Hijo consultarPorId(int hijoId);
	public List<Hijo> consultarTodos();
	
}
