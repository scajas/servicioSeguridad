package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;

public class CalculoHorasExigiblesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double horasExigiblesTP;
	private double horasExigiblesTC;
	private String mensajeError;
	private String seleccionRelLAboral;
	private boolean seleccionTP;
	private boolean seleccionTC;
	
	/**
	 * @return the horasExigiblesTC
	 */
	public double getHorasExigiblesTC() {
		return horasExigiblesTC;
	}
	/**
	 * @param horasExigiblesTC the horasExigiblesTC to set
	 */
	public void setHorasExigiblesTC(double horasExigiblesTC) {
		this.horasExigiblesTC = horasExigiblesTC;
	}
	/**
	 * @return the horasExigiblesTP
	 */
	public double getHorasExigiblesTP() {
		return horasExigiblesTP;
	}
	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}
	/**
	 * @param horasExigiblesTP the horasExigiblesTP to set
	 */
	public void setHorasExigiblesTP(double horasExigiblesTP) {
		this.horasExigiblesTP = horasExigiblesTP;
	}
	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	/**
	 * @return the seleccionTP
	 */
	public boolean isSeleccionTP() {
		return seleccionTP;
	}
	/**
	 * @return the seleccionTC
	 */
	public boolean isSeleccionTC() {
		return seleccionTC;
	}
	/**
	 * @param seleccionTP the seleccionTP to set
	 */
	public void setSeleccionTP(boolean seleccionTP) {
		this.seleccionTP = seleccionTP;
	}
	/**
	 * @param seleccionTC the seleccionTC to set
	 */
	public void setSeleccionTC(boolean seleccionTC) {
		this.seleccionTC = seleccionTC;
	}
	/**
	 * @return the seleccionRelLAboral
	 */
	public String getSeleccionRelLAboral() {
		return seleccionRelLAboral;
	}
	/**
	 * @param seleccionRelLAboral the seleccionRelLAboral to set
	 */
	public void setSeleccionRelLAboral(String seleccionRelLAboral) {
		this.seleccionRelLAboral = seleccionRelLAboral;
	}

}
