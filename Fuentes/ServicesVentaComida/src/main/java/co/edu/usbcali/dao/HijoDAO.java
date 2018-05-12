package co.edu.usbcali.dao;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSInput;

import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;

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

		Padre padre = null;
		List<Usuario> misHijosUsuario= null;
		List<Hijo> misHijos = null;
		String hql_subSelect = "SELECT h FROM Usuario u, Hijo h  inner JOIN FETCH h.usuario where h.padre.id =(SELECT p.id FROM Padre p, Usuario u WHERE p.usuario.id = u.id AND u.numIdentificacion =:numIdentificaicon) AND h.usuario.id=u.id ";
//		String hql_hijo = "SELECT h FROM Usuario u, Hijo h where h.usuario.id=:idUsuario  ";
		
//		try {
		
			misHijos = sessionFactory.getCurrentSession().createQuery(hql_subSelect).setLong("numIdentificaicon", numIdentificaicon).list();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.getMessage();
//		}
				
		
//		misHijos = new ArrayList<>();
//		for (Usuario usuario : misHijosUsuario) {
//			Hijo hijo = (Hijo)sessionFactory.getCurrentSession().createQuery(hql_hijo).setLong("idUsuario", usuario.getId()).uniqueResult();			
//			misHijos.add(hijo);
//		}
		
		return misHijos;
	}

	@Override
	public Hijo consultarPorIdUsuario(long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
