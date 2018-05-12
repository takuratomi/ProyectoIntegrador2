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

import co.edu.usbcali.dao.IPrincipioDAO;
import co.edu.usbcali.modelo.Principio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPrincipioDAO {

	private static final Logger log = LoggerFactory.getLogger(TestPrincipioDAO.class);

	@Autowired
	private IPrincipioDAO principioDAO;

	BigDecimal id = new BigDecimal("1");

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void atest() {		

//		Principio principio= principioDAO.consultarPorId(id);
//
//		assertNull("El principio existe", principio);
//
//		// creacion de principio
//		principio = new Principio();	
//		
//		principio.setId(id);
//		principio.setNombre("Frijoles");
//		principio.setDescripcion("Frijoles al gusto ...");
//
//		principioDAO.crear(principio);
//
//		log.info("id: "+principio.getId());
//		log.info("nombre: "+principio.getNombre());
//		log.info("descripcion: "+principio.getDescripcion());
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void ctest() {
//		Principio principio= principioDAO.consultarPorId(id);
//
//		assertNotNull("El principio existe", principio);
//
//		principio.setNombre("Pasta");
//		principio.setDescripcion("pasta napolitana...");
//		
//		principioDAO.modificar(principio);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void dtest() {
//		
//		Principio principio= principioDAO.consultarPorId(id);
//
//		assertNotNull("El principio existe", principio);		
//		
//		principioDAO.borrar(principio);
	}	
}
