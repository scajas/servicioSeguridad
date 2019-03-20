package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the diashora database table.
 * 
 */
@Embeddable
public class GrupoEstudiantePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_planificacion", insertable = false, updatable = false)
	private Integer idPlanificacion;

	@Column(name = "id_estudiantes", insertable = false, updatable = false)
	private Integer idEstudiantes;

	public Integer getIdPlanificacion() {
		return idPlanificacion;
	}

	public void setIdPlanificacion(Integer idPlanificacion) {
		this.idPlanificacion = idPlanificacion;
	}

	public Integer getIdEstudiantes() {
		return idEstudiantes;
	}

	public void setIdEstudiantes(Integer idEstudiantes) {
		this.idEstudiantes = idEstudiantes;
	}

	public GrupoEstudiantePK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GrupoEstudiantePK)) {
			return false;
		}
		GrupoEstudiantePK castOther = (GrupoEstudiantePK) other;
		return this.idPlanificacion.equals(castOther.idPlanificacion)
				&& this.idEstudiantes.equals(castOther.idEstudiantes);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEstudiantes.hashCode();
		hash = hash * prime + this.idPlanificacion.hashCode();

		return hash;
	}
}