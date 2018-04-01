package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IParametrosDAO;
import co.edu.usbcali.modelo.Parametros;


@Service
@Scope("singleton")
	
public class ParametrosLogica implements IParametrosLogica {
		
		@Autowired
		private IParametrosDAO parametrosDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Parametros entity) throws Exception {
			if(entity==null){
				throw new Exception("El parametro no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del parametro no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre del parametro no puede ser nulo o estar vacio");
			}
			if(entity.getValor()==null || entity.getValor().trim().equals("")==true) {
				throw new Exception("El valor del parametro no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El parametro debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El parametro debe tener una fecha de creacion");
			}
			
				
			parametrosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Parametros entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El parametro no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del parametro no puede ser 0");
			}
			if(entity.getNombre()==null || entity.getNombre().trim().equals("")==true) {
				throw new Exception("El nombre del parametro no puede ser nulo o estar vacio");
			}
			if(entity.getValor()==null || entity.getValor().trim().equals("")==true) {
				throw new Exception("El valor del parametro no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El parametro debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El parametro debe tener una fecha de creacion");
			}
			
			
			parametrosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Parametros entity) throws Exception {
			if(entity==null){
				throw new Exception("El parametro no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del parametro no puede ser 0");
			}
			
			Parametros parametros= parametrosDAO.consultarPorId(entity.getId());
			if(parametros==null) {
				throw new Exception("El parametro con id " + entity.getId() + " no existe");
			}
			
			parametrosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Parametros consultarPorId(Long parametrosId) {
			return parametrosDAO.consultarPorId(parametrosId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Parametros> consultarTodos() {
			return parametrosDAO.consultarTodos();
		}

	
}
