package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gestioncompra database table.
 * 
 */
@Entity
@Table(name="gestioncompra", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Gestioncompra.findAll", query="SELECT g FROM Gestioncompra g")
public class Gestioncompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_gestioncompra")
	private Integer idGestioncompra;

	@Temporal(TemporalType.DATE)
	@Column(name="fecharegistro_gestioncompra")
	private Date fecharegistroGestioncompra;

	@Column(name="justificacion_gestioncompra")
	private String justificacionGestioncompra;

	@Column(name="observaciones_gestioncompra")
	private String observacionesGestioncompra;

	@Column(name="solicitante_gestioncompra")
	private Integer solicitanteGestioncompra;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equiposcalibracionequipo equiposcalibracionequipo;

	//bi-directional many-to-one association to Estadogestioncompra
	@ManyToOne
	@JoinColumn(name="id_estadogcompra")
	private Estadogestioncompra estadogestioncompra;

	public Gestioncompra() {
	}

	public Integer getIdGestioncompra() {
		return this.idGestioncompra;
	}

	public void setIdGestioncompra(Integer idGestioncompra) {
		this.idGestioncompra = idGestioncompra;
	}

	public Date getFecharegistroGestioncompra() {
		return this.fecharegistroGestioncompra;
	}

	public void setFecharegistroGestioncompra(Date fecharegistroGestioncompra) {
		this.fecharegistroGestioncompra = fecharegistroGestioncompra;
	}

	public String getJustificacionGestioncompra() {
		return this.justificacionGestioncompra;
	}

	public void setJustificacionGestioncompra(String justificacionGestioncompra) {
		this.justificacionGestioncompra = justificacionGestioncompra;
	}

	public String getObservacionesGestioncompra() {
		return this.observacionesGestioncompra;
	}

	public void setObservacionesGestioncompra(String observacionesGestioncompra) {
		this.observacionesGestioncompra = observacionesGestioncompra;
	}

	public Integer getSolicitanteGestioncompra() {
		return this.solicitanteGestioncompra;
	}

	public void setSolicitanteGestioncompra(Integer solicitanteGestioncompra) {
		this.solicitanteGestioncompra = solicitanteGestioncompra;
	}

	public Equiposcalibracionequipo getEquiposcalibracionequipo() {
		return this.equiposcalibracionequipo;
	}

	public void setEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		this.equiposcalibracionequipo = equiposcalibracionequipo;
	}

	public Estadogestioncompra getEstadogestioncompra() {
		return this.estadogestioncompra;
	}

	public void setEstadogestioncompra(Estadogestioncompra estadogestioncompra) {
		this.estadogestioncompra = estadogestioncompra;
	}

}