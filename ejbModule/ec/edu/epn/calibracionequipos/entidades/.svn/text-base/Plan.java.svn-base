package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the plan database table.
 * 
 */
@Entity
@Table(name = "plan", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_plan")
	private Integer idPlan;

	@Column(name = "descripcion_plan")
	private String descripcionPlan;

	@Column(name = "diasparaactividad_plan")
	private Integer diasparaactividadPlan;

	@Column(name = "nombre_plan")
	private String nombrePlan;

	@Column(name = "observaciones_plan")
	private String observacionesPlan;

	// bi-directional many-to-one association to Detalleplan
	@OneToMany(mappedBy = "plan")
	private List<Detalleplan> detalleplans;

	@OneToMany(mappedBy = "plan")
	private List<EvidenciasPlan> evidenciasPlan;

	// bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name = "id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	// bi-directional one-to-one association to Tipoplan
	@OneToOne
	@JoinColumn(name = "id_tipoplan")
	private Tipoplan tipoplan;

	public Plan() {
	}

	public Integer getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getDescripcionPlan() {
		return this.descripcionPlan;
	}

	public void setDescripcionPlan(String descripcionPlan) {
		this.descripcionPlan = descripcionPlan;
	}

	public Integer getDiasparaactividadPlan() {
		return this.diasparaactividadPlan;
	}

	public void setDiasparaactividadPlan(Integer diasparaactividadPlan) {
		this.diasparaactividadPlan = diasparaactividadPlan;
	}

	public String getNombrePlan() {
		return this.nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public String getObservacionesPlan() {
		return this.observacionesPlan;
	}

	public void setObservacionesPlan(String observacionesPlan) {
		this.observacionesPlan = observacionesPlan;
	}

	public List<Detalleplan> getDetalleplans() {
		return this.detalleplans;
	}

	public void setDetalleplans(List<Detalleplan> detalleplans) {
		this.detalleplans = detalleplans;
	}

	public Detalleplan addDetalleplan(Detalleplan detalleplan) {
		getDetalleplans().add(detalleplan);
		detalleplan.setPlan(this);

		return detalleplan;
	}

	public Detalleplan removeDetalleplan(Detalleplan detalleplan) {
		getDetalleplans().remove(detalleplan);
		detalleplan.setPlan(null);

		return detalleplan;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

	public Tipoplan getTipoplan() {
		return this.tipoplan;
	}

	public void setTipoplan(Tipoplan tipoplan) {
		this.tipoplan = tipoplan;
	}

	public List<EvidenciasPlan> getEvidenciasPlan() {
		return evidenciasPlan;
	}

	public void setEvidenciasPlan(List<EvidenciasPlan> evidenciasPlan) {
		this.evidenciasPlan = evidenciasPlan;
	}

}