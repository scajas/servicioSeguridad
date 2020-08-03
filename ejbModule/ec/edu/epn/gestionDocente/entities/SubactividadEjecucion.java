package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.*;


/**
 * The persistent class for the subactividad_ejecucion database table.
 * 
 */
@Entity
@Table(name="subactividad_ejecucion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="SubactividadEjecucion.findAll", query="SELECT s FROM SubactividadEjecucion s")
public class SubactividadEjecucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"GestionDocente\".sec_sub_actv_ejec")
	@SequenceGenerator(name = "\"GestionDocente\".sec_sub_actv_ejec", sequenceName = "\"GestionDocente\".sec_sub_actv_ejec", allocationSize = 1)
	@Column(name="id_subactv_ejec")
	private Integer idSubactvEjec;

	@Column(name="cumpl_auto")
	private Double cumplAuto;

	@Column(name="cumpl_coe")
	private Double cumplCoe;
	
	@Column(name="horas_planif")
	private Double horasPlanif;
	

	@Column(name="horas_auto")
	private Double horasAuto;

	@Column(name="horas_coe")
	private Double horasCoe;

	@Column(name="nombre_subactv")
	private String nombreSubactv;
	
	@Column(name="id_subactv_eval")
	private Integer idSubactvEvaluacion;
	
	
	@Transient
	private BigDecimal cumplAutoDecimal;
	
	@Transient
	private BigDecimal cumplCoeDecimal;
	
	@Transient
	private BigDecimal horasPlanifDecimal;
	
	@Transient
	private BigDecimal horasAutoDecimal;
	
	@Transient
	private BigDecimal horasCoeDecimal;

	//bi-directional many-to-one association to ActividadEjecucion
	@ManyToOne
	@JoinColumn(name="id_actv_ejec")
	private ActividadEjecucion actividadEjecucion;

	public SubactividadEjecucion() {
	}

	public Integer getIdSubactvEjec() {
		return this.idSubactvEjec;
	}

	public void setIdSubactvEjec(Integer idSubactvEjec) {
		this.idSubactvEjec = idSubactvEjec;
	}

	public Double getCumplAuto() {
		return this.cumplAuto;
	}

	public void setCumplAuto(Double cumplAuto) {
		this.cumplAuto = cumplAuto;
	}

	public Double getCumplCoe() {
		return this.cumplCoe;
	}

	public void setCumplCoe(Double cumplCoe) {
		this.cumplCoe = cumplCoe;
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

	public String getNombreSubactv() {
		return this.nombreSubactv;
	}

	public void setNombreSubactv(String nombreSubactv) {
		this.nombreSubactv = nombreSubactv;
	}

	public ActividadEjecucion getActividadEjecucion() {
		return this.actividadEjecucion;
	}

	public void setActividadEjecucion(ActividadEjecucion actividadEjecucion) {
		this.actividadEjecucion = actividadEjecucion;
	}

	/**
	 * @return the horasAutoDecimal
	 */
	public BigDecimal getHorasAutoDecimal() {
		horasAutoDecimal = new BigDecimal(horasAuto==null?0.0:horasAuto);
		return horasAutoDecimal.setScale(2, RoundingMode.HALF_UP);
		
	}

	/**
	 * @return the horasCoeDecimal
	 */
	public BigDecimal getHorasCoeDecimal() {
		horasCoeDecimal = new BigDecimal(horasCoe==null?0.0:horasCoe);
		return horasCoeDecimal.setScale(2, RoundingMode.HALF_UP);		
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
	 * @return the horasPlanif
	 */
	public Double getHorasPlanif() {
		return horasPlanif;
	}

	/**
	 * @param horasPlanif the horasPlanif to set
	 */
	public void setHorasPlanif(Double horasPlanif) {
		this.horasPlanif = horasPlanif;
	}

	

	/**
	 * @return the idSubactvEvaluacion
	 */
	public Integer getIdSubactvEvaluacion() {
		return idSubactvEvaluacion;
	}

	/**
	 * @param idSubactvEvaluacion the idSubactvEvaluacion to set
	 */
	public void setIdSubactvEvaluacion(Integer idSubactvEvaluacion) {
		this.idSubactvEvaluacion = idSubactvEvaluacion;
	}

	/**
	 * @return the cumplAutoDecimal
	 */
	public BigDecimal getCumplAutoDecimal() {
		cumplAutoDecimal = new BigDecimal(cumplAuto==null?0.0:cumplAuto);
		return cumplAutoDecimal.setScale(2, RoundingMode.HALF_UP);
		
	}

	/**
	 * @return the cumplCoeDecimal
	 */
	public BigDecimal getCumplCoeDecimal() {
		cumplCoeDecimal = new BigDecimal(cumplCoe==null?0.0:cumplCoe);
		return cumplCoeDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @return the horasPlanifDecimal
	 */
	public BigDecimal getHorasPlanifDecimal() {
		horasPlanifDecimal = new BigDecimal(horasPlanif==null?0.0:horasPlanif);
		return horasPlanifDecimal.setScale(2, RoundingMode.HALF_UP);		
	}

	/**
	 * @param cumplAutoDecimal the cumplAutoDecimal to set
	 */
	public void setCumplAutoDecimal(BigDecimal cumplAutoDecimal) {
		this.cumplAutoDecimal = cumplAutoDecimal;
	}

	/**
	 * @param cumplCoeDecimal the cumplCoeDecimal to set
	 */
	public void setCumplCoeDecimal(BigDecimal cumplCoeDecimal) {
		this.cumplCoeDecimal = cumplCoeDecimal;
	}

	/**
	 * @param horasPlanifDecimal the horasPlanifDecimal to set
	 */
	public void setHorasPlanifDecimal(BigDecimal horasPlanifDecimal) {
		this.horasPlanifDecimal = horasPlanifDecimal;
	}

}