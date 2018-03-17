package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Parametros;

public interface IParametrosLogica {

	public void crear(Parametros entity) throws Exception;
	public void modificar(Parametros entity) throws Exception;
	public void borrar(Parametros entity) throws Exception;
	public Parametros consultarPorId(int parametrosId);
	public List<Parametros> consultarTodos();
	
}
