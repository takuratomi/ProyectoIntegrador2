package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Padre;

@Repository
@Scope("singleton")
public class PadreDAO implements IPadreDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Padre entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Padre entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Padre entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Padre consultarPorId(Long padreId) {
		return (Padre)sessionFactory.getCurrentSession().get(Padre.class, padreId);
	}

	@Override
	public List<Padre> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Padre.class).list();
	}
	
	@Override
	public Long getConsecutivo() {
		String sqlName="PADRE_SEQ";
		Long consecutivo = null;
		List qlist = null;
	try {		
		Query query = sessionFactory.getCurrentSession().getNamedQuery(sqlName);
		qlist = query.list();
		consecutivo = (Long)qlist.get(0);		
	} catch (org.hibernate.HibernateException e) {
		consecutivo = new Long(0);		
	}
		return consecutivo;
	}

}
