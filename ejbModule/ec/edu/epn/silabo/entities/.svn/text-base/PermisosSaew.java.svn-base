package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the permisos_saew database table.
 * 
 */
@Entity
@Table(name = "permisos_saew", catalog = "`bddcorpepn`", schema = "`Silabo`")
@NamedQuery(name = "PermisosSaew.findAll", query = "SELECT p FROM PermisosSaew p")
public class PermisosSaew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 256)
	private String anio;

	@Column(length = 256)
	private String carrera;

	@Column(length = 256)
	private String dia;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(length = 256)
	private String feriado;

	@Column(length = 256)
	private String hora1;

	@Column(length = 256)
	private String hora2;

	@Column(length = 256)
	private String hora21;

	@Column(length = 256)
	private String hora22;

	@Id
	private Integer idPermiso;

	@Column(length = 256)
	private String motivo;

	@Column(length = 256)
	private String motivo2;

	@Column(length = 256)
	private String semestre;

	public PermisosSaew() {
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFeriado() {
		return this.feriado;
	}

	public void setFeriado(String feriado) {
		this.feriado = feriado;
	}

	public String getHora1() {
		return this.hora1;
	}

	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}

	public String getHora2() {
		return this.hora2;
	}

	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}

	public String getHora21() {
		return this.hora21;
	}

	public void setHora21(String hora21) {
		this.hora21 = hora21;
	}

	public String getHora22() {
		return this.hora22;
	}

	public void setHora22(String hora22) {
		this.hora22 = hora22;
	}

	public Integer getIdPermiso() {
		return this.idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMotivo2() {
		return this.motivo2;
	}

	public void setMotivo2(String motivo2) {
		this.motivo2 = motivo2;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}