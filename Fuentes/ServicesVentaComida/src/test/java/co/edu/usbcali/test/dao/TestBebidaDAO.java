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

import co.edu.usbcali.dao.IBebidaDAO;
import co.edu.usbcali.modelo.Bebida;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBebidaDAO {

	private static final Logger log = LoggerFactory.getLogger(TestBebidaDAO.class);

	@Autowired
	private IBebidaDAO bebidaDAO;

	BigDecimal id = new BigDecimal("1");

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void atest() {

//		Bebida bebida = bebidaDAO.consultarPorId(id);
//
//		assertNull("La bebida existe", bebida);
//
//		// creacion de bebida
//		bebida = new Bebida();
//				
//		bebida.setId(id);
//		bebida.setNombre("Jugo de mora");
//		bebida.setDescripcion("rica bebida");
//		bebida.setEstado("A");
//
//		bebidaDAO.crear(bebida);
//
//		log.info("id " + bebida.getId());
//		log.info("nombre " + bebida.getNombre());
//		log.info("descripcion " + bebida.getDescripcion());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void ctest() {

//		Bebida bebida = bebidaDAO.consultarPorId(id);
//
//		assertNotNull("La bebida existe", bebida);
//		bebida.setNombre("Jugo de naranja");
//		
//		bebidaDAO.modificar(bebida);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void dtest() {

//		Bebida bebida = bebidaDAO.consultarPorId(id);
//
//		assertNotNull("La bebida no existe", bebida);	
//		
//		bebidaDAO.borrar(bebida);
	}
	
}
