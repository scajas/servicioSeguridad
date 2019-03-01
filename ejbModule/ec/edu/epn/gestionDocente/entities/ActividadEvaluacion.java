package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the actividad_evaluacion database table.
 * 
 */
@Entity
@Table(name="actividad_evaluacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="ActividadEvaluacion.findAll", query="SELECT a FROM ActividadEvaluacion a")
public class ActividadEvaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_actividad_evaluacion")
	@SequenceGenerator(name = "\"GestionDocente\".sec_actividad_evaluacion", sequenceName = "\"GestionDocente\".sec_actividad_evaluacion", allocationSize = 1)
	@Column(name="id_actividad_evaluacion")
	private Integer idActividadEvaluacion;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="valor_16_planif")
	private Double valor16Planif;	
	
	@Column(name="valor_8_planif")
	private Double valor8Planif;	
	
	@Column(name="valor_16_auto")	
	private Double valor16Auto;
	
	@Column(name="cumplimiento_auto")
	private Double cumplimientoAuto;
	
	@Column(name="calificacion_ponderada_auto")
	private Double calificacionPonderadaAuto;
	
	@Column(name="valor_16_coe")
	private Double valor16Coe;
	
	@Column(name="cumplimiento_coe")
	private Double cumplimientoCoe;	
	 
	@Column(name="calificacion_ponderada_coe")
	private Double calificacionPonderadaCoe;
	
	
	@Column(name="id_usuario_planif")
	private Integer idUsuarioPlanif;	
	
	@Column(name="id_usuario_auto")
	private Integer idUsuarioAuto;	
	
	@Column(name="id_usuario_coe")
	private Integer idUsuarioCoe;
	
	@Column(name="fecha_planif")
	private Date fechaPlanif;
	
	@Column(name="fecha_auto")
	private Date fechaAuto;
	
	@Column(name="fecha_coe")
	private Date fechaCoe;
	
	
	private String descripcion;
	
	@Column(name="val_actv_doc_hrs_dentro")
	private String valActvDocHrsDentro;
	
	
	@ManyToOne
	@JoinColumn(name="id_catalogo_actividad")
	private ReglamentoEvaluacion reglamentoEvaluacion;
	
	//bi-directional many-to-one association to EvaluacionAcademica
	@ManyToOne
	@JoinColumn(name="id_eval_acad")
	private EvaluacionAcademica evaluacionAcademica;
	
	@Column(name="id_tipo_actv_eval")
	private Integer idTipoActvEval;
	
	
	
	/**VALORES PARA PRESENTACION DE INFORMACION CON 2 DECIMALES*/	
	@Transient
	private BigDecimal valor16PlanifDecimal;
	
	@Transient
	private BigDecimal valor16AutoDecimal;
	
	@Transient
	private BigDecimal cumplimientoAutoDecimal;
	
	@Transient
	private BigDecimal calificacionPonderadaAutoDecimal;
	
	@Transient
	private BigDecimal valor16CoeDecimal;
	
	@Transient
	private BigDecimal cumplimientoCoeDecimal;
	
	@Transient
	private BigDecimal calificacionPonderadaCoeDecimal;
	

	public ActividadEvaluacion() {
	}

	public Integer getIdActividadEvaluacion() {
		return this.idActividadEvaluacion;
	}

	public void setIdActividadEvaluacion(Integer idActividadEvaluacion) {
		this.idActividadEvaluacion = idActividadEvaluacion;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	

	public EvaluacionAcademica getEvaluacionAcademica() {
		return this.evaluacionAcademica;
	}

	public void setEvaluacionAcademica(EvaluacionAcademica evaluacionAcademica) {
		this.evaluacionAcademica = evaluacionAcademica;
	}


	/**
	 * @return the idTipoActvEval
	 */
	public Integer getIdTipoActvEval() {
		return idTipoActvEval;
	}

	/**
	 * @param idTipoActvEval the idTipoActvEval to set
	 */
	public void setIdTipoActvEval(Integer idTipoActvEval) {
		this.idTipoActvEval = idTipoActvEval;
	}

	

	/**
	 * @return the valor16Planif
	 */
	public Double getValor16Planif() {
		return valor16Planif;
	}

	/**
	 * @param valor16Planif the valor16Planif to set
	 */
	public void setValor16Planif(Double valor16Planif) {
		this.valor16Planif = valor16Planif;
	}

	/**
	 * @return the valor16Auto
	 */
	public Double getValor16Auto() {		
		return valor16Auto;
	}

	/**
	 * @param valor16Auto the valor16Auto to set
	 */
	public void setValor16Auto(Double valor16Auto) {
		this.valor16Auto = valor16Auto;
	}

	/**
	 * @return the cumplimientoAuto
	 */
	public Double getCumplimientoAuto() {
		return cumplimientoAuto;
	}

	/**
	 * @param cumplimientoAuto the cumplimientoAuto to set
	 */
	public void setCumplimientoAuto(Double cumplimientoAuto) {
		this.cumplimientoAuto = cumplimientoAuto;
	}

	/**
	 * @return the calificacionPonderadaAuto
	 */
	public Double getCalificacionPonderadaAuto() {
		return calificacionPonderadaAuto;
	}

	/**
	 * @param calificacionPonderadaAuto the calificacionPonderadaAuto to set
	 */
	public void setCalificacionPonderadaAuto(Double calificacionPonderadaAuto) {
		this.calificacionPonderadaAuto = calificacionPonderadaAuto;
	}

	/**
	 * @return the valor16Coe
	 */
	public Double getValor16Coe() {
		return valor16Coe;
	}

	/**
	 * @param valor16Coe the valor16Coe to set
	 */
	public void setValor16Coe(Double valor16Coe) {
		this.valor16Coe = valor16Coe;
	}

	/**
	 * @return the cumplimientoCoe
	 */
	public Double getCumplimientoCoe() {
		return cumplimientoCoe;
	}

	/**
	 * @param cumplimientoCoe the cumplimientoCoe to set
	 */
	public void setCumplimientoCoe(Double cumplimientoCoe) {
		this.cumplimientoCoe = cumplimientoCoe;
	}

	/**
	 * @return the calificacionPonderadaCoe
	 */
	public Double getCalificacionPonderadaCoe() {
		return calificacionPonderadaCoe;
	}

	/**
	 * @param calificacionPonderadaCoe the calificacionPonderadaCoe to set
	 */
	public void setCalificacionPonderadaCoe(Double calificacionPonderadaCoe) {
		this.calificacionPonderadaCoe = calificacionPonderadaCoe;
	}

	

	
	/**
	 * @return the valor8Planif
	 */
	public Double getValor8Planif() {
		return valor8Planif;
	}

	/**
	 * @param valor8Planif the valor8Planif to set
	 */
	public void setValor8Planif(Double valor8Planif) {
		this.valor8Planif = valor8Planif;
	}

	/**
	 * @return the idUsuarioPlanif
	 */
	public Integer getIdUsuarioPlanif() {
		return idUsuarioPlanif;
	}

	/**
	 * @param idUsuarioPlanif the idUsuarioPlanif to set
	 */
	public void setIdUsuarioPlanif(Integer idUsuarioPlanif) {
		this.idUsuarioPlanif = idUsuarioPlanif;
	}

	/**
	 * @return the idUsuarioAuto
	 */
	public Integer getIdUsuarioAuto() {
		return idUsuarioAuto;
	}

	/**
	 * @param idUsuarioAuto the idUsuarioAuto to set
	 */
	public void setIdUsuarioAuto(Integer idUsuarioAuto) {
		this.idUsuarioAuto = idUsuarioAuto;
	}

	/**
	 * @return the idUsuarioCoe
	 */
	public Integer getIdUsuarioCoe() {
		return idUsuarioCoe;
	}

	/**
	 * @param idUsuarioCoe the idUsuarioCoe to set
	 */
	public void setIdUsuarioCoe(Integer idUsuarioCoe) {
		this.idUsuarioCoe = idUsuarioCoe;
	}

	/**
	 * @return the fechaPlanif
	 */
	public Date getFechaPlanif() {
		return fechaPlanif;
	}

	/**
	 * @param fechaPlanif the fechaPlanif to set
	 */
	public void setFechaPlanif(Date fechaPlanif) {
		this.fechaPlanif = fechaPlanif;
	}

	/**
	 * @return the fechaAuto
	 */
	public Date getFechaAuto() {
		return fechaAuto;
	}

	/**
	 * @param fechaAuto the fechaAuto to set
	 */
	public void setFechaAuto(Date fechaAuto) {
		this.fechaAuto = fechaAuto;
	}

	/**
	 * @return the fechaCoe
	 */
	public Date getFechaCoe() {
		return fechaCoe;
	}

	/**
	 * @param fechaCoe the fechaCoe to set
	 */
	public void setFechaCoe(Date fechaCoe) {
		this.fechaCoe = fechaCoe;
	}

	/**
	 * @return the valActvDocHrsDentro
	 */
	public String getValActvDocHrsDentro() {
		return valActvDocHrsDentro;
	}

	/**
	 * @param valActvDocHrsDentro the valActvDocHrsDentro to set
	 */
	public void setValActvDocHrsDentro(String valActvDocHrsDentro) {
		this.valActvDocHrsDentro = valActvDocHrsDentro;
	}

	/**
	 * @return the reglamentoEvaluacion
	 */
	public ReglamentoEvaluacion getReglamentoEvaluacion() {
		return reglamentoEvaluacion;
	}

	/**
	 * @param reglamentoEvaluacion the reglamentoEvaluacion to set
	 */
	public void setReglamentoEvaluacion(ReglamentoEvaluacion reglamentoEvaluacion) {
		this.reglamentoEvaluacion = reglamentoEvaluacion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the valor16PlanifDecimal
	 */
	public BigDecimal getValor16PlanifDecimal() {		
		
		valor16PlanifDecimal = new BigDecimal(valor16Planif==null?0.0:valor16Planif);
		return valor16PlanifDecimal.setScale(2, RoundingMode.HALF_UP);
		//return valor16PlanifDecimal;
	}

	/**
	 * @return the valor16AutoDecimal
	 */
	public BigDecimal getValor16AutoDecimal() {
		valor16AutoDecimal = new BigDecimal(valor16Auto==null?0.0:valor16Auto);
		return valor16AutoDecimal.setScale(2, RoundingMode.HALF_UP);
		//return valor16AutoDecimal;
	}

	/**
	 * @return the cumplimientoAutoDecimal
	 */
	public BigDecimal getCumplimientoAutoDecimal() {
		cumplimientoAutoDecimal = new BigDecimal(cumplimientoAuto==null?0.0:cumplimientoAuto);
		return cumplimientoAutoDecimal.setScale(2, RoundingMode.HALF_UP);
		//return cumplimientoAutoDecimal;
	}

	/**
	 * @return the calificacionPonderadaAutoDecimal
	 */
	public BigDecimal getCalificacionPonderadaAutoDecimal() {
		calificacionPonderadaAutoDecimal = new BigDecimal(calificacionPonderadaAuto==null?0.0:calificacionPonderadaAuto);
		return calificacionPonderadaAutoDecimal.setScale(2, RoundingMode.HALF_UP);
		//return calificacionPonderadaAutoDecimal;
	}

	/**
	 * @return the valor16CoeDecimal
	 */
	public BigDecimal getValor16CoeDecimal() {
		valor16CoeDecimal = new BigDecimal(valor16Coe==null?0.0:valor16Coe);
		return valor16CoeDecimal.setScale(2, RoundingMode.HALF_UP);
		//return valor16CoeDecimal;
	}

	/**
	 * @return the cumplimientoCoeDecimal
	 */
	public BigDecimal getCumplimientoCoeDecimal() {
		cumplimientoCoeDecimal = new BigDecimal(cumplimientoCoe==null?0.0:cumplimientoCoe);
		return cumplimientoCoeDecimal.setScale(2, RoundingMode.HALF_UP);
		//return cumplimientoCoeDecimal;
	}

	/**
	 * @return the calificacionPonderadaCoeDecimal
	 */
	public BigDecimal getCalificacionPonderadaCoeDecimal() {
		calificacionPonderadaCoeDecimal = new BigDecimal(calificacionPonderadaCoe==null?0.0:calificacionPonderadaCoe);
		return calificacionPonderadaCoeDecimal.setScale(2, RoundingMode.HALF_UP);
		//return calificacionPonderadaCoeDecimal;
	}

	/**
	 * @param valor16PlanifDecimal the valor16PlanifDecimal to set
	 */
	public void setValor16PlanifDecimal(BigDecimal valor16PlanifDecimal) {		
		this.valor16PlanifDecimal = valor16PlanifDecimal;
	}

	/**
	 * @param valor16AutoDecimal the valor16AutoDecimal to set
	 */
	public void setValor16AutoDecimal(BigDecimal valor16AutoDecimal) {
		this.valor16AutoDecimal = valor16AutoDecimal;
	}

	/**
	 * @param cumplimientoAutoDecimal the cumplimientoAutoDecimal to set
	 */
	public void setCumplimientoAutoDecimal(BigDecimal cumplimientoAutoDecimal) {
		this.cumplimientoAutoDecimal = cumplimientoAutoDecimal;
	}

	/**
	 * @param calificacionPonderadaAutoDecimal the calificacionPonderadaAutoDecimal to set
	 */
	public void setCalificacionPonderadaAutoDecimal(BigDecimal calificacionPonderadaAutoDecimal) {
		this.calificacionPonderadaAutoDecimal = calificacionPonderadaAutoDecimal;
	}

	/**
	 * @param valor16CoeDecimal the valor16CoeDecimal to set
	 */
	public void setValor16CoeDecimal(BigDecimal valor16CoeDecimal) {
		this.valor16CoeDecimal = valor16CoeDecimal;
	}

	/**
	 * @param cumplimientoCoeDecimal the cumplimientoCoeDecimal to set
	 */
	public void setCumplimientoCoeDecimal(BigDecimal cumplimientoCoeDecimal) {
		this.cumplimientoCoeDecimal = cumplimientoCoeDecimal;
	}

	/**
	 * @param calificacionPonderadaCoeDecimal the calificacionPonderadaCoeDecimal to set
	 */
	public void setCalificacionPonderadaCoeDecimal(BigDecimal calificacionPonderadaCoeDecimal) {
		this.calificacionPonderadaCoeDecimal = calificacionPonderadaCoeDecimal;
	}

	
	

}