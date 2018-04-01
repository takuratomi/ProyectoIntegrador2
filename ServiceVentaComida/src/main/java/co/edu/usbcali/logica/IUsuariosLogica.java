package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Usuario;

public interface IUsuariosLogica {

	public void crear(Usuario entity) throws Exception;
	public void modificar(Usuario entity) throws Exception;
	public void borrar(Usuario entity) throws Exception;
	public Usuario consultarPorId(Long usuId);
	public Usuario consultarPorIdentificacion(Integer numIdentificacion, Integer tipoIdentificacion) throws Exception;
	public List<Usuario> consultarTodos() throws Exception;
	
}
