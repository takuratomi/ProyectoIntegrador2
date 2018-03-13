package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Sopa;

@Repository
@Scope("singleton")
public class SopaDAO implements ISopaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Sopa entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Sopa entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Sopa entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Sopa consultarPorId(BigDecimal idSopa) {
		return (Sopa)sessionFactory.getCurrentSession().get(Sopa.class, idSopa);
	}

	@Override
	public Sopa consultarPorIdentificacion(Integer idSopa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sopa> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Sopa.class).list();
	}

}
