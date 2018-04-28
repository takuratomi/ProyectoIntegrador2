package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
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
		List<Bebida> lst = sessionFactory.getCurrentSession().createCriteria(Bebida.class).list();
		return lst;
	}
	
	@Override
	public Long getConsecutivo() {
		String sqlName="BEBIDA_SEQ";
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
