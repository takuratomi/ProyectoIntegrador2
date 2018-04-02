package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.ISopaDAO;
import co.edu.usbcali.modelo.Sopa;


@Service
@Scope("singleton")
	
public class SopaLogica implements ISopaLogica {
		
		@Autowired
		private ISopaDAO sopasDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Sopa entity) throws Exception {
			if(entity==null){
				throw new Exception("La sopa no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id de la sopa no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre de la sopa no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null) {
				throw new Exception("La descripcion de la sopa no puede ser nula");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("La sopa debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("La sopa debe tener una fecha de creacion");
			}
			
				
			
			sopasDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Sopa entity) throws Exception {
			if(entity==null){
				throw new Exception("La sopa no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id de la sopa no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre de la sopa no puede ser nulo o estar vacio");
			}
			if(entity.getDescripcion()==null) {
				throw new Exception("La descripcion de la sopa no puede ser nula");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("La sopa debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("La sopa debe tener una fecha de creacion");
			}
			
			
			sopasDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Sopa entity) throws Exception {
			if(entity==null){
				throw new Exception("La sopa no puede ser nula");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id de la sopa no puede ser 0");
			}
			
			Sopa sopas=sopasDAO.consultarPorId(entity.getId());
			if(sopas==null) {
				throw new Exception("la sopa con id: " + entity.getId() + " no existe");
			}
			
			sopasDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Sopa consultarPorId(BigDecimal sopaId) {
			return sopasDAO.consultarPorId(sopaId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Sopa> consultarTodos() {
			return sopasDAO.consultarTodos();
		}

	
}
