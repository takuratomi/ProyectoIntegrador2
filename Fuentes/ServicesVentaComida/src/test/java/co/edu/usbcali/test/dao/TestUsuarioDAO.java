package co.edu.usbcali.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

import co.edu.usbcali.dao.IHijoDAO;
import co.edu.usbcali.dao.IUsuarioDAO;
import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUsuarioDAO {
	
	private static final Logger log=LoggerFactory.getLogger(TestUsuarioDAO.class);
	
	@Autowired
	private IHijoDAO hijoDAO;
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	Long id = 3L;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Rollback(false)
	public void atest() {
	
//		Usuario usuario = new Usuario();
//		
//		usuario = usuarioDAO.consultarPorId(id);
//		
//		assertNull("El usuario existe", usuario);
//		
//		// creacion del usuario
//		usuario = new Usuario();
//		usuario.setId(id);
//		usuario.setPrimerNombre("Camilo");
//		usuario.setSegundoNombre("fernando");
//		usuario.setPrimerApellido("Duarte");
//		usuario.setSegundoApellido("Duarte");
//		usuario.setTipoIdentificacion(1);
//		usuario.setNumIdentificacion(123422L);
//		usuario.setRol(2);
//		
//		usuarioDAO.crear(usuario);
//		
//		
//		log.info("id "+usuario.getId());
//		log.info("nombre1 "+usuario.getPrimerNombre());
//		log.info("nombre2 "+usuario.getSegundoNombre());
//		log.info("apellido1 "+usuario.getPrimerApellido());
//		log.info("apellido2 "+usuario.getSegundoApellido());
//		log.info("tipoIdent "+usuario.getTipoIdentificacion());
//		log.info("numIdent "+usuario.getNumIdentificacion());
//		log.info("rol "+usuario.getRol());
		
	}

	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Rollback(false)
	public void btest() {
//		Usuario usuario = new Usuario();
//		
//		usuario = usuarioDAO.consultarPorId(id);		
//		assertNull("El usuario existe", usuario);
//		
//		usuario = new Usuario();
//		usuario.setId(id);
//		usuario.setPrimerNombre("Camilo");
//		usuario.setSegundoNombre("fernando");
//		usuario.setPrimerApellido("Duarte");
//		usuario.setSegundoApellido("Duarte");
//		usuario.setTipoIdentificacion(1);
//		usuario.setNumIdentificacion(3422L);
//		usuario.setRol(2);
//		
//		usuarioDAO.crear(usuario);
		
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Rollback(false)
	public void ctest() {
//		Usuario usuario = new Usuario();
//		
//		usuario = usuarioDAO.consultarPorId(id);		
//		assertNotNull("El usuario no existe", usuario);
//		
//		
//		usuario.setSegundoApellido("Gutierrez");
//		usuario.setTipoIdentificacion(1);
//		usuario.setNumIdentificacion(22L);
//		usuario.setRol(2);
//		
//		usuarioDAO.modificar(usuario);
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Rollback(false)
	public void dtest() {
//		Usuario usuario = new Usuario();
//		
//		usuario = usuarioDAO.consultarPorId(id);		
//		assertNotNull("El usuario no existe", usuario);				
//		usuarioDAO.borrar(usuario);
	}
		
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Rollback(false)
	public void especial_test() {
	
//		Object ob = usuarioDAO.consultarPorIdentificacion(1113648236L);
	}
	
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@Rollback(false)
	public void aConsultarMisHijosTest() {
		
		List<Hijo> misHijos = null;
		
		misHijos = hijoDAO.consultarMisHijo(2311234L);
		log.info("Inicio la muestra");
		log.info("--------------------");
		for (Hijo hijo : misHijos) {
			log.info("-- "+hijo.getUsuario().getPrimerNombre()+" "+hijo.getUsuario().getSegundoApellido()+" --");
		}
		log.info("--------------------");
				
	}
}
