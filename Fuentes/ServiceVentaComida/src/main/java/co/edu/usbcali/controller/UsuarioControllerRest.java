package co.edu.usbcali.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.dto.UsuarioDTO;
import co.edu.usbcali.modelo.Usuario;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/usuarioControllerRest")
public class UsuarioControllerRest {

	private final static Logger log = LoggerFactory.getLogger(UsuarioControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarUsuarioPorId/{id}",method=RequestMethod.GET)
	public UsuarioDTO consultarUsuarioPorId(@PathVariable("usuarioId") Long usuarioId) {
		
		log.info("Ingreso a consultar sopa por sopaId");
		
		Usuario usuario;
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		try {
			
			usuario = delegadoDeNegocio.consultarPorIdUsuario(usuarioId);
			if(usuario == null) {
				usuarioDTO.setCodigoError("80");
				usuarioDTO.setMensajeError("El usuario con numero: " + usuarioId + " no existe");
				return usuarioDTO;
			}
			
			usuarioDTO = new UsuarioDTO();
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setPrimerNombre(usuario.getPrimerNombre());
			usuarioDTO.setSegundoNombre(usuario.getSegundoNombre());
			usuarioDTO.setPrimerApellido(usuario.getPrimerApellido());
			usuarioDTO.setSegundoApellido(usuario.getSegundoApellido());
			usuarioDTO.setNumIdentificacion(usuario.getNumIdentificacion());
			usuarioDTO.setRol(usuario.getRol());
			usuarioDTO.setTipoIdentificacion(usuario.getTipoIdentificacion());
			usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
			usuarioDTO.setUsuarioCreacion(usuario.getUsuarioCreacion());
			usuarioDTO.setFechaModifica(usuario.getFechaModifica());
			usuarioDTO.setUsuarioModifica(usuario.getUsuarioModifica());
			
			usuarioDTO.setCodigoError("0");
			usuarioDTO.setMensajeError("OK");
			
			return usuarioDTO;
			
			
		} catch (Exception e) {
			
			usuarioDTO.setCodigoError("30");
			usuarioDTO.setMensajeError(e.getMessage());
			
			return usuarioDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearUsuario",method=RequestMethod.POST)
	public ResultadoRest crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		log.info("Ingreso a crear usuario");
	
			try {
				
				Usuario usuario = new Usuario();
				
				usuarioDTO = new UsuarioDTO();
				usuarioDTO.setId(usuario.getId());
				usuarioDTO.setPrimerNombre(usuario.getPrimerNombre());
				usuarioDTO.setSegundoNombre(usuario.getSegundoNombre());
				usuarioDTO.setPrimerApellido(usuario.getPrimerApellido());
				usuarioDTO.setSegundoApellido(usuario.getSegundoApellido());
				usuarioDTO.setNumIdentificacion(usuario.getNumIdentificacion());
				usuarioDTO.setRol(usuario.getRol());
				usuarioDTO.setTipoIdentificacion(usuario.getTipoIdentificacion());
				usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
				usuarioDTO.setUsuarioCreacion(usuario.getUsuarioCreacion());
			
		
				delegadoDeNegocio.crearUsuario(usuario);
				
				ResultadoRest resultadoRest = new ResultadoRest();
				
				resultadoRest.setCodigoError("0");
				resultadoRest.setMensajeError("OK");
				return resultadoRest;
				
			} catch (Exception e) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				
				resultadoRest.setCodigoError("30");
				resultadoRest.setMensajeError(e.getMessage());
				return resultadoRest;
			}
	}
	
	@RequestMapping(value="/modificarUsuario",method=RequestMethod.PUT)
	public ResultadoRest modificarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		log.info("Ingreso a modificar Usuario");
		
		try {
			Usuario usuario = delegadoDeNegocio.consultarPorIdUsuario(usuarioDTO.getId());
			if(usuario == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El usuario con numero:" + usuarioDTO.getId() + " no existe");
				
				return resultadoRest;
			}
			
			usuarioDTO.setPrimerNombre(usuario.getPrimerNombre());
			usuarioDTO.setSegundoNombre(usuario.getSegundoNombre());
			usuarioDTO.setPrimerApellido(usuario.getPrimerApellido());
			usuarioDTO.setSegundoApellido(usuario.getSegundoApellido());
			usuarioDTO.setNumIdentificacion(usuario.getNumIdentificacion());
			usuarioDTO.setRol(usuario.getRol());
			usuarioDTO.setTipoIdentificacion(usuario.getTipoIdentificacion());
			usuarioDTO.setFechaModifica(usuario.getFechaModifica());
			usuarioDTO.setUsuarioModifica(usuario.getUsuarioModifica());
			
			delegadoDeNegocio.modificarUsuario(usuario);
			
			ResultadoRest resultadoRest = new ResultadoRest();
			
			resultadoRest.setCodigoError("0");
			resultadoRest.setMensajeError("OK");
			return resultadoRest;
			
		} catch (Exception e) {
			
			ResultadoRest resultadoRest = new ResultadoRest();
			
			resultadoRest.setCodigoError("30");
			resultadoRest.setMensajeError(e.getMessage());
			return resultadoRest;
		}
	}
	
	@RequestMapping(value="/borrarUsuario",method=RequestMethod.DELETE)
	public ResultadoRest borrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		log.info("Ingreso a borrar usuario");
		
		try {
			
			Usuario usuario = delegadoDeNegocio.consultarPorIdUsuario(usuarioDTO.getId());
			if(usuario == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El usuario con numero:"+usuarioDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarUsuario(usuario);
			
			ResultadoRest resultadoRest = new ResultadoRest();
			
			resultadoRest.setCodigoError("0");
			resultadoRest.setMensajeError("OK");
			return resultadoRest;
			
		} catch (Exception e) {
			
			
			ResultadoRest resultadoRest = new ResultadoRest();
			
			resultadoRest.setCodigoError("30");
			resultadoRest.setMensajeError(e.getMessage());
			return resultadoRest;
		}
	}
	
}
