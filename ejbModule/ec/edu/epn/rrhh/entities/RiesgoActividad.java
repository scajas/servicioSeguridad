package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the riesgo_actividad database table.
 * 
 */
@Entity
@Table(name="riesgo_actividad", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="RiesgoActividad.findAll", query="SELECT r FROM RiesgoActividad r")
public class RiesgoActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_actividad")
	private Integer idActividad;

	private String descripcion;

	//bi-directional many-to-one association to RiesgosLaborale
	@ManyToOne
	@JoinColumn(name="id_riesgo")
	private RiesgosLaborale riesgosLaborale;

	public RiesgoActividad() {
	}

	public Integer getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RiesgosLaborale getRiesgosLaborale() {
		return this.riesgosLaborale;
	}

	public void setRiesgosLaborale(RiesgosLaborale riesgosLaborale) {
		this.riesgosLaborale = riesgosLaborale;
	}

}