package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the actividad_proyectotraspaso database table.
 * 
 */
@Entity
@Table(name="actividad_proyectotraspaso")
@NamedQuery(name="ActividadProyectotraspaso.findAll", query="SELECT a FROM ActividadProyectotraspaso a")
public class ActividadProyectotraspaso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_activid_proy")
	private String idActividProy;

	private Integer a�o;

	@Column(name="cedula_dri")
	private String cedulaDri;

	@Column(name="descripcion_act_proy")
	private String descripcionActProy;

	private String estado;

	@Column(name="estado_proyecto")
	private String estadoProyecto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_finp")
	private Date fechaFinp;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inip")
	private Date fechaInip;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="id_proy")
	private String idProy;

	private String muestra;

	private String nced;

	@Column(name="nom_dri")
	private String nomDri;

	@Column(name="nom_proyecto")
	private String nomProyecto;

	@Column(name="num_horas_planific")
	private Integer numHorasPlanific;

	@Column(name="rol_proyecto")
	private String rolProyecto;

	private String semestre;

	@Column(name="tipo_proy")
	private String tipoProy;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	public ActividadProyectotraspaso() {
	}

	public String getIdActividProy() {
		return this.idActividProy;
	}

	public void setIdActividProy(String idActividProy) {
		this.idActividProy = idActividProy;
	}

	public Integer getA�o() {
		return this.a�o;
	}

	public void setA�o(Integer a�o) {
		this.a�o = a�o;
	}

	public String getCedulaDri() {
		return this.cedulaDri;
	}

	public void setCedulaDri(String cedulaDri) {
		this.cedulaDri = cedulaDri;
	}

	public String getDescripcionActProy() {
		return this.descripcionActProy;
	}

	public void setDescripcionActProy(String descripcionActProy) {
		this.descripcionActProy = descripcionActProy;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoProyecto() {
		return this.estadoProyecto;
	}

	public void setEstadoProyecto(String estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}

	public Date getFechaFinp() {
		return this.fechaFinp;
	}

	public void setFechaFinp(Date fechaFinp) {
		this.fechaFinp = fechaFinp;
	}

	public Date getFechaInip() {
		return this.fechaInip;
	}

	public void setFechaInip(Date fechaInip) {
		this.fechaInip = fechaInip;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getIdProy() {
		return this.idProy;
	}

	public void setIdProy(String idProy) {
		this.idProy = idProy;
	}

	public String getMuestra() {
		return this.muestra;
	}

	public void setMuestra(String muestra) {
		this.muestra = muestra;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomDri() {
		return this.nomDri;
	}

	public void setNomDri(String nomDri) {
		this.nomDri = nomDri;
	}

	public String getNomProyecto() {
		return this.nomProyecto;
	}

	public void setNomProyecto(String nomProyecto) {
		this.nomProyecto = nomProyecto;
	}

	public Integer getNumHorasPlanific() {
		return this.numHorasPlanific;
	}

	public void setNumHorasPlanific(Integer numHorasPlanific) {
		this.numHorasPlanific = numHorasPlanific;
	}

	public String getRolProyecto() {
		return this.rolProyecto;
	}

	public void setRolProyecto(String rolProyecto) {
		this.rolProyecto = rolProyecto;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTipoProy() {
		return this.tipoProy;
	}

	public void setTipoProy(String tipoProy) {
		this.tipoProy = tipoProy;
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