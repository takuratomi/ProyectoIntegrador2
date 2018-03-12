package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Principio;

public interface IPrincipioDAO {

	public void crear(Principio entity);
	public void modificar(Principio entity);
	public void borrar(Principio entity);
	public Principio consultarPorId(int idPrincipio);
	public Principio consultarPorIdentificacion(Integer idPrincipio);
	public List<Principio> consultarTodos();
	
	
}
