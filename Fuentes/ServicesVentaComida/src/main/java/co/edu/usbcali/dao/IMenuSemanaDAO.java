package co.edu.usbcali.dao;

import java.util.List;

import co.edu.usbcali.modelo.MenuSemana;

public interface IMenuSemanaDAO {

	public void crear(MenuSemana entity);
	public void modificar(MenuSemana entity);
	public void borrar(MenuSemana entity);
	public MenuSemana consultarPorId(Long menuSemanaId);
	public List<MenuSemana> consultarTodos();
}
