package co.edu.usbcali.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.modelo.Pedido;


@Repository
@Scope("singleton")
public class PedidoDAO implements IPedidoDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crear(Pedido entity) {
		sessionFactory.getCurrentSession().save(entity);		
	}

	@Override
	public void modificar(Pedido entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void borrar(Pedido entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Pedido consultarPorId(BigDecimal usuId) {
		return (Pedido)sessionFactory.getCurrentSession().get(Pedido.class, usuId);
	}

	@Override
	public Pedido consultarPorIdentificacion(Integer idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> consultarTodos() {
		return sessionFactory.getCurrentSession().createCriteria(Pedido.class).list();
	}

}
