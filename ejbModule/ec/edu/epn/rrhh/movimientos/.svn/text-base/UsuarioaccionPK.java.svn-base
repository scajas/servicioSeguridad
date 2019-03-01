package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuarioaccion database table.
 * 
 */
@Embeddable
public class UsuarioaccionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_accionbtn", insertable=false, updatable=false)
	private Integer idAccionbtn;

	@Column(name="id_usuario", insertable=false, updatable=false)
	private Integer idUsuario;

	public UsuarioaccionPK() {
	}
	public Integer getIdAccionbtn() {
		return this.idAccionbtn;
	}
	public void setIdAccionbtn(Integer idAccionbtn) {
		this.idAccionbtn = idAccionbtn;
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
		if (!(other instanceof UsuarioaccionPK)) {
			return false;
		}
		UsuarioaccionPK castOther = (UsuarioaccionPK)other;
		return 
			this.idAccionbtn.equals(castOther.idAccionbtn)
			&& this.idUsuario.equals(castOther.idUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAccionbtn.hashCode();
		hash = hash * prime + this.idUsuario.hashCode();
		
		return hash;
	}
}