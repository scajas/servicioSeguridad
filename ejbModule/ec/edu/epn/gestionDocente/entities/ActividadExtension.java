package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the actividad_extension database table.
 * 
 */
@Entity
@Table(name="actividad_extension", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="ActividadExtension.findAll", query="SELECT a FROM ActividadExtension a")
public class ActividadExtension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "actividad_extension_idae_seq", sequenceName="actividad_extension_idae_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actividad_extension_idae_seq")
	@Column(name="id_activid_extens")
	private Integer idActividExtens;

	private String cliente;

	@Column(name="descripcion_aext")
	private String descripcionAext;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_activid")
	private Date fechaActivid;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="id_tipo_ext")
	private String idTipoExt;

	private String nced;

	@Column(name="nombre_act")
	private String nombreAct;

	@Column(name="num_horas_extens")
	private Integer numHorasExtens;

	private String ocupacion;

	@Column(name="orden_trabajo")
	private String ordenTrabajo;

	private String semestre;

	private String tipo;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name="fecha_activid_fin")
	private Date fechaActividFin;*/
	
	
	

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	public ActividadExtension() {
	}

	public Integer getIdActividExtens() {
		return this.idActividExtens;
	}

	public void setIdActividExtens(Integer idActividExtens) {
		this.idActividExtens = idActividExtens;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDescripcionAext() {
		return this.descripcionAext;
	}

	public void setDescripcionAext(String descripcionAext) {
		this.descripcionAext = descripcionAext;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActivid() {
		return this.fechaActivid;
	}

	public void setFechaActivid(Date fechaActivid) {
		this.fechaActivid = fechaActivid;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getIdTipoExt() {
		return this.idTipoExt;
	}

	public void setIdTipoExt(String idTipoExt) {
		this.idTipoExt = idTipoExt;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreAct() {
		return this.nombreAct;
	}

	public void setNombreAct(String nombreAct) {
		this.nombreAct = nombreAct;
	}

	public Integer getNumHorasExtens() {
		return this.numHorasExtens;
	}

	public void setNumHorasExtens(Integer numHorasExtens) {
		this.numHorasExtens = numHorasExtens;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getOrdenTrabajo() {
		return this.ordenTrabajo;
	}

	public void setOrdenTrabajo(String ordenTrabajo) {
		this.ordenTrabajo = ordenTrabajo;
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

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	

}