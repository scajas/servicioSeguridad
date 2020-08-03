package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the actividad_docencia database table.
 * 
 */
@Entity

@Table(name="act_academica",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
public class ActAcademica implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name="id_act_academica")	
	@SequenceGenerator(name = "sec_act_academica", sequenceName = "sec_act_academica", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_act_academica")
	private Integer idActAcademica;

	@Column(name="id_tipo_planif_act_acad")
	private Integer idTipoPlanifActAcad;
    
	@Column(name="nombre_actividad")
	private String nombreActividad;

	
	@Column(name="valor_16")
	private Double valor16;	
	
	@Column(name="valor_8")
	private Double valor8;
	
	@ManyToOne
	@JoinColumn(name="id_planf_act_acad")
	private PlanfActAcademica planfActAcad;

	/**
	 * @return the idActAcademica
	 */
	public Integer getIdActAcademica() {
		return idActAcademica;
	}

	/**
	 * @return the idTipoPlanifActAcad
	 */
	public Integer getIdTipoPlanifActAcad() {
		return idTipoPlanifActAcad;
	}

	/**
	 * @return the nombreActividad
	 */
	public String getNombreActividad() {
		return nombreActividad;
	}

	/**
	 * @return the valor16
	 */
	public Double getValor16() {
		return valor16;
	}

	/**
	 * @return the valor8
	 */
	public Double getValor8() {
		return valor8;
	}

	/**
	 * @return the planfActAcad
	 */
	public PlanfActAcademica getPlanfActAcad() {
		return planfActAcad;
	}

	/**
	 * @param idActAcademica the idActAcademica to set
	 */
	public void setIdActAcademica(Integer idActAcademica) {
		this.idActAcademica = idActAcademica;
	}

	/**
	 * @param idTipoPlanifActAcad the idTipoPlanifActAcad to set
	 */
	public void setIdTipoPlanifActAcad(Integer idTipoPlanifActAcad) {
		this.idTipoPlanifActAcad = idTipoPlanifActAcad;
	}

	/**
	 * @param nombreActividad the nombreActividad to set
	 */
	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	/**
	 * @param valor16 the valor16 to set
	 */
	public void setValor16(Double valor16) {
		this.valor16 = valor16;
	}

	/**
	 * @param valor8 the valor8 to set
	 */
	public void setValor8(Double valor8) {
		this.valor8 = valor8;
	}

	/**
	 * @param planfActAcad the planfActAcad to set
	 */
	public void setPlanfActAcad(PlanfActAcademica planfActAcad) {
		this.planfActAcad = planfActAcad;
	}

		
}