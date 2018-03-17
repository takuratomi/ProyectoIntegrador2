package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Almuerzo;

public interface IAlmuerzoLogica {

	public void crear(Almuerzo entity) throws Exception;
	public void modificar(Almuerzo entity) throws Exception;
	public void borrar(Almuerzo entity) throws Exception;
	public Almuerzo consultarPorId(BigDecimal almuerzoId);
	public List<Almuerzo> consultarTodos();
	
}
