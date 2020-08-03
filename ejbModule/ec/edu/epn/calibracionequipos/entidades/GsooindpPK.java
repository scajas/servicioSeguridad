package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gsooindp database table.
 * 
 */
@Embeddable
public class GsooindpPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_proceso")
	private Integer idProceso;

	@Column(name="id_indicepotencial")
	private Integer idIndicepotencial;

	public GsooindpPK() {
	}
	public Integer getIdProceso() {
		return this.idProceso;
	}
	public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}
	public Integer getIdIndicepotencial() {
		return this.idIndicepotencial;
	}
	public void setIdIndicepotencial(Integer idIndicepotencial) {
		this.idIndicepotencial = idIndicepotencial;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GsooindpPK)) {
			return false;
		}
		GsooindpPK castOther = (GsooindpPK)other;
		return 
			this.idProceso.equals(castOther.idProceso)
			&& this.idIndicepotencial.equals(castOther.idIndicepotencial);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProceso.hashCode();
		hash = hash * prime + this.idIndicepotencial.hashCode();
		
		return hash;
	}
}