package ec.edu.epn.acreditacion.DTO;

import java.io.Serializable;


public class SubCriterioDetalleDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3574385754496084840L;
	private Integer idSubCriterioDetalle;
	private Integer idSubCriterio;
	private Integer idCriterioDetalle;
	private String nombreSubCriterio;
	private Double peso;
	private Double calificacion;

	public SubCriterioDetalleDTO() {
	}

	/**
	 * @return the idSubCriterioDetalle
	 */
	public Integer getIdSubCriterioDetalle() {
		return idSubCriterioDetalle;
	}

	/**
	 * @param idSubCriterioDetalle the idSubCriterioDetalle to set
	 */
	public void setIdSubCriterioDetalle(Integer idSubCriterioDetalle) {
		this.idSubCriterioDetalle = idSubCriterioDetalle;
	}

	/**
	 * @return the idSubCriterio
	 */
	public Integer getIdSubCriterio() {
		return idSubCriterio;
	}

	/**
	 * @param idSubCriterio the idSubCriterio to set
	 */
	public void setIdSubCriterio(Integer idSubCriterio) {
		this.idSubCriterio = idSubCriterio;
	}

	
	/**
	 * @return the nombreSubCriterio
	 */
	public String getNombreSubCriterio() {
		return nombreSubCriterio;
	}

	/**
	 * @param nombreSubCriterio the nombreSubCriterio to set
	 */
	public void setNombreSubCriterio(String nombreSubCriterio) {
		this.nombreSubCriterio = nombreSubCriterio;
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

	/**
	 * @return the calificacion
	 */
	public Double getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

		
}
