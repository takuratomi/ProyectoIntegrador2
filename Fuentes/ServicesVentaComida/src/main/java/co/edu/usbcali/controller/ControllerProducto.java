package co.edu.usbcali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.dto.ProductoDTO;
import co.edu.usbcali.logica.IProductoLogica;

@RestController
@RequestMapping("/ProductoRest")
public class ControllerProducto {

	@Autowired
	private IProductoLogica productoLogica;
	
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public ProductoDTO crearProductoRest(@RequestBody ProductoDTO productoDTO)throws Exception{
		
		return productoLogica.crearProducto(productoDTO);		
	}	
	
	@RequestMapping(value="/consultarTodos",method=RequestMethod.GET)
	public List<ProductoDTO> consultarClientePorId()throws Exception{
		
		List<ProductoDTO> losProductosDTO = null;		
		losProductosDTO = productoLogica.consultarTodosProducto();		
		
		return losProductosDTO;
	}
	
	/*
	@RequestMapping(value="/modificar", method = RequestMethod.PUT)
	public void modificarCliente(@RequestBody ClienteDTO clienteDTO)throws Exception{
		
		Clientes clientes=clienteLogica.consultarPorId(clienteDTO.getCliId());
		if(clientes==null){
			throw new Exception("El cliente no existe");
		}
		clientes.setCliDireccion(clienteDTO.getCliDireccion());
		clientes.setCliId(clienteDTO.getCliId());
		clientes.setCliMail(clienteDTO.getCliMail());
		clientes.setCliNombre(clienteDTO.getCliNombre());
		clientes.setCliTelefono(clienteDTO.getCliTelefono());
		
		TiposDocumentos tiposDocumentos=tipoDocumentoLogica.consultarPorId(clienteDTO.getTdocCodigo());
		clientes.setTiposDocumentos(tiposDocumentos);
		
		clienteLogica.modificar(clientes);
		
	}
	
	@RequestMapping(value="/borrar/{id}", method = RequestMethod.DELETE)
	public void borrarCliente(@PathVariable("id")Long id)throws Exception{
		
		Clientes clientes=clienteLogica.consultarPorId(id);
		if(clientes==null){
			throw new Exception("El cliente no existe");
		}
		
		clienteLogica.borrar(clientes);
		
	} 
	*/
}
