package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import co.edu.usbcali.modelo.Bebida;

public interface IBebidaDAO {

	public void crear(Bebida entity);
	public void modificar(Bebida entity);
	public void borrar(Bebida entity);
	public Bebida consultarPorId(BigDecimal idBebida);
	public Bebida consultarPorIdentificacion(Integer idBebida);
	public List<Bebida> consultarTodos();
	
	public Long getConsecutivo();
	
	
}
