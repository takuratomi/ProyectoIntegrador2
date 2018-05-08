package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Padre;

public interface IPadreDAO {

	public void crear(Padre entity);
	public void modificar(Padre entity);
	public void borrar(Padre entity);
	public Padre consultarPorId(Long padreId);
	public Padre consultarPorIdUsuario(long numIdentificacion_);
	public List<Padre> consultarTodos();
	
	public Long getConsecutivo();
	
	
}
