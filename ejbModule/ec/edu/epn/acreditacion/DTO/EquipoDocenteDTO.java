package ec.edu.epn.acreditacion.DTO;

import java.io.Serializable;

public class EquipoDocenteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cedula, nombres, relacion, dedicacion, cargo, departamento, facultad, tipo, equipo, fasiganacion,
			bienes, anio;
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	public String getDedicacion() {
		return dedicacion;
	}
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String getFasiganacion() {
		return fasiganacion;
	}
	public void setFasiganacion(String fasiganacion) {
		this.fasiganacion = fasiganacion;
	}
	public String getBienes() {
		return bienes;
	}
	public void setBienes(String bienes) {
		this.bienes = bienes;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	

}
