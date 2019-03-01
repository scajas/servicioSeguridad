package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gsooindp database table.
 * 
 */
@Embeddable
public class LabLinInvPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_laboratorio")
	private Integer idLaboratorio;

	@Column(name = "id_lineainvestigacion")
	private Integer idLineainvestigacion;

	public Integer getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Integer idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public Integer getIdLineainvestigacion() {
		return idLineainvestigacion;
	}

	public void setIdLineainvestigacion(Integer idLineainvestigacion) {
		this.idLineainvestigacion = idLineainvestigacion;
	}

	public LabLinInvPK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LabLinInvPK)) {
			return false;
		}
		LabLinInvPK castOther = (LabLinInvPK) other;
		return this.idLaboratorio.equals(castOther.idLaboratorio)
				&& this.idLineainvestigacion.equals(castOther.idLineainvestigacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLaboratorio.hashCode();
		hash = hash * prime + this.idLineainvestigacion.hashCode();

		return hash;
	}
}