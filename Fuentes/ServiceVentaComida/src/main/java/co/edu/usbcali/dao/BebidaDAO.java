package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Bebida;

@Repository
@Scope("singleton")
public class BebidaDAO implements IBebidaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Bebida entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Bebida entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Bebida entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Bebida consultarPorId(BigDecimal idBebida) {
		return (Bebida)sessionFactory.getCurrentSession().get(Bebida.class, idBebida);
	}

	@Override
	public Bebida consultarPorIdentificacion(Integer idBebida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bebida> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Bebida.class).list();
	}

}
