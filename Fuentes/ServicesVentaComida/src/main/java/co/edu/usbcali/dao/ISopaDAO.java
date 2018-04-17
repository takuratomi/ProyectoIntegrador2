package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Sopa;

public interface ISopaDAO {

	public void crear(Sopa entity);
	public void modificar(Sopa entity);
	public void borrar(Sopa entity);
	public Sopa consultarPorId(BigDecimal idSopa);
	public Sopa consultarPorIdentificacion(Integer idSopa);
	public List<Sopa> consultarTodos();
	public Long getConsecutivo();
	
	
}
