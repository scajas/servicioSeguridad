package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;

/**
 * The persistent class for the responsable database table.
 * 
 */
@Entity
@Table(name = "responsable", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class ResponsableInfra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_responsable")
	private Integer idResponsable;

	@Column(name = "apellido_resp")
	private String apellidoResp;

	@Column(name = "cedula_resp")
	private String cedulaResp;

	@Column(name = "direccion_resp")
	private String direccionResp;

	@Column(name = "email_resp")
	private String emailResp;

	@Column(name = "nombre_resp")
	private String nombreResp;

	@Column(name = "telefono_resp")
	private String telefonoResp;

	@Column(name = "lugar_trabajo")
	private String lugarTrabajo;

	public String getLugarTrabajo() {
		return lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	// bi-directional many-to-one association to Evento
	@OneToMany(mappedBy = "responsable")
	private Set<Evento> eventos;

	public ResponsableInfra() {
	}

	public Integer getIdResponsable() {
		return this.idResponsable;
	}

	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getApellidoResp() {
		return this.apellidoResp;
	}

	public void setApellidoResp(String apellidoResp) {
		this.apellidoResp = apellidoResp;
	}

	public String getCedulaResp() {
		return this.cedulaResp;
	}

	public void setCedulaResp(String cedulaResp) {
		this.cedulaResp = cedulaResp;
	}

	public String getDireccionResp() {
		return this.direccionResp;
	}

	public void setDireccionResp(String direccionResp) {
		this.direccionResp = direccionResp;
	}

	public String getEmailResp() {
		return this.emailResp;
	}

	public void setEmailResp(String emailResp) {
		this.emailResp = emailResp;
	}

	public String getNombreResp() {
		return this.nombreResp;
	}

	public void setNombreResp(String nombreResp) {
		this.nombreResp = nombreResp;
	}

	public String getTelefonoResp() {
		return this.telefonoResp;
	}

	public void setTelefonoResp(String telefonoResp) {
		this.telefonoResp = telefonoResp;
	}

	public Set<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

}