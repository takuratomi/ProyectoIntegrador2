package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Bebida;

public interface IBebidaLogica {

	public void crear(Bebida entity) throws Exception;
	public void modificar(Bebida entity) throws Exception;
	public void borrar(Bebida entity) throws Exception;
	public Bebida consultarPorId(BigDecimal bebidaId) throws Exception;
	public List<Bebida> consultarTodos() throws Exception;
	
}
