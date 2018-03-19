package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Padre;

public interface IPadreLogica {

	public void crear(Padre entity) throws Exception;
	public void modificar(Padre entity) throws Exception;
	public void borrar(Padre entity) throws Exception;
	public Padre consultarPorId(int padreId);
	public List<Padre> consultarTodos();
	
}
