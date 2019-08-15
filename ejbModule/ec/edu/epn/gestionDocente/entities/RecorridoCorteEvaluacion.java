package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the recorrido_corte_evaluacion database table.
 * 
 */
@Entity
@Table(name="recorrido_corte_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="RecorridoCorteEvaluacion.findAll", query="SELECT r FROM RecorridoCorteEvaluacion r")
public class RecorridoCorteEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="id_recorrido_corte" , unique=true, nullable=false)
	private Integer idRecorridoCorte;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cambio")
	private Date fechaCambio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	private String tipo;

	@Column(name="id_user_cambio")
	private Integer idUserCambio;

	private String observacion;

	//bi-directional many-to-one association to CorteEvaluacion
	@ManyToOne
	@JoinColumn(name="id_corte_eval")
	private CorteEvaluacion corteEvaluacion;

	public RecorridoCorteEvaluacion() {
	}

	public Integer getIdRecorridoCorte() {
		return this.idRecorridoCorte;
	}

	public void setIdRecorridoCorte(Integer idRecorridoCorte) {
		this.idRecorridoCorte = idRecorridoCorte;
	}

	public Date getFechaCambio() {
		return this.fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public Integer getIdUserCambio() {
		return this.idUserCambio;
	}

	public void setIdUserCambio(Integer idUserCambio) {
		this.idUserCambio = idUserCambio;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public CorteEvaluacion getCorteEvaluacion() {
		return this.corteEvaluacion;
	}

	public void setCorteEvaluacion(CorteEvaluacion corteEvaluacion) {
		this.corteEvaluacion = corteEvaluacion;
	}

	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}