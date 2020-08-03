package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoplan database table.
 * 
 */
@Entity
@Table(name="tipoplan", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipoplan.findAll", query="SELECT t FROM Tipoplan t")
public class Tipoplan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoplan")
	private Integer idTipoplan;

	@Column(name="descripcion_tipoplan")
	private String descripcionTipoplan;

	@Column(name="frecuencia_tipoplan")
	private Integer frecuenciaTipoplan;

	@Column(name="nombre_tipoplan")
	private String nombreTipoplan;

	//bi-directional one-to-one association to Plan
	@OneToOne(mappedBy="tipoplan")
	private Plan plan;

	public Tipoplan() {
	}

	public Integer getIdTipoplan() {
		return this.idTipoplan;
	}

	public void setIdTipoplan(Integer idTipoplan) {
		this.idTipoplan = idTipoplan;
	}

	public String getDescripcionTipoplan() {
		return this.descripcionTipoplan;
	}

	public void setDescripcionTipoplan(String descripcionTipoplan) {
		this.descripcionTipoplan = descripcionTipoplan;
	}

	public Integer getFrecuenciaTipoplan() {
		return this.frecuenciaTipoplan;
	}

	public void setFrecuenciaTipoplan(Integer frecuenciaTipoplan) {
		this.frecuenciaTipoplan = frecuenciaTipoplan;
	}

	public String getNombreTipoplan() {
		return this.nombreTipoplan;
	}

	public void setNombreTipoplan(String nombreTipoplan) {
		this.nombreTipoplan = nombreTipoplan;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}