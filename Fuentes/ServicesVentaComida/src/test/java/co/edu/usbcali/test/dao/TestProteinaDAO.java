package co.edu.usbcali.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

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

import co.edu.usbcali.dao.IProteinaDAO;
import co.edu.usbcali.dao.IUsuarioDAO;
import co.edu.usbcali.modelo.Proteina;
import co.edu.usbcali.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProteinaDAO {

	private static final Logger log = LoggerFactory.getLogger(TestProteinaDAO.class);

	@Autowired
	private IProteinaDAO proteinaDAO;

	BigDecimal id = new BigDecimal("1");

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void atest() {

//		Proteina proteina = new Proteina();
//
//		proteina = proteinaDAO.consultarPorId(id);
//
//		assertNull("La proteina existe", proteina);
//
//		// creacion de proteina
//		proteina = new Proteina();
//		proteina.setId(id);
//		proteina.setNombre("Carne desmechada");
//		proteina.setDescripcion("carne rica en ...");
//
//		proteinaDAO.crear(proteina);
//
//		log.info("id " + proteina.getId());
//		log.info("nombre " + proteina.getNombre());
//		log.info("descripcion " + proteina.getDescripcion());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void ctest() {
//		Proteina proteina = new Proteina();
//
//		proteina = proteinaDAO.consultarPorId(id);
//
//		assertNotNull("La proteina no existe", proteina);
//
//		proteina.setNombre("Pescado");
//		proteina.setDescripcion("");
//		proteinaDAO.modificar(proteina);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void dtest() {
		
//		Proteina proteina = new Proteina();
//		proteina = proteinaDAO.consultarPorId(id);
//		
//		assertNotNull("La proteina no existe", proteina);
//		proteinaDAO.borrar(proteina);
	}
}
