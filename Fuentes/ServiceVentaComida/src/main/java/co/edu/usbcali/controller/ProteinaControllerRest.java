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

import co.edu.usbcali.dto.ProteinaDTO;
import co.edu.usbcali.dto.ResultadoRest;
import co.edu.usbcali.modelo.Proteina;
import co.usbcali.edu.delegado.IDelegadoDeNegocio;


@RestController
@RequestMapping("/proteinaControllerRest")
public class ProteinaControllerRest {

	private final static Logger log = LoggerFactory.getLogger(ProteinaControllerRest.class);
	
	@Autowired
	private IDelegadoDeNegocio delegadoDeNegocio;
	
	@RequestMapping(value="/consultarProteinaPorId/{id}",method=RequestMethod.GET)
	public ProteinaDTO consultarPrincipioPorId(@PathVariable("proteinaId") BigDecimal proteinaId) {
		
		log.info("Ingreso a consultar proteina por proteinaId");
		
		Proteina proteina;
		ProteinaDTO proteinaDTO = new ProteinaDTO();
		
		try {
			
			proteina = delegadoDeNegocio.consultarPorIdProteina(proteinaId);
			if(proteina == null) {
				proteinaDTO.setCodigoError("80");
				proteinaDTO.setMensajeError("La proteina con numero: " + proteinaId + " no existe");
				return proteinaDTO;
			}
			
			proteinaDTO = new ProteinaDTO();
			proteinaDTO.setId(proteina.getId());
			proteinaDTO.setNombre(proteina.getNombre());
			proteinaDTO.setDescripcion(proteina.getDescripcion());
			proteinaDTO.setFechaCreacion(proteina.getFechaCreacion());
			proteinaDTO.setUsuarioCreacion(proteina.getUsuarioCreacion());
			proteinaDTO.setFechaModifica(proteina.getFechaModifica());
			proteinaDTO.setUsuarioModifica(proteina.getUsuarioModifica());
			
			proteinaDTO.setCodigoError("0");
			proteinaDTO.setMensajeError("OK");
			
			return proteinaDTO;
			
			
		} catch (Exception e) {
			
			proteinaDTO.setCodigoError("30");
			proteinaDTO.setMensajeError(e.getMessage());
			
			return proteinaDTO;		
			
		}
		
	}
	

	@RequestMapping(value="/crearProteina",method=RequestMethod.POST)
	public ResultadoRest crearProteina(@RequestBody ProteinaDTO proteinaDTO) {
		
		log.info("Ingreso a crear proteina");
	
			try {
				
				Proteina proteina = new Proteina();
				
				proteina.setId(proteinaDTO.getId());
				proteina.setNombre(proteinaDTO.getNombre());
				proteina.setDescripcion(proteinaDTO.getDescripcion());
				proteina.setFechaCreacion(proteinaDTO.getFechaCreacion());
				proteina.setUsuarioCreacion(proteinaDTO.getUsuarioCreacion());
			
		
				delegadoDeNegocio.crearProteina(proteina);
				
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
	
	@RequestMapping(value="/modificarProteina",method=RequestMethod.PUT)
	public ResultadoRest modificarProteina(@RequestBody ProteinaDTO proteinaDTO) {
		
		log.info("Ingreso a modificar proteina");
		
		try {
			Proteina proteina = delegadoDeNegocio.consultarPorIdProteina(proteinaDTO.getId());
			if(proteina == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("La proteina con numero:" + proteinaDTO.getId() + " no existe");
				
				return resultadoRest;
			}
			
			proteina.setNombre(proteinaDTO.getNombre());
			proteina.setDescripcion(proteinaDTO.getDescripcion());
			proteina.setFechaModifica(proteinaDTO.getFechaModifica());
			proteina.setUsuarioModifica(proteinaDTO.getUsuarioModifica());
			
			delegadoDeNegocio.modificarProteina(proteina);
			
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
	
	@RequestMapping(value="/borrarProteina",method=RequestMethod.DELETE)
	public ResultadoRest borrarProteina(@RequestBody ProteinaDTO proteinaDTO) {
		
		log.info("Ingreso a borrar proteina");
		
		try {
			
			Proteina proteina = delegadoDeNegocio.consultarPorIdProteina(proteinaDTO.getId());
			if(proteina == null) {
				
				ResultadoRest resultadoRest = new ResultadoRest();
				resultadoRest.setCodigoError("10");
				resultadoRest.setMensajeError("La proteina con numero:"+proteinaDTO.getId()+" no existe");
				
				return resultadoRest;
			}
			
			delegadoDeNegocio.borrarProteina(proteina);
			
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
