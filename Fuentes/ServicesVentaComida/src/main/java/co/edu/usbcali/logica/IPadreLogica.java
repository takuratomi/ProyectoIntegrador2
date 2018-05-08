package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

public interface IPadreLogica {
	
	public void crearPadre(Padre padre) throws Exception;
	public void modificarPadre(Padre padre) throws Exception;
	public Padre consultarPadrePorId(long id) throws Exception;
	public List<Padre>consultarPadreTodos() throws Exception;
	
	public Usuario consultarUsuarioPorIdentificacion(Long numIdentificacion) throws Exception;
	
	public Padre consultarPadrePorIdentificacion(long numIdentificacion) throws Exception;

}
