package co.edu.usbcali.test.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class TestTemplateRestClient {

	private final static Logger log = LoggerFactory.getLogger(TestTemplateRestClient.class);

	/* 
	 * esta url se cambia por la que se debe llamar al servicio rest
	 */
	final String  url = "http://localhost:8080/demoBancoWeb/controller/operacionesMatematicas/sumar/2/2";
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		/* Linea para realizar el llamado al servicio rest. 
		 * Se debe modificar la clase de salida.
		Resultado resultado= restTemplate.getForObject(url,Resultado.class); 
		*/
		log.info("Resultado: ");

	}

}
