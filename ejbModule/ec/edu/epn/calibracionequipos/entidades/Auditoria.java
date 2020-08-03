package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the auditorias database table.
 * 
 */
@Entity
@Table(name="auditorias", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_auditoria")
	private Integer idAuditoria;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_auditoria")
	private Date fechaAuditoria;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_proxima_auditoria")
	private Date fechaProximaAuditoria;

	@Column(name="observaciones_auditoria")
	private String observacionesAuditoria;

	//bi-directional many-to-one association to Cercalacrasignado
	
	
	

	//bi-directional many-to-one association to Laboratorioscalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_laboratorio")
	private Laboratorioscalibracionequipo laboratorioscalibracionequipo;

	//bi-directional many-to-one association to Tipoauditoria
	@ManyToOne
	@JoinColumn(name="id_tipoaudit")
	private Tipoauditoria tipoauditoria;

	//bi-directional many-to-one association to Sistemagestioncalidad
	@OneToMany(mappedBy="auditoria")
	private List<Sistemagestioncalidad> sistemagestioncalidads;

	public Auditoria() {
	}

	public Integer getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(Integer idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public Date getFechaAuditoria() {
		return this.fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public Date getFechaProximaAuditoria() {
		return this.fechaProximaAuditoria;
	}

	public void setFechaProximaAuditoria(Date fechaProximaAuditoria) {
		this.fechaProximaAuditoria = fechaProximaAuditoria;
	}

	public String getObservacionesAuditoria() {
		return this.observacionesAuditoria;
	}

	public void setObservacionesAuditoria(String observacionesAuditoria) {
		this.observacionesAuditoria = observacionesAuditoria;
	}

	

	public Laboratorioscalibracionequipo getLaboratorioscalibracionequipo() {
		return this.laboratorioscalibracionequipo;
	}

	public void setLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		this.laboratorioscalibracionequipo = laboratorioscalibracionequipo;
	}

	public Tipoauditoria getTipoauditoria() {
		return this.tipoauditoria;
	}

	public void setTipoauditoria(Tipoauditoria tipoauditoria) {
		this.tipoauditoria = tipoauditoria;
	}

	public List<Sistemagestioncalidad> getSistemagestioncalidads() {
		return this.sistemagestioncalidads;
	}

	public void setSistemagestioncalidads(List<Sistemagestioncalidad> sistemagestioncalidads) {
		this.sistemagestioncalidads = sistemagestioncalidads;
	}

	public Sistemagestioncalidad addSistemagestioncalidad(Sistemagestioncalidad sistemagestioncalidad) {
		getSistemagestioncalidads().add(sistemagestioncalidad);
		sistemagestioncalidad.setAuditoria(this);

		return sistemagestioncalidad;
	}

	public Sistemagestioncalidad removeSistemagestioncalidad(Sistemagestioncalidad sistemagestioncalidad) {
		getSistemagestioncalidads().remove(sistemagestioncalidad);
		sistemagestioncalidad.setAuditoria(null);

		return sistemagestioncalidad;
	}
	
	
	

	
	
	
	

}