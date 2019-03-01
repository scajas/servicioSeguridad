package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Dep;

import java.util.Date;

/**
 * The persistent class for the laboratorio database table.
 * 
 */
@Entity(name = "LaboratorioCatalogo")
@Table(name = "`laboratorio`", catalog = "`bddcorpepn`", schema = "`Catalogos`")
@NamedQuery(name = "LaboratorioCatalogo.findAll", query = "SELECT l FROM LaboratorioCatalogo l order by l.nombreL")
public class Laboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_lab")
	private String idLab;

	@Column(name = "centrocosto_l")
	private String centrocostoL;

	@Column(name = "descripcion_lab")
	private String descripcionLab;

	@Column(name = "direccion_l")
	private String direccionL;

	@Column(name = "email_l")
	private String emailL;

	@Column(name = "fax_l")
	private String faxL;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_aut")
	private Date fechaAut;

	@Column(name = "id_unidad")
	private Integer idUnidad;

	@Column(name = "id_usuario_aut")
	private Integer idUsuarioAut;

	@Column(name = "leyenda_ot_l")
	private String leyendaOtL;

	@Column(name = "leyendaprof_l")
	private String leyendaprofL;

	@Column(name = "nom_jefe_lab")
	private String nomJefeLab;

	@Column(name = "nombre_l")
	private String nombreL;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "responsable_l")
	private String responsableL;

	@Column(name = "telefono_l")
	private String telefonoL;

	private String extension;
	private String docencia;
	private String investigacion;
	private String servicios;
	private String url;
	private Integer edificio;
	private String ubicacion;

	// bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name = "coddep")
	private Dep departamento;

	private String tipo;

	public Laboratorio() {
	}

	public String getIdLab() {
		return this.idLab;
	}

	public void setIdLab(String idLab) {
		this.idLab = idLab;
	}

	public String getCentrocostoL() {
		return this.centrocostoL;
	}

	public void setCentrocostoL(String centrocostoL) {
		this.centrocostoL = centrocostoL;
	}

	public String getDescripcionLab() {
		return this.descripcionLab;
	}

	public void setDescripcionLab(String descripcionLab) {
		this.descripcionLab = descripcionLab;
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

	public Date getFechaAut() {
		return this.fechaAut;
	}

	public void setFechaAut(Date fechaAut) {
		this.fechaAut = fechaAut;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Integer getIdUsuarioAut() {
		return this.idUsuarioAut;
	}

	public void setIdUsuarioAut(Integer idUsuarioAut) {
		this.idUsuarioAut = idUsuarioAut;
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

	public String getNomJefeLab() {
		return this.nomJefeLab;
	}

	public void setNomJefeLab(String nomJefeLab) {
		this.nomJefeLab = nomJefeLab;
	}

	public String getNombreL() {
		return this.nombreL;
	}

	public void setNombreL(String nombreL) {
		this.nombreL = nombreL;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public Dep getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Dep departamento) {
		this.departamento = departamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDocencia() {
		return docencia;
	}

	public void setDocencia(String docencia) {
		this.docencia = docencia;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public String getInvestigacion() {
		return investigacion;
	}

	public void setInvestigacion(String investigacion) {
		this.investigacion = investigacion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getEdificio() {
		return edificio;
	}

	public void setEdificio(Integer edificio) {
		this.edificio = edificio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}