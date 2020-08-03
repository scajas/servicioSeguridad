package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the actividad_administrativa database table.
 * 
 */
@Entity
@Table(name="actividad_administrativa", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="ActividadAdministrativa.findAll", query="SELECT a FROM ActividadAdministrativa a")
public class ActividadAdministrativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	
	@SequenceGenerator(name = "actividad_administrativa_idactadm_seq", sequenceName="actividad_administrativa_idactadm_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actividad_administrativa_idactadm_seq")
	
	@Column(name="id_act_adm")
	private Integer idActAdm;

	private String cargo;

	private String descripcion;

	private String descripcion1;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_adm")
	private Date fechaFinAdm;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_adm")
	private Date fechaInicioAdm;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Column(name="horas_semana")
	private Integer horasSemana;

	@Column(name="id_cargo_adm")
	private String idCargoAdm;

	private String nced;

	@Column(name="nombre_adm")
	private String nombreAdm;

	@Column(name="num_horas_adm")
	private Integer numHorasAdm;

	private String semestre;

	private String tipo;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;

	public ActividadAdministrativa() {
	}

	public Integer getIdActAdm() {
		return this.idActAdm;
	}

	public void setIdActAdm(Integer idActAdm) {
		this.idActAdm = idActAdm;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinAdm() {
		return this.fechaFinAdm;
	}

	public void setFechaFinAdm(Date fechaFinAdm) {
		this.fechaFinAdm = fechaFinAdm;
	}

	public Date getFechaInicioAdm() {
		return this.fechaInicioAdm;
	}

	public void setFechaInicioAdm(Date fechaInicioAdm) {
		this.fechaInicioAdm = fechaInicioAdm;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public Integer getHorasSemana() {
		return this.horasSemana;
	}

	public void setHorasSemana(Integer horasSemana) {
		this.horasSemana = horasSemana;
	}

	public String getIdCargoAdm() {
		return this.idCargoAdm;
	}

	public void setIdCargoAdm(String idCargoAdm) {
		this.idCargoAdm = idCargoAdm;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreAdm() {
		return this.nombreAdm;
	}

	public void setNombreAdm(String nombreAdm) {
		this.nombreAdm = nombreAdm;
	}

	public Integer getNumHorasAdm() {
		return this.numHorasAdm;
	}

	public void setNumHorasAdm(Integer numHorasAdm) {
		this.numHorasAdm = numHorasAdm;
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