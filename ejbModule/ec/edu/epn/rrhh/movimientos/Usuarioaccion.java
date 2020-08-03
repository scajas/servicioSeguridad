package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarioaccion database table.
 * 
 */
@Entity
@NamedQuery(name="Usuarioaccion.findAll", query="SELECT u FROM Usuarioaccion u")
public class Usuarioaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioaccionPK id;

	

	public Usuarioaccion() {
	}

	public UsuarioaccionPK getId() {
		return this.id;
	}

	public void setId(UsuarioaccionPK id) {
		this.id = id;
	}
	
	

}