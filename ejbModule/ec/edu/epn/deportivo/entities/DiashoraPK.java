package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the diashora database table.
 * 
 */
@Embeddable
public class DiashoraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_horaplanificacion", insertable=false, updatable=false)
	private Integer idHoraplanificacion;

	@Column(name="id_diaplanificacion", insertable=false, updatable=false)
	private Integer idDiaplanificacion;

	public DiashoraPK() {
	}
	public Integer getIdHoraplanificacion() {
		return this.idHoraplanificacion;
	}
	public void setIdHoraplanificacion(Integer idHoraplanificacion) {
		this.idHoraplanificacion = idHoraplanificacion;
	}
	public Integer getIdDiaplanificacion() {
		return this.idDiaplanificacion;
	}
	public void setIdDiaplanificacion(Integer idDiaplanificacion) {
		this.idDiaplanificacion = idDiaplanificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DiashoraPK)) {
			return false;
		}
		DiashoraPK castOther = (DiashoraPK)other;
		return 
			this.idHoraplanificacion.equals(castOther.idHoraplanificacion)
			&& this.idDiaplanificacion.equals(castOther.idDiaplanificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idHoraplanificacion.hashCode();
		hash = hash * prime + this.idDiaplanificacion.hashCode();
		
		return hash;
	}
}