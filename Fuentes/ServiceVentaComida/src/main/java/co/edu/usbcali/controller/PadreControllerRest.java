package co.edu.usbcali.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.PadreDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/padreControllerRest")
public class PadreControllerRest {

	private final static Logger log = LoggerFactory.getLogger(PadreControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarPadrePorId/{id}",method=RequestMethod.GET)
	public PadreDTO consultarPadrePorId(@PathVariable("padreId") Long padreId) {
		
		log.info("Ingreso a consultar padre por padreId");
		
		Padre padre;
		PadreDTO padreDTO = new PadreDTO();
		
		try {
			
			padre = delegadoDeNegocio.consultarPorIdPadre(padreId);
			if(padre == null) {
				padreDTO.setCodigoError("80");
				padreDTO.setMensajeError("El padre con numero: " + padreId + " no existe");
				return padreDTO;
			}
			
			
			padreDTO = new PadreDTO();
			padreDTO.setId(padre.getId());
			padreDTO.setDireccion(padre.getDireccion());
			padreDTO.setTelefono(padre.getTelefono());
			padreDTO.setUsuario(padre.getUsuario());
			padreDTO.setUsuarioCreacion(padre.getUsuarioCreacion());
			padreDTO.setFechaCreacion(padre.getFechaCreacion());
			padreDTO.setUsuarioModifica(padre.getUsuarioModifica());
			padreDTO.setFechaModifica(padre.getFechaModifica());
			
			padreDTO.setCodigoError("0");
			padreDTO.setMensajeError("OK");
			
			return padreDTO;
			
			
		} catch (Exception e) {
			
			padreDTO.setCodigoError("30");
			padreDTO.setMensajeError(e.getMessage());
			
			return padreDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearPadre",method=RequestMethod.POST)
	public ResultadoRest crearPadre(@RequestBody PadreDTO padreDTO) {
	
		log.info("Ingreso a crear Padre");
		
			try {
				
				Padre padre = new Padre();
				
				padre.setId(padreDTO.getId());
				padre.setDireccion(padreDTO.getDireccion());
				padre.setTelefono(padreDTO.getTelefono());
				
				Usuario usuario = delegadoDeNegocio.consultarPorIdUsuario(padreDTO.getUsuario().getId());
				padre.setUsuario(usuario);
				
				
				padre.setUsuarioCreacion(padreDTO.getUsuarioCreacion());
				padre.setFechaCreacion(padreDTO.getFechaCreacion());
				
				
				delegadoDeNegocio.crearPadre(padre);
				
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
	
	@RequestMapping(value="/modificarPadre",method=RequestMethod.PUT)
	public ResultadoRest modificarPadre(@RequestBody PadreDTO padreDTO) {
		
		log.info("Ingreso a modificar padre");
		
		try {
			Padre padre = delegadoDeNegocio.consultarPorIdPadre(padreDTO.getId());
			if(padre == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El padre con numero:"+padreDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			padre.setDireccion(padreDTO.getDireccion());
			padre.setTelefono(padreDTO.getTelefono());
			
			Usuario usuario = delegadoDeNegocio.consultarPorIdUsuario(padreDTO.getUsuario().getId());
			padre.setUsuario(usuario);
			
			
			padre.setUsuarioModifica(padreDTO.getUsuarioModifica());
			padre.setFechaModifica(padreDTO.getFechaModifica());
			
			delegadoDeNegocio.modificarPadre(padre);
			
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
	
	@RequestMapping(value="/borrarPadre",method=RequestMethod.DELETE)
	public ResultadoRest borrarPadre(@RequestBody PadreDTO padreDTO) {
		
		log.info("Ingreso a borrar padre");
		
		try {
			
			Padre padre = delegadoDeNegocio.consultarPorIdPadre(padreDTO.getId());
			if(padre == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El padre con numero:"+padreDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarPadre(padre);
			
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
