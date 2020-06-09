package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the historia_laboral database table.
 * 
 */
@Embeddable
public class HistoriaLaboralPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_hist")
	private Integer idHist;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_i")
	private java.util.Date fechaI;

	private String estado;

	public HistoriaLaboralPK() {
	}
	public Integer getIdHist() {
		return this.idHist;
	}
	public void setIdHist(Integer idHist) {
		this.idHist = idHist;
	}
	public java.util.Date getFechaI() {
		return this.fechaI;
	}
	public void setFechaI(java.util.Date fechaI) {
		this.fechaI = fechaI;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HistoriaLaboralPK)) {
			return false;
		}
		HistoriaLaboralPK castOther = (HistoriaLaboralPK)other;
		return 
			this.idHist.equals(castOther.idHist)
			&& this.fechaI.equals(castOther.fechaI)
			&& this.estado.equals(castOther.estado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idHist.hashCode();
		hash = hash * prime + this.fechaI.hashCode();
		hash = hash * prime + this.estado.hashCode();
		
		return hash;
	}
}