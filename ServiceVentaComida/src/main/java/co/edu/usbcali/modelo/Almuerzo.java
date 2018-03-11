package co.edu.usbcali.modelo;
// Generated 10-mar-2018 20:23:35 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * Almuerzo generated by hbm2java
 */
public class Almuerzo implements java.io.Serializable {

	private BigDecimal id;
	private Hijo hijo;
	private MenuSemana menuSemana;
	private Pedido pedido;
	private Integer estado;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;

	public Almuerzo() {
	}

	public Almuerzo(BigDecimal id, Hijo hijo, MenuSemana menuSemana, Pedido pedido) {
		this.id = id;
		this.hijo = hijo;
		this.menuSemana = menuSemana;
		this.pedido = pedido;
	}

	public Almuerzo(BigDecimal id, Hijo hijo, MenuSemana menuSemana, Pedido pedido, Integer estado,
			String usuarioCreacion, Date fechaCreacion, String usuarioModifica, Date fechaModifica) {
		this.id = id;
		this.hijo = hijo;
		this.menuSemana = menuSemana;
		this.pedido = pedido;
		this.estado = estado;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioModifica = usuarioModifica;
		this.fechaModifica = fechaModifica;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Hijo getHijo() {
		return this.hijo;
	}

	public void setHijo(Hijo hijo) {
		this.hijo = hijo;
	}

	public MenuSemana getMenuSemana() {
		return this.menuSemana;
	}

	public void setMenuSemana(MenuSemana menuSemana) {
		this.menuSemana = menuSemana;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModifica() {
		return this.usuarioModifica;
	}

	public void setUsuarioModifica(String usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

	public Date getFechaModifica() {
		return this.fechaModifica;
	}

	public void setFechaModifica(Date fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

}