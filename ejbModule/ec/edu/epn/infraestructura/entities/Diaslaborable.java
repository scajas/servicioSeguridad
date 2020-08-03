package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the diaslaborables database table.
 * 
 */
@Entity
@Table(name = "diaslaborables", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Diaslaborable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_diaslab")
	private Integer idDiaslab;

	@OneToMany(mappedBy = "dias")
	private List<Sesione> sesiones;

	

	public List<Sesione> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesione> sesiones) {
		this.sesiones = sesiones;
	}

	@OneToMany(mappedBy = "dias")
	private List<PreferenciaHorario> preferenciahorarios;

	public List<PreferenciaHorario> getPreferenciahorarios() {
		return preferenciahorarios;
	}

	public void setPreferenciahorarios(
			List<PreferenciaHorario> preferenciahorarios) {
		this.preferenciahorarios = preferenciahorarios;
	}

	private String descripcion;

	// bi-directional many-to-one association to HorarioEspacio
	@OneToMany(mappedBy = "diaslaborable")
	private Set<HorarioEspacio> horarioEspacios;

	public Diaslaborable() {
	}

	public Integer getIdDiaslab() {
		return this.idDiaslab;
	}

	public void setIdDiaslab(Integer idDiaslab) {
		this.idDiaslab = idDiaslab;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<HorarioEspacio> getHorarioEspacios() {
		return this.horarioEspacios;
	}

	public void setHorarioEspacios(Set<HorarioEspacio> horarioEspacios) {
		this.horarioEspacios = horarioEspacios;
	}

}