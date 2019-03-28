package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the saldo_existencia database table.
 * 
 */
@Embeddable
public class SaldoExistenciaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_existencia")
	private String idExistencia;

	private Integer mes;

	private Integer anio;

	public SaldoExistenciaPK() {
	}
	public String getIdExistencia() {
		return this.idExistencia;
	}
	public void setIdExistencia(String idExistencia) {
		this.idExistencia = idExistencia;
	}
	public Integer getMes() {
		return this.mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return this.anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SaldoExistenciaPK)) {
			return false;
		}
		SaldoExistenciaPK castOther = (SaldoExistenciaPK)other;
		return 
			this.idExistencia.equals(castOther.idExistencia)
			&& this.mes.equals(castOther.mes)
			&& this.anio.equals(castOther.anio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idExistencia.hashCode();
		hash = hash * prime + this.mes.hashCode();
		hash = hash * prime + this.anio.hashCode();
		
		return hash;
	}
}