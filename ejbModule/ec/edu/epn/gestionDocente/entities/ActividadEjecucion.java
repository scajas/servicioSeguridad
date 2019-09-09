package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the actividad_ejecucion database table.
 * 
 */
@Entity
@Table(name="actividad_ejecucion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="ActividadEjecucion.findAll", query="SELECT a FROM ActividadEjecucion a")
public class ActividadEjecucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_actv_ejec")
	@SequenceGenerator(name = "\"GestionDocente\".sec_actv_ejec", sequenceName = "\"GestionDocente\".sec_actv_ejec", allocationSize = 1)	
	@Column(name="id_actv_ejec")
	private Integer idActvEjec;

	@Column(name="calf_ponderada_auto")
	private Double calfPonderadaAuto;

	@Column(name="calf_ponderada_coe")
	private Double calfPonderadaCoe;

	@Column(name="cumplimiento_auto")
	private Double cumplimientoAuto;

	@Column(name="cumplimiento_coe")
	private Double cumplimientoCoe;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_auto")
	private Date fechaAuto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_coe")
	private Date fechaCoe;

	@Column(name="id_tipo_actv_eval")
	private Integer idTipoActvEval;

	@Column(name="id_usr_auto")
	private Integer idUsrAuto;

	@Column(name="id_usr_coe")
	private Integer idUsrCoe;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="val_actv_doc_hrs_dentro")
	private String valActvDocHrsDentro;
	
	@Column(name="valor_planif")
	private Double valorPlanif;

	@Column(name="valor_auto")
	private Double valorAuto;

	@Column(name="valor_coe")
	private Double valorCoe;
	
	@Column(name="id_actv_eval")
	private Integer idActvEvaluacion;
	
