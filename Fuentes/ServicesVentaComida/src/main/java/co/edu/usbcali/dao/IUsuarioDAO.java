package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

public interface IUsuarioDAO {

	public void crear(Usuario entity);
	public void modificar(Usuario entity);
	public void borrar(Usuario entity);
	public Usuario consultarPorId(long usuId);
	public Usuario consultarPorIdentificacion(Long numIdentificacion);
	public List<Usuario> consultarTodos();
	
	public Long getConsecutivo();
	
	
}
