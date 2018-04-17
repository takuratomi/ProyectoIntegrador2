package co.edu.usbcali.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Descripción: Objeto que permite conocer el producto que se envia por el servicio
 * @author takuratomi
 *
 */

public class ProductoDTO {
	
	/**
	 * tipo producto: parametro con el que se identifica que tipo de producto es el enviado
	 * 1-> sopa
	 * 2-> principio
	 * 3-> proteina
	 * 4-> bebida
	 *
	 * estado: A-> activo I-> inactivo
	 *
	 * codigoError				mensajeError
	 * 	0						Operacion exitosa
	 *  1						Campo obligatorio no fue enviado
	 *  99						Ocurrio un error inesperado,comunicarse con el proveedor					
	 * 
	 */
	
	//atributos
	private int tipoProducto;
	private BigDecimal id;
	private String nombre;
	private String descripcion;
	private String estado;	
	private String usuario;
	private Date fecha;	
	
	private int codigoError;
	private String mensajeError;
	
	
	public ProductoDTO() {
		super();
	}

	public ProductoDTO(int tipoProducto, BigDecimal id, String nombre, String descripcion, String usuario, Date fecha,
			int codigoError, String mensajeError) {
		super();
		this.tipoProducto = tipoProducto;
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fecha = fecha;
		this.codigoError = codigoError;
		this.mensajeError = mensajeError;
	}

	public int getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(int tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}		
}
