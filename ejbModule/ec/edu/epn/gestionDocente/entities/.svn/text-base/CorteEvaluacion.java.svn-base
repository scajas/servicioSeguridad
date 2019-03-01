package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the corte_evaluacion database table.
 * 
 */
@Entity
@Table(name="corte_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="CorteEvaluacion.findAll", query="SELECT c FROM CorteEvaluacion c")
public class CorteEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_corte_eval")
	private Integer idCorteEval;

	@Column(name="cod_dep")
	private String codDep;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_auto")
	private Date fechaAuto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_coe")
	private Date fechaCoe;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_planif")
	private Date fechaPlanif;

	@Column(name="id_pensum")
	private Integer idPensum;

	public CorteEvaluacion() {
	}

	public Integer getIdCorteEval() {
		return this.idCorteEval;
	}

	public void setIdCorteEval(Integer idCorteEval) {
		this.idCorteEval = idCorteEval;
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public Date getFechaAuto() {
		return this.fechaAuto;
	}

	public void setFechaAuto(Date fechaAuto) {
		this.fechaAuto = fechaAuto;
	}

	public Date getFechaCoe() {
		return this.fechaCoe;
	}

	public void setFechaCoe(Date fechaCoe) {
		this.fechaCoe = fechaCoe;
	}

	public Date getFechaPlanif() {
		return this.fechaPlanif;
	}

	public void setFechaPlanif(Date fechaPlanif) {
		this.fechaPlanif = fechaPlanif;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

}