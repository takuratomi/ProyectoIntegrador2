package co.edu.usbcali.dto;

import java.util.Date;

public class UsuarioDTO {
	/**
	 * rol que tiene el usuario en el sistema
	 *	1-> administrador
	 *	2-> cliente
	 *
	 * codigoError				mensajeError
	 * 	0						Operacion exitosa
	 *  1						Campo obligatorio no fue enviado
	 *  99						Ocurrio un error inesperado,comunicarse con el proveedor					
	 * 
	 */
	
	private Long id;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Long numIdentificacion;
	private Integer tipoIdentificacion;
	private String password;
	private Integer rol;
	private String usuario;
	private Date fecha;
	
	private int codigoError;
	private String mensajeError;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			Long numIdentificacion, Integer tipoIdentificacion, String password, Integer rol, String usuario,
			Date fecha, int codigoError, String mensajeError) {
		super();
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.numIdentificacion = numIdentificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.password = password;
		this.rol = rol;
		this.usuario = usuario;
		this.fecha = fecha;
		this.codigoError = codigoError;
		this.mensajeError = mensajeError;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Long getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(Long numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public Integer getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(Integer tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRol() {
		return rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
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
