package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.*;


/**
 * The persistent class for the subactividad_evaluacion database table.
 * 
 */
@Entity
@Table(name="subactividad_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="SubactividadEvaluacion.findAll", query="SELECT s FROM SubactividadEvaluacion s")
public class SubactividadEvaluacion implements Serializable {
	

	private static final long serialVersionUID = -1667669004887350449L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_subactividad_evaluacion")
	@SequenceGenerator(name = "\"GestionDocente\".sec_subactividad_evaluacion", sequenceName = "\"GestionDocente\".sec_subactividad_evaluacion", allocationSize = 1)
	@Column(name="id_subactividad_eval")
	private Integer idSubactividadEval;

	@Column(name="horas_auto")
	private Double horasAuto;

	@Column(name="horas_coe")
	private Double horasCoe;

	@Column(name="horas_planif")
	private Double horasPlanif;

	@Column(name="nombre_subactividad")
	private String nombreSubactividad;
	
	@Column(name="cumpl_auto")
	private Double cumplAuto;
	
	@Column(name="cumpl_coe")
	private Double cumplCoe;
	
	/**VARIABLES PARA CALCULOS CON DECIMAL (2)*/
	
	@Transient
	private BigDecimal horasAutoDecimal;
	
	@Transient
	private BigDecimal horasCoeDecimal;
	
	@Transient
	private BigDecimal horasPlanifDecimal;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="id_actividad_eval")
	private ActividadEvaluacion actividadEvaluacion;

	public SubactividadEvaluacion() {
	}

	public Integer getIdSubactividadEval() {
		return this.idSubactividadEval;
	}

	public void setIdSubactividadEval(Integer idSubactividadEval) {
		this.idSubactividadEval = idSubactividadEval;
	}

	public Double getHorasAuto() {
		return this.horasAuto;
	}

	public void setHorasAuto(Double horasAuto) {
		this.horasAuto = horasAuto;
	}

	public Double getHorasCoe() {
		return this.horasCoe;
	}

	public void setHorasCoe(Double horasCoe) {
		this.horasCoe = horasCoe;
	}

	public Double getHorasPlanif() {
		return this.horasPlanif;
	}

	public void setHorasPlanif(Double horasPlanif) {
		this.horasPlanif = horasPlanif;
	}
	

	public String getNombreSubactividad() {
		return this.nombreSubactividad;
	}

	public void setNombreSubactividad(String nombreSubactividad) {
		this.nombreSubactividad = nombreSubactividad;
	}

	/**
	 * @return the actividadEvaluacion
	 */
	public ActividadEvaluacion getActividadEvaluacion() {
		return actividadEvaluacion;
	}

	/**
	 * @param actividadEvaluacion the actividadEvaluacion to set
	 */
	public void setActividadEvaluacion(ActividadEvaluacion actividadEvaluacion) {
		this.actividadEvaluacion = actividadEvaluacion;
	}

	/**
	 * @return the horasAutoDecimal
	 */
	public BigDecimal getHorasAutoDecimal() {
		horasAutoDecimal = new BigDecimal(horasAuto==null?0.0:horasAuto);
		return horasAutoDecimal.setScale(2, RoundingMode.HALF_UP);
		//return horasAutoDecimal;
	}

	/**
	 * @return the horasCoeDecimal
	 */
	public BigDecimal getHorasCoeDecimal() {
		horasCoeDecimal = new BigDecimal(horasCoe==null?0.0:horasCoe);
		return horasCoeDecimal.setScale(2, RoundingMode.HALF_UP);
		//return horasCoeDecimal;
	}

	/**
	 * @return the horasPlanifDecimal
	 */
	public BigDecimal getHorasPlanifDecimal() {
		horasPlanifDecimal = new BigDecimal(horasPlanif==null?0.0:horasPlanif);
		return horasPlanifDecimal.setScale(2, RoundingMode.HALF_UP);	
		//return horasPlanifDecimal;
	}

	/**
	 * @param horasAutoDecimal the horasAutoDecimal to set
	 */
	public void setHorasAutoDecimal(BigDecimal horasAutoDecimal) {
		this.horasAutoDecimal = horasAutoDecimal;
	}

	/**
	 * @param horasCoeDecimal the horasCoeDecimal to set
	 */
	public void setHorasCoeDecimal(BigDecimal horasCoeDecimal) {
		this.horasCoeDecimal = horasCoeDecimal;
	}

	/**
	 * @param horasPlanifDecimal the horasPlanifDecimal to set
	 */
	public void setHorasPlanifDecimal(BigDecimal horasPlanifDecimal) {
		this.horasPlanifDecimal = horasPlanifDecimal;
	}

	/**
	 * @return the cumplAuto
	 */
	public Double getCumplAuto() {
		return cumplAuto;
	}

	/**
	 * @return the cumplCoe
	 */
	public Double getCumplCoe() {
		return cumplCoe;
	}

	/**
	 * @param cumplAuto the cumplAuto to set
	 */
	public void setCumplAuto(Double cumplAuto) {
		this.cumplAuto = cumplAuto;
	}

	/**
	 * @param cumplCoe the cumplCoe to set
	 */
	public void setCumplCoe(Double cumplCoe) {
		this.cumplCoe = cumplCoe;
	}

}