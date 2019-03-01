package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_proyecto database table.
 * 
 */
@Entity
@Table(name="rol_proyecto")
@NamedQuery(name="RolProyecto.findAll", query="SELECT r FROM RolProyecto r")
public class RolProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol_proy")
	private String idRolProy;

	@Column(name="rol_proy")
	private String rolProy;

	public RolProyecto() {
	}

	public String getIdRolProy() {
		return this.idRolProy;
	}

	public void setIdRolProy(String idRolProy) {
		this.idRolProy = idRolProy;
	}

	public String getRolProy() {
		return this.rolProy;
	}

	public void setRolProy(String rolProy) {
		this.rolProy = rolProy;
	}

}