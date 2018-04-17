package co.edu.usbcali.controller;

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
	
	/*
	@RequestMapping(value="/consultarPorId/{id}",method=RequestMethod.GET)
	public ClienteDTO consultarClientePorId(@PathVariable("id")Long id)throws Exception{
		Clientes clientes=clienteLogica.consultarPorId(id);
		if(clientes==null){
			return null;
		}
		
		ClienteDTO clienteDTO=new ClienteDTO();
		clienteDTO.setCliDireccion(clientes.getCliDireccion());
		clienteDTO.setCliId(clientes.getCliId());
		clienteDTO.setCliMail(clientes.getCliMail());
		clienteDTO.setCliNombre(clientes.getCliNombre());
		clienteDTO.setCliTelefono(clientes.getCliTelefono());
		clienteDTO.setTdocCodigo(clientes.getTiposDocumentos().getTdocCodigo());
		
		return clienteDTO;
	}
	*/
	@RequestMapping(value="/crear", method = RequestMethod.POST)
	public ProductoDTO crearProductoRest(@RequestBody ProductoDTO productoDTO)throws Exception{
		
		return productoLogica.crearProducto(productoDTO);		
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
