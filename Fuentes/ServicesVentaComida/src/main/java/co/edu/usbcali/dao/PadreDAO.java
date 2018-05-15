package co.edu.usbcali.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

@Repository
@Scope("singleton")
public class PadreDAO implements IPadreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UsuarioDAO usuarioDAO;

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
		Padre padre = null;
		padre = (Padre) sessionFactory.getCurrentSession().get(Padre.class, padreId);
		return padre;
	}

	@Override
	public List<Padre> consultarTodos() {
		
		String hql = "SELECT p FROM Padre p, Usuario u INNER JOIN FETCH p.usuario WHERE p.usuario.id = u.id AND u.rol=2";
		
		List<Padre> listPadre = sessionFactory.getCurrentSession().createQuery(hql).list();
		
		return listPadre;
	}

	@Override
	public Long getConsecutivo() {
		String sqlName = "PADRE_SEQ";
		Long consecutivo = null;
		List qlist = null;
		try {
			Query query = sessionFactory.getCurrentSession().getNamedQuery(sqlName);
			qlist = query.list();
			consecutivo = (Long) qlist.get(0);
		} catch (org.hibernate.HibernateException e) {
			consecutivo = new Long(0);
		}
		return consecutivo;
	}

	@Override
	public Padre consultarPorIdUsuario(long numIdentificacion_) {

		Padre padre = null;
		String hql = "SELECT p from Usuario u, Padre p where p.usuario.id = u.id and u.numIdentificacion=:numIdentificacion_";
		
		padre = (Padre) sessionFactory.getCurrentSession().createQuery(hql).setLong("numIdentificacion_", numIdentificacion_)
				.uniqueResult();		
		return padre;
	}

}
