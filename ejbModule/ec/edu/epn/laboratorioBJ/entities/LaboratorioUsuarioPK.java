package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the laboratorio_usuario database table.
 * 
 */
@Embeddable
public class LaboratorioUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_laboratorio")
	private Integer idLaboratorio;

	@Column(name="id_usuario")
	private Integer idUsuario;

	public LaboratorioUsuarioPK() {
	}
	public Integer getIdLaboratorio() {
		return this.idLaboratorio;
	}
	public void setIdLaboratorio(Integer idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}
	public Integer getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LaboratorioUsuarioPK)) {
			return false;
		}
		LaboratorioUsuarioPK castOther = (LaboratorioUsuarioPK)other;
		return 
			this.idLaboratorio.equals(castOther.idLaboratorio)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLaboratorio.hashCode();
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}