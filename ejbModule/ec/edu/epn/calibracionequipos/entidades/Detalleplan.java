package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the detalleplan database table.
 * 
 */
@Entity
@Table(name = "detalleplan", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Detalleplan.findAll", query = "SELECT d FROM Detalleplan d")
public class Detalleplan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_detalleplan")
	private Integer idDetalleplan;

	@Column(name = "costotarea_detalleplan")
	private String costotareaDetalleplan;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_detalleplan")
	private Date fechaDetalleplan;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaprox_detalleplan")
	private Date fechaproxDetalleplan;

	private String frecuencia;

	@Column(name = "tipo_detalle")
	private String tipoDetalle;

	@Column(name = "observaciones_detalleplan")
	private String observacionesDetalleplan;

	@Column(name = "realizadopor_detalleplan")
	private String realizadoporDetalleplan;

	@Column(name = "revizadopor_detalleplan")
	private String revizadoporDetalleplan;

	@Column(name = "tareaporrealizar_detalleplan")
	private String tareaporrealizarDetalleplan;

	// bi-directional many-to-one association to Estadoejecucion
	@ManyToOne
	@JoinColumn(name = "id_estadoejecucion")
	private Estadoejecucion estadoejecucion;

	// bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name = "id_plan")
	private Plan plan;

	// bi-directional many-to-one association to Serviciotecnico
	@ManyToOne
	@JoinColumn(name = "id_serviciotecnico")
	private Serviciotecnico serviciotecnico;

	public Detalleplan() {
	}

	public Integer getIdDetalleplan() {
		return this.idDetalleplan;
	}

	public void setIdDetalleplan(Integer idDetalleplan) {
		this.idDetalleplan = idDetalleplan;
	}

	public String getCostotareaDetalleplan() {
		return this.costotareaDetalleplan;
	}

	public void setCostotareaDetalleplan(String costotareaDetalleplan) {
		this.costotareaDetalleplan = costotareaDetalleplan;
	}

	public Date getFechaDetalleplan() {
		return this.fechaDetalleplan;
	}

	public void setFechaDetalleplan(Date fechaDetalleplan) {
		this.fechaDetalleplan = fechaDetalleplan;
	}

	public Date getFechaproxDetalleplan() {
		return this.fechaproxDetalleplan;
	}

	public void setFechaproxDetalleplan(Date fechaproxDetalleplan) {
		this.fechaproxDetalleplan = fechaproxDetalleplan;
	}

	public String getFrecuencia() {
		return this.frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getObservacionesDetalleplan() {
		return this.observacionesDetalleplan;
	}

	public void setObservacionesDetalleplan(String observacionesDetalleplan) {
		this.observacionesDetalleplan = observacionesDetalleplan;
	}

	public String getRealizadoporDetalleplan() {
		return this.realizadoporDetalleplan;
	}

	public void setRealizadoporDetalleplan(String realizadoporDetalleplan) {
		this.realizadoporDetalleplan = realizadoporDetalleplan;
	}

	public String getRevizadoporDetalleplan() {
		return this.revizadoporDetalleplan;
	}

	public void setRevizadoporDetalleplan(String revizadoporDetalleplan) {
		this.revizadoporDetalleplan = revizadoporDetalleplan;
	}

	public String getTareaporrealizarDetalleplan() {
		return this.tareaporrealizarDetalleplan;
	}

	public void setTareaporrealizarDetalleplan(String tareaporrealizarDetalleplan) {
		this.tareaporrealizarDetalleplan = tareaporrealizarDetalleplan;
	}

	public Estadoejecucion getEstadoejecucion() {
		return this.estadoejecucion;
	}

	public void setEstadoejecucion(Estadoejecucion estadoejecucion) {
		this.estadoejecucion = estadoejecucion;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Serviciotecnico getServiciotecnico() {
		return this.serviciotecnico;
	}

	public void setServiciotecnico(Serviciotecnico serviciotecnico) {
		this.serviciotecnico = serviciotecnico;
	}

	public String getTipoDetalle() {
		return tipoDetalle;
	}

	public void setTipoDetalle(String tipoDetalle) {
		this.tipoDetalle = tipoDetalle;
	}

}