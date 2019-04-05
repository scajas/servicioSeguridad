package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity
@Table(name = "`personal`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Personal.findAll", query="SELECT p FROM Personal p")
public class PersonalLab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_personal")
	private String idPersonal;

	@Column(name="aux_idpersonal")
	private Integer auxIdpersonal;

	@Column(name="cargo_pe")
	private String cargoPe;

	@Column(name="cedula_pe")
	private String cedulaPe;

	@Column(name="direccion_pe")
	private String direccionPe;

	@Column(name="email_pe")
	private String emailPe;

	@Temporal(TemporalType.DATE)
	@Column(name="fechafin_pe")
	private Date fechafinPe;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaing_pe")
	private Date fechaingPe;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="nombres_pe")
	private String nombresPe;

	@Column(name="sueldo_pe")
	private double sueldoPe;

	@Column(name="telefono_pe")
	private String telefonoPe;

	@Column(name="tipo_pe")
	private String tipoPe;

	//bi-directional many-to-one association to Detalleorden
	@OneToMany(mappedBy="personal")
	private List<Detalleorden> detalleordens;

	//bi-directional many-to-one association to Cargospersonal
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargospersonal cargospersonal;

	//bi-directional many-to-one association to Tipopersonal
	@ManyToOne
	@JoinColumn(name="id_tipopersonal")
	private Tipopersonal tipopersonal;

	public PersonalLab() {
	}

	public String getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Integer getAuxIdpersonal() {
		return this.auxIdpersonal;
	}

	public void setAuxIdpersonal(Integer auxIdpersonal) {
		this.auxIdpersonal = auxIdpersonal;
	}

	public String getCargoPe() {
		return this.cargoPe;
	}

	public void setCargoPe(String cargoPe) {
		this.cargoPe = cargoPe;
	}

	public String getCedulaPe() {
		return this.cedulaPe;
	}

	public void setCedulaPe(String cedulaPe) {
		this.cedulaPe = cedulaPe;
	}

	public String getDireccionPe() {
		return this.direccionPe;
	}

	public void setDireccionPe(String direccionPe) {
		this.direccionPe = direccionPe;
	}

	public String getEmailPe() {
		return this.emailPe;
	}

	public void setEmailPe(String emailPe) {
		this.emailPe = emailPe;
	}

	public Date getFechafinPe() {
		return this.fechafinPe;
	}

	public void setFechafinPe(Date fechafinPe) {
		this.fechafinPe = fechafinPe;
	}

	public Date getFechaingPe() {
		return this.fechaingPe;
	}

	public void setFechaingPe(Date fechaingPe) {
		this.fechaingPe = fechaingPe;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getNombresPe() {
		return this.nombresPe;
	}

	public void setNombresPe(String nombresPe) {
		this.nombresPe = nombresPe;
	}

	public double getSueldoPe() {
		return this.sueldoPe;
	}

	public void setSueldoPe(double sueldoPe) {
		this.sueldoPe = sueldoPe;
	}

	public String getTelefonoPe() {
		return this.telefonoPe;
	}

	public void setTelefonoPe(String telefonoPe) {
		this.telefonoPe = telefonoPe;
	}

	public String getTipoPe() {
		return this.tipoPe;
	}

	public void setTipoPe(String tipoPe) {
		this.tipoPe = tipoPe;
	}

	public List<Detalleorden> getDetalleordens() {
		return this.detalleordens;
	}

	public void setDetalleordens(List<Detalleorden> detalleordens) {
		this.detalleordens = detalleordens;
	}

	public Detalleorden addDetalleorden(Detalleorden detalleorden) {
		getDetalleordens().add(detalleorden);
		detalleorden.setPersonal(this);

		return detalleorden;
	}

	public Detalleorden removeDetalleorden(Detalleorden detalleorden) {
		getDetalleordens().remove(detalleorden);
		detalleorden.setPersonal(null);

		return detalleorden;
	}

	public Cargospersonal getCargospersonal() {
		return this.cargospersonal;
	}

	public void setCargospersonal(Cargospersonal cargospersonal) {
		this.cargospersonal = cargospersonal;
	}

	public Tipopersonal getTipopersonal() {
		return this.tipopersonal;
	}

	public void setTipopersonal(Tipopersonal tipopersonal) {
		this.tipopersonal = tipopersonal;
	}

}