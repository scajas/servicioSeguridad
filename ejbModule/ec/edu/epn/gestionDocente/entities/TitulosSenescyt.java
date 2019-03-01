package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "titulosSenescyt" database table.
 * 
 */
@Entity
@Table(name="\"titulosSenescyt\"")
@NamedQuery(name="TitulosSenescyt.findAll", query="SELECT t FROM TitulosSenescyt t")
public class TitulosSenescyt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String area;

	private String areacodigo;

	private String cedula;

	private String codigo;

	private String escalafondocente;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	private Date fechagrado;

	private String ies;

	private String iesextranjeracolegioprofesional;

	private String listadopertenece;

	private String nacionalidad;

	private String nivel;

	private String nombreclasificacion;

	private String nombredetallecampo;

	private String nombres;

	private String observacion;

	private String reconocidopor;

	@Column(name="registro_senescyt")
	private String registroSenescyt;

	private String sexo;

	private String subarea;

	private String subareacodigo;

	private String tipoextranjerocolegio;

	private String tiponivel;

	private String tiptitulo;

	@Column(name="titulo_docente")
	private String tituloDocente;

	private String universidad;

	public TitulosSenescyt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreacodigo() {
		return this.areacodigo;
	}

	public void setAreacodigo(String areacodigo) {
		this.areacodigo = areacodigo;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEscalafondocente() {
		return this.escalafondocente;
	}

	public void setEscalafondocente(String escalafondocente) {
		this.escalafondocente = escalafondocente;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechagrado() {
		return this.fechagrado;
	}

	public void setFechagrado(Date fechagrado) {
		this.fechagrado = fechagrado;
	}

	public String getIes() {
		return this.ies;
	}

	public void setIes(String ies) {
		this.ies = ies;
	}

	public String getIesextranjeracolegioprofesional() {
		return this.iesextranjeracolegioprofesional;
	}

	public void setIesextranjeracolegioprofesional(String iesextranjeracolegioprofesional) {
		this.iesextranjeracolegioprofesional = iesextranjeracolegioprofesional;
	}

	public String getListadopertenece() {
		return this.listadopertenece;
	}

	public void setListadopertenece(String listadopertenece) {
		this.listadopertenece = listadopertenece;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNombreclasificacion() {
		return this.nombreclasificacion;
	}

	public void setNombreclasificacion(String nombreclasificacion) {
		this.nombreclasificacion = nombreclasificacion;
	}

	public String getNombredetallecampo() {
		return this.nombredetallecampo;
	}

	public void setNombredetallecampo(String nombredetallecampo) {
		this.nombredetallecampo = nombredetallecampo;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getReconocidopor() {
		return this.reconocidopor;
	}

	public void setReconocidopor(String reconocidopor) {
		this.reconocidopor = reconocidopor;
	}

	public String getRegistroSenescyt() {
		return this.registroSenescyt;
	}

	public void setRegistroSenescyt(String registroSenescyt) {
		this.registroSenescyt = registroSenescyt;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSubarea() {
		return this.subarea;
	}

	public void setSubarea(String subarea) {
		this.subarea = subarea;
	}

	public String getSubareacodigo() {
		return this.subareacodigo;
	}

	public void setSubareacodigo(String subareacodigo) {
		this.subareacodigo = subareacodigo;
	}

	public String getTipoextranjerocolegio() {
		return this.tipoextranjerocolegio;
	}

	public void setTipoextranjerocolegio(String tipoextranjerocolegio) {
		this.tipoextranjerocolegio = tipoextranjerocolegio;
	}

	public String getTiponivel() {
		return this.tiponivel;
	}

	public void setTiponivel(String tiponivel) {
		this.tiponivel = tiponivel;
	}

	public String getTiptitulo() {
		return this.tiptitulo;
	}

	public void setTiptitulo(String tiptitulo) {
		this.tiptitulo = tiptitulo;
	}

	public String getTituloDocente() {
		return this.tituloDocente;
	}

	public void setTituloDocente(String tituloDocente) {
		this.tituloDocente = tituloDocente;
	}

	public String getUniversidad() {
		return this.universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

}