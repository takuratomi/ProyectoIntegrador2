package co.edu.usbcali.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.PadreDTO;

@RestController
@RequestMapping("/UsuarioRest")
public class UsuarioController {
	
		
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public PadreDTO consultarUsuarioRest(@RequestBody PadreDTO padreDTO)throws Exception{
					
		return null;
			
	}

}
