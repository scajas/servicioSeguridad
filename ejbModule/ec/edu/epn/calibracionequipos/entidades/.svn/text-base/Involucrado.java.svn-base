package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the involucrado database table.
 * 
 */
@Entity
@Table(name="involucrado", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Involucrado.findAll", query="SELECT i FROM Involucrado i")
public class Involucrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_involucrado")
	private Integer idInvolucrado;

	@Column(name="cargo_involucrado")
	private String cargoInvolucrado;

	@Column(name="cedula_incolucrado")
	private String cedulaIncolucrado;

	@Column(name="celular_involucrado")
	private String celularInvolucrado;

	@Column(name="cuidad_involucrado")
	private String cuidadInvolucrado;

	@Column(name="direccion_involucrado")
	private String direccionInvolucrado;

	@Column(name="edad_involucrado")
	private Integer edadInvolucrado;

	@Column(name="estadocivil_involucrado")
	private String estadocivilInvolucrado;

	@Temporal(TemporalType.DATE)
	@Column(name="fechanac_involucrado")
	private Date fechanacInvolucrado;

	@Column(name="id_tipoinvolucrado")
	private Integer idTipoinvolucrado;

	@Column(name="nombres_involucrados")
	private String nombresInvolucrados;

	@Column(name="provincia_involucrado")
	private String provinciaInvolucrado;

	@Column(name="telefono_involucrado")
	private String telefonoInvolucrado;

	@Column(name="tiempopuestotrabajo_involucrado")
	private Integer tiempopuestotrabajoInvolucrado;

	//bi-directional many-to-one association to Incidentesaccidente
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Incidentesaccidente incidentesaccidente;

	//bi-directional one-to-one association to Tipoinvolucrado
	@OneToOne
	@JoinColumn(name="id_involucrado")
	private Tipoinvolucrado tipoinvolucrado;

	public Involucrado() {
	}

	public Integer getIdInvolucrado() {
		return this.idInvolucrado;
	}

	public void setIdInvolucrado(Integer idInvolucrado) {
		this.idInvolucrado = idInvolucrado;
	}

	public String getCargoInvolucrado() {
		return this.cargoInvolucrado;
	}

	public void setCargoInvolucrado(String cargoInvolucrado) {
		this.cargoInvolucrado = cargoInvolucrado;
	}

	public String getCedulaIncolucrado() {
		return this.cedulaIncolucrado;
	}

	public void setCedulaIncolucrado(String cedulaIncolucrado) {
		this.cedulaIncolucrado = cedulaIncolucrado;
	}

	public String getCelularInvolucrado() {
		return this.celularInvolucrado;
	}

	public void setCelularInvolucrado(String celularInvolucrado) {
		this.celularInvolucrado = celularInvolucrado;
	}

	public String getCuidadInvolucrado() {
		return this.cuidadInvolucrado;
	}

	public void setCuidadInvolucrado(String cuidadInvolucrado) {
		this.cuidadInvolucrado = cuidadInvolucrado;
	}

	public String getDireccionInvolucrado() {
		return this.direccionInvolucrado;
	}

	public void setDireccionInvolucrado(String direccionInvolucrado) {
		this.direccionInvolucrado = direccionInvolucrado;
	}

	public Integer getEdadInvolucrado() {
		return this.edadInvolucrado;
	}

	public void setEdadInvolucrado(Integer edadInvolucrado) {
		this.edadInvolucrado = edadInvolucrado;
	}

	public String getEstadocivilInvolucrado() {
		return this.estadocivilInvolucrado;
	}

	public void setEstadocivilInvolucrado(String estadocivilInvolucrado) {
		this.estadocivilInvolucrado = estadocivilInvolucrado;
	}

	public Date getFechanacInvolucrado() {
		return this.fechanacInvolucrado;
	}

	public void setFechanacInvolucrado(Date fechanacInvolucrado) {
		this.fechanacInvolucrado = fechanacInvolucrado;
	}

	public Integer getIdTipoinvolucrado() {
		return this.idTipoinvolucrado;
	}

	public void setIdTipoinvolucrado(Integer idTipoinvolucrado) {
		this.idTipoinvolucrado = idTipoinvolucrado;
	}

	public String getNombresInvolucrados() {
		return this.nombresInvolucrados;
	}

	public void setNombresInvolucrados(String nombresInvolucrados) {
		this.nombresInvolucrados = nombresInvolucrados;
	}

	public String getProvinciaInvolucrado() {
		return this.provinciaInvolucrado;
	}

	public void setProvinciaInvolucrado(String provinciaInvolucrado) {
		this.provinciaInvolucrado = provinciaInvolucrado;
	}

	public String getTelefonoInvolucrado() {
		return this.telefonoInvolucrado;
	}

	public void setTelefonoInvolucrado(String telefonoInvolucrado) {
		this.telefonoInvolucrado = telefonoInvolucrado;
	}

	public Integer getTiempopuestotrabajoInvolucrado() {
		return this.tiempopuestotrabajoInvolucrado;
	}

	public void setTiempopuestotrabajoInvolucrado(Integer tiempopuestotrabajoInvolucrado) {
		this.tiempopuestotrabajoInvolucrado = tiempopuestotrabajoInvolucrado;
	}

	public Incidentesaccidente getIncidentesaccidente() {
		return this.incidentesaccidente;
	}

	public void setIncidentesaccidente(Incidentesaccidente incidentesaccidente) {
		this.incidentesaccidente = incidentesaccidente;
	}

	public Tipoinvolucrado getTipoinvolucrado() {
		return this.tipoinvolucrado;
	}

	public void setTipoinvolucrado(Tipoinvolucrado tipoinvolucrado) {
		this.tipoinvolucrado = tipoinvolucrado;
	}

}