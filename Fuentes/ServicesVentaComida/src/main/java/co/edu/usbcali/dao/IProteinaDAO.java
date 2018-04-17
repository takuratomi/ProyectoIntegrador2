package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Proteina;

public interface IProteinaDAO {

	public void crear(Proteina entity);
	public void modificar(Proteina entity);
	public void borrar(Proteina entity);
	public Proteina consultarPorId(BigDecimal idProteina);
	public Proteina consultarPorIdentificacion(Integer idProteina);
	public List<Proteina> consultarTodos();
	public Long getConsecutivo();
	
}
