package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Hijo;

@Repository
@Scope("singleton")
public class HijoDAO implements IHijoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Hijo entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Hijo entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Hijo entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Hijo consultarPorId(int hijoId) {
		return (Hijo)sessionFactory.getCurrentSession().get(Hijo.class, hijoId);
	}

	@Override
	public List<Hijo> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Hijo.class).list();
	}

}
