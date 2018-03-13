package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Principio;

@Repository
@Scope("singleton")
public class PrincipioDAO implements IPrincipioDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Principio entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Principio entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Principio entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Principio consultarPorId(BigDecimal idPrincipio) {
		return (Principio)sessionFactory.getCurrentSession().get(Principio.class, idPrincipio);
	}

	@Override
	public Principio consultarPorIdentificacion(Integer idAlmuerzo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Principio> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Principio.class).list();
	}

}
