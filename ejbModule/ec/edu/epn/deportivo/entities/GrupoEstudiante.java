package ec.edu.epn.deportivo.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the diashora database table.
 * 
 */
@Entity
@Table(name = "grupoestudiante", catalog = "`bddcorpepn`", schema = "`Deportivo`")
@NamedQuery(name = "GrupoEstudiante.findAll", query = "SELECT d FROM GrupoEstudiante d")
public class GrupoEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GrupoEstudiantePK id;

	// bi-directional many-to-one association to DiasPlanificacion
	@ManyToOne
	@JoinColumn(name = "id_planificacion", insertable = false, updatable = false)
	private Planificacion planificacion;

	// bi-directional many-to-one association to HoraPlanificacion
	@ManyToOne
	@JoinColumn(name = "id_estudiantes", insertable = false, updatable = false)
	private Estudiante estudiante;

	public Planificacion getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(Planificacion planificacion) {
		this.planificacion = planificacion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public GrupoEstudiante() {
	}

	public GrupoEstudiantePK getId() {
		return this.id;
	}

	public void setId(GrupoEstudiantePK id) {
		this.id = id;
	}

}