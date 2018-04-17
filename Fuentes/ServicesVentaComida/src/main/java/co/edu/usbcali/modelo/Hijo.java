package co.edu.usbcali.modelo;
// Generated 11-abr-2018 21:14:45 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hijo generated by hbm2java
 */
public class Hijo implements java.io.Serializable {

	private long id;
	private Padre padre;
	private Usuario usuario;
	private Date fechaNacimiento;
	private String curso;
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private Set<Almuerzo> almuerzos = new HashSet<Almuerzo>(0);

	public Hijo() {
	}

	public Hijo(long id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Hijo(long id, Padre padre, Usuario usuario, Date fechaNacimiento, String curso, String usuarioCreacion,
			Date fechaCreacion, String usuarioModifica, Date fechaModifica, Set<Almuerzo> almuerzos) {
		this.id = id;
		this.padre = padre;
		this.usuario = usuario;
		this.fechaNacimiento = fechaNacimiento;
		this.curso = curso;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioModifica = usuarioModifica;
		this.fechaModifica = fechaModifica;
		this.almuerzos = almuerzos;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Padre getPadre() {
		return this.padre;
	}

	public void setPadre(Padre padre) {
		this.padre = padre;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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

	public Set<Almuerzo> getAlmuerzos() {
		return this.almuerzos;
	}

	public void setAlmuerzos(Set<Almuerzo> almuerzos) {
		this.almuerzos = almuerzos;
	}

}
