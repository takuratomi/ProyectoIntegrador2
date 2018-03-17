package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Sopa;

public interface ISopaLogica {

	public void crear(Sopa entity) throws Exception;
	public void modificar(Sopa entity) throws Exception;
	public void borrar(Sopa entity) throws Exception;
	public Sopa consultarPorId(int sopaId);
	public List<Sopa> consultarTodos();
	
}
