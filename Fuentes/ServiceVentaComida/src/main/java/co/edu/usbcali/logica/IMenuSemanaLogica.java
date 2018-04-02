package co.edu.usbcali.logica;

import java.util.List;

import co.edu.usbcali.modelo.MenuSemana;

public interface IMenuSemanaLogica {

	public void crear(MenuSemana entity) throws Exception;
	public void modificar(MenuSemana entity) throws Exception;
	public void borrar(MenuSemana entity) throws Exception;
	public MenuSemana consultarPorId(Long menuSemanaId) throws Exception;
	public List<MenuSemana> consultarTodos() throws Exception;
	
}
