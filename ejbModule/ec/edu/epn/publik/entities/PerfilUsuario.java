package ec.edu.epn.publik.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfil_usuario database table.
 * 
 */
@Entity
@Table(name="perfil_usuario")
public class PerfilUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PerfilUsuarioPK id;

    public PerfilUsuario() {
    }

	public PerfilUsuarioPK getId() {
		return this.id;
	}

	public void setId(PerfilUsuarioPK id) {
		this.id = id;
	}
	
}