package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Usuario;

@Repository
@Scope("singleton")
public class UsuarioDAO implements IUsuarioDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Usuario entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Usuario entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Usuario entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Usuario consultarPorId(long usuId) {
		return (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, usuId);
	}

	@Override
	public Usuario consultarPorIdentificacion(Long numIdentificacion) {
		
		String hql ="SELECT u from Usuario u where u.numIdentificacion =:identificacion";		

		return (Usuario) sessionFactory.getCurrentSession().createQuery(hql).setLong("identificacion", numIdentificacion).uniqueResult();
	}

	@Override
	public List<Usuario> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
	}
	
	@Override
	public Long getConsecutivo() {
		String sqlName="USUARIO_SEQ";
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
