package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nombramiento database table.
 * 
 */
@Entity
@NamedQuery(name="Nombramiento.findAll", query="SELECT n FROM Nombramiento n")
public class Nombramiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nom")
	private Integer idNom;

	private String cargo;

	private String dedicacion;

	private String dependencia;

	private Integer edad;

	@Column(name="fecha_ingreso_epn")
	private String fechaIngresoEpn;

	@Column(name="fecha_nac")
	private String fechaNac;

	private String nced;

	private String nombres;

	@Column(name="nuevo_escalon")
	private String nuevoEscalon;

	private String observaciones;

	private double rmu;

	@Column(name="tiempo_servicio")
	private Integer tiempoServicio;

	private String titulo;

	public Nombramiento() {
	}

	public Integer getIdNom() {
		return this.idNom;
	}

	public void setIdNom(Integer idNom) {
		this.idNom = idNom;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public Integer getEdad() {
		return this.edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFechaIngresoEpn() {
		return this.fechaIngresoEpn;
	}

	public void setFechaIngresoEpn(String fechaIngresoEpn) {
		this.fechaIngresoEpn = fechaIngresoEpn;
	}

	public String getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNuevoEscalon() {
		return this.nuevoEscalon;
	}

	public void setNuevoEscalon(String nuevoEscalon) {
		this.nuevoEscalon = nuevoEscalon;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getRmu() {
		return this.rmu;
	}

	public void setRmu(double rmu) {
		this.rmu = rmu;
	}

	public Integer getTiempoServicio() {
		return this.tiempoServicio;
	}

	public void setTiempoServicio(Integer tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}