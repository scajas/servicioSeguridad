package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the ocupante database table.
 * 
 */
@Entity
@Table(name = "ocupante", catalog = "bddcorpepn", schema = "`Infraestructura`")

public class Ocupante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ocupante")
	private Integer idOcupante;

	@Column(name="apellido_ocupante")
	private String apellidoOcupante;

	@Column(name="cedula_ocupante")
	private String cedulaOcupante;

	@Column(name="direccion_ocupamte")
	private String direccionOcupamte;

	@Column(name="email_ocupante")
	private String emailOcupante;

	@Column(name="nombre_ocupante")
	private String nombreOcupante;

	@Column(name="telefono_ocupante")
	private String telefonoOcupante;

	//bi-directional many-to-one association to HorarioEspacioOcupante
	@OneToMany(mappedBy="ocupante")
	private Set<HorarioEspacioOcupante> horarioEspacioOcupantes;

    public Ocupante() {
    }

	public Integer getIdOcupante() {
		return this.idOcupante;
	}

	public void setIdOcupante(Integer idOcupante) {
		this.idOcupante = idOcupante;
	}

	public String getApellidoOcupante() {
		return this.apellidoOcupante;
	}

	public void setApellidoOcupante(String apellidoOcupante) {
		this.apellidoOcupante = apellidoOcupante;
	}

	public String getCedulaOcupante() {
		return this.cedulaOcupante;
	}

	public void setCedulaOcupante(String cedulaOcupante) {
		this.cedulaOcupante = cedulaOcupante;
	}

	public String getDireccionOcupamte() {
		return this.direccionOcupamte;
	}

	public void setDireccionOcupamte(String direccionOcupamte) {
		this.direccionOcupamte = direccionOcupamte;
	}

	public String getEmailOcupante() {
		return this.emailOcupante;
	}

	public void setEmailOcupante(String emailOcupante) {
		this.emailOcupante = emailOcupante;
	}

	public String getNombreOcupante() {
		return this.nombreOcupante;
	}

	public void setNombreOcupante(String nombreOcupante) {
		this.nombreOcupante = nombreOcupante;
	}

	public String getTelefonoOcupante() {
		return this.telefonoOcupante;
	}

	public void setTelefonoOcupante(String telefonoOcupante) {
		this.telefonoOcupante = telefonoOcupante;
	}

	public Set<HorarioEspacioOcupante> getHorarioEspacioOcupantes() {
		return this.horarioEspacioOcupantes;
	}

	public void setHorarioEspacioOcupantes(Set<HorarioEspacioOcupante> horarioEspacioOcupantes) {
		this.horarioEspacioOcupantes = horarioEspacioOcupantes;
	}
	
}