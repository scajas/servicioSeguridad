package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

/**
 * The persistent class for the tesis_dirigidas database table.
 * 
 */
@Entity

@Table(name = "tesis_dirigidas", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "TesisDirigida.findAll", query = "SELECT t FROM TesisDirigida t")
public class TesisDirigida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "tesis_dirigidas_idtd_seq", sequenceName="tesis_dirigidas_idtd_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tesis_dirigidas_idtd_seq")
	@Column(name = "id_tesis_d")
	private Integer idTesisD;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_aprobacion")
	private Date fechaAprobacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_graduacion")
	private Date fechaGraduacion;

	@Column(name = "fecha_sis")
	private Timestamp fechaSis;

	@Column(name = "horas_tesis_d")
	private Integer horasTesisD;
	// bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name = "id_periodo")
	private Periodo periodo;

	private String nced;

	private String nivel;

	@Column(name = "nombre_graduado")
	private String nombreGraduado;

	private String semestre;

	@Column(name = "tema_tesis_d")
	private String temaTesisD;

	@Column(name = "usuario_log")
	private String usuarioLog;

	private String validacion;
	
	private String path;

	public TesisDirigida() {
	}

	public Integer getIdTesisD() {
		return this.idTesisD;
	}

	public void setIdTesisD(Integer idTesisD) {
		this.idTesisD = idTesisD;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAprobacion() {
		return this.fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaGraduacion() {
		return this.fechaGraduacion;
	}

	public void setFechaGraduacion(Date fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public Integer getHorasTesisD() {
		return this.horasTesisD;
	}

	public void setHorasTesisD(Integer horasTesisD) {
		this.horasTesisD = horasTesisD;
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

	public String getNombreGraduado() {
		return this.nombreGraduado;
	}

	public void setNombreGraduado(String nombreGraduado) {
		this.nombreGraduado = nombreGraduado;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTemaTesisD() {
		return this.temaTesisD;
	}

	public void setTemaTesisD(String temaTesisD) {
		this.temaTesisD = temaTesisD;
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
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

}