package co.edu.usbcali.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.ParametrosDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Parametros;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/parametrosControllerRest")
public class ParametrosControllerRest {

	private final static Logger log = LoggerFactory.getLogger(ParametrosControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarParametroPorId/{id}",method=RequestMethod.GET)
	public ParametrosDTO consultarParametrosPorId(@PathVariable("parametrosId") Long parametrosId) {
		
		log.info("Ingreso a consultar parametros por parametrosId");
		
		Parametros parametros;
		ParametrosDTO parametrosDTO = new ParametrosDTO();
		
		try {
			
			parametros = delegadoDeNegocio.consultarPorIdParametros(parametrosId);
			if(parametros == null) {
				parametrosDTO.setCodigoError("80");
				parametrosDTO.setMensajeError("El parametro con numero: " + parametrosId + " no existe");
				return parametrosDTO;
			}
			
			parametrosDTO = new ParametrosDTO();
			parametrosDTO.setId(parametros.getId());
			parametrosDTO.setNombre(parametros.getNombre());
			parametrosDTO.setValor(parametros.getValor());
			parametrosDTO.setFechaCreacion(parametros.getFechaCreacion());
			parametrosDTO.setUsuarioCreacion(parametros.getUsuarioCreacion());
			parametrosDTO.setFechaModifica(parametros.getFechaModifica());
			parametrosDTO.setUsuarioModifica(parametros.getUsuarioModifica());
			
			parametrosDTO.setCodigoError("0");
			parametrosDTO.setMensajeError("OK");
			
			return parametrosDTO;
			
			
		} catch (Exception e) {
			
			parametrosDTO.setCodigoError("30");
			parametrosDTO.setMensajeError(e.getMessage());
			
			return parametrosDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearParametros",method=RequestMethod.POST)
	public ResultadoRest crearParametros(@RequestBody ParametrosDTO parametrosDTO) {
		
		log.info("Ingreso a crear parametros");
	
			try {
				
				Parametros parametros = new Parametros();
				
				parametros.setId(parametrosDTO.getId());
				parametros.setNombre(parametrosDTO.getNombre());
				parametros.setValor(parametrosDTO.getValor());
				parametros.setFechaCreacion(parametrosDTO.getFechaCreacion());
				parametros.setUsuarioCreacion(parametrosDTO.getUsuarioCreacion());
			
		
				delegadoDeNegocio.crearParametros(parametros);
				
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
	
	@RequestMapping(value="/modificarParametros",method=RequestMethod.PUT)
	public ResultadoRest modificarParametros(@RequestBody ParametrosDTO parametrosDTO) {
		
		log.info("Ingreso a modificar parametros");
		
		try {
			Parametros parametros = delegadoDeNegocio.consultarPorIdParametros(parametrosDTO.getId());
			if(parametros == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El parametro con numero:"+parametrosDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			parametros.setNombre(parametrosDTO.getNombre());
			parametros.setValor(parametrosDTO.getValor());
			parametros.setFechaModifica(parametrosDTO.getFechaModifica());
			parametros.setUsuarioModifica(parametrosDTO.getUsuarioModifica());
			
			delegadoDeNegocio.modificarParametros(parametros);
			
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
	
	@RequestMapping(value="/borrarParametros",method=RequestMethod.DELETE)
	public ResultadoRest borrarParametros(@RequestBody ParametrosDTO parametrosDTO) {
		
		log.info("Ingreso a borrar parametros");
		
		try {
			
			Parametros parametros = delegadoDeNegocio.consultarPorIdParametros(parametrosDTO.getId());
			if(parametros == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El parametro con numero:"+parametrosDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarParametros(parametros);
			
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
