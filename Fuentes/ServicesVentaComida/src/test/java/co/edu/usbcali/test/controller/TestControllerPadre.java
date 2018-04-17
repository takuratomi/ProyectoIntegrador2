package co.edu.usbcali.test.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import co.edu.usbcali.dto.PadreDTO;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

public class TestControllerPadre {

	private final static Logger log = LoggerFactory.getLogger(TestControllerPadre.class);

	public static void main(String[] args) {
		
		String url = "http://localhost:8080/ServicesVentaComida/controller/PadreRest/crear";
		
		PadreDTO padreDTO = new PadreDTO();		
		//productoDTO.setId(id);
		padreDTO.setPrimerNombre("Alejandro");
		padreDTO.setSegundoNombre("Juan");
		padreDTO.setPrimerApellido("Rodriguez");
		padreDTO.setSegundoApellido("Collazos");
		padreDTO.setNumIdentificacion(2311234L);
		padreDTO.setTipoIdentificacion(3);
		padreDTO.setPassword("123");
		padreDTO.setRol(2);
		padreDTO.setUsuario("TAKURATOMI");
		padreDTO.setFecha(new Date());
		padreDTO.setTelefono("2751675");
		padreDTO.setDireccion("carrea 69 # 10b- 101 apt 101");
		
		RestTemplate restTemplate = new RestTemplate();		
		Object response =  restTemplate.postForEntity(url, padreDTO, PadreDTO.class);		
		log.info("Creacion satisfactoria ");
		
	}

}
