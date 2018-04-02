package co.edu.usbcali.dto;

import java.math.BigDecimal;
import java.util.Date;

import co.edu.usbcali.modelo.Hijo;
import co.edu.usbcali.modelo.MenuSemana;
import co.edu.usbcali.modelo.Pedido;

public class AlmuerzoDTO {
	
	private BigDecimal id;
	private Hijo hijo;
	private MenuSemana menuSemana;
	private Pedido pedido;
	private Integer estado;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	
	private String codigoError;
	private String mensajeError;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public Hijo getHijo() {
		return hijo;
	}
	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}
	public MenuSemana getMenuSemana() {
		return menuSemana;
	}
	public void setMenuSemana(MenuSemana menuSemana) {
		this.menuSemana = menuSemana;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioModifica() {
		return usuarioModifica;
	}
	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	public Date getFechaModifica() {
		return fechaModifica;
	}
	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}
	public String getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	
}
