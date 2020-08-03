package ec.edu.epn.gestionDocente.DTO;


public class CalculoEvaluacionDTO {
	
	
	private String tipo;
	private Double puntanje;
	private Double puntanje100;
	private Double pesoInstrumento;
	private Double valorAportePeso;
	
	
	
	
	public CalculoEvaluacionDTO(){
		
	}

	
	public CalculoEvaluacionDTO(String tipo, Double puntanje, Double puntanje100,
									Double pesoInstrumento, Double valorAportePeso) {
		super();
		
		this.tipo= tipo;
		this.puntanje= puntanje;
		this.puntanje100= puntanje100;
		this.pesoInstrumento= pesoInstrumento;
		this.valorAportePeso= valorAportePeso;
		
		
		
			
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the puntanje
	 */
	public Double getPuntanje() {
		return puntanje;
	}


	/**
	 * @param puntanje the puntanje to set
	 */
	public void setPuntanje(Double puntanje) {
		this.puntanje = puntanje;
	}


	/**
	 * @return the puntanje100
	 */
	public Double getPuntanje100() {
		return puntanje100;
	}


	/**
	 * @param puntanje100 the puntanje100 to set
	 */
	public void setPuntanje100(Double puntanje100) {
		this.puntanje100 = puntanje100;
	}


	/**
	 * @return the pesoInstrumento
	 */
	public Double getPesoInstrumento() {
		return pesoInstrumento;
	}


	/**
	 * @param pesoInstrumento the pesoInstrumento to set
	 */
	public void setPesoInstrumento(Double pesoInstrumento) {
		this.pesoInstrumento = pesoInstrumento;
	}


	/**
	 * @return the valorAportePeso
	 */
	public Double getValorAportePeso() {
		return valorAportePeso;
	}


	/**
	 * @param valorAportePeso the valorAportePeso to set
	 */
	public void setValorAportePeso(Double valorAportePeso) {
		this.valorAportePeso = valorAportePeso;
	}


	
}
