package co.edu.usbcali.test.logica;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.logica.IPadreLogica;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPadreLogica {

	private static final Logger log = LoggerFactory.getLogger(TestProductoLogica.class);

	@Autowired
	private IPadreLogica padreLogica;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void atest() {

//		Usuario usuario = new Usuario();
//		usuario.setPrimerNombre("Juan");
//		usuario.setPrimerApellido("Dorado");
//		usuario.setSegundoApellido("Segundo");
//		usuario.setNumIdentificacion(1012345L);
//		usuario.setTipoIdentificacion(3);
//		usuario.setRol(2);
//
//		Padre padre = new Padre(0, usuario, "2751675", "parcelacion bonsques de belen", null, null, null, null, null,
//				null);
//
//		try {
//			padreLogica.crearPadre(padre);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void btest() {

		Long numIdentificacion = 2311234L;

		try {
			Usuario usuario = padreLogica.consultarUsuarioPorIdentificacion(numIdentificacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Rollback(false)
	public void consultarTodosPadreTest() {

		log.info("---------------------------------");
		log.info("------- FUNCIONA LOG  ----------");
		try
		{
			List<Padre> listPadre = padreLogica.consultarPadreTodos();
			
			for (Padre padre : listPadre) {
				
				log.info(padre.getUsuario().getPrimerApellido());
				log.info(padre.getUsuario().getPrimerNombre());
				log.info(""+padre.getUsuario().getTipoIdentificacion());
				log.info(""+padre.getUsuario().getNumIdentificacion());
				log.info(""+padre.getUsuario().getRol());
				log.info("---------------------------------");	
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	}
	
}
