package co.edu.usbcali.logica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IMenuSemanaDAO;
import co.edu.usbcali.modelo.MenuSemana;


@Service
@Scope("singleton")
	
public class MenuSemanaLogica implements IMenuSemanaLogica {
		
		@Autowired
		private IMenuSemanaDAO menuSemanaDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(MenuSemana entity) throws Exception {
			if(entity==null){
				throw new Exception("El Menu Semana no puede ser nulo");
			}	
			if(entity.getId() == 0) {
				throw new Exception("El id del Menu Semana no puede ser 0");
			}
			
			if(entity.getDia()==null || entity.getDia().trim().equals("")==true) {
				throw new Exception("El Menu Semana debe tener un dia");
			}
			if(entity.getAlmuerzos()==null) {
				throw new Exception("El Menu semana debe tener almuerzo");
			}
			
			if(entity.getIdBebida()==null) {
				throw new Exception("El Menu semana debe tener bebida");
			}
			
			if(entity.getPrincipio()==null) {
				throw new Exception("El Menu semana debe tener principio");
			}
			
			if(entity.getProteina()==null) {
				throw new Exception("El Menu semana debe tener proteina");
			}
			
			if(entity.getSopa()==null) {
				throw new Exception("El Menu semana debe tener sopa");
			}
			
			if(entity.getEstado()==null) {
				throw new Exception("El estado del Menu Semana no puede ser nulo");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El Menu Semana debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El Menu Semana debe tener una fecha de creacion");
			}
				
			menuSemanaDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(MenuSemana entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El pago no puede ser nulo");
			}	
			if(entity.getId()== 0) {
				throw new Exception("El id del pago no puede ser 0");
			}
			if(entity.getDia()==null || entity.getDia().trim().equals("")==true) {
				throw new Exception("El Menu Semana debe tener un dia");
			}
			if(entity.getAlmuerzos()==null) {
				throw new Exception("El Menu semana debe tener almuerzo");
			}
			
			if(entity.getIdBebida()==null) {
				throw new Exception("El Menu semana debe tener bebida");
			}
			
			if(entity.getPrincipio()==null) {
				throw new Exception("El Menu semana debe tener principio");
			}
			
			if(entity.getProteina()==null) {
				throw new Exception("El Menu semana debe tener proteina");
			}
			
			if(entity.getSopa()==null) {
				throw new Exception("El Menu semana debe tener sopa");
			}
			
			if(entity.getEstado()==null) {
				throw new Exception("El estado del Menu Semana no puede ser nulo");
			}
			if(entity.getUsuarioModifica()==null) {
				throw new Exception("El Menu Semana debe tener un usuario de creacion");
			}
			if(entity.getFechaModifica()==null) {
				throw new Exception("El Menu Semana debe tener una fecha de creacion");
			}
			
			
			menuSemanaDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(MenuSemana entity) throws Exception {
			if(entity==null){
				throw new Exception("El Menu Semana no puede ser nulo");
			}	
			if(entity.getId()==0) {
				throw new Exception("El id del Menu Semana no puede ser 0");
			}
			
			MenuSemana menuSemana=menuSemanaDAO.consultarPorId(entity.getId());
			if(menuSemana==null) {
				throw new Exception("El Menu Semana con id " + entity.getId() + " no existe");
			}
			
			menuSemanaDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public MenuSemana consultarPorId(Long menuSemanaId) {
			return menuSemanaDAO.consultarPorId(menuSemanaId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<MenuSemana> consultarTodos() {
			return menuSemanaDAO.consultarTodos();
		}

	
}
