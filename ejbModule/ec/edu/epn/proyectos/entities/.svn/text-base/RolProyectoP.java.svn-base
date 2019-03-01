package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol_proyecto database table.
 * 
 */
@Entity

@Table(name="rol_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class RolProyectoP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rol_proy")
	private Integer idRolProy;

	@Column(name="rol_proy")
	private String rolProy;
	
	private String descripcion;
	

	//bi-directional many-to-one association to RecursohPr
	@OneToMany(mappedBy="rolProyecto")
	private List<RecursohPr> recursohPrs;

    public RolProyectoP() {
    }

	public Integer getIdRolProy() {
		return this.idRolProy;
	}

	public void setIdRolProy(Integer idRolProy) {
		this.idRolProy = idRolProy;
	}

	public String getRolProy() {
		return this.rolProy;
	}

	public void setRolProy(String rolProy) {
		this.rolProy = rolProy;
	}

	public List<RecursohPr> getRecursohPrs() {
		return this.recursohPrs;
	}

	public void setRecursohPrs(List<RecursohPr> recursohPrs) {
		this.recursohPrs = recursohPrs;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}