package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Hijo;

@Repository
@Scope("singleton")
public class HijoDAO implements IHijoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crear(Hijo entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void modificar(Hijo entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Hijo entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Hijo consultarPorId(Long hijoId) {
		return (Hijo) sessionFactory.getCurrentSession().get(Hijo.class, hijoId);
	}

	@Override
	public List<Hijo> consultarTodos() {

		return sessionFactory.getCurrentSession().createCriteria(Hijo.class).list();
	}

	@Override
	public List<Hijo> consultarMisHijo(long numIdentificaicon) {

		List<Hijo> misHijos = null;
		String hql_subSelect = "SELECT h FROM Usuario u, Hijo h inner JOIN FETCH h.usuario where h.padre.id =(SELECT p.id FROM Padre p, Usuario u WHERE p.usuario.id = u.id AND u.numIdentificacion =:numIdentificaicon) AND h.usuario.id=u.id ";

		misHijos = sessionFactory.getCurrentSession().createQuery(hql_subSelect).setLong("numIdentificaicon", numIdentificaicon).list();

		return misHijos;
	}

	@Override
	public Hijo consultarPorIdUsuario(long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getConsecutivo() {
		String sqlName="HIJO_SEQ";
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
