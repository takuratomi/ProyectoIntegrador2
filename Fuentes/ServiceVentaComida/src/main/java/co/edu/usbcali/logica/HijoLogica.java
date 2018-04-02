package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IHijoDAO;
import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.Padre;
import co.edu.usbcali.modelo.Usuario;


@Service
@Scope("singleton")
	
public class HijoLogica implements IHijoLogica {
		
		@Autowired
		private IHijoDAO hijosDAO;
		
		@Autowired
		private PadreLogica padresLogica;
		
		@Autowired
		private UsuariosLogica usuariosLogica;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Hijo entity) throws Exception {
			if(entity==null){
				throw new Exception("El hijo no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del hijo no puede ser 0");
			}
			if(entity.getFechaNacimiento()==null) {
				throw new Exception("La fecha de nacimiento no puede ser nula");
			}
			if(entity.getCurso()==null || entity.getCurso().trim().equals("")==true) {
				throw new Exception("El curso del hijo no puede ser nulo o estar vacio");
			}
			if(entity.getUsuario().getId()==0) {
				throw new Exception("El id del usuario no puede ser 0");
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
			
			Padre padres= padresLogica.consultarPorId(entity.getPadre().getId());
			
			if(padres==null) {
				throw new Exception("El padre con id: " + entity.getPadre().getId() + " no existe");
			}
			
			hijosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Hijo entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El hijo no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del hijo no puede ser 0");
			}
			if(entity.getFechaNacimiento()==null) {
				throw new Exception("La fecha de nacimiento no puede ser nula");
			}
			if(entity.getCurso()==null || entity.getCurso().trim().equals("")==true) {
				throw new Exception("El curso del hijo no puede ser nulo o estar vacio");
			}
			if(entity.getUsuario().getId()==0) {
				throw new Exception("El id del usuario no puede ser 0");
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
			
			Padre padres= padresLogica.consultarPorId(entity.getPadre().getId());
			
			if(padres==null) {
				throw new Exception("El padre con id: " + entity.getPadre().getId() + " no existe");
			}
			
			hijosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Hijo entity) throws Exception {
			if(entity==null){
				throw new Exception("El hijo no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del hijo no puede ser 0");
			}
			
			Hijo hijos= hijosDAO.consultarPorId(entity.getId());
			
			if(hijos==null) {
				throw new Exception("El hijo con id: " + entity.getId() + " no existe");
			}
			hijosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Hijo consultarPorId(Long hijoId) {
			return hijosDAO.consultarPorId(hijoId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Hijo> consultarTodos() {
			return hijosDAO.consultarTodos();
		}

	
}
