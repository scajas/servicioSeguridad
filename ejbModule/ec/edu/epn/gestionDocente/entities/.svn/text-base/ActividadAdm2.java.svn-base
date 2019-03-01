package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the actividad_adm2 database table.
 * 
 */
@Entity
@Table(name="actividad_adm2")
@NamedQuery(name="ActividadAdm2.findAll", query="SELECT a FROM ActividadAdm2 a")
public class ActividadAdm2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_act_adm")
	private String idActAdm;

	private String cargo;

	private String descripcion;

	private String descripcion1;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_adm")
	private Date fechaFinAdm;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_adm")
	private Date fechaInicioAdm;

	@Column(name="horas_semana")
	private Integer horasSemana;

	@Column(name="id_cargo_adm")
	private String idCargoAdm;

	@Column(name="id_periodo")
	private String idPeriodo;

	private String nced;

	@Column(name="nombre_adm")
	private String nombreAdm;

	@Column(name="num_horas_adm")
	private Integer numHorasAdm;

	private String semestre;

	private String tipo;

	public ActividadAdm2() {
	}

	public String getIdActAdm() {
		return this.idActAdm;
	}

	public void setIdActAdm(String idActAdm) {
		this.idActAdm = idActAdm;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public Date getFechaFinAdm() {
		return this.fechaFinAdm;
	}

	public void setFechaFinAdm(Date fechaFinAdm) {
		this.fechaFinAdm = fechaFinAdm;
	}

	public Date getFechaInicioAdm() {
		return this.fechaInicioAdm;
	}

	public void setFechaInicioAdm(Date fechaInicioAdm) {
		this.fechaInicioAdm = fechaInicioAdm;
	}

	public Integer getHorasSemana() {
		return this.horasSemana;
	}

	public void setHorasSemana(Integer horasSemana) {
		this.horasSemana = horasSemana;
	}

	public String getIdCargoAdm() {
		return this.idCargoAdm;
	}

	public void setIdCargoAdm(String idCargoAdm) {
		this.idCargoAdm = idCargoAdm;
	}

	public String getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreAdm() {
		return this.nombreAdm;
	}

	public void setNombreAdm(String nombreAdm) {
		this.nombreAdm = nombreAdm;
	}

	public Integer getNumHorasAdm() {
		return this.numHorasAdm;
	}

	public void setNumHorasAdm(Integer numHorasAdm) {
		this.numHorasAdm = numHorasAdm;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}