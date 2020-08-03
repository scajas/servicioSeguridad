package ec.edu.epn.acreditacion.DTO;

import java.io.Serializable;


public class CriterioDetalleDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3574385754496084840L;
	private Integer idCriterioDetalle;
	private Integer idCriterio;
	private Integer idCarrera;
	private String nombreCriterio;
	private Double peso;
	private Double Calificacion;

	public CriterioDetalleDTO() {
	}

	/**
	 * @return the idCriterioDetalle
	 */
	public Integer getIdCriterioDetalle() {
		return idCriterioDetalle;
	}

	/**
	 * @param idCriterioDetalle the idCriterioDetalle to set
	 */
	public void setIdCriterioDetalle(Integer idCriterioDetalle) {
		this.idCriterioDetalle = idCriterioDetalle;
	}

	/**
	 * @return the idCriterio
	 */
	public Integer getIdCriterio() {
		return idCriterio;
	}

	/**
	 * @param idCriterio the idCriterio to set
	 */
	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	/**
	 * @return the nombreCriterio
	 */
	public String getNombreCriterio() {
		return nombreCriterio;
	}

	/**
	 * @param nombreCriterio the nombreCriterio to set
	 */
	public void setNombreCriterio(String nombreCriterio) {
		this.nombreCriterio = nombreCriterio;
	}

	

	/**
	 * @return the calificacion
	 */
	public Double getCalificacion() {
		return Calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Double calificacion) {
		Calificacion = calificacion;
	}

	/**
	 * @return the idCarrera
	 */
	public Integer getIdCarrera() {
		return idCarrera;
	}

	/**
	 * @param idCarrera the idCarrera to set
	 */
	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}

	/**
	 * @return the peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	
}
