package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

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
		
		if(flag_)
		{
			producto.setCodigoError(0);
			producto.setMensajeError("Operacion exitosa");
		}
		else
		{
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
		// TODO Auto-generated method stub
		return null;
	}

}
