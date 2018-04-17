package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Almuerzo;

@Repository
@Scope("singleton")
public class AlmuerzoDAO implements IAlmuerzoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Almuerzo entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Almuerzo entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Almuerzo entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Almuerzo consultarPorId(BigDecimal usuId) {
		return (Almuerzo)sessionFactory.getCurrentSession().get(Almuerzo.class, usuId);
	}

	@Override
	public Almuerzo consultarPorIdentificacion(Integer idAlmuerzo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Almuerzo> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Almuerzo.class).list();
	}

}
