package co.edu.usbcali.dao;

import java.util.List;

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
	public Proteina consultarPorId(int usuId) {
		return (Proteina)sessionFactory.getCurrentSession().get(Proteina.class, usuId);
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

}
