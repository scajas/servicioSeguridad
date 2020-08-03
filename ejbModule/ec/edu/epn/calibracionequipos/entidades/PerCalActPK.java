package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gsooindp database table.
 * 
 */
@Embeddable
public class PerCalActPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_personalcalificado")
	private Integer idPersonalCalificado;

	@Column(name = "id_actividadecalif")
	private Integer idActividadeCalif;

	public Integer getIdPersonalCalificado() {
		return idPersonalCalificado;
	}

	public void setIdPersonalCalificado(Integer idPersonalCalificado) {
		this.idPersonalCalificado = idPersonalCalificado;
	}

	public Integer getIdActividadeCalif() {
		return idActividadeCalif;
	}

	public void setIdActividadeCalif(Integer idActividadeCalif) {
		this.idActividadeCalif = idActividadeCalif;
	}

	public PerCalActPK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PerCalActPK)) {
			return false;
		}
		PerCalActPK castOther = (PerCalActPK) other;
		return this.idPersonalCalificado.equals(castOther.idPersonalCalificado)
				&& this.idActividadeCalif.equals(castOther.idActividadeCalif);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersonalCalificado.hashCode();
		hash = hash * prime + this.idActividadeCalif.hashCode();

		return hash;
	}
}