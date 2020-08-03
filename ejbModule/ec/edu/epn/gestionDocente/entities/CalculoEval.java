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
 * The persistent class for the actividad_docencia database table.
 * 
 */
@Entity

@Table(name="calculo_eval",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
public class CalculoEval implements Serializable {
	private static final long serialVersionUID = 1L;		
	
	@Id
	@Column(name="id_calculo_eval")	
	@SequenceGenerator(name = "sec_calc_eval", sequenceName = "sec_calc_eval", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_calc_eval")
	private Integer idCalculoEval;

	@Column(name="id_pensum")
	private Integer idPensum;
    
	@Column(name="nced")
	private String nced;

	private Double autoev;	
	private Double coev;
	private Double heteroev;
	
	@Column(name="aprob_estud")
	private Double aprobEstudiante;
	
	@Temporal( TemporalType.DATE)
	@Column(name="fecha_calculo")
	private Date fechaCalculo;	
	

	
	/**
	 * @return the idPensum
	 */
	public Integer getIdPensum() {
		return idPensum;
	}

	/**
	 * @param idPensum the idPensum to set
	 */
	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	/**
	 * @return the nced
	 */
	public String getNced() {
		return nced;
	}

	/**
	 * @param nced the nced to set
	 */
	public void setNced(String nced) {
		this.nced = nced;
	}

	/**
	 * @return the idCalculoEval
	 */
	public Integer getIdCalculoEval() {
		return idCalculoEval;
	}

	/**
	 * @param idCalculoEval the idCalculoEval to set
	 */
	public void setIdCalculoEval(Integer idCalculoEval) {
		this.idCalculoEval = idCalculoEval;
	}

	/**
	 * @return the autoev
	 */
	public Double getAutoev() {
		return autoev;
	}

	/**
	 * @param autoev the autoev to set
	 */
	public void setAutoev(Double autoev) {
		this.autoev = autoev;
	}

	/**
	 * @return the coev
	 */
	public Double getCoev() {
		return coev;
	}

	/**
	 * @param coev the coev to set
	 */
	public void setCoev(Double coev) {
		this.coev = coev;
	}

	/**
	 * @return the heteroev
	 */
	public Double getHeteroev() {
		return heteroev;
	}

	/**
	 * @param heteroev the heteroev to set
	 */
	public void setHeteroev(Double heteroev) {
		this.heteroev = heteroev;
	}

	

	/**
	 * @return the aprobEstudiante
	 */
	public Double getAprobEstudiante() {
		return aprobEstudiante;
	}

	/**
	 * @param aprobEstudiante the aprobEstudiante to set
	 */
	public void setAprobEstudiante(Double aprobEstudiante) {
		this.aprobEstudiante = aprobEstudiante;
	}

	/**
	 * @return the fechaCalculo
	 */
	public Date getFechaCalculo() {
		return fechaCalculo;
	}

	/**
	 * @param fechaCalculo the fechaCalculo to set
	 */
	public void setFechaCalculo(Date fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}	

		
}