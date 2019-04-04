package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the laboratorio database table.
 * 
 */
@Entity
@Table(name = "laboratorio", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="LaboratorioLab.findAll", query="SELECT l FROM LaboratorioLab l")
public class LaboratorioLab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LABORATORIO_IDLABORATORIO_GENERATOR", sequenceName = "secuencia_laboratorio", allocationSize = 1, catalog = "bddcorpepn", schema = "`Laboratorios`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LABORATORIO_IDLABORATORIO_GENERATOR")
	@Column(name="id_laboratorio")
	private int idLaboratorio;

	@Column(name="centrocosto_l")
	private String centrocostoL;

	@Column(name="direccion_l")
	private String direccionL;

	@Column(name="email_l")
	private String emailL;

	@Column(name="fax_l")
	private String faxL;

	@Column(name="leyenda_ot_l")
	private String leyendaOtL;

	@Column(name="leyendaprof_l")
	private String leyendaprofL;

	@Column(name="nombre_l")
	private String nombreL;

	@Column(name="responsable_l")
	private String responsableL;

	@Column(name="telefono_l")
	private String telefonoL;

	//bi-directional many-to-one association to Unidad
	@ManyToOne
	@JoinColumn(name="id_unidad")
	private UnidadLabo unidad;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="laboratorio")
	private List<Servicio> servicios;

	public LaboratorioLab() {
	}

	public int getIdLaboratorio() {
		return this.idLaboratorio;
	}

	public void setIdLaboratorio(int idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getCentrocostoL() {
		return this.centrocostoL;
	}

	public void setCentrocostoL(String centrocostoL) {
		this.centrocostoL = centrocostoL;
	}

	public String getDireccionL() {
		return this.direccionL;
	}

	public void setDireccionL(String direccionL) {
		this.direccionL = direccionL;
	}

	public String getEmailL() {
		return this.emailL;
	}

	public void setEmailL(String emailL) {
		this.emailL = emailL;
	}

	public String getFaxL() {
		return this.faxL;
	}

	public void setFaxL(String faxL) {
		this.faxL = faxL;
	}

	public String getLeyendaOtL() {
		return this.leyendaOtL;
	}

	public void setLeyendaOtL(String leyendaOtL) {
		this.leyendaOtL = leyendaOtL;
	}

	public String getLeyendaprofL() {
		return this.leyendaprofL;
	}

	public void setLeyendaprofL(String leyendaprofL) {
		this.leyendaprofL = leyendaprofL;
	}

	public String getNombreL() {
		return this.nombreL;
	}

	public void setNombreL(String nombreL) {
		this.nombreL = nombreL;
	}

	public String getResponsableL() {
		return this.responsableL;
	}

	public void setResponsableL(String responsableL) {
		this.responsableL = responsableL;
	}

	public String getTelefonoL() {
		return this.telefonoL;
	}

	public void setTelefonoL(String telefonoL) {
		this.telefonoL = telefonoL;
	}

	public UnidadLabo getUnidad() {
		return this.unidad;
	}

	public void setUnidad(UnidadLabo unidad) {
		this.unidad = unidad;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setLaboratorio(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setLaboratorio(null);

		return servicio;
	}
}