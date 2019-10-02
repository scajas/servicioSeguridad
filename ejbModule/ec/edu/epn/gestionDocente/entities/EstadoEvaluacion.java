package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_evaluacion database table.
 * 
 */
@Entity
@Table(name="estado_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="EstadoEvaluacion.findAll", query="SELECT e FROM EstadoEvaluacion e")
public class EstadoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_eval")
	private Integer idEstadoEval;

	private String descripcion;

	private String nombre;

	public EstadoEvaluacion() {
	}

	public Integer getIdEstadoEval() {
		return this.idEstadoEval;
	}

	public void setIdEstadoEval(Integer idEstadoEval) {
		this.idEstadoEval = idEstadoEval;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}