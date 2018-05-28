package co.edu.usbcali.test.logica;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.Date;
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

import co.edu.usbcali.dto.ProductoDTO;
import co.edu.usbcali.logica.IProductoLogica;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProductoLogica {

	private static final Logger log = LoggerFactory.getLogger(TestProductoLogica.class);

	@Autowired
	private IProductoLogica productoLogica;

	BigDecimal id = new BigDecimal("2");

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void atest() {

//		ProductoDTO productoDTO = new ProductoDTO();
//		
//		//productoDTO.setId(id);
//		productoDTO.setNombre("Sopa de pastas");
//		productoDTO.setTipoProducto(1);
//		productoDTO.setDescripcion("Deliciosa sopa con pasta");
//		productoDTO.setUsuario("TOSHIRO");
//		productoDTO.setFecha(new Date());
//
//		try {
//			productoLogica.crearProducto(productoDTO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void ConsultaProductosDTOtest() {

		List<ProductoDTO> lstProductosDTO;

		try {
			lstProductosDTO = productoLogica.consultarTodosProducto();
			
			assertNotNull("Los productos son nulos",lstProductosDTO);
			
			for (ProductoDTO productoDTO : lstProductosDTO) {
				log.info("id "+productoDTO.getId());
				log.info("nombre "+productoDTO.getNombre());
				log.info("estado "+productoDTO.getEstado());
				log.info("tipoProducto "+productoDTO.getTipoProducto());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void ctest() {

		Bebida bebida = bebidaDAO.consultarPorId(id);

		assertNotNull("La bebida existe", bebida);
		bebida.setNombre("Jugo de naranja");
		
		bebidaDAO.modificar(bebida);
		
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Rollback(false)
	public void dtest() {

		Bebida bebida = bebidaDAO.consultarPorId(id);

		assertNotNull("La bebida no existe", bebida);	
		
		bebidaDAO.borrar(bebida);
	}	
	*/
}
