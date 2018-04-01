package co.edu.usbcali.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.PrincipioDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Principio;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/principioControllerRest")
public class PrincipioControllerRest {

	private final static Logger log = LoggerFactory.getLogger(PrincipioControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarPrincipioPorId/{id}",method=RequestMethod.GET)
	public PrincipioDTO consultarPrincipioPorId(@PathVariable("principioId") BigDecimal principioId) {
		
		log.info("Ingreso a consultar principio por principioId");
		
		Principio principio;
		PrincipioDTO principioDTO = new PrincipioDTO();
		
		try {
			
			principio = delegadoDeNegocio.consultarPorIdPrincpio(principioId);
			if(principio == null) {
				principioDTO.setCodigoError("80");
				principioDTO.setMensajeError("El principio con numero: " + principioId + " no existe");
				return principioDTO;
			}
			
			principioDTO = new PrincipioDTO();
			principioDTO.setId(principio.getId());
			principioDTO.setNombre(principio.getNombre());
			principioDTO.setDescripcion(principio.getDescripcion());
			principioDTO.setFechaCreacion(principio.getFechaCreacion());
			principioDTO.setUsuarioCreacion(principio.getUsuarioCreacion());
			principioDTO.setFechaModifica(principio.getFechaCreacion());
			principioDTO.setUsuarioModifica(principio.getUsuarioModifica());
			
			principioDTO.setCodigoError("0");
			principioDTO.setMensajeError("OK");
			
			return principioDTO;
			
			
		} catch (Exception e) {
			
			principioDTO.setCodigoError("30");
			principioDTO.setMensajeError(e.getMessage());
			
			return principioDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearPrincipio",method=RequestMethod.POST)
	public ResultadoRest crearPrincipio(@RequestBody PrincipioDTO principioDTO) {
		
		log.info("Ingreso a crear principio");
	
			try {
				
				Principio principio = new Principio();
				
				principio.setId(principioDTO.getId());
				principio.setNombre(principioDTO.getNombre());
				principio.setDescripcion(principioDTO.getDescripcion());
				principio.setFechaCreacion(principioDTO.getFechaCreacion());
				principio.setUsuarioCreacion(principioDTO.getUsuarioCreacion());
			
		
				delegadoDeNegocio.crearPrincipio(principio);
				
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
	
	@RequestMapping(value="/modificarPrincipio",method=RequestMethod.PUT)
	public ResultadoRest modificarPrincipio(@RequestBody PrincipioDTO principioDTO) {
		
		log.info("Ingreso a modificar principio");
		
		try {
			Principio principio = delegadoDeNegocio.consultarPorIdPrincpio(principioDTO.getId());
			if(principio == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El principio con numero:" + principioDTO.getId() + " no existe");
				
				return resultadoRest;
			}
			
			principio.setNombre(principioDTO.getNombre());
			principio.setDescripcion(principioDTO.getDescripcion());
			principio.setFechaModifica(principioDTO.getFechaModifica());
			principio.setUsuarioModifica(principioDTO.getUsuarioModifica());
			
			delegadoDeNegocio.modificarPrincipio(principio);
			
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
	
	@RequestMapping(value="/borrarPrincipio",method=RequestMethod.DELETE)
	public ResultadoRest borrarPrincipio(@RequestBody PrincipioDTO principioDTO) {
		
		log.info("Ingreso a borrar principio");
		
		try {
			
			Principio principio = delegadoDeNegocio.consultarPorIdPrincpio(principioDTO.getId());
			if(principio == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El principio con numero:"+principioDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarPrincipio(principio);
			
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
