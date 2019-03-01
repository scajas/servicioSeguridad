package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the compromiso_evaluacion database table.
 * 
 */
@Entity
@Table(name="compromiso_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="CompromisoEvaluacion.findAll", query="SELECT c FROM CompromisoEvaluacion c")
public class CompromisoEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_compromiso_eval")
	@SequenceGenerator(name = "\"GestionDocente\".sec_compromiso_eval", sequenceName = "\"GestionDocente\".sec_compromiso_eval", allocationSize = 1)
	@Column(name="id_compromiso_eval")
	private Integer idCompromisoEval;

	private String actividad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="id_eval_acad")
	private Integer idEvalAcad;

	private String responable;
	
	@Column(name="fecha_ingreso")
	private Date fecha_ingreso;
	
	@Column(name="id_usuario_ingreso")
	private Integer id_usuario_ingreso;
	
	@Column(name="id_usuario_act")
	private Integer id_usuario_act;
	

	public CompromisoEvaluacion() {
	}

	public Integer getIdCompromisoEval() {
		return this.idCompromisoEval;
	}

	public void setIdCompromisoEval(Integer idCompromisoEval) {
		this.idCompromisoEval = idCompromisoEval;
	}

	public String getActividad() {
		return this.actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getIdEvalAcad() {
		return this.idEvalAcad;
	}

	public void setIdEvalAcad(Integer idEvalAcad) {
		this.idEvalAcad = idEvalAcad;
	}

	public String getResponable() {
		return this.responable;
	}

	public void setResponable(String responable) {
		this.responable = responable;
	}

	/**
	 * @return the fecha_ingreso
	 */
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	/**
	 * @return the id_usuario_ingreso
	 */
	public Integer getId_usuario_ingreso() {
		return id_usuario_ingreso;
	}

	/**
	 * @return the id_usuario_act
	 */
	public Integer getId_usuario_act() {
		return id_usuario_act;
	}

	/**
	 * @param fecha_ingreso the fecha_ingreso to set
	 */
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	/**
	 * @param id_usuario_ingreso the id_usuario_ingreso to set
	 */
	public void setId_usuario_ingreso(Integer id_usuario_ingreso) {
		this.id_usuario_ingreso = id_usuario_ingreso;
	}

	/**
	 * @param id_usuario_act the id_usuario_act to set
	 */
	public void setId_usuario_act(Integer id_usuario_act) {
		this.id_usuario_act = id_usuario_act;
	}

}