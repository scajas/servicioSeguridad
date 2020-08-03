package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the asignacion_jefe_dep database table.
 * 
 */
@Entity
@Table(name="asignacion_jefe_dep",catalog = "`bddcorpepn`", schema = "`Rrhh`")
@NamedQuery(name="AsignacionJefeDep.findAll", query="SELECT a FROM AsignacionJefeDep a")
public class AsignacionJefeDep implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1429387331132032628L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_asignacion_jefe_dep")
	private Integer idAsignacionJefeDep;
	

	@Column(name="nced")
	private String nced;

	@Column(name="cod_dep")
	private String codDep;
	
	
	private String estado;

	@Column(name="enviado_por")
	private Integer enviadoPor;

	@Column(name="fecha_desde")
	private Date fechaDesde;
	
	@Column(name="fecha_hasta")
	private Date fechaHasta;

	private String observacion;

	/**
	 * @return the idAsignacionJefeDep
	 */
	public Integer getIdAsignacionJefeDep() {
		return idAsignacionJefeDep;
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
	 * @return the enviadoPor
	 */
	public Integer getEnviadoPor() {
		return enviadoPor;
	}

	/**
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param idAsignacionJefeDep the idAsignacionJefeDep to set
	 */
	public void setIdAsignacionJefeDep(Integer idAsignacionJefeDep) {
		this.idAsignacionJefeDep = idAsignacionJefeDep;
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
	 * @param enviadoPor the enviadoPor to set
	 */
	public void setEnviadoPor(Integer enviadoPor) {
		this.enviadoPor = enviadoPor;
	}

	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}