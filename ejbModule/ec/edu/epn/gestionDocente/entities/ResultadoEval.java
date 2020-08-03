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

@Table(name="resultado_eval",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
public class ResultadoEval implements Serializable {
	private static final long serialVersionUID = 1L;	
	
	
	@Id
	@Column(name="id_resultado_eval")	
	@SequenceGenerator(name = "sec_resultados_eval", sequenceName = "sec_resultados_eval", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_resultados_eval")
	private Integer idResultadoEval;

	@Column(name="id_pensum")
	private Integer idPensum;
    
	@Column(name="nced")
	private String nced;

	@Column(name="nced_dir")
	private String ncedDir;

	@Column(name="nota_final")
	private Double notaFinal;

	@Column(name="tipo_eval")
	private String tipoEval;
	
	@Temporal( TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;	
	

	/**
	 * @return the idResultadoEval
	 */
	public Integer getIdResultadoEval() {
		return idResultadoEval;
	}

	/**
	 * @param idResultadoEval the idResultadoEval to set
	 */
	public void setIdResultadoEval(Integer idResultadoEval) {
		this.idResultadoEval = idResultadoEval;
	}

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
	 * @return the ncedDir
	 */
	public String getNcedDir() {
		return ncedDir;
	}

	/**
	 * @param ncedDir the ncedDir to set
	 */
	public void setNcedDir(String ncedDir) {
		this.ncedDir = ncedDir;
	}

	/**
	 * @return the notaFinal
	 */
	public Double getNotaFinal() {
		return notaFinal;
	}

	/**
	 * @param notaFinal the notaFinal to set
	 */
	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}

	/**
	 * @return the tipoEval
	 */
	public String getTipoEval() {
		return tipoEval;
	}

	/**
	 * @param tipoEval the tipoEval to set
	 */
	public void setTipoEval(String tipoEval) {
		this.tipoEval = tipoEval;
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