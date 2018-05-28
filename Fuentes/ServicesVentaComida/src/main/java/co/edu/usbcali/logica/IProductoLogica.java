package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.dto.ProductoDTO;

public interface IProductoLogica {
	
	public ProductoDTO crearProducto(ProductoDTO producto) throws Exception;
	public ProductoDTO modificarProducto(ProductoDTO producto) throws Exception;
	
	public ProductoDTO consultarProductoPorID(BigDecimal id, int tipoProducto) throws Exception;	
	public List<ProductoDTO> consultarTodosProducto() throws Exception;

	public ProductoDTO updateStatusProducto(ProductoDTO[] productoDTOs) throws Exception;
	
}
