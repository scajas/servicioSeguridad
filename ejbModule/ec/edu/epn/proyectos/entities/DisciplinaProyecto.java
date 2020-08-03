package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disciplina_proyecto database table.
 * 
 */
@Entity
@Table(name="disciplina_proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class DisciplinaProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;



	//bi-directional many-to-one association to Disciplina
    @ManyToOne
	@JoinColumn(name="iddisciplina")
	private Disciplina disciplina;
    
    
    
  //bi-directional many-to-one association to Disciplina
    @ManyToOne
	@JoinColumn(name="idproyecto")
	private ProyectoP proyecto;

    public DisciplinaProyecto() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
}