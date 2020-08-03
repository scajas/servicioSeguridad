package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the horario_espacio database table.
 * 
 */
@Entity
@Table(name = "horario_espacio", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class HorarioEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_horario_espacio")
	private Integer idHorarioEspacio;

	@Column(name = "descripcion_he")
	private String descripcionHe;

	@Column(name = "uso_he")
	private String usoHe;

	@Column(name = "usado_por")
	private String prestadoA;

	public String getPrestadoA() {
		return prestadoA;
	}

	public void setPrestadoA(String prestadoA) {
		this.prestadoA = prestadoA;
	}

	// bi-directional many-to-one association to Diaslaborable
	@ManyToOne
	@JoinColumn(name = "id_diaslab")
	private Diaslaborable diaslaborable;

	// bi-directional many-to-one association to Espacio
	@ManyToOne
	@JoinColumn(name = "id_espacio")
	private Espacio espacio;

	// bi-directional many-to-one association to EstadoEspacio
	@ManyToOne
	@JoinColumn(name = "id_estado_espacio")
	private EstadoEspacio estadoEspacio;

	// bi-directional many-to-one association to Horario
	@ManyToOne
	@JoinColumn(name = "id_horario")
	private Horario horario;

	// bi-directional many-to-one association to HorarioEspacioOcupante
	@OneToMany(mappedBy = "horarioEspacio")
	private Set<HorarioEspacioOcupante> horarioEspacioOcupantes;

	public HorarioEspacio() {
	}

	public Integer getIdHorarioEspacio() {
		return this.idHorarioEspacio;
	}

	public void setIdHorarioEspacio(Integer idHorarioEspacio) {
		this.idHorarioEspacio = idHorarioEspacio;
	}

	public String getDescripcionHe() {
		return this.descripcionHe;
	}

	public void setDescripcionHe(String descripcionHe) {
		this.descripcionHe = descripcionHe;
	}

	public String getUsoHe() {
		return this.usoHe;
	}

	public void setUsoHe(String usoHe) {
		this.usoHe = usoHe;
	}

	public Diaslaborable getDiaslaborable() {
		return this.diaslaborable;
	}

	public void setDiaslaborable(Diaslaborable diaslaborable) {
		this.diaslaborable = diaslaborable;
	}

	public Espacio getEspacio() {
		return this.espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public EstadoEspacio getEstadoEspacio() {
		return this.estadoEspacio;
	}

	public void setEstadoEspacio(EstadoEspacio estadoEspacio) {
		this.estadoEspacio = estadoEspacio;
	}

	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Set<HorarioEspacioOcupante> getHorarioEspacioOcupantes() {
		return this.horarioEspacioOcupantes;
	}

	public void setHorarioEspacioOcupantes(
			Set<HorarioEspacioOcupante> horarioEspacioOcupantes) {
		this.horarioEspacioOcupantes = horarioEspacioOcupantes;
	}

}