/*	@Column(name="semestre_acad")
	private Double semestreAcad;*/

	@ManyToOne
	@JoinColumn(name="id_catalogo_actividad")
	private ReglamentoEvaluacion reglamentoEvaluacion;
	
	//bi-directional many-to-one association to EvaluacionAcademica
	@ManyToOne
	@JoinColumn(name="id_eval_acad")
	private EvaluacionAcademica evaluacionAcademica;
	
	
	/***PARA CALCULOS DE VALORES CON 2 DECIMALES*/
	
	@Transient
	private BigDecimal valorPlanifDecimal;
	
	@Transient
	private BigDecimal valorAutoDecimal;
	
	@Transient
	private BigDecimal cumplimientoAutoDecimal;
	
	@Transient
	private BigDecimal calfPonderadaAutoDecimal;
	
	@Transient
	private BigDecimal valorCoeDecimal;
	
	@Transient
	private BigDecimal cumplimientoCoeDecimal;
	
	@Transient
	private BigDecimal calfPonderadaCoeDecimal;
	
	
	public ActividadEjecucion() {
	}

	public Integer getIdActvEjec() {
		return this.idActvEjec;
	}

	public void setIdActvEjec(Integer idActvEjec) {
		this.idActvEjec = idActvEjec;
	}

	public Double getCalfPonderadaAuto() {
		return this.calfPonderadaAuto;
	}

	public void setCalfPonderadaAuto(Double calfPonderadaAuto) {
		this.calfPonderadaAuto = calfPonderadaAuto;
	}

	public Double getCalfPonderadaCoe() {
		return this.calfPonderadaCoe;
	}

	public void setCalfPonderadaCoe(Double calfPonderadaCoe) {
		this.calfPonderadaCoe = calfPonderadaCoe;
	}

	public Double getCumplimientoAuto() {
		return this.cumplimientoAuto;
	}

	public void setCumplimientoAuto(Double cumplimientoAuto) {
		this.cumplimientoAuto = cumplimientoAuto;
	}

	public Double getCumplimientoCoe() {
		return this.cumplimientoCoe;
	}

	public void setCumplimientoCoe(Double cumplimientoCoe) {
		this.cumplimientoCoe = cumplimientoCoe;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAuto() {
		return this.fechaAuto;
	}

	public void setFechaAuto(Date fechaAuto) {
		this.fechaAuto = fechaAuto;
	}

	public Date getFechaCoe() {
		return this.fechaCoe;
	}

	public void setFechaCoe(Date fechaCoe) {
		this.fechaCoe = fechaCoe;
	}

	

	public Integer getIdTipoActvEval() {
		return this.idTipoActvEval;
	}

	public void setIdTipoActvEval(Integer idTipoActvEval) {
		this.idTipoActvEval = idTipoActvEval;
	}

	public Integer getIdUsrAuto() {
		return this.idUsrAuto;
	}

	public void setIdUsrAuto(Integer idUsrAuto) {
		this.idUsrAuto = idUsrAuto;
	}

	public Integer getIdUsrCoe() {
		return this.idUsrCoe;
	}

	public void setIdUsrCoe(Integer idUsrCoe) {
		this.idUsrCoe = idUsrCoe;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getValActvDocHrsDentro() {
		return this.valActvDocHrsDentro;
	}

	public void setValActvDocHrsDentro(String valActvDocHrsDentro) {
		this.valActvDocHrsDentro = valActvDocHrsDentro;
	}

	/**
	 * @return the valorAuto
	 */
	public Double getValorAuto() {
		return valorAuto;
	}

	/**
	 * @return the valorCoe
	 */
	public Double getValorCoe() {
		return valorCoe;
	}

	/**
	 * @param valorAuto the valorAuto to set
	 */
	public void setValorAuto(Double valorAuto) {
		this.valorAuto = valorAuto;
	}

	/**
	 * @param valorCoe the valorCoe to set
	 */
	public void setValorCoe(Double valorCoe) {
		this.valorCoe = valorCoe;
	}

	/**
	 * @return the reglamentoEvaluacion
	 */
	public ReglamentoEvaluacion getReglamentoEvaluacion() {
		return reglamentoEvaluacion;
	}

	/**
	 * @return the evaluacionAcademica
	 */
	public EvaluacionAcademica getEvaluacionAcademica() {
		return evaluacionAcademica;
	}

	/**
	 * @param reglamentoEvaluacion the reglamentoEvaluacion to set
	 */
	public void setReglamentoEvaluacion(ReglamentoEvaluacion reglamentoEvaluacion) {
		this.reglamentoEvaluacion = reglamentoEvaluacion;
	}

	/**
	 * @param evaluacionAcademica the evaluacionAcademica to set
	 */
	public void setEvaluacionAcademica(EvaluacionAcademica evaluacionAcademica) {
		this.evaluacionAcademica = evaluacionAcademica;
	}

	/**
	 * @return the valorPlanifDecimal
	 */
	public BigDecimal getValorPlanifDecimal() {
		
		valorPlanifDecimal = new BigDecimal(valorPlanif==null?0.0:valorPlanif);
		return valorPlanifDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the valorAutoDecimal
	 */
	public BigDecimal getValorAutoDecimal() {
		
		valorAutoDecimal = new BigDecimal(valorAuto==null?0.0:valorAuto);
		return valorAutoDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the cumplimientoAutoDecimal
	 */
	public BigDecimal getCumplimientoAutoDecimal() {
		
		cumplimientoAutoDecimal = new BigDecimal(cumplimientoAuto==null?0.0:cumplimientoAuto);
		return cumplimientoAutoDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the calfPonderadaAutoDecimal
	 */
	public BigDecimal getCalfPonderadaAutoDecimal() {
		calfPonderadaAutoDecimal = new BigDecimal(calfPonderadaAuto==null?0.0:calfPonderadaAuto);
		return calfPonderadaAutoDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the valorCoeDecimal
	 */
	public BigDecimal getValorCoeDecimal() {
		valorCoeDecimal = new BigDecimal(valorCoe==null?0.0:valorCoe);
		return valorCoeDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the cumplimientoCoeDecimal
	 */
	public BigDecimal getCumplimientoCoeDecimal() {
		cumplimientoCoeDecimal = new BigDecimal(cumplimientoCoe==null?0.0:cumplimientoCoe);
		return cumplimientoCoeDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the calfPonderadaCoeDecimal
	 */
	public BigDecimal getCalfPonderadaCoeDecimal() {
		calfPonderadaCoeDecimal = new BigDecimal(calfPonderadaCoe==null?0.0:calfPonderadaCoe);
		return calfPonderadaCoeDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @param valorPlanifDecimal the valorPlanifDecimal to set
	 */
	public void setValorPlanifDecimal(BigDecimal valorPlanifDecimal) {
		this.valorPlanifDecimal = valorPlanifDecimal;
	}

	/**
	 * @param valorAutoDecimal the valorAutoDecimal to set
	 */
	public void setValorAutoDecimal(BigDecimal valorAutoDecimal) {
		this.valorAutoDecimal = valorAutoDecimal;
	}

	/**
	 * @param cumplimientoAutoDecimal the cumplimientoAutoDecimal to set
	 */
	public void setCumplimientoAutoDecimal(BigDecimal cumplimientoAutoDecimal) {
		this.cumplimientoAutoDecimal = cumplimientoAutoDecimal;
	}

	/**
	 * @param calfPonderadaAutoDecimal the calfPonderadaAutoDecimal to set
	 */
	public void setCalfPonderadaAutoDecimal(BigDecimal calfPonderadaAutoDecimal) {
		this.calfPonderadaAutoDecimal = calfPonderadaAutoDecimal;
	}

	/**
	 * @param valorCoeDecimal the valorCoeDecimal to set
	 */
	public void setValorCoeDecimal(BigDecimal valorCoeDecimal) {
		this.valorCoeDecimal = valorCoeDecimal;
	}

	/**
	 * @param cumplimientoCoeDecimal the cumplimientoCoeDecimal to set
	 */
	public void setCumplimientoCoeDecimal(BigDecimal cumplimientoCoeDecimal) {
		this.cumplimientoCoeDecimal = cumplimientoCoeDecimal;
	}

	/**
	 * @param calfPonderadaCoeDecimal the calfPonderadaCoeDecimal to set
	 */
	public void setCalfPonderadaCoeDecimal(BigDecimal calfPonderadaCoeDecimal) {
		this.calfPonderadaCoeDecimal = calfPonderadaCoeDecimal;
	}

	/**
	 * @return the valorPlanif
	 */
	public Double getValorPlanif() {
		return valorPlanif;
	}

	/**
	 * @param valorPlanif the valorPlanif to set
	 */
	public void setValorPlanif(Double valorPlanif) {
		this.valorPlanif = valorPlanif;
	}

	/**
	 * @return the idActvEvaluacion
	 */
	public Integer getIdActvEvaluacion() {
		return idActvEvaluacion;
	}

	/**
	 * @param idActvEvaluacion the idActvEvaluacion to set
	 */
	public void setIdActvEvaluacion(Integer idActvEvaluacion) {
		this.idActvEvaluacion = idActvEvaluacion;
	}

	
	
}