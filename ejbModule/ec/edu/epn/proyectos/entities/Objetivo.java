package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the objetivo database table.
 * 
 */
@Entity
@Table(name = "objetivo", catalog = "bddcorpepn", schema = "`Proyectos`")

public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String detalle;

	private String literal;

	//bi-directional many-to-one association to ProyectoObjetivo
	@OneToMany(mappedBy="objetivo")
	private List<ProyectoObjetivo> proyectoObjetivos;

    public Objetivo() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getLiteral() {
		return this.literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public List<ProyectoObjetivo> getProyectoObjetivos() {
		return this.proyectoObjetivos;
	}

	public void setProyectoObjetivos(List<ProyectoObjetivo> proyectoObjetivos) {
		this.proyectoObjetivos = proyectoObjetivos;
	}
	
}