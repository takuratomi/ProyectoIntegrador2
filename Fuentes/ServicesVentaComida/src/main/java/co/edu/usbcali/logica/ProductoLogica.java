package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IBebidaDAO;
import co.edu.usbcali.dao.IPrincipioDAO;
import co.edu.usbcali.dao.IProteinaDAO;
import co.edu.usbcali.dao.ISopaDAO;
import co.edu.usbcali.dao.ProteinaDAO;
import co.edu.usbcali.dto.ProductoDTO;
import co.edu.usbcali.modelo.Bebida;
import co.edu.usbcali.modelo.Principio;
import co.edu.usbcali.modelo.Proteina;
import co.edu.usbcali.modelo.Sopa;

@Service
@Scope("singleton")
public class ProductoLogica implements IProductoLogica {

	private static final Logger log = LoggerFactory.getLogger(ProductoLogica.class);

	@Autowired
	private ISopaDAO sopaDAO;

	@Autowired
	private IPrincipioDAO principioDAO;

	@Autowired
	private IProteinaDAO proteinaDAO;

	@Autowired
	private IBebidaDAO bebidaDAO;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ProductoDTO crearProducto(ProductoDTO producto) throws Exception {

		// productos
		Sopa sopa;
		Principio principio;
		Proteina proteina;
		Bebida bebida;
		// flag_ false si falla en la operacion
		boolean flag_ = false;

		if (producto == null)
			throw new Exception("Producto no puede ser nulo");

		if (producto.getTipoProducto() <= 0)
			throw new Exception("El tipo de producto es obligatorio");

		if (producto.getNombre() == null || producto.getNombre().trim().equals(""))
			throw new Exception("El nombre del producto es obligatorio");

		if (producto.getDescripcion() == null || producto.getDescripcion().trim().equals(""))
			throw new Exception("La descripción del producto es obligatorio");

		switch (producto.getTipoProducto()) {
		case 1:
			sopa = new Sopa();
			sopa.setId(new BigDecimal(sopaDAO.getConsecutivo()));
			sopa.setNombre(producto.getNombre().trim());
			sopa.setEstado("A");
			sopa.setUsuarioCreacion(producto.getUsuario().trim());
			sopa.setFechaCreacion(producto.getFecha());
			sopaDAO.crear(sopa);
			flag_ = true;
			break;
		case 2:
			principio = new Principio();
			principio.setId(new BigDecimal(principioDAO.getConsecutivo()));
			principio.setNombre(producto.getNombre().trim());
			principio.setEstado("A");
			principio.setUsuarioCreacion(producto.getUsuario().trim());
			principio.setFechaCreacion(producto.getFecha());
			principioDAO.crear(principio);
			flag_ = true;
			break;
		case 3:
			proteina = new Proteina();
			proteina.setId(new BigDecimal(proteinaDAO.getConsecutivo()));
			proteina.setNombre(producto.getNombre().trim());
			proteina.setEstado("A");
			proteina.setUsuarioCreacion(producto.getUsuario().trim());
			proteina.setFechaCreacion(producto.getFecha());
			proteinaDAO.crear(proteina);
			flag_ = true;
			break;
		case 4:
			bebida = new Bebida();
			bebida.setId(new BigDecimal(bebidaDAO.getConsecutivo()));
			bebida.setNombre(producto.getNombre().trim());
			bebida.setEstado("A");
			bebida.setUsuarioCreacion(producto.getUsuario().trim());
			bebida.setFechaCreacion(producto.getFecha());
			bebidaDAO.crear(bebida);
			flag_ = true;
			break;
		}

		if (flag_) {
			producto.setCodigoError(0);
			producto.setMensajeError("Operacion exitosa");
		} else {
			producto.setCodigoError(99);
			producto.setMensajeError("Ocurrio un error inesperado,comunicarse con el proveedor");
		}
		return producto;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ProductoDTO modificarProducto(ProductoDTO producto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public ProductoDTO consultarProductoPorID(BigDecimal id, int tipoProducto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<ProductoDTO> consultarTodosProducto() throws Exception {
		List<ProductoDTO> losProductosDTO = new ArrayList<ProductoDTO>();

		// OBTENER BEBIDAS
		List<Bebida> lasBebidas = bebidaDAO.consultarTodos();
		// OBTENER SOPAS
		List<Sopa> lasSopas = sopaDAO.consultarTodos();
		// OBTENER PRINCIPIOS
		List<Principio> losPrincipios = principioDAO.consultarTodos();
		// OBTENER PROTEINAS
		List<Proteina> lasProteinas = proteinaDAO.consultarTodos();

		// CREACION DEL PRODUCTODTO PARA SOPAS
		if (lasSopas != null || lasSopas.size() > 0) {
			for (Sopa sopa : lasSopas) {
				ProductoDTO productoDTO = new ProductoDTO();
				productoDTO.setId(sopa.getId());
				productoDTO.setNombre(sopa.getNombre());
				productoDTO.setDescripcion(sopa.getDescripcion());
				productoDTO.setEstado(sopa.getEstado());
				productoDTO.setTipoProducto(1);
				losProductosDTO.add(productoDTO);
			}
		}

		// CREACION DEL PRODUCTODTO PARA PRINCIPIOS
		if (losPrincipios != null || losPrincipios.size() > 0) {
			for (Principio principio : losPrincipios) {
				ProductoDTO productoDTO = new ProductoDTO();
				productoDTO.setId(principio.getId());
				productoDTO.setNombre(principio.getNombre());
				productoDTO.setDescripcion(principio.getDescripcion());
				productoDTO.setEstado(principio.getEstado());
				productoDTO.setTipoProducto(2);
				losProductosDTO.add(productoDTO);
			}
		}

		// CREACION DEL PRODUCTODTO PARA PROTEINAS
		if (lasProteinas != null || lasProteinas.size() > 0) {
			for (Proteina proteina : lasProteinas) {
				ProductoDTO productoDTO = new ProductoDTO();
				productoDTO.setId(proteina.getId());
				productoDTO.setNombre(proteina.getNombre());
				productoDTO.setDescripcion(proteina.getDescripcion());
				productoDTO.setEstado(proteina.getEstado());
				productoDTO.setTipoProducto(3);
				losProductosDTO.add(productoDTO);
			}
		}

		// CREACION DEL PRODUCTODTO PARA BEBIDAS
		if (lasBebidas != null || lasBebidas.size() > 0) {
			for (Bebida bebida : lasBebidas) {
				ProductoDTO productoDTO = new ProductoDTO();
				productoDTO.setId(bebida.getId());
				productoDTO.setNombre(bebida.getNombre());
				productoDTO.setDescripcion(bebida.getDescripcion());
				productoDTO.setEstado(bebida.getEstado());
				productoDTO.setTipoProducto(4);
				losProductosDTO.add(productoDTO);
			}
		}

		if (losProductosDTO == null || losProductosDTO.size() == 0) {
			losProductosDTO = null;
		}

		return losProductosDTO;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public ProductoDTO updateStatusProducto(ProductoDTO[] productoDTOs) throws Exception {

		ProductoDTO productodto = new ProductoDTO();
		productodto.setId(new BigDecimal(0L));
		productodto.setMensajeError("Operación Exitosa");
		productodto.setCodigoError(0);

		// productos
		Sopa sopa;
		Principio principio;
		Proteina proteina;
		Bebida bebida;

		for (ProductoDTO productoDTO2 : productoDTOs) {

			try {

				switch (productoDTO2.getTipoProducto()) {
				case 1:
					sopa = sopaDAO.consultarPorId(productoDTO2.getId());
					sopa.setEstado(productoDTO2.getEstado());
					sopaDAO.modificar(sopa);
					break;
				case 2:
					principio = principioDAO.consultarPorId(productoDTO2.getId());
					principio.setEstado(productoDTO2.getEstado());					
					principioDAO.modificar(principio);					
					break;
				case 3:
					proteina = proteinaDAO.consultarPorId(productoDTO2.getId());
					proteina.setEstado(productoDTO2.getEstado());					
					proteinaDAO.modificar(proteina);					
					break;					
				case 4:
					bebida = bebidaDAO.consultarPorId(productodto.getId());
					bebida.setEstado(productoDTO2.getEstado());					
					bebidaDAO.modificar(bebida);					
					break;
				}
			} catch (Exception eupdateProduto) {
				log.info("Error en logica updateStatusProducto: " + eupdateProduto.getMessage());
				productodto.setCodigoError(92);
				productodto.setMensajeError(eupdateProduto.getMessage());
			}
		}
		
		return productodto;
	}

}
