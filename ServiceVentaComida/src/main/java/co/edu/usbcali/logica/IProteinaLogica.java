package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Proteina;

public interface IProteinaLogica {

	public void crear(Proteina entity) throws Exception;
	public void modificar(Proteina entity) throws Exception;
	public void borrar(Proteina entity) throws Exception;
	public Proteina consultarPorId(BigDecimal proteinaId) throws Exception;
	public List<Proteina> consultarTodos() throws Exception;
	
}
