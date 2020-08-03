package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the datosok database table.
 * 
 */
@Entity
@NamedQuery(name="Datosok.findAll", query="SELECT d FROM Datosok d")
public class Datosok implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cedula;

	@Column(name="cod_dep")
	private String codDep;

	private String dependencia;

	private String modalidad;

	private String nombres;

	private String puesto;

	public Datosok() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}