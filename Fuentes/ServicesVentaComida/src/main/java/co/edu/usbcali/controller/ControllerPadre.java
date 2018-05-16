package co.edu.usbcali.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.HijoDTO;
import co.edu.usbcali.dto.PadreDTO;
import co.edu.usbcali.dto.UsuarioDTO;
import co.edu.usbcali.logica.IPadreLogica;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

@RestController
@RequestMapping("/PadreRest")
public class ControllerPadre {

	@Autowired
	private IPadreLogica padreLogica;

	@RequestMapping(value = "/crearPadre", method = RequestMethod.POST)
	public PadreDTO crearPadreRest(@RequestBody PadreDTO padreDTO) throws Exception {

		Usuario usuario = new Usuario();
		Padre padre = new Padre();
		String usuario_ = "";
		Date fecha = null;

		if (padreDTO != null) {
			usuario_ = padreDTO.getUsuario();
			fecha = padreDTO.getFecha();
			usuario.setPrimerNombre(padreDTO.getPrimerNombre());
			usuario.setSegundoNombre(padreDTO.getSegundoNombre());
			usuario.setPrimerApellido(padreDTO.getPrimerApellido());
			usuario.setSegundoApellido(padreDTO.getSegundoApellido());
			usuario.setNumIdentificacion(padreDTO.getNumIdentificacion());
			usuario.setTipoIdentificacion(padreDTO.getTipoIdentificacion());
			usuario.setPassword(padreDTO.getPassword());
			usuario.setRol(padreDTO.getRol());
			usuario.setUsuarioCreacion(padreDTO.getUsuario());
			usuario.setFechaCreacion(padreDTO.getFecha());

			padre.setTelefono(padreDTO.getTelefono());
			padre.setDireccion(padreDTO.getDireccion());
			padre.setUsuario(usuario);
			padre.setUsuarioCreacion(usuario_);
			padre.setFechaCreacion(fecha);

			try {
				padreLogica.crearPadre(padre);
				padreDTO.setCodigoError(0);
				padreDTO.setMensajeError("Operación Exitosa");

				return padreDTO;
			} catch (Exception e) {
				padreDTO.setCodigoError(9);
				padreDTO.setMensajeError(e.getMessage());
				return padreDTO;
			}
		}
		return null;
	}
	
	
	@RequestMapping(value = "/modificarPadre", method = RequestMethod.POST)
	public PadreDTO modificarPadreRest(@RequestBody PadreDTO padreDTO) throws Exception {

		Usuario usuario = new Usuario();
		Padre padre = new Padre();
		String usuario_ = "";
		Date fecha = null;

		if (padreDTO != null) {
			usuario_ = padreDTO.getUsuario();
			fecha = padreDTO.getFecha();
			usuario.setPrimerNombre(padreDTO.getPrimerNombre());
			usuario.setSegundoNombre(padreDTO.getSegundoNombre());
			usuario.setPrimerApellido(padreDTO.getPrimerApellido());
			usuario.setSegundoApellido(padreDTO.getSegundoApellido());
			usuario.setNumIdentificacion(padreDTO.getNumIdentificacion());
			usuario.setTipoIdentificacion(padreDTO.getTipoIdentificacion());
			usuario.setPassword(padreDTO.getPassword());
			usuario.setRol(padreDTO.getRol());
			usuario.setUsuarioCreacion(padreDTO.getUsuario());
			usuario.setFechaCreacion(padreDTO.getFecha());

			padre.setId(padreDTO.getId_padre());
			padre.setTelefono(padreDTO.getTelefono());
			padre.setDireccion(padreDTO.getDireccion());
			padre.setUsuario(usuario);
			padre.setUsuarioCreacion(usuario_);
			padre.setFechaCreacion(fecha);

			try {
				padreLogica.modificarPadre(padre);
				padreDTO.setCodigoError(0);
				padreDTO.setMensajeError("Operación Exitosa");

				return padreDTO;
			} catch (Exception e) {
				padreDTO.setCodigoError(9);
				padreDTO.setMensajeError(e.getMessage());
				return padreDTO;
			}
		}
		return null;
	}

	@RequestMapping(value ="/verificarDatosUsuario/{id}", method=RequestMethod.GET)
	public UsuarioDTO verificarDatosUsuario(@PathVariable("id") Long id) throws Exception {
		
		Long numIdentificacion = id;	
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		try {
			
			Usuario user = padreLogica.consultarUsuarioPorIdentificacion(numIdentificacion);
					
			if(user != null)
			{
				usuarioDTO.setId(user.getId());
				usuarioDTO.setPrimerNombre(user.getPrimerNombre());
				usuarioDTO.setSegundoNombre(user.getSegundoNombre());
				usuarioDTO.setPrimerApellido(user.getPrimerApellido());
				usuarioDTO.setSegundoApellido(user.getSegundoApellido());
				usuarioDTO.setRol(user.getRol());
				usuarioDTO.setNumIdentificacion(user.getNumIdentificacion());
				usuarioDTO.setTipoIdentificacion(user.getTipoIdentificacion());
							
				usuarioDTO.setCodigoError(0);
				usuarioDTO.setMensajeError("Operación Exitosa");
			}
			else
			{
				usuarioDTO = new UsuarioDTO();
				usuarioDTO.setId(0);
				usuarioDTO.setNumIdentificacion(0L);
				usuarioDTO.setRol(0);
				usuarioDTO.setCodigoError(91);
				usuarioDTO.setMensajeError("El usuario no existe");
			}
			
			return usuarioDTO;

		} catch (Exception e) {
			
			usuarioDTO.setCodigoError(90);
			usuarioDTO.setMensajeError(e.getMessage());
		
			return usuarioDTO;
		}		
	}
	
	@RequestMapping(value ="/consultarPadres", method=RequestMethod.GET)
	public List<PadreDTO> consultarPadres() throws Exception
	{
		List<Padre> losPadres = null;
		List<PadreDTO> losPadresDTO = null;
		PadreDTO padreDTO = null;
		losPadres = padreLogica.consultarPadreTodos();
		
		if(losPadres != null)
		{
			losPadresDTO = new ArrayList<PadreDTO>();
			
			for (Padre padre : losPadres) {
				padreDTO = new PadreDTO();
				
				padreDTO.setId_padre(padre.getId());
				padreDTO.setId_usuario(padre.getUsuario().getId());
				padreDTO.setPrimerNombre(padre.getUsuario().getPrimerNombre());
				padreDTO.setSegundoNombre(padre.getUsuario().getSegundoNombre());
				padreDTO.setPrimerApellido(padre.getUsuario().getPrimerApellido());
				padreDTO.setSegundoApellido(padre.getUsuario().getSegundoApellido());
				padreDTO.setNumIdentificacion(padre.getUsuario().getNumIdentificacion());
				padreDTO.setTipoIdentificacion(padre.getUsuario().getTipoIdentificacion());
				padreDTO.setRol(padre.getUsuario().getRol());
				padreDTO.setTelefono(padre.getTelefono());
				padreDTO.setDireccion(padre.getDireccion());
				
				losPadresDTO.add(padreDTO);
			}
			
		}
		
		return losPadresDTO;
	}

}
