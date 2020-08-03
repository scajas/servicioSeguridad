package ec.edu.epn.gestionDocente.DTO;


public class CoEvaluacionResultadoDTO {
	
	
	private String detalle;
	private Double valorHoras;
	private Double valorDedicacion;
	
	public CoEvaluacionResultadoDTO(){
		
	}

	
	public CoEvaluacionResultadoDTO(String detalle, Double valorHoras, Double valorDedicacion) {
		super();
		
		this.detalle= detalle;
		this.valorHoras= valorHoras;
		this.valorDedicacion= valorDedicacion;
		
		
		
			
	}


	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}


	/**
	 * @return the valorHoras
	 */
	public Double getValorHoras() {
		return valorHoras;
	}


	/**
	 * @return the valorDedicacion
	 */
	public Double getValorDedicacion() {
		return valorDedicacion;
	}


	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	/**
	 * @param valorHoras the valorHoras to set
	 */
	public void setValorHoras(Double valorHoras) {
		this.valorHoras = valorHoras;
	}


	/**
	 * @param valorDedicacion the valorDedicacion to set
	 */
	public void setValorDedicacion(Double valorDedicacion) {
		this.valorDedicacion = valorDedicacion;
	}


		
}
