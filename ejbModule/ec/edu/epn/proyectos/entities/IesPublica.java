package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ies_publicas database table.
 * 
 */
@Entity
@Table(name = "ies_publicas", catalog = "bddcorpepn", schema = "`Proyectos`")
public class IesPublica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cup;

	private String grupo;

	@ManyToOne
	@JoinColumn(name = "id_proy")
	private ProyectoP proyecto;

	private String item;

	public IesPublica() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCup() {
		return this.cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

}