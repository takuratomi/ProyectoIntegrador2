package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Pago;

public interface IPagoLogica {

	public void crear(Pago entity) throws Exception;
	public void modificar(Pago entity) throws Exception;
	public void borrar(Pago entity) throws Exception;
	public Pago consultarPorId(BigDecimal bebidaId);
	public List<Pago> consultarTodos();
	
}
