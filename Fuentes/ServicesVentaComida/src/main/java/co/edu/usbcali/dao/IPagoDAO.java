package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Pago;

public interface IPagoDAO {

	public void crear(Pago entity);
	public void modificar(Pago entity);
	public void borrar(Pago entity);
	public Pago consultarPorId(BigDecimal idPago);
	public Pago consultarPorIdentificacion(Integer idPago);
	public List<Pago> consultarTodos();
	
	
}
