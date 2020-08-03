package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_actividad_evaluacion database table.
 * 
 */
@Entity
@Table(name="tipo_actividad_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="TipoActividadEvaluacion.findAll", query="SELECT t FROM TipoActividadEvaluacion t")
public class TipoActividadEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_actv_eval")
	private Integer idTipoActvEval;

	private String detalle;

	private String nombre;
	

	//bi-directional many-to-one association to TipoEvaluacion
	@ManyToOne
	@JoinColumn(name="id_tipo_evaluacion")
	private TipoEvaluacion tipoEvaluacion;

	public TipoActividadEvaluacion() {
	}

	public Integer getIdTipoActvEval() {
		return this.idTipoActvEval;
	}

	public void setIdTipoActvEval(Integer idTipoActvEval) {
		this.idTipoActvEval = idTipoActvEval;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	

	public TipoEvaluacion getTipoEvaluacion() {
		return this.tipoEvaluacion;
	}

	public void setTipoEvaluacion(TipoEvaluacion tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

}