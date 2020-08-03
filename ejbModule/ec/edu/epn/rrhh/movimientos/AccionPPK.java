package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the accion_p database table.
 * 
 */
@Embeddable
public class AccionPPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_accionp")
	private Integer idAccionp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ini")
	private java.util.Date fechaIni;

	public AccionPPK() {
	}
	public Integer getIdAccionp() {
		return this.idAccionp;
	}
	public void setIdAccionp(Integer idAccionp) {
		this.idAccionp = idAccionp;
	}
	public java.util.Date getFechaIni() {
		return this.fechaIni;
	}
	public void setFechaIni(java.util.Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AccionPPK)) {
			return false;
		}
		AccionPPK castOther = (AccionPPK)other;
		return 
			this.idAccionp.equals(castOther.idAccionp)
			&& this.fechaIni.equals(castOther.fechaIni);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAccionp.hashCode();
		hash = hash * prime + this.fechaIni.hashCode();
		
		return hash;
	}
}