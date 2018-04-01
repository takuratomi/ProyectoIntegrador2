package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IPedidoDAO;
import co.edu.usbcali.modelo.Pedido;


@Service
@Scope("singleton")
	
public class PedidoLogica implements IPedidoLogica {
		
		@Autowired
		private IPedidoDAO pedidosDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Pedido entity) throws Exception {
			if(entity==null){
				throw new Exception("La bebida no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del pedido no puede ser 0");
			}
			if(entity.getPadre()==null) {
				throw new Exception("El pedido debe tener un padre");
			}
			if(entity.getPago()==null) {
				throw new Exception("El pedido debe tener un pago");
			}
			if(entity.getIdAlmuerzo()==0 || entity.getIdAlmuerzo()==null) {
				throw new Exception("Los almuerzos del pedido no pueden ser 0 o estar nulos");
			}
			if(entity.getFechaPedido()==null) {
				throw new Exception("La fecha de pedido no puede ser nula");
			}
			if(entity.getFechaEntrega()==null) {
				throw new Exception("La fecha de entrega no puede ser nula");
			}
			if(entity.getEstado()==null) {
				throw new Exception("El estado del pedido no puede ser nulo");
			}
			if(entity.getCantAlmuerzos()==0 || entity.getCantAlmuerzos()==null) {
				throw new Exception("La cantidad de almuerzos del pedido no puede ser 0 o estar nula");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El pedido debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El pedido debe tener una fecha de creacion");
			}
			
			pedidosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Pedido entity) throws Exception {
			
			if(entity==null){
				throw new Exception("La bebida no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del pedido no puede ser 0");
			}
			if(entity.getPadre()==null) {
				throw new Exception("El pedido debe tener un padre");
			}
			if(entity.getPago()==null) {
				throw new Exception("El pedido debe tener un pago");
			}
			if(entity.getIdAlmuerzo()==0 || entity.getIdAlmuerzo()==null) {
				throw new Exception("Los almuerzos del pedido no pueden ser 0 o estar nulos");
			}
			if(entity.getFechaPedido()==null) {
				throw new Exception("La fecha de pedido no puede ser nula");
			}
			if(entity.getFechaEntrega()==null) {
				throw new Exception("La fecha de entrega no puede ser nula");
			}
			if(entity.getEstado()==null) {
				throw new Exception("El estado del pedido no puede ser nulo");
			}
			if(entity.getCantAlmuerzos()==0 || entity.getCantAlmuerzos()==null) {
				throw new Exception("La cantidad de almuerzos del pedido no puede ser 0 o estar nula");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El pedido debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El pedido debe tener una fecha de creacion");
			}
			
			pedidosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Pedido entity) throws Exception {
			if(entity==null){
				throw new Exception("La bebida no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del pedido no puede ser 0");
			}
			
			Pedido pedidos=pedidosDAO.consultarPorId(entity.getId());
			if(pedidos==null) {
				throw new Exception("El pedido con id " + entity.getId() + " no existe");
			}
			
			pedidosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Pedido consultarPorId(BigDecimal pedidoId) {
			return pedidosDAO.consultarPorId(pedidoId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Pedido> consultarTodos() {
			return pedidosDAO.consultarTodos();
		}

	
}
