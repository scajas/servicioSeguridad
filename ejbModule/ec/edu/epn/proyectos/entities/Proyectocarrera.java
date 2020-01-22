package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proyectocarrera database table.
 * 
 */
@Entity
@Table(name="proyectocarrera", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="Proyectocarrera.findAll", query="SELECT p FROM Proyectocarrera p")
public class Proyectocarrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

	private String nombre;

	public Proyectocarrera() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}