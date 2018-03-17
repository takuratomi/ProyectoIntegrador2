package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IPrincipioDAO;
import co.edu.usbcali.modelo.Principio;


@Service
@Scope("singleton")
	
public class PrincipioLogica implements IPrincipioLogica {
		
		@Autowired
		private IPrincipioDAO principiosDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Principio entity) throws Exception {
			if(entity==null){
				throw new Exception("El principio no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del principio no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre del principio no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null || entity.getDescripcion().trim().equals("")==true) {
				throw new Exception("La descripcion del principio no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El principio debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El principio debe tener una fecha de creacion");
			}
			
				
			
			principiosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Principio entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El principio no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del principio no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre del principio no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null || entity.getDescripcion().trim().equals("")==true) {
				throw new Exception("La descripcion del principio no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El principio debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El principio debe tener una fecha de creacion");
			}
			
			
			principiosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Principio entity) throws Exception {
			if(entity==null){
				throw new Exception("El principio no puede ser nula");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del principio no puede ser 0");
			}
			
			Principio principios=principiosDAO.consultarPorId(entity.getId());
			if(principios==null) {
				throw new Exception("El principio con id: " + entity.getId() + " no existe");
			}
			
			principiosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Principio consultarPorId(int principioId) {
			return principiosDAO.consultarPorId(principioId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Principio> consultarTodos() {
			return principiosDAO.consultarTodos();
		}

	
}
