package ec.edu.epn.rrhh.DTO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class AsignacionJDepDTO implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8382319827347219560L;
	
	private String jefeDepartamento;
	private String dependencia;
	private String codDep;
	private String nced;
	private String observacion;	
	private String estado;
	private Integer idAsignacion;
	private Date fechaDesde;
	private Date fechaHasta;
	private boolean activo;
	
	/**
	 * @return the jefeDepartamento
	 */
	public String getJefeDepartamento() {
		return jefeDepartamento;
	}
	/**
	 * @return the dependencia
	 */
	public String getDependencia() {
		return dependencia;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
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
	 * @param jefeDepartamento the jefeDepartamento to set
	 */
	public void setJefeDepartamento(String jefeDepartamento) {
		this.jefeDepartamento = jefeDepartamento;
	}
	/**
	 * @param dependencia the dependencia to set
	 */
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
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
	/**
	 * @return the codDep
	 */
	public String getCodDep() {
		return codDep;
	}
	/**
	 * @return the nced
	 */
	public String getNced() {
		return nced;
	}
	/**
	 * @param codDep the codDep to set
	 */
	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}
	/**
	 * @param nced the nced to set
	 */
	public void setNced(String nced) {
		this.nced = nced;
	}
	/**
	 * @return the idAsignacion
	 */
	public Integer getIdAsignacion() {
		return idAsignacion;
	}
	/**
	 * @param idAsignacion the idAsignacion to set
	 */
	public void setIdAsignacion(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	
}
