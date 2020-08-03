package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the capacitacion database table.
 * 
 */
@Entity
@Table(name="capacitacion", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="Capacitacion.findAll", query="SELECT c FROM Capacitacion c order by c.fechaInicioCapac")
public class Capacitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CAPAC_IDPUBLIC_GENERATOR", sequenceName="capacitacion_idcap_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAPAC_IDPUBLIC_GENERATOR")
	@Column(name="id_capac")
	private Integer idCapac;

	@Column(name="clase_capacitacion")
	private String claseCapacitacion;

	@Column(name="contenido_capac")
	private String contenidoCapac;

	private String dirigidoa;

	@Column(name="doc_obtenido")
	private String docObtenido;

	private String estado;

	@Column(name="facilitador_capac")
	private String facilitadorCapac;

	@Column(name="fecha_fin_capac")
	private String fechaFinCapac;

	@Column(name="fecha_inicio_capac")
	private String fechaInicioCapac;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="horas_capac")
	private Integer horasCapac;

	@ManyToOne
	@JoinColumn(name = "id_periodo")
	private Periodo periodo;

	@Column(name="lugar_capac")
	private String lugarCapac;

	private String mencion;

	@Column(name="metodologia_capac")
	private String metodologiaCapac;

	private String nced;

	@Column(name="nombre_capac")
	private String nombreCapac;

	@Column(name="observaciones_capac")
	private String observacionesCapac;

	@Column(name="pais_capac")
	private String paisCapac;

	private String semestre;

	private String tipo;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;
	
	private String validarevalorazion ;
	private Date  fechavalidarevaloriacion;
	private String validarecategorza;
	private Date fechavalidarecategoriza;
	private String categoria;
	private String path;

	public Capacitacion() {
	}

	public Integer getIdCapac() {
		return this.idCapac;
	}

	public void setIdCapac(Integer idCapac) {
		this.idCapac = idCapac;
	}

	public String getClaseCapacitacion() {
		return this.claseCapacitacion;
	}

	public void setClaseCapacitacion(String claseCapacitacion) {
		this.claseCapacitacion = claseCapacitacion;
	}

	public String getContenidoCapac() {
		return this.contenidoCapac;
	}

	public void setContenidoCapac(String contenidoCapac) {
		this.contenidoCapac = contenidoCapac;
	}

	public String getDirigidoa() {
		return this.dirigidoa;
	}

	public void setDirigidoa(String dirigidoa) {
		this.dirigidoa = dirigidoa;
	}

	public String getDocObtenido() {
		return this.docObtenido;
	}

	public void setDocObtenido(String docObtenido) {
		this.docObtenido = docObtenido;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFacilitadorCapac() {
		return this.facilitadorCapac;
	}

	public void setFacilitadorCapac(String facilitadorCapac) {
		this.facilitadorCapac = facilitadorCapac;
	}

	public String getFechaFinCapac() {
		return this.fechaFinCapac;
	}

	public void setFechaFinCapac(String fechaFinCapac) {
		this.fechaFinCapac = fechaFinCapac;
	}

	public String getFechaInicioCapac() {
		return this.fechaInicioCapac;
	}

	public void setFechaInicioCapac(String fechaInicioCapac) {
		this.fechaInicioCapac = fechaInicioCapac;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public Integer getHorasCapac() {
		return this.horasCapac;
	}

	public void setHorasCapac(Integer horasCapac) {
		this.horasCapac = horasCapac;
	}

	

	public String getLugarCapac() {
		return this.lugarCapac;
	}

	public void setLugarCapac(String lugarCapac) {
		this.lugarCapac = lugarCapac;
	}

	public String getMencion() {
		return this.mencion;
	}

	public void setMencion(String mencion) {
		this.mencion = mencion;
	}

	public String getMetodologiaCapac() {
		return this.metodologiaCapac;
	}

	public void setMetodologiaCapac(String metodologiaCapac) {
		this.metodologiaCapac = metodologiaCapac;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreCapac() {
		return this.nombreCapac;
	}

	public void setNombreCapac(String nombreCapac) {
		this.nombreCapac = nombreCapac;
	}

	public String getObservacionesCapac() {
		return this.observacionesCapac;
	}

	public void setObservacionesCapac(String observacionesCapac) {
		this.observacionesCapac = observacionesCapac;
	}

	public String getPaisCapac() {
		return this.paisCapac;
	}

	public void setPaisCapac(String paisCapac) {
		this.paisCapac = paisCapac;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public Date getFechavalidarecategoriza() {
		return fechavalidarecategoriza;
	}

	public void setFechavalidarecategoriza(Date fechavalidarecategoriza) {
		this.fechavalidarecategoriza = fechavalidarecategoriza;
	}

	public Date getFechavalidarevaloriacion() {
		return fechavalidarevaloriacion;
	}

	public void setFechavalidarevaloriacion(Date fechavalidarevaloriacion) {
		this.fechavalidarevaloriacion = fechavalidarevaloriacion;
	}

	public String getValidarecategorza() {
		return validarecategorza;
	}

	public void setValidarecategorza(String validarecategorza) {
		this.validarecategorza = validarecategorza;
	}

	public String getValidarevalorazion() {
		return validarevalorazion;
	}

	public void setValidarevalorazion(String validarevalorazion) {
		this.validarevalorazion = validarevalorazion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	

}