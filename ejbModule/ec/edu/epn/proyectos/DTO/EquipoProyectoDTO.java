package ec.edu.epn.proyectos.DTO;

import java.io.Serializable;

public class EquipoProyectoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2149162640476118740L;

	private String rol;
	private String nombres;
	private String depar;
	private String cargo;
	private Double Hplanif;
	private Double Hreport;
	private String justificacion;
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDepar() {
		return depar;
	}
	public void setDepar(String depar) {
		this.depar = depar;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getHplanif() {
		return Hplanif;
	}
	public void setHplanif(Double hplanif) {
		Hplanif = hplanif;
	}
	public Double getHreport() {
		return Hreport;
	}
	public void setHreport(Double hreport) {
		Hreport = hreport;
	}
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	
	
}
