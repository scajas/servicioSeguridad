package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the caracteristica_usuario database table.
 * 
 */
@Embeddable
public class CaracteristicaUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_caracteristica", insertable=false, updatable=false)
	private String idCaracteristica;

	@Column(name="id_usuario")
	private Integer idUsuario;

	public CaracteristicaUsuarioPK() {
	}
	public String getIdCaracteristica() {
		return this.idCaracteristica;
	}
	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
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
		if (!(other instanceof CaracteristicaUsuarioPK)) {
			return false;
		}
		CaracteristicaUsuarioPK castOther = (CaracteristicaUsuarioPK)other;
		return 
			this.idCaracteristica.equals(castOther.idCaracteristica)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCaracteristica.hashCode();
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}