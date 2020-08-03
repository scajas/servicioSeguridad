package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;

public class NombramientoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3458342098015718118L;
	private String cargo;
	private String categoria;
	private String fecha;
	private String fechaF;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the fechaF
	 */
	public String getFechaF() {
		return fechaF;
	}

	/**
	 * @param fechaF
	 *            the fechaF to set
	 */
	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}

}
