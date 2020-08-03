package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the planf_act_acad database table.
 * 
 */
@Entity
@Table(name="planf_act_acad",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
public class PlanfActAcademica implements Serializable {
	private static final long serialVersionUID = 1L;		
	
	
	@Id
	@Column(name="id_planf_act_acad")	
	@SequenceGenerator(name = "sec_planf_act_acad", sequenceName = "sec_planf_act_acad", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_planf_act_acad")
	private Integer idPlanfActAcad;

	@Column(name="id_pensum")
	private Integer idPensum;
    
	@Column(name="nced")
	private String nced;
	
	@Column(name="nced_dir")
	private String ncedDir;

	@Column(name="val_final_16")
	private Double valFinal16;
	
	@Column(name="val_final_8")
	private Double valFinal8;	
	
	@Temporal( TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	/**
	 * @return the idPlanfActAcad
	 */
	public Integer getIdPlanfActAcad() {
		return idPlanfActAcad;
	}

	/**
	 * @return the idPensum
	 */
	public Integer getIdPensum() {
		return idPensum;
	}

	/**
	 * @return the nced
	 */
	public String getNced() {
		return nced;
	}

	/**
	 * @return the ncedDir
	 */
	public String getNcedDir() {
		return ncedDir;
	}

	/**
	 * @return the valFinal16
	 */
	public Double getValFinal16() {
		return valFinal16;
	}

	/**
	 * @return the valFinal8
	 */
	public Double getValFinal8() {
		return valFinal8;
	}

	

	/**
	 * @param idPlanfActAcad the idPlanfActAcad to set
	 */
	public void setIdPlanfActAcad(Integer idPlanfActAcad) {
		this.idPlanfActAcad = idPlanfActAcad;
	}

	/**
	 * @param idPensum the idPensum to set
	 */
	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	/**
	 * @param nced the nced to set
	 */
	public void setNced(String nced) {
		this.nced = nced;
	}

	/**
	 * @param ncedDir the ncedDir to set
	 */
	public void setNcedDir(String ncedDir) {
		this.ncedDir = ncedDir;
	}

	/**
	 * @param valFinal16 the valFinal16 to set
	 */
	public void setValFinal16(Double valFinal16) {
		this.valFinal16 = valFinal16;
	}

	/**
	 * @param valFinal8 the valFinal8 to set
	 */
	public void setValFinal8(Double valFinal8) {
		this.valFinal8 = valFinal8;
	}

	/**
	 * @return the fechaIngreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
	

	
	
		
}