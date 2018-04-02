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

import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.dto.SopaDTO;
import co.edu.usbcali.modelo.Sopa;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/sopaControllerRest")
public class SopaControllerRest {

	private final static Logger log = LoggerFactory.getLogger(SopaControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarSopaPorId/{id}",method=RequestMethod.GET)
	public SopaDTO consultarSopaPorId(@PathVariable("sopaId") BigDecimal sopaId) {
		
		log.info("Ingreso a consultar sopa por sopaId");
		
		Sopa sopa;
		SopaDTO sopaDTO = new SopaDTO();
		
		try {
			
			sopa = delegadoDeNegocio.consultarPorIdSopa(sopaId);
			if(sopa == null) {
				sopaDTO.setCodigoError("80");
				sopaDTO.setMensajeError("La sopa con numero: " + sopaId + " no existe");
				return sopaDTO;
			}
			
			sopaDTO = new SopaDTO();
			sopaDTO.setId(sopa.getId());
			sopaDTO.setNombre(sopa.getNombre());
			sopaDTO.setDescripcion(sopa.getDescripcion());
			sopaDTO.setFechaCreacion(sopa.getFechaCreacion());
			sopaDTO.setUsuarioCreacion(sopa.getUsuarioCreacion());
			sopaDTO.setFechaModifica(sopa.getFechaModifica());
			sopaDTO.setUsuarioModifica(sopa.getUsuarioModifica());
			
			sopaDTO.setCodigoError("0");
			sopaDTO.setMensajeError("OK");
			
			return sopaDTO;
			
			
		} catch (Exception e) {
			
			sopaDTO.setCodigoError("30");
			sopaDTO.setMensajeError(e.getMessage());
			
			return sopaDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearSopa",method=RequestMethod.POST)
	public ResultadoRest crearSopa(@RequestBody SopaDTO sopaDTO) {
		
		log.info("Ingreso a crear sopa");
	
			try {
				
				Sopa sopa = new Sopa();
				
				sopa.setId(sopaDTO.getId());
				sopa.setNombre(sopaDTO.getNombre());
				sopa.setDescripcion(sopaDTO.getDescripcion());
				sopa.setFechaCreacion(sopaDTO.getFechaCreacion());
				sopa.setUsuarioCreacion(sopaDTO.getUsuarioCreacion());
			
		
				delegadoDeNegocio.crearSopa(sopa);
				
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
	
	@RequestMapping(value="/modificarSopa",method=RequestMethod.PUT)
	public ResultadoRest modificarSopa(@RequestBody SopaDTO sopaDTO) {
		
		log.info("Ingreso a modificar sopa");
		
		try {
			Sopa sopa = delegadoDeNegocio.consultarPorIdSopa(sopaDTO.getId());
			if(sopa == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("La sopa con numero:" + sopaDTO.getId() + " no existe");
				
				return resultadoRest;
			}
			
			sopa.setId(sopaDTO.getId());
			sopa.setNombre(sopaDTO.getNombre());
			sopa.setDescripcion(sopaDTO.getDescripcion());
			sopa.setFechaModifica(sopaDTO.getFechaModifica());
			sopa.setUsuarioModifica(sopaDTO.getUsuarioModifica());
			
			delegadoDeNegocio.modificarSopa(sopa);
			
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
	
	@RequestMapping(value="/borrarSopa",method=RequestMethod.DELETE)
	public ResultadoRest borrarSopa(@RequestBody SopaDTO sopaDTO) {
		
		log.info("Ingreso a borrar sopa");
		
		try {
			
			Sopa sopa = delegadoDeNegocio.consultarPorIdSopa(sopaDTO.getId());
			if(sopa == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("La sopa con numero:"+sopaDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarSopa(sopa);
			
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
