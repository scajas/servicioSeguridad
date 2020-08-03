package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gsooindp database table.
 * 
 */
@Embeddable
public class EqPerCalfPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_equipo")
	private Integer idEquipo;

	@Column(name = "id_personalcalificado")
	private Integer idPersonalCalificado;

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Integer getIdPersonalCalificado() {
		return idPersonalCalificado;
	}

	public void setIdPersonalCalificado(Integer idPersonalCalificado) {
		this.idPersonalCalificado = idPersonalCalificado;
	}

	public EqPerCalfPK() {
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EqPerCalfPK)) {
			return false;
		}
		EqPerCalfPK castOther = (EqPerCalfPK) other;
		return this.idEquipo.equals(castOther.idEquipo)
				&& this.idPersonalCalificado.equals(castOther.idPersonalCalificado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idEquipo.hashCode();
		hash = hash * prime + this.idPersonalCalificado.hashCode();

		return hash;
	}
}