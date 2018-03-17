package co.edu.usbcali.logica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IUsuarioDAO;
import co.edu.usbcali.modelo.Usuario;

@Service
@Scope("singleton")
	
public class UsuariosLogica implements IUsuariosLogica {
		
		@Autowired
		private IUsuarioDAO usuariosDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Usuario entity) throws Exception {
			if(entity==null){
				throw new Exception("El usuario no puede ser nulo");
			}	
			if(entity.getId()==0){
				throw new Exception("El id del usuario no puede ser 0");
			};
			if(entity.getPrimerNombre()==null || entity.getPrimerNombre().trim().equals("")==true){
				throw new Exception("El primer nombre del usuario no puede ser nulo o estar en blanco");
			}
			if(entity.getPrimerApellido()==null || entity.getPrimerApellido().trim().equals("")==true) {
				throw new Exception("El primer apellido del usuario no puede ser nulo o estar en blanco");
			}
			if(entity.getNumIdentificacion()==0){
				throw new Exception("El numero de identificaci[on no puede ser 0");
			}
			if(entity.getTipoIdentificacion()==null) {
				throw new Exception("El usuario debe tener un tipo de identificaci[on");
			}
			if(entity.getRol()==null) {
				throw new Exception("El usuario debe tener un rol");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El usuario debe tener una fecha de creación");
			}
	
			
			usuariosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Usuario entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El usuario no puede ser nulo");
			}	
			if(entity.getId()==0){
				throw new Exception("El id del usuario no puede ser 0");
			};
			if(entity.getPrimerNombre()==null || entity.getPrimerNombre().trim().equals("")==true){
				throw new Exception("El primer nombre del usuario no puede ser nulo o estar en blanco");
			}
			if(entity.getPrimerApellido()==null || entity.getPrimerApellido().trim().equals("")==true) {
				throw new Exception("El primer apellido del usuario no puede ser nulo o estar en blanco");
			}
			if(entity.getNumIdentificacion()==0){
				throw new Exception("El numero de identificaci[on no puede ser 0");
			}
			if(entity.getTipoIdentificacion()==null) {
				throw new Exception("El usuario debe tener un tipo de identificaci[on");
			}
			if(entity.getRol()==null) {
				throw new Exception("El usuario debe tener un rol");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El usuario debe tener una fecha de creación");
			}
			
			usuariosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Usuario entity) throws Exception {
			if(entity==null){
				throw new Exception("El usuario no puede ser nulo");
			}	
			if(entity.getId()==0){
				throw new Exception("El id del usuario no puede ser 0");
			};
			
			Usuario usuarios=usuariosDAO.consultarPorId(entity.getId());
			if(usuarios == null) {
				throw new Exception("El usuarios con id:" + entity.getId() + "no existe" );
			}
			
			
			usuariosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Usuario consultarPorId(int usuId) {
			return usuariosDAO.consultarPorId(usuId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Usuario> consultarTodos() {
			return usuariosDAO.consultarTodos();
		}
		
		@Override
		public Usuario consultarPorIdentificacion(Integer numIdentificacion, Integer tipoIdentificacion) {
			return usuariosDAO.consultarPorIdentificacion(numIdentificacion, tipoIdentificacion);
		}
		
		/*
		@Override
		@Transactional(readOnly=true)
		public List<ClientesDTO> findAllClientesDTO() {
				List<Clientes> losClientes= clientesDAO.findAll();
				List<ClientesDTO> losClientesDTOs = new ArrayList<>();
				
				for (Clientes clientes : losClientes) {
					ClientesDTO clientesDTO = new ClientesDTO();
					clientesDTO.setCliDireccion(clientes.getCliDireccion());
					clientesDTO.setCliId(clientes.getCliId());
					clientesDTO.setCliMail(clientes.getCliMail());
					clientesDTO.setCliNombre(clientes.getCliNombre());
					clientesDTO.setCliTelefono(clientes.getCliTelefono());
					clientesDTO.setTdocCodigo(clientes.getTiposDocumentos().getTdocCodigo());
					clientesDTO.setTdocNombre(clientes.getTiposDocumentos().getTdocNombre());
					losClientesDTOs.add(clientesDTO);
				}
				return losClientesDTOs;
			}
		*/


	
}
