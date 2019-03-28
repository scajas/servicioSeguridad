package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bodega_usuario database table.
 * 
 */
@Embeddable
public class BodegaUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_bodega", insertable=false, updatable=false)
	private String idBodega;

	@Column(name="id_usuario")
	private Integer idUsuario;

	public BodegaUsuarioPK() {
	}
	public String getIdBodega() {
		return this.idBodega;
	}
	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
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
		if (!(other instanceof BodegaUsuarioPK)) {
			return false;
		}
		BodegaUsuarioPK castOther = (BodegaUsuarioPK)other;
		return 
			this.idBodega.equals(castOther.idBodega)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idBodega.hashCode();
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}