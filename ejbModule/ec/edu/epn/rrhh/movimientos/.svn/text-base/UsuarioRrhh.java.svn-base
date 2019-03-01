package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="UsuarioRrhh.findAll", query="SELECT u FROM UsuarioRrhh u")
public class UsuarioRrhh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String activo;

	private String cedula;

	private String clave;

	private String claveenc;

	private String claveok;

	private String dep1;

	private String dep2;

	private String dep3;

	private String dep4;

	private String email;

	private String estmail;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="id_bodega")
	private String idBodega;

	@Column(name="id_carrera")
	private String idCarrera;

	@Column(name="id_depart")
	private Integer idDepart;

	@Column(name="id_facultad")
	private String idFacultad;

	@Column(name="id_laboratorio")
	private String idLaboratorio;

	@Column(name="id_personal")
	private String idPersonal;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	private String nombres;

	private String pathfirma;

	@Column(name="plan_trabajo")
	private String planTrabajo;

	private String prueba;

	@Column(name="tipo_u")
	private String tipoU;

	private String usercambio;

	//bi-directional many-to-many association to Accionespersonalbtn
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="usuarioaccion"
		, joinColumns={
			@JoinColumn(name="id_usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_accionbtn")
			}
		)
	private List<Accionespersonalbtn> accionespersonalbtns;

	public UsuarioRrhh() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClaveenc() {
		return this.claveenc;
	}

	public void setClaveenc(String claveenc) {
		this.claveenc = claveenc;
	}

	public String getClaveok() {
		return this.claveok;
	}

	public void setClaveok(String claveok) {
		this.claveok = claveok;
	}

	public String getDep1() {
		return this.dep1;
	}

	public void setDep1(String dep1) {
		this.dep1 = dep1;
	}

	public String getDep2() {
		return this.dep2;
	}

	public void setDep2(String dep2) {
		this.dep2 = dep2;
	}

	public String getDep3() {
		return this.dep3;
	}

	public void setDep3(String dep3) {
		this.dep3 = dep3;
	}

	public String getDep4() {
		return this.dep4;
	}

	public void setDep4(String dep4) {
		this.dep4 = dep4;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstmail() {
		return this.estmail;
	}

	public void setEstmail(String estmail) {
		this.estmail = estmail;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}

	public String getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Integer getIdDepart() {
		return this.idDepart;
	}

	public void setIdDepart(Integer idDepart) {
		this.idDepart = idDepart;
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getIdLaboratorio() {
		return this.idLaboratorio;
	}

	public void setIdLaboratorio(String idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public String getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPathfirma() {
		return this.pathfirma;
	}

	public void setPathfirma(String pathfirma) {
		this.pathfirma = pathfirma;
	}

	public String getPlanTrabajo() {
		return this.planTrabajo;
	}

	public void setPlanTrabajo(String planTrabajo) {
		this.planTrabajo = planTrabajo;
	}

	public String getPrueba() {
		return this.prueba;
	}

	public void setPrueba(String prueba) {
		this.prueba = prueba;
	}

	public String getTipoU() {
		return this.tipoU;
	}

	public void setTipoU(String tipoU) {
		this.tipoU = tipoU;
	}

	public String getUsercambio() {
		return this.usercambio;
	}

	public void setUsercambio(String usercambio) {
		this.usercambio = usercambio;
	}

	public List<Accionespersonalbtn> getAccionespersonalbtns() {
		return this.accionespersonalbtns;
	}

	public void setAccionespersonalbtns(List<Accionespersonalbtn> accionespersonalbtns) {
		this.accionespersonalbtns = accionespersonalbtns;
	}

}