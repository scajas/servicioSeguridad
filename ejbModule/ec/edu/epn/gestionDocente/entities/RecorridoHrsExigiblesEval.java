package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.epn.seguridad.vo.Usuario;


/**
 * The persistent class for the recorrido_hrs_exigibles_eval database table.
 * 
 */
@Entity
@Table(name="recorrido_hrs_exigibles_eval",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="RecorridoHrsExigiblesEval.findAll", query="SELECT r FROM RecorridoHrsExigiblesEval r")
public class RecorridoHrsExigiblesEval implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4942079483200571958L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rec_hrs_exigibles_eval")
	private Integer idRecorridoHrsExigiblesEval;
	
	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;
	

	
	@ManyToOne
	@JoinColumn(name="ingresado_por")
	private Usuario usuario;

	@Column(name="id_eval_acad")
	private Integer idEvalAcad;

	private String observacion;
	
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	private String tipo;
	
	private String dedicacion;
	
	@Column(name="dias_laborables")
	private Double diasLaborables;
	
	@Column(name="dias_descanso")
	private Double diasDescanso;
	
	@Column(name="horas_dedicacion")
	private Double horasDedicacion;
	
	@Column(name="promedio_horas")
	private Double promedioHoras;
	
	@Column(name="dias_permiso")
	private Double diasPermiso;
	
	@Column(name="dias_vacacion")
	private Double diasVacacion;
	
	@Column(name="horas_permiso")
	private Double horasPermiso;
	
	@Column(name="horas_vacacion")
	private Double horasVacacion;
	
	@Column(name="horas_exigibles")
	private Double horasExigibles;

	/**
	 * @return the fechaIngreso
	 */
	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @return the diasLaborables
	 */
	public Double getDiasLaborables() {
		return diasLaborables;
	}

	/**
	 * @return the diasDescanso
	 */
	public Double getDiasDescanso() {
		return diasDescanso;
	}

	/**
	 * @return the horasDedicacion
	 */
	public Double getHorasDedicacion() {
		return horasDedicacion;
	}

	/**
	 * @return the diasPermiso
	 */
	public Double getDiasPermiso() {
		return diasPermiso;
	}

	/**
	 * @return the diasVacacion
	 */
	public Double getDiasVacacion() {
		return diasVacacion;
	}

	/**
	 * @return the horasPermiso
	 */
	public Double getHorasPermiso() {
		return horasPermiso;
	}

	/**
	 * @return the horasVacacion
	 */
	public Double getHorasVacacion() {
		return horasVacacion;
	}

	/**
	 * @return the horasExigibles
	 */
	public Double getHorasExigibles() {
		return horasExigibles;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @param dedicacion the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @param diasLaborables the diasLaborables to set
	 */
	public void setDiasLaborables(Double diasLaborables) {
		this.diasLaborables = diasLaborables;
	}

	/**
	 * @param diasDescanso the diasDescanso to set
	 */
	public void setDiasDescanso(Double diasDescanso) {
		this.diasDescanso = diasDescanso;
	}

	/**
	 * @param horasDedicacion the horasDedicacion to set
	 */
	public void setHorasDedicacion(Double horasDedicacion) {
		this.horasDedicacion = horasDedicacion;
	}

	/**
	 * @param diasPermiso the diasPermiso to set
	 */
	public void setDiasPermiso(Double diasPermiso) {
		this.diasPermiso = diasPermiso;
	}

	/**
	 * @param diasVacacion the diasVacacion to set
	 */
	public void setDiasVacacion(Double diasVacacion) {
		this.diasVacacion = diasVacacion;
	}

	/**
	 * @param horasPermiso the horasPermiso to set
	 */
	public void setHorasPermiso(Double horasPermiso) {
		this.horasPermiso = horasPermiso;
	}

	/**
	 * @param horasVacacion the horasVacacion to set
	 */
	public void setHorasVacacion(Double horasVacacion) {
		this.horasVacacion = horasVacacion;
	}

	/**
	 * @param horasExigibles the horasExigibles to set
	 */
	public void setHorasExigibles(Double horasExigibles) {
		this.horasExigibles = horasExigibles;
	}

	/**
	 * @return the idRecorridoHrsExigiblesEval
	 */
	public Integer getIdRecorridoHrsExigiblesEval() {
		return idRecorridoHrsExigiblesEval;
	}

	

	/**
	 * @return the idEvalAcad
	 */
	public Integer getIdEvalAcad() {
		return idEvalAcad;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the promedioHoras
	 */
	public Double getPromedioHoras() {
		return promedioHoras;
	}

	/**
	 * @param idRecorridoHrsExigiblesEval the idRecorridoHrsExigiblesEval to set
	 */
	public void setIdRecorridoHrsExigiblesEval(Integer idRecorridoHrsExigiblesEval) {
		this.idRecorridoHrsExigiblesEval = idRecorridoHrsExigiblesEval;
	}

	

	/**
	 * @param idEvalAcad the idEvalAcad to set
	 */
	public void setIdEvalAcad(Integer idEvalAcad) {
		this.idEvalAcad = idEvalAcad;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param promedioHoras the promedioHoras to set
	 */
	public void setPromedioHoras(Double promedioHoras) {
		this.promedioHoras = promedioHoras;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
}