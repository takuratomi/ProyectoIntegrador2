package co.edu.usbcali.logica;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dao.IPagoDAO;
import co.edu.usbcali.modelo.Pago;


@Service
@Scope("singleton")
	
public class PagoLogica implements IPagoLogica {
		
		@Autowired
		private IPagoDAO pagosDAO;
		

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void crear(Pago entity) throws Exception {
			if(entity==null){
				throw new Exception("El pago no puede ser nulo");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del pago no puede ser 0");
			}
			if(entity.getDetalle()==null || entity.getDetalle().trim().equals("")==true) {
				throw new Exception("El pago debe tener un detalle");
			}
			if(entity.getValor()==0 || entity.getValor() == null) {
				throw new Exception("El pago no puede ser 0 o estar vacio");
			}
			if(entity.getEstado()==null) {
				throw new Exception("El estado del pago no puede ser nulo");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El pago debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El pago debe tener una fecha de creacion");
			}
				
			pagosDAO.crear(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void modificar(Pago entity) throws Exception {
			
			if(entity==null){
				throw new Exception("El pago no puede ser nulo");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del pago no puede ser 0");
			}
			if(entity.getDetalle()==null || entity.getDetalle().trim().equals("")==true) {
				throw new Exception("El pago debe tener un detalle");
			}
			if(entity.getValor()==0 || entity.getValor() == null) {
				throw new Exception("El pago no puede ser 0 o estar vacio");
			}
			if(entity.getEstado()==null) {
				throw new Exception("El estado del pago no puede ser nulo");
			}
			if(entity.getUsuarioCreacion()==null) {
				throw new Exception("El pago debe tener un usuario de creacion");
			}
			if(entity.getFechaCreacion()==null) {
				throw new Exception("El pago debe tener una fecha de creacion");
			}
			
			
			pagosDAO.modificar(entity);
			
		}

		@Override
		@Transactional(readOnly=false,propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		public void borrar(Pago entity) throws Exception {
			if(entity==null){
				throw new Exception("El pago no puede ser nulo");
			}	
			if(entity.getId()==BigDecimal.ZERO) {
				throw new Exception("El id del pago no puede ser 0");
			}
			
			Pago pagos=pagosDAO.consultarPorId(entity.getId());
			if(pagos==null) {
				throw new Exception("El pago con id " + entity.getId() + " no existe");
			}
			
			pagosDAO.borrar(entity);
			
		}

		@Override
		@Transactional(readOnly=true)
		public Pago consultarPorId(BigDecimal pagoId) {
			return pagosDAO.consultarPorId(pagoId);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Pago> consultarTodos() {
			return pagosDAO.consultarTodos();
		}

	
}
