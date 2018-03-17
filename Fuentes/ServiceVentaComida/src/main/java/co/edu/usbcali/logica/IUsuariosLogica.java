package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Usuario;

public interface IUsuariosLogica {

	public void crear(Usuario entity) throws Exception;
	public void modificar(Usuario entity) throws Exception;
	public void borrar(Usuario entity) throws Exception;
	public Usuario consultarPorId(int usuId);
	public Usuario consultarPorIdentificacion(Integer numIdentificacion, Integer tipoIdentificacion);
	public List<Usuario> consultarTodos();
	
}
