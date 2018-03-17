package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IBebidaDAO;
import co.edu.usbcali.dao.IProteinaDAO;
import co.edu.usbcali.modelo.Bebida;
import co.edu.usbcali.modelo.Proteina;


@Service
@Scope("singleton")
	
public class ProteinaLogica implements IProteinaLogica {
		
		@Autowired
		private IProteinaDAO proteinasDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Proteina entity) throws Exception {
			if(entity==null){
				throw new Exception("La proteina no puede ser nula");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id de la proteina no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre de la proteina no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null || entity.getDescripcion().trim().equals("")==true) {
				throw new Exception("La descripcion de la proteina no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("La proteina debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("La proteina debe tener una fecha de creacion");
			}
			
				
			
			proteinasDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Proteina entity) throws Exception {
			
			if(entity==null){
				throw new Exception("La proteina no puede ser nula");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id de la proteina no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre de la proteina no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null || entity.getDescripcion().trim().equals("")==true) {
				throw new Exception("La descripcion de la proteina no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("La proteina debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("La proteina debe tener una fecha de creacion");
			}
			
			
			proteinasDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Proteina entity) throws Exception {
			if(entity==null){
				throw new Exception("La proteina no puede ser nula");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id de la proteina no puede ser 0");
			}
			
			Proteina proteinas=proteinasDAO.consultarPorId(entity.getId());
			if(proteinas==null) {
				throw new Exception("la proteina con id: " + entity.getId() + " no existe");
			}
			
			proteinasDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Proteina consultarPorId(int proteinaId) {
			return proteinasDAO.consultarPorId(proteinaId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Proteina> consultarTodos() {
			return proteinasDAO.consultarTodos();
		}

	
}
