package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IPadreDAO;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;


@Service
@Scope("singleton")
	
public class PadreLogica implements IPadreLogica {
		
		@Autowired
		private IPadreDAO padresDAO;
		
		@Autowired
		private UsuariosLogica usuariosLogica;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Padre entity) throws Exception {
			if(entity==null){
				throw new Exception("El padre no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del padre no puede ser 0");
			}
			if(entity.getTelefono()==null || entity.getTelefono().trim().equals("")==true) {
				throw new Exception("El telefono del padre no puede ser nulo o estar vacio");
			}
			if(entity.getDireccion()==null || entity.getDireccion().trim().equals("")==true) {
				throw new Exception("La direccion del padre no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El padre debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El padre debe tener una fecha de creacion");
			}
			
			Usuario usuarios= usuariosLogica.consultarPorId(entity.getUsuario().getId());
			
			if(usuarios==null) {
				throw new Exception("El usuario con id: " + entity.getUsuario().getId() + " no existe");
			}
			
			padresDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Padre entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El padre no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del padre no puede ser 0");
			}
			if(entity.getTelefono()==null || entity.getTelefono().trim().equals("")==true) {
				throw new Exception("El telefono del padre no puede ser nulo o estar vacio");
			}
			if(entity.getDireccion()==null || entity.getDireccion().trim().equals("")==true) {
				throw new Exception("La direccion del padre no puede ser nula o estar vacia");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El padre debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El padre debe tener una fecha de creacion");
			}
			
			Usuario usuarios= usuariosLogica.consultarPorId(entity.getUsuario().getId());
			
			if(usuarios==null) {
				throw new Exception("El usuario con id: " + entity.getUsuario().getId() + " no existe");
			}
			
			padresDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Padre entity) throws Exception {
			if(entity==null){
				throw new Exception("El padre no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del padre no puede ser 0");
			}
			
			Padre padres= padresDAO.consultarPorId(entity.getId());
			
			if(padres==null) {
				throw new Exception("El padre con id: " + entity.getId() + " no existe");
			}
			
			padresDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Padre consultarPorId(Long padreId) {
			return padresDAO.consultarPorId(padreId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Padre> consultarTodos() {
			return padresDAO.consultarTodos();
		}

	
}
