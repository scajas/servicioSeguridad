package ec.edu.epn.catalogos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity

@Table(name="preguntas_evaluacion", catalog = "bddcorpepn", schema = "`Catalogos`")
public class PreguntasEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_preguntas_eval")
	private Integer idPreguntasEval;

	@Column(name="detalle")
	private String detalle;

	@Column(name="tipo")
	private String tipo;
	
	@Column(name="asignacion")
	private String asignacion;
	
	@Column(name="orden")
	private Integer orden;
	

	/**
	 * @return the idPreguntasEval
	 */
	public Integer getIdPreguntasEval() {
		return idPreguntasEval;
	}

	/**
	 * @param idPreguntasEval the idPreguntasEval to set
	 */
	public void setIdPreguntasEval(Integer idPreguntasEval) {
		this.idPreguntasEval = idPreguntasEval;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the asignacion
	 */
	public String getAsignacion() {
		return asignacion;
	}

	/**
	 * @param asignacion the asignacion to set
	 */
	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}	

	
}