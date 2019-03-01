package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the proyecto_objetivo database table.
 * 
 */
@Entity
@Table(name = "proyecto_objetivo", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ProyectoObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idproyecto")
	private ProyectoP proyecto;

	// bi-directional many-to-one association to Objetivo
	@ManyToOne
	@JoinColumn(name = "id_objetivo")
	private Objetivo objetivo;

	public ProyectoObjetivo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

}