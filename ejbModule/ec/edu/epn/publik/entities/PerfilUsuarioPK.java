package ec.edu.epn.publik.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the perfil_usuario database table.
 * 
 */
@Embeddable
public class PerfilUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_perfil")
	private Integer idPerfil;

	@Column(name="id_usuario")
	private Integer idUsuario;

    public PerfilUsuarioPK() {
    }
	public Integer getIdPerfil() {
		return this.idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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
		if (!(other instanceof PerfilUsuarioPK)) {
			return false;
		}
		PerfilUsuarioPK castOther = (PerfilUsuarioPK)other;
		return 
			this.idPerfil.equals(castOther.idPerfil)
			&& this.idUsuario.equals(castOther.idUsuario);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPerfil.hashCode();
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
    }
}