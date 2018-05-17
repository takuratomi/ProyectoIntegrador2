package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Hijo;

public interface IHijoDAO {

	public void crear(Hijo entity);
	public void modificar(Hijo entity);
	public void borrar(Hijo entity);
	public Hijo consultarPorId(Long hijoId);
	public Hijo consultarPorIdUsuario(long idUsuario);
	public List<Hijo> consultarTodos();
	
	// permite consultar mis hijos con el numero de identificacion
	public List<Hijo> consultarMisHijo(long numIdentificaicon);
	
	public Long getConsecutivo();
	
}
