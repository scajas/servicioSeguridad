package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@Table(name = "disciplina", catalog = "bddcorpepn", schema = "`Proyectos`")

public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String detalle;

	private String literal;

	//bi-directional many-to-one association to DisciplinaProyecto
	@OneToMany(mappedBy="disciplina")
	private List<DisciplinaProyecto> disciplinaProyectos;

    public Disciplina() {
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

	public List<DisciplinaProyecto> getDisciplinaProyectos() {
		return this.disciplinaProyectos;
	}

	public void setDisciplinaProyectos(List<DisciplinaProyecto> disciplinaProyectos) {
		this.disciplinaProyectos = disciplinaProyectos;
	}
	
}