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

import co.edu.usbcali.dto.BebidaDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Bebida;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/bebidaControllerRest")
public class BebidaControllerRest {

	private final static Logger log = LoggerFactory.getLogger(BebidaControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarBebidaPorId/{id}",method=RequestMethod.GET)
	public BebidaDTO consultarBebidaPorId(@PathVariable("bebidaId") BigDecimal bebidaId) {
		
		log.info("Ingreso a consultar Bebida por bebidaId");
		
		Bebida bebida;
		BebidaDTO bebidaDTO = new BebidaDTO();
		
		try {
			
			bebida = delegadoDeNegocio.consultarPorIdBebida(bebidaId);
			if(bebida == null) {
				bebidaDTO.setCodigoError("80");
				bebidaDTO.setMensajeError("La bebida con numero: " + bebidaId + " no existe");
				return bebidaDTO;
			}
			
			bebidaDTO = new BebidaDTO();
			bebidaDTO.setId(bebida.getId());
			bebidaDTO.setNombre(bebida.getNombre());
			bebidaDTO.setDescripcion(bebida.getDescripcion());
			bebidaDTO.setUsuarioCreacion(bebida.getUsuarioCreacion());
			bebidaDTO.setFechaCreacion(bebida.getFechaCreacion());
			bebidaDTO.setUsuarioModifica(bebida.getUsuarioModifica());
			bebidaDTO.setFechaModifica(bebida.getFechaModifica());
			
			bebidaDTO.setCodigoError("0");
			bebidaDTO.setMensajeError("OK");
			
			return bebidaDTO;
			
			
		} catch (Exception e) {
			
			bebidaDTO.setCodigoError("30");
			bebidaDTO.setMensajeError(e.getMessage());
			
			return bebidaDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearBebida",method=RequestMethod.POST)
	public ResultadoRest crearBebida(@RequestBody BebidaDTO bebidaDTO) {
	
		log.info("Ingreso a crear bebida");
		
			try {
				
				Bebida bebida = new Bebida();
				bebida.setId(bebidaDTO.getId());
				bebida.setNombre(bebidaDTO.getNombre());
				bebida.setDescripcion(bebidaDTO.getDescripcion());
				bebida.setFechaCreacion(bebidaDTO.getFechaCreacion());
				bebida.setUsuarioCreacion(bebidaDTO.getUsuarioCreacion());
				
				delegadoDeNegocio.crearBebida(bebida);
				
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
	
	@RequestMapping(value="/modificarBebida",method=RequestMethod.PUT)
	public ResultadoRest modificarBebida(@RequestBody BebidaDTO bebidaDTO) {
		
		log.info("Ingreso a modificar bebida");
		
		try {
			Bebida bebida = delegadoDeNegocio.consultarPorIdBebida(bebidaDTO.getId());
			if(bebida == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("La bebida con numero:"+bebidaDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			bebida.setNombre(bebidaDTO.getNombre());
			bebida.setDescripcion(bebidaDTO.getDescripcion());
			bebida.setFechaModifica(bebidaDTO.getFechaModifica());
			bebida.setUsuarioModifica(bebidaDTO.getUsuarioModifica());
			
			delegadoDeNegocio.modificarBebida(bebida);
			
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
	
	@RequestMapping(value="/borrarBebida",method=RequestMethod.DELETE)
	public ResultadoRest borrarBebida(@RequestBody BebidaDTO bebidaDTO) {
		
		log.info("Ingreso a borrar bebida");
		
		try {
			
			Bebida bebida = delegadoDeNegocio.consultarPorIdBebida(bebidaDTO.getId());
			if(bebida == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("La bebida con numero:"+bebidaDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarBebida(bebida);
			
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
