package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the actividad_docencia database table.
 * 
 */
@Entity
@Table(name = "actividad_docencia", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "ActividadDocencia.findAll", query = "SELECT a FROM ActividadDocencia a")
public class ActividadDocencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "actividad_docencia_idad_seq", sequenceName="actividad_docencia_idad_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="actividad_docencia_idad_seq")
	@Column(name = "id_docencia")
	private Integer idDocencia;

	private String carrera;

	@Column(name = "cod_materia")
	private String codMateria;

	private String descripcion;

	private String estado;

	@Column(name = "fecha_sis")
	private Timestamp fechaSis;

	private String materia;

	private String nced;

	private String nivel;

	@Column(name = "nro_est")
	private Integer nroEst;

	@Column(name = "num_horas_doc")
	private Integer numHorasDoc;

	@Column(name = "num_horas_semana")
	private Integer numHorasSemana;

	@Column(name = "num_paralelos")
	private Integer numParalelos;

	private String paralelo;

	private String semestre;

	@Column(name = "usuario_log")
	private String usuarioLog;

	private String validacion;

	// bi-directional many-to-one association to Carrera
	@ManyToOne
	@JoinColumn(name = "cod_carre")
	private Carre carr;

	// bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name = "id_periodo")
	private Periodo periodo;

	public ActividadDocencia() {
	}

	public Integer getIdDocencia() {
		return this.idDocencia;
	}

	public void setIdDocencia(Integer idDocencia) {
		this.idDocencia = idDocencia;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCodMateria() {
		return this.codMateria;
	}

	public void setCodMateria(String codMateria) {
		this.codMateria = codMateria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Integer getNroEst() {
		return this.nroEst;
	}

	public void setNroEst(Integer nroEst) {
		this.nroEst = nroEst;
	}

	public Integer getNumHorasDoc() {
		return this.numHorasDoc;
	}

	public void setNumHorasDoc(Integer numHorasDoc) {
		this.numHorasDoc = numHorasDoc;
	}

	public Integer getNumHorasSemana() {
		return this.numHorasSemana;
	}

	public void setNumHorasSemana(Integer numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public Integer getNumParalelos() {
		return this.numParalelos;
	}

	public void setNumParalelos(Integer numParalelos) {
		this.numParalelos = numParalelos;
	}

	public String getParalelo() {
		return this.paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
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

	public Carre getCarr() {
		return carr;
	}

	public void setCarr(Carre carr) {
		this.carr = carr;
	}
	

}