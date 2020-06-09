package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the corte_evaluacion database table.
 * 
 */
@Entity
@Table(name="corte_evaluacion_docente",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="CorteEvaluacionDocente.findAll", query="SELECT c FROM CorteEvaluacionDocente c")
public class CorteEvaluacionDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_corte_eval_doc")
	private Integer idCorteEvalDoc;

	@Column(name="nced")
	private String nced;
	  
	@Column(name="cod_dep")
	private String codDep;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cierre")
	private Date fechaCierre;	

	@Column(name="id_pensum")
	private Integer idPensum;
	
	@Column(name="opcion")
	private String opcion;
	
	
	@Column(name="observacion")
	private String observacion;
	
	@Column(name="estado_eval")
	private String estadoEval;

	public CorteEvaluacionDocente() {
	}

	/**
	 * @return the idCorteEvalDoc
	 */
	public Integer getIdCorteEvalDoc() {
		return idCorteEvalDoc;
	}

	/**
	 * @return the nced
	 */
	public String getNced() {
		return nced;
	}

	/**
	 * @return the codDep
	 */
	public String getCodDep() {
		return codDep;
	}

	/**
	 * @return the fechaCierre
	 */
	public Date getFechaCierre() {
		return fechaCierre;
	}

	/**
	 * @return the idPensum
	 */
	public Integer getIdPensum() {
		return idPensum;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @return the estadoEval
	 */
	public String getEstadoEval() {
		return estadoEval;
	}

	/**
	 * @param idCorteEvalDoc the idCorteEvalDoc to set
	 */
	public void setIdCorteEvalDoc(Integer idCorteEvalDoc) {
		this.idCorteEvalDoc = idCorteEvalDoc;
	}

	/**
	 * @param nced the nced to set
	 */
	public void setNced(String nced) {
		this.nced = nced;
	}

	/**
	 * @param codDep the codDep to set
	 */
	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	/**
	 * @param fechaCierre the fechaCierre to set
	 */
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	/**
	 * @param idPensum the idPensum to set
	 */
	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @param estadoEval the estadoEval to set
	 */
	public void setEstadoEval(String estadoEval) {
		this.estadoEval = estadoEval;
	}

	/**
	 * @return the opcion
	 */
	public String getOpcion() {
		return opcion;
	}

	/**
	 * @param opcion the opcion to set
	 */
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	
}