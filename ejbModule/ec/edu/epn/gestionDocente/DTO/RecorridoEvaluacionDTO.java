package ec.edu.epn.gestionDocente.DTO;

import java.sql.Timestamp;

public class RecorridoEvaluacionDTO {
	
	
	private String nombreAutorizacion;
	private String estadoAnterior;
	private String estadoActual;
	private String observacion;
	private Timestamp fechaRecorrido;
	
	
	
	
	public RecorridoEvaluacionDTO(){
		
	}

	
	
		
		
	

	/**
	 * @return the nombreAutorizacion
	 */
	public String getNombreAutorizacion() {
		return nombreAutorizacion;
	}


	/**
	 * @return the estadoAnterior
	 */
	public String getEstadoAnterior() {
		return estadoAnterior;
	}


	/**
	 * @return the estadoActual
	 */
	public String getEstadoActual() {
		return estadoActual;
	}


	/**
	 * @return the observación
	 */
	public String getObservacion() {
		return observacion;
	}


	/**
	 * @return the fechaRecorrido
	 */
	public Timestamp getFechaRecorrido() {
		return fechaRecorrido;
	}


	/**
	 * @param nombreAutorizacion the nombreAutorizacion to set
	 */
	public void setNombreAutorizacion(String nombreAutorizacion) {
		this.nombreAutorizacion = nombreAutorizacion;
	}


	/**
	 * @param estadoAnterior the estadoAnterior to set
	 */
	public void setEstadoAnterior(String estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}


	/**
	 * @param estadoActual the estadoActual to set
	 */
	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}


	/**
	 * @param observación the observación to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	/**
	 * @param fechaRecorrido the fechaRecorrido to set
	 */
	public void setFechaRecorrido(Timestamp fechaRecorrido) {
		this.fechaRecorrido = fechaRecorrido;
	}


		
}
