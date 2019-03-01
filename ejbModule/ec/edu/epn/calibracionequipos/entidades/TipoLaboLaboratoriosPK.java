package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gsooindp database table.
 * 
 */
@Embeddable
public class TipoLaboLaboratoriosPK implements Serializable {
	// default serial version id, required for serializable classes.

	public TipoLaboLaboratoriosPK() {
	}

	private static final long serialVersionUID = 1L;

	@Column(name = "id_tipolaboratorio")
	private Integer idTipoLaboratorio;

	@Column(name = "id_laboratorio")
	private Integer idLaboratorio;

	public Integer getIdTipoLaboratorio() {
		return idTipoLaboratorio;
	}

	public void setIdTipoLaboratorio(Integer idTipoLaboratorio) {
		this.idTipoLaboratorio = idTipoLaboratorio;
	}

	public Integer getIdLaboratorio() {
		return idLaboratorio;
	}

	public void setIdLaboratorio(Integer idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TipoLaboLaboratoriosPK)) {
			return false;
		}
		TipoLaboLaboratoriosPK castOther = (TipoLaboLaboratoriosPK) other;
		return this.idLaboratorio.equals(castOther.idLaboratorio)
				&& this.idTipoLaboratorio.equals(castOther.idTipoLaboratorio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLaboratorio.hashCode();
		hash = hash * prime + this.idTipoLaboratorio.hashCode();

		return hash;
	}
}