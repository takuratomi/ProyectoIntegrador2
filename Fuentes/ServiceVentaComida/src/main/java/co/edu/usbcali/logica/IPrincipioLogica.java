package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Principio;

public interface IPrincipioLogica {

	public void crear(Principio entity) throws Exception;
	public void modificar(Principio entity) throws Exception;
	public void borrar(Principio entity) throws Exception;
	public Principio consultarPorId(BigDecimal principioId) throws Exception;
	public List<Principio> consultarTodos() throws Exception;
	
}
