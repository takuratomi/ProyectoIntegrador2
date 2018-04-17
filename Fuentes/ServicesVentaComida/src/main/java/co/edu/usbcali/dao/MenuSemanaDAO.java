package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.MenuSemana;

@Repository
@Scope("singleton")
public class MenuSemanaDAO implements IMenuSemanaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(MenuSemana entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(MenuSemana entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(MenuSemana entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public MenuSemana consultarPorId(Long menuSemanaId) {
		return (MenuSemana)sessionFactory.getCurrentSession().get(MenuSemana.class, menuSemanaId);
	}

	@Override
	public List<MenuSemana> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(MenuSemana.class).list();
	}

}
