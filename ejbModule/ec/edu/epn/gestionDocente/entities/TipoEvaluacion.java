package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tipo_evaluacion database table.
 * 
 */
@Entity
@Table(name="tipo_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="TipoEvaluacion.findAll", query="SELECT t FROM TipoEvaluacion t")
public class TipoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_evaluacion")
	private Integer idTipoEvaluacion;

	private String detalle;

	@Column(name="nombre_tipo")
	private String nombreTipo;

	

	public TipoEvaluacion() {
	}

	public Integer getIdTipoEvaluacion() {
		return this.idTipoEvaluacion;
	}

	public void setIdTipoEvaluacion(Integer idTipoEvaluacion) {
		this.idTipoEvaluacion = idTipoEvaluacion;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}


}