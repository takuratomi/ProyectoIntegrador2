package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Parametros;

@Repository
@Scope("singleton")
public class ParametrosDAO implements IParametrosDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crear(Parametros entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}

	@Override
	public void modificar(Parametros entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}

	@Override
	public void borrar(Parametros entity) {
		sessionFactory.getCurrentSession().delete(entity);		
	}

	@Override
	public Parametros consultarPorId(long idParametros) {
		return (Parametros)sessionFactory.getCurrentSession().get(Parametros.class, idParametros);
	}

	@Override
	public Parametros consultarPorIdentificacion(Integer idParametros) {
		
		return null;
	}

	@Override
	public List<Parametros> consultarTodos() {
		
		return sessionFactory.getCurrentSession().createCriteria(Parametros.class).list();
	}
	
	

}
