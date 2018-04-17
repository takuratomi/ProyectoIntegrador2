package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IPadreDAO;
import co.edu.usbcali.dao.IUsuarioDAO;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

@Service
@Scope("singleton")
public class PadreLogica implements IPadreLogica {

	@Autowired
	private IPadreDAO padreDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)	
	@Override
	public void crearPadre(Padre padre) throws Exception {
		
		String mensaje = "EL campo $ es obligatorio";
		
		padre.setId(padreDAO.getConsecutivo());
		padre.getUsuario().setId(usuarioDAO.getConsecutivo());
		
		if(padre == null) throw new Exception("El padre no puede ser nulo");
		if(padre.getUsuario() == null) throw new Exception("El usuario no puede ser nulo");		
		if(padre.getUsuario().getPrimerNombre() == null || padre.getUsuario().getPrimerNombre().equals("")) throw new Exception("EL primero nombre es obligatorio");
		if(padre.getUsuario().getPrimerApellido() == null || padre.getUsuario().getPrimerApellido().equals("")) throw new Exception("El primer apellido es obligatorio");
		if(padre.getUsuario().getSegundoApellido() == null || padre.getUsuario().getSegundoApellido().equals("")) throw new Exception("El segundo apellido es obligatorio");
		if(padre.getUsuario().getTipoIdentificacion() <=0 ) throw new Exception("El tipo de identificacion es obligatorio");
		if(padre.getUsuario().getNumIdentificacion() <=0 ) throw new Exception("El numero de identificacion es obligatorio");
		if(padre.getUsuario().getRol() <= 0 && padre.getUsuario().getRol() >= 3) throw new Exception("El rol es obligatorio");
		
		// validacion de que el usuario con numero de identificacion no exista.
		
		if(padre.getDireccion() == null || padre.getDireccion().equals("")) throw new Exception(mensaje.replace("$", "direccion"));
		if(padre.getTelefono() == null || padre.getTelefono().equals("")) throw new Exception(mensaje.replace("$", "telefono"));
		
		usuarioDAO.crear(padre.getUsuario());
		padreDAO.crear(padre);
	}

	@Override
	public void modificarPadre(Padre padre) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Padre consultarPadrePorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Padre> consultarPadreTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(readOnly=true,rollbackFor=Exception.class)
	@Override
	public Usuario consultarUsuarioPorIdentificacion(Long numIdentificacion) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		usuario = usuarioDAO.consultarPorIdentificacion(numIdentificacion);
		return usuario;
	}

}
