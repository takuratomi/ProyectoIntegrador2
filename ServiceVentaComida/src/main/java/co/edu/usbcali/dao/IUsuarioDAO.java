package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Usuario;

public interface IUsuarioDAO {

	public void crear(Usuario entity);
	public void modificar(Usuario entity);
	public void borrar(Usuario entity);
	public Usuario consultarPorId(int usuId);
	public Usuario consultarPorIdentificacion(Integer numIdentificacion, Integer tipoIdentificacion);
	public List<Usuario> consultarTodos();
	
	
}
