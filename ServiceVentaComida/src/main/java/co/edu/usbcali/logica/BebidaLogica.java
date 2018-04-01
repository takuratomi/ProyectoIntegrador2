package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IBebidaDAO;
import co.edu.usbcali.modelo.Bebida;


@Service
@Scope("singleton")
	
public class BebidaLogica implements IBebidaLogica {
		
		@Autowired
		private IBebidaDAO bebidasDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Bebida entity) throws Exception {
			if(entity==null){
				throw new Exception("La bebida no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id de la bebida no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre de la bebida no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null || entity.getDescripcion().trim().equals("")==true) {
				throw new Exception("La descripcion de la bebida no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("La bebida debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("La bebida debe tener una fecha de creacion");
			}
			
				
			
			bebidasDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Bebida entity) throws Exception {
			
			if(entity==null){
				throw new Exception("La bebida no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id de la bebida no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre de la bebida no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null || entity.getDescripcion().trim().equals("")==true) {
				throw new Exception("La descripcion de la bebida no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("La bebida debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("La bebida debe tener una fecha de creacion");
			}
			
			
			bebidasDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Bebida entity) throws Exception {
			if(entity==null){
				throw new Exception("La bebida no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id de la bebida no puede ser 0");
			}
			
			Bebida bebidas=bebidasDAO.consultarPorId(entity.getId());
			if(bebidas==null) {
				throw new Exception("la bebida con id: " + entity.getId() + " no existe");
			}
			
			bebidasDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Bebida consultarPorId(BigDecimal bebidaId) {
			return bebidasDAO.consultarPorId(bebidaId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Bebida> consultarTodos() {
			return bebidasDAO.consultarTodos();
		}

	
}
