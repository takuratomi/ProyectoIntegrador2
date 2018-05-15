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
import co.edu.usbcali.dao.ISopaDAO;
import co.edu.usbcali.dao.IUsuarioDAO;
import co.edu.usbcali.modelo.Proteina;
import co.edu.usbcali.modelo.Sopa;
import co.edu.usbcali.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSopaDAO {

	private static final Logger log = LoggerFactory.getLogger(TestSopaDAO.class);

	@Autowired
	private ISopaDAO sopaDAO;

	BigDecimal id = new BigDecimal("1");

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void atest() {

//		Sopa sopa = sopaDAO.consultarPorId(id);
//
//		assertNull("La sopa existe", sopa);
//
//		// creacion de sopa
//		sopa = new Sopa();
//		sopa.setId(id);
//		sopa.setNombre("Crema");
//		// sopa.setDescripcion("rica crema");
//
//		sopaDAO.crear(sopa);
//
//		log.info("id " + sopa.getId());
//		log.info("nombre " + sopa.getNombre());
//		log.info("descripcion " + sopa.getDescripcion());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void ctest() {

//		Sopa sopa = sopaDAO.consultarPorId(id);
//
//		assertNotNull("La sopa existe", sopa);
//
//		sopa.setNombre("Pescado");
//		
//		sopaDAO.modificar(sopa);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void dtest() {

//		Sopa sopa = sopaDAO.consultarPorId(id);
//
//		assertNotNull("La sopa no existe", sopa);	
//		
//		sopaDAO.borrar(sopa);
	}
}
