package ec.edu.epn.rrhh.DTO;

import java.io.Serializable;

public class EmpleadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8847800830106030977L;

	private String numCedula;
	private String nombreEmpleado;
	private String nombreDepartamento;
	private String tipoPersona;
	private String tipoContrato;
	private String dedicacion;
	private String nombrefacultad;
	private String fechaIngresoEPN;
	private String cargo;
	

	public EmpleadoDTO() {

	}

	public EmpleadoDTO(String numCedula, String nombreDepartamento, String tipoPersona, String tipoContrato,
			String nombreEmpleado, String dedicacion, String nombrefacultad) {
		super();
		this.numCedula = numCedula;
		this.nombreEmpleado = nombreEmpleado;
		this.nombreDepartamento = nombreDepartamento;
		this.tipoPersona = tipoPersona;
		this.tipoContrato = tipoContrato;
		this.dedicacion = dedicacion;
		this.nombrefacultad = nombrefacultad;

	}

	/**
	 * @return the numCedula
	 */
	public String getNumCedula() {
		return numCedula;
	}

	/**
	 * @param numCedula
	 *            the numCedula to set
	 */
	public void setNumCedula(String numCedula) {
		this.numCedula = numCedula;
	}

	/**
	 * @return the nombreDepartamento
	 */
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	/**
	 * @param nombreDepartamento
	 *            the nombreDepartamento to set
	 */
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	/**
	 * @return the tipoPersona
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona
	 *            the tipoPersona to set
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	/**
	 * @return the tipoContrato
	 */
	public String getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * @param tipoContrato
	 *            the tipoContrato to set
	 */
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	/**
	 * @return the nombreEmpleado
	 */
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	/**
	 * @param nombreEmpleado
	 *            the nombreEmpleado to set
	 */
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @param dedicacion
	 *            the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @return the nombrefacultad
	 */
	public String getNombrefacultad() {
		return nombrefacultad;
	}

	/**
	 * @param nombrefacultad
	 *            the nombrefacultad to set
	 */
	public void setNombrefacultad(String nombrefacultad) {
		this.nombrefacultad = nombrefacultad;
	}

	/**
	 * @return the fechaIngresoEPN
	 */
	public String getFechaIngresoEPN() {
		return fechaIngresoEPN;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param fechaIngresoEPN the fechaIngresoEPN to set
	 */
	public void setFechaIngresoEPN(String fechaIngresoEPN) {
		this.fechaIngresoEPN = fechaIngresoEPN;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
