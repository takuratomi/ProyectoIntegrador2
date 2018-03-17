package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Pedido;

public interface IPedidoLogica {

	public void crear(Pedido entity) throws Exception;
	public void modificar(Pedido entity) throws Exception;
	public void borrar(Pedido entity) throws Exception;
	public Pedido consultarPorId(BigDecimal pedidoId);
	public List<Pedido> consultarTodos();
	
}
