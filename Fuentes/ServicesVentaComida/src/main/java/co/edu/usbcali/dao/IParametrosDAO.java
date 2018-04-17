package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Parametros;

public interface IParametrosDAO {

	public void crear(Parametros entity);
	public void modificar(Parametros entity);
	public void borrar(Parametros entity);
	public Parametros consultarPorId(long idParametros);
	public Parametros consultarPorIdentificacion(Integer idParametros);
	public List<Parametros> consultarTodos();
	
	
}
