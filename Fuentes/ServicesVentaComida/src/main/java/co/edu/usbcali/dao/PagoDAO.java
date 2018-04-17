package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Pago;

@Repository
@Scope("singleton")
public class PagoDAO implements IPagoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Pago entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Pago entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Pago entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Pago consultarPorId(BigDecimal usuId) {
		return (Pago)sessionFactory.getCurrentSession().get(Pago.class, usuId);
	}

	@Override
	public Pago consultarPorIdentificacion(Integer idPago) {
		
		return null;
	}

	@Override
	public List<Pago> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Pago.class).list();
	}

}
