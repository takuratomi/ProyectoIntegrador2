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

import co.edu.usbcali.dto.AlmuerzoDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Almuerzo;
import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.MenuSemana;
import co.edu.usbcali.modelo.Pedido;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/almuerzoControllerRest")
public class AlmuerzoControllerRest {

	private final static Logger log = LoggerFactory.getLogger(AlmuerzoControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarAlmuerzoPorId/{id}",method=RequestMethod.GET)
	public AlmuerzoDTO consultarBebidaPorId(@PathVariable("almuerzoID") BigDecimal almuerzoId) {
		
		log.info("Ingreso a consultar almuerzo por almuerzoId");
		
		Almuerzo almuerzo;
		AlmuerzoDTO almuerzoDTO = new AlmuerzoDTO();
		
		try {
			
			almuerzo = delegadoDeNegocio.consultarPorIdAlmuerzo(almuerzoId);
			if(almuerzo == null) {
				almuerzoDTO.setCodigoError("80");
				almuerzoDTO.setMensajeError("La bebida con numero: " + almuerzoId + " no existe");
				return almuerzoDTO;
			}
			
			almuerzoDTO = new AlmuerzoDTO();
			almuerzoDTO.setId(almuerzo.getId());
			almuerzoDTO.setEstado(almuerzo.getEstado());
			almuerzoDTO.setHijo(almuerzo.getHijo());
			almuerzoDTO.setMenuSemana(almuerzo.getMenuSemana());
			almuerzoDTO.setPedido(almuerzo.getPedido());
			almuerzoDTO.setUsuarioCreacion(almuerzo.getUsuarioCreacion());
			almuerzoDTO.setFechaCreacion(almuerzo.getFechaCreacion());
			almuerzoDTO.setUsuarioModifica(almuerzo.getUsuarioModifica());
			almuerzoDTO.setFechaModifica(almuerzo.getFechaModifica());
			
			almuerzoDTO.setCodigoError("0");
			almuerzoDTO.setMensajeError("OK");
			
			return almuerzoDTO;
			
			
		} catch (Exception e) {
			
			almuerzoDTO.setCodigoError("30");
			almuerzoDTO.setMensajeError(e.getMessage());
			
			return almuerzoDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearAlmuerzo",method=RequestMethod.POST)
	public ResultadoRest crearAlmuerzo(@RequestBody AlmuerzoDTO almuerzoDTO) {
	
		log.info("Ingreso a crear almuerzo");
		
			try {
				
				Almuerzo almuerzo = new Almuerzo();
				
				almuerzo.setId(almuerzoDTO.getId());
				almuerzo.setEstado(almuerzoDTO.getEstado());
				
				Hijo hijo = delegadoDeNegocio.consultarPorIdHijo(almuerzoDTO.getHijo().getId());
				almuerzo.setHijo(hijo);
				
				Pedido pedido = delegadoDeNegocio.consultarPorIdPedido(almuerzoDTO.getPedido().getId());
				almuerzo.setPedido(pedido);
				
				MenuSemana menuSemana = delegadoDeNegocio.consultarPorIdMenuSemana(almuerzoDTO.getMenuSemana().getId());
				almuerzo.setMenuSemana(menuSemana);
				
				almuerzo.setUsuarioCreacion(almuerzoDTO.getUsuarioCreacion());
				almuerzo.setFechaCreacion(almuerzoDTO.getFechaCreacion());
				
				
				delegadoDeNegocio.crearAlmuerzo(almuerzo);
				
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
	
	@RequestMapping(value="/modificarAlmuerzo",method=RequestMethod.PUT)
	public ResultadoRest modificarAlmuerzo(@RequestBody AlmuerzoDTO almuerzoDTO) {
		
		log.info("Ingreso a modificar almuerzo");
		
		try {
			Almuerzo almuerzo = delegadoDeNegocio.consultarPorIdAlmuerzo(almuerzoDTO.getId());
			if(almuerzo == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El almuerzo con numero:"+almuerzoDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			almuerzo.setEstado(almuerzoDTO.getEstado());
			
			Hijo hijo = delegadoDeNegocio.consultarPorIdHijo(almuerzoDTO.getHijo().getId());
			almuerzo.setHijo(hijo);
			
			Pedido pedido = delegadoDeNegocio.consultarPorIdPedido(almuerzoDTO.getPedido().getId());
			almuerzo.setPedido(pedido);
			
			MenuSemana menuSemana = delegadoDeNegocio.consultarPorIdMenuSemana(almuerzoDTO.getMenuSemana().getId());
			almuerzo.setMenuSemana(menuSemana);
			
			almuerzo.setUsuarioModifica(almuerzoDTO.getUsuarioModifica());
			almuerzo.setFechaModifica(almuerzoDTO.getFechaModifica());
			
			delegadoDeNegocio.modificarAlmuerzo(almuerzo);
			
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
	
	@RequestMapping(value="/borrarAlmuerzo",method=RequestMethod.DELETE)
	public ResultadoRest borrarAlmuerzo(@RequestBody AlmuerzoDTO almuerzoDTO) {
		
		log.info("Ingreso a borrar almuerzo");
		
		try {
			
			Almuerzo almuerzo = delegadoDeNegocio.consultarPorIdAlmuerzo(almuerzoDTO.getId());
			if(almuerzo == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("El almuerzo con numero:"+almuerzoDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarAlmuerzo(almuerzo);
			
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
