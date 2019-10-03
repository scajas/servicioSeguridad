package ec.edu.epn.seguridad.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.edu.epn.catalogos.entities.FacultadCatalogos;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_usuario")
	@SequenceGenerator(name = "secUsuario", sequenceName = "sec_usuario", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secUsuario")
	private long id;
	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	private String clave;

	private String cedula;

	private String activo;


	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")

	private Date fechaCreacion;
	@Column(name = "id_personal")

	private String idPersonal;

	private int id_unidad;

	private String dep1;

	private String dep2;

	private String dep3;

	private String dep4;
	
	private String usercambio;

	@Column(name = "tipo_u")
	private String tipoE;

	@Column(name = "email")
	private String email;

	@Column(name = "id_carrera")
	private String idcarrera;

	private String pathfirma;

	// private String id_laboratorio;
	// private String id_bodega;
	@ManyToMany(mappedBy = "usuarios")
	private List<Perfil> perfiles;

	@Column(name = "nombres")
	private String nombreapellido;

	@ManyToOne
	@JoinColumn(name = "id_facultad")
	private FacultadCatalogos facultad;

	public FacultadCatalogos getFacultad() {
		return facultad;
	}

	public void setFacultad(FacultadCatalogos facultad) {
		this.facultad = facultad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public int getId_unidad() {
		return id_unidad;
	}

	public void setId_unidad(int idUnidad) {
		id_unidad = idUnidad;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public String getNombreapellido() {
		return nombreapellido;
	}

	public void setNombreapellido(String nombreapellido) {
		this.nombreapellido = nombreapellido;
	}

	public String getTipoE() {
		return tipoE;
	}

	public void setTipoE(String tipoE) {
		this.tipoE = tipoE;
	}

	public String getDep1() {
		return dep1;
	}

	public void setDep1(String dep1) {
		this.dep1 = dep1;
	}

	public String getDep2() {
		return dep2;
	}

	public void setDep2(String dep2) {
		this.dep2 = dep2;
	}

	public String getDep3() {
		return dep3;
	}

	public void setDep3(String dep3) {
		this.dep3 = dep3;
	}

	public String getDep4() {
		return dep4;
	}

	public void setDep4(String dep4) {
		this.dep4 = dep4;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcarrera() {
		return idcarrera;
	}

	public void setIdcarrera(String idcarrera) {
		this.idcarrera = idcarrera;
	}

	public String getPathfirma() {
		return pathfirma;
	}

	public void setPathfirma(String pathfirma) {
		this.pathfirma = pathfirma;
	}

	public String getUsercambio() {
		return usercambio;
	}

	public void setUsercambio(String usercambio) {
		this.usercambio = usercambio;
	}

	/**
	 * @return the activo
	 */
	public String getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(String activo) {
		this.activo = activo;
	}

}
