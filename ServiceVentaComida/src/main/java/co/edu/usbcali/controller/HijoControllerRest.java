package co.edu.usbcali.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.HijoDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/hijoControllerRest")
public class HijoControllerRest {

	private final static Logger log = LoggerFactory.getLogger(HijoControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarHijoPorId/{id}",method=RequestMethod.GET)
	public HijoDTO consultarBebidaPorId(@PathVariable("hijoId") Long hijoId) {
		
		log.info("Ingreso a consultar hijo por hijoId");
		
		Hijo hijo;
		HijoDTO hijoDTO = new HijoDTO();
		
		try {
			
			hijo = delegadoDeNegocio.consultarPorIdHijo(hijoId);
			if(hijo == null) {
				hijoDTO.setCodigoError("80");
				hijoDTO.setMensajeError("La bebida con numero: " + hijoId + " no existe");
				return hijoDTO;
			}
			
			hijoDTO = new HijoDTO();
			hijoDTO.setId(hijo.getId());
			hijoDTO.setFechaNacimiento(hijo.getFechaNacimiento());
			hijoDTO.setCurso(hijo.getCurso());
			hijoDTO.setPadre(hijo.getPadre());
			hijoDTO.setUsuario(hijo.getUsuario());
			hijoDTO.setUsuarioCreacion(hijo.getUsuarioCreacion());
			hijoDTO.setFechaCreacion(hijo.getFechaCreacion());
			hijoDTO.setUsuarioModifica(hijo.getUsuarioModifica());
			hijoDTO.setFechaModifica(hijo.getFechaModifica());
			
			hijoDTO.setCodigoError("0");
			hijoDTO.setMensajeError("OK");
			
			return hijoDTO;
			
			
		} catch (Exception e) {
			
			hijoDTO.setCodigoError("30");
			hijoDTO.setMensajeError(e.getMessage());
			
			return hijoDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearHijo",method=RequestMethod.POST)
	public ResultadoRest crearHijo(@RequestBody HijoDTO hijoDTO) {
	
		log.info("Ingreso a crear hijo");
		
			try {
				
				Hijo hijo = new Hijo();
				
				hijo.setId(hijoDTO.getId());
				hijo.setCurso(hijoDTO.getCurso());
				hijo.setFechaNacimiento(hijoDTO.getFechaNacimiento());
				
				Padre padre = delegadoDeNegocio.consultarPorIdPadre(hijoDTO.getPadre().getId());
				hijo.setPadre(padre);
				
				Usuario usuario = delegadoDeNegocio.consultarPorIdUsuario(hijoDTO.getUsuario().getId());
				hijo.setUsuario(usuario);
				
				
				hijo.setUsuarioCreacion(hijoDTO.getUsuarioCreacion());
				hijo.setFechaCreacion(hijoDTO.getFechaCreacion());
				
				
				delegadoDeNegocio.crearHijo(hijo);
				
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
	
	@RequestMapping(value="/modificarHijo",method=RequestMethod.PUT)
	public ResultadoRest modificarHijo(@RequestBody HijoDTO hijoDTO) {
		
		log.info("Ingreso a modificar hijo");
		
		try {
			Hijo hijo = delegadoDeNegocio.consultarPorIdHijo(hijoDTO.getId());
			if(hijo == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El hijo con numero:"+hijoDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			hijo.setId(hijoDTO.getId());
			hijo.setCurso(hijoDTO.getCurso());
			hijo.setFechaNacimiento(hijoDTO.getFechaNacimiento());
			
			Padre padre = delegadoDeNegocio.consultarPorIdPadre(hijoDTO.getPadre().getId());
			hijo.setPadre(padre);
			
			Usuario usuario = delegadoDeNegocio.consultarPorIdUsuario(hijoDTO.getUsuario().getId());
			hijo.setUsuario(usuario);
			
			
			hijo.setUsuarioModifica(hijoDTO.getUsuarioModifica());
			hijo.setFechaModifica(hijoDTO.getFechaModifica());
			
			delegadoDeNegocio.modificarHijo(hijo);
			
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
	
	@RequestMapping(value="/borrarHijo",method=RequestMethod.DELETE)
	public ResultadoRest borrarHijo(@RequestBody HijoDTO hijoDTO) {
		
		log.info("Ingreso a borrar hijo");
		
		try {
			
			Hijo hijo = delegadoDeNegocio.consultarPorIdHijo(hijoDTO.getId());
			if(hijo == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El hijo con numero:"+hijoDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarHIjo(hijo);
			
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
