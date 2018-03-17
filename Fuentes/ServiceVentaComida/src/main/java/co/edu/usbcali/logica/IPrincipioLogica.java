package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Principio;

public interface IPrincipioLogica {

	public void crear(Principio entity) throws Exception;
	public void modificar(Principio entity) throws Exception;
	public void borrar(Principio entity) throws Exception;
	public Principio consultarPorId(int principioId);
	public List<Principio> consultarTodos();
	
}
