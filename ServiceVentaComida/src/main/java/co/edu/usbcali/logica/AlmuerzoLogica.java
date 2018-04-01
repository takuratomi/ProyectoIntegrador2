package co.edu.usbcali.logica;

import java.math.BigDecimal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IAlmuerzoDAO;
import co.edu.usbcali.modelo.Almuerzo;


@Service
@Scope("singleton")
	
public class AlmuerzoLogica implements IAlmuerzoLogica {
		
		@Autowired
		private IAlmuerzoDAO almuerzosDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Almuerzo entity) throws Exception {
			if(entity==null){
				throw new Exception("El almuerzo no puede ser nulo");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del almuerzo no puede ser 0");
			}
			if(entity.getHijo()==null) {
				throw new Exception("El almuerzo debe estar asignado a un hijo");
			}
			if(entity.getMenuSemana()==null) {
				throw new Exception("El almuerzo debe tener un menu");
			}
			if(entity.getPedido()==null) {
				throw new Exception("El almuerzo debe tener un pedido");
			}
			if(entity.getEstado()==null) {
				throw new Exception("El almuerzo debe tener un estado");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El almuerzo debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El almuerzo debe tener una fecha de creacion");
			}
			
			almuerzosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Almuerzo entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El almuerzo no puede ser nulo");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del almuerzo no puede ser 0");
			}
			if(entity.getHijo()==null) {
				throw new Exception("El almuerzo debe estar asignado a un hijo");
			}
			if(entity.getMenuSemana()==null) {
				throw new Exception("El almuerzo debe tener un menu");
			}
			if(entity.getPedido()==null) {
				throw new Exception("El almuerzo debe tener un pedido");
			}
			if(entity.getEstado()==null) {
				throw new Exception("El almuerzo debe tener un estado");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El almuerzo debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El almuerzo debe tener una fecha de creacion");
			}
			
			almuerzosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Almuerzo entity) throws Exception {
			if(entity==null){
				throw new Exception("El almuerzo no puede ser nulo");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del almuerzo no puede ser 0");
			}
			
			Almuerzo almuerzos=almuerzosDAO.consultarPorId(entity.getId());
			if(almuerzos == null) {
				throw new Exception("El almuerzo con id:" + entity.getId() + "no exite");
			}
		
			
			
			almuerzosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Almuerzo consultarPorId(BigDecimal almuerzoId) {
			return almuerzosDAO.consultarPorId(almuerzoId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Almuerzo> consultarTodos() {
			return almuerzosDAO.consultarTodos();
		}

	
}
