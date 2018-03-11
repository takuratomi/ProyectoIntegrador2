package co.edu.usbcali.modelo;
// Generated 10-mar-2018 20:23:35 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Proteina generated by hbm2java
 */
public class Proteina implements java.io.Serializable {

	private int id;
	private String nombre;
	private String descripcion;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private Set<MenuSemana> menuSemanas = new HashSet<MenuSemana>(0);

	public Proteina() {
	}

	public Proteina(int id) {
		this.id = id;
	}

	public Proteina(int id, String nombre, String descripcion, String usuarioCreacion, Date fechaCreacion,
			String usuarioModifica, Date fechaModifica, Set<MenuSemana> menuSemanas) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioModifica = usuarioModifica;
		this.fechaModifica = fechaModifica;
		this.menuSemanas = menuSemanas;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Set<MenuSemana> getMenuSemanas() {
		return this.menuSemanas;
	}

	public void setMenuSemanas(Set<MenuSemana> menuSemanas) {
		this.menuSemanas = menuSemanas;
	}

}
