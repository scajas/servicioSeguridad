package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the tesis_calificadas database table.
 * 
 */
@Entity
@Table(name="tesis_calificadas", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="TesisCalificada.findAll", query="SELECT t FROM TesisCalificada t")
public class TesisCalificada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "tesis_calificadas_idtc_seq", sequenceName="tesis_calificadas_idtc_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tesis_calificadas_idtc_seq")
	@Column(name="id_tesis_c")
	private Integer idTesisC;

	private String carrera;

	@Column(name="descripcion_tc")
	private String descripcionTc;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_calificacion")
	private Date fechaCalificacion;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;
	
	@ManyToOne
	@JoinColumn(name = "id_periodo")
	private Periodo periodo;

	private String nced;

	private String nivel;

	@Column(name="num_hr_tc")
	private Integer numHrTc;

	private String semestre;

	@Column(name="tema_tesis_c")
	private String temaTesisC;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String validacion;
	
	private String path;

	public TesisCalificada() {
	}

	public Integer getIdTesisC() {
		return this.idTesisC;
	}

	public void setIdTesisC(Integer idTesisC) {
		this.idTesisC = idTesisC;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getDescripcionTc() {
		return this.descripcionTc;
	}

	public void setDescripcionTc(String descripcionTc) {
		this.descripcionTc = descripcionTc;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCalificacion() {
		return this.fechaCalificacion;
	}

	public void setFechaCalificacion(Date fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
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

	public Integer getNumHrTc() {
		return this.numHrTc;
	}

	public void setNumHrTc(Integer numHrTc) {
		this.numHrTc = numHrTc;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTemaTesisC() {
		return this.temaTesisC;
	}

	public void setTemaTesisC(String temaTesisC) {
		this.temaTesisC = temaTesisC;
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