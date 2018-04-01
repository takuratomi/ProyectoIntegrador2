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

import co.edu.usbcali.dto.PagoDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Pago;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/pagoControllerRest")
public class PagoControllerRest {

	private final static Logger log = LoggerFactory.getLogger(PagoControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarPagoPorId/{id}",method=RequestMethod.GET)
	public PagoDTO consultarPagoPorId(@PathVariable("pagoId") BigDecimal pagoId) {
		
		log.info("Ingreso a consultar pago por pagoId");
		
		Pago pago;
		PagoDTO pagoDTO = new PagoDTO();
		
		try {
			
			pago = delegadoDeNegocio.consultarPorIdPago(pagoId);
			if(pago == null) {
				pagoDTO.setCodigoError("80");
				pagoDTO.setMensajeError("El pago con numero: " + pagoId + " no existe");
				return pagoDTO;
			}
			
			pagoDTO = new PagoDTO();
			pagoDTO.setId(pago.getId());
			pagoDTO.setDetalle(pago.getDetalle());
			pagoDTO.setEstado(pago.getEstado());
			pagoDTO.setValor(pago.getValor());
			pagoDTO.setFechaCreacion(pago.getFechaCreacion());
			pagoDTO.setUsuarioCreacion(pago.getUsuarioCreacion());
			pagoDTO.setFechaModifica(pago.getFechaModifica());
			pagoDTO.setUsuarioModifica(pago.getUsuarioModifica());
			
			pagoDTO.setCodigoError("0");
			pagoDTO.setMensajeError("OK");
			
			return pagoDTO;
			
			
		} catch (Exception e) {
			
			pagoDTO.setCodigoError("30");
			pagoDTO.setMensajeError(e.getMessage());
			
			return pagoDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearPago",method=RequestMethod.POST)
	public ResultadoRest crearPago(@RequestBody PagoDTO pagoDTO) {
	
		log.info("Ingreso a crear pago");
		
			try {
				
				Pago pago = new Pago();
				
				pago.setId(pagoDTO.getId());
				pago.setDetalle(pagoDTO.getDetalle());
				pago.setEstado(pagoDTO.getEstado());
				pago.setValor(pagoDTO.getValor());
				pago.setFechaCreacion(pagoDTO.getFechaCreacion());
				pago.setUsuarioCreacion(pagoDTO.getUsuarioCreacion());
		
				delegadoDeNegocio.crearPago(pago);
				
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
	
	@RequestMapping(value="/modificarPago",method=RequestMethod.PUT)
	public ResultadoRest modificarPago(@RequestBody PagoDTO pagoDTO) {
		
		log.info("Ingreso a modificar pago");
		
		try {
			Pago pago = delegadoDeNegocio.consultarPorIdPago(pagoDTO.getId());
			if(pago == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El pago con numero:"+pagoDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			pago.setDetalle(pagoDTO.getDetalle());
			pago.setEstado(pagoDTO.getEstado());
			pago.setValor(pagoDTO.getValor());
			pago.setFechaModifica(pagoDTO.getFechaModifica());
			pago.setUsuarioModifica(pagoDTO.getUsuarioModifica());
			
			delegadoDeNegocio.modificarPago(pago);
			
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
	
	@RequestMapping(value="/borrarPago",method=RequestMethod.DELETE)
	public ResultadoRest borrarPago(@RequestBody PagoDTO pagoDTO) {
		
		log.info("Ingreso a borrar pago");
		
		try {
			
			Pago pago = delegadoDeNegocio.consultarPorIdPago(pagoDTO.getId());
			if(pago == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El pago con numero:"+pagoDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarPago(pago);
			
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
