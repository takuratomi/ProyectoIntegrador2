package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Proteina;

@Repository
@Scope("singleton")
public class ProteinaDAO implements IProteinaDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Proteina entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Proteina entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Proteina entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Proteina consultarPorId(BigDecimal idProteina) {
		return (Proteina)sessionFactory.getCurrentSession().get(Proteina.class, idProteina);
	}

	@Override
	public Proteina consultarPorIdentificacion(Integer idProteina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proteina> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Proteina.class).list();
	}

	@Override
	public Long getConsecutivo() {
		String sqlName="PROTEINA_SEQ";
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
