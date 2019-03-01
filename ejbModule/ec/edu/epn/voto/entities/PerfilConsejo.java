package ec.edu.epn.voto.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfil_consejo database table.
 * 
 */
@Entity
@Table(name="perfil_consejo" , catalog = "`bddcorpepn`", schema = "`Votoe`")
public class PerfilConsejo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_perfil_consejo")
	private Integer idPerfilConsejo;

	@Column(name="id_consejo")
	private Integer idConsejo;

	@Column(name="id_perfil")
	private Integer idPerfil;

    public PerfilConsejo() {
    }

	public Integer getIdPerfilConsejo() {
		return this.idPerfilConsejo;
	}

	public void setIdPerfilConsejo(Integer idPerfilConsejo) {
		this.idPerfilConsejo = idPerfilConsejo;
	}

	public Integer getIdConsejo() {
		return this.idConsejo;
	}

	public void setIdConsejo(Integer idConsejo) {
		this.idConsejo = idConsejo;
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

}