package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Sopa;

public interface ISopaLogica {

	public void crear(Sopa entity) throws Exception;
	public void modificar(Sopa entity) throws Exception;
	public void borrar(Sopa entity) throws Exception;
	public Sopa consultarPorId(BigDecimal sopaId) throws Exception;
	public List<Sopa> consultarTodos() throws Exception;
	
}
