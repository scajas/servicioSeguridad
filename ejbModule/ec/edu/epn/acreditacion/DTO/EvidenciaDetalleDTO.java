package ec.edu.epn.acreditacion.DTO;

import java.io.Serializable;

public class EvidenciaDetalleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3574385754496084840L;

	private Integer idEvidencia;
	private Integer idEvidenciaDetalle;
	private Integer idPensum;
	private String idCarrera;
	private String nombreEvidencia;
	private String descripcion;
	private String observacion;
	private String existencia;	
	private Double calificacion;
	

	public EvidenciaDetalleDTO() {
	}


	/**
	 * @return the idEvidencia
	 */
	public Integer getIdEvidencia() {
		return idEvidencia;
	}


	/**
	 * @return the idEvidenciaDetalle
	 */
	public Integer getIdEvidenciaDetalle() {
		return idEvidenciaDetalle;
	}


	/**
	 * @return the idPensum
	 */
	public Integer getIdPensum() {
		return idPensum;
	}


	/**
	 * @return the idCarrera
	 */
	public String getIdCarrera() {
		return idCarrera;
	}


	/**
	 * @return the nombreEvidencia
	 */
	public String getNombreEvidencia() {
		return nombreEvidencia;
	}


	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}


	/**
	 * @return the existencia
	 */
	public String getExistencia() {
		return existencia;
	}


	/**
	 * @return the calificacion
	 */
	public Double getCalificacion() {
		return calificacion;
	}


	/**
	 * @param idEvidencia the idEvidencia to set
	 */
	public void setIdEvidencia(Integer idEvidencia) {
		this.idEvidencia = idEvidencia;
	}


	/**
	 * @param idEvidenciaDetalle the idEvidenciaDetalle to set
	 */
	public void setIdEvidenciaDetalle(Integer idEvidenciaDetalle) {
		this.idEvidenciaDetalle = idEvidenciaDetalle;
	}


	/**
	 * @param idPensum the idPensum to set
	 */
	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}


	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}


	/**
	 * @param nombreEvidencia the nombreEvidencia to set
	 */
	public void setNombreEvidencia(String nombreEvidencia) {
		this.nombreEvidencia = nombreEvidencia;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(String existencia) {
		this.existencia = existencia;
	}


	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

}
