package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reglamento_evaluacion database table.
 * 
 */
@Entity
@Table(name="reglamento_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="ReglamentoEvaluacion.findAll", query="SELECT r FROM ReglamentoEvaluacion r")
public class ReglamentoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reglamento_evaluacion")
	private Integer idReglamentoEvaluacion;

	private String actividad;

	@Column(name="asignacion_horas")
	private String asignacionHoras;

	@Column(name="id_tipo_actv_eval")
	private Integer idTipoActvEval;

	public ReglamentoEvaluacion() {
	}

	public Integer getIdReglamentoEvaluacion() {
		return this.idReglamentoEvaluacion;
	}

	public void setIdReglamentoEvaluacion(Integer idReglamentoEvaluacion) {
		this.idReglamentoEvaluacion = idReglamentoEvaluacion;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getAsignacionHoras() {
		return this.asignacionHoras;
	}

	public void setAsignacionHoras(String asignacionHoras) {
		this.asignacionHoras = asignacionHoras;
	}

	public Integer getIdTipoActvEval() {
		return this.idTipoActvEval;
	}

	public void setIdTipoActvEval(Integer idTipoActvEval) {
		this.idTipoActvEval = idTipoActvEval;
	}

}