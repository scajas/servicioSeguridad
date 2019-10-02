package ec.edu.epn.gestionDocente.entities;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the calculo_horas_exigibles database table.
 * 
 */
@Entity
@Table(name="calculo_horas_exigibles", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="CalculoHorasExigible.findAll", query="SELECT c FROM CalculoHorasExigible c")
public class CalculoHorasExigible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_calculo_horas")
	private Integer idCalculoHoras;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	private double feriados;

	@Column(name="horas_semanatc")
	private double horasSemanatc;

	@Column(name="horas_semanatp")
	private double horasSemanatp;

	@Column(name="id_pensum")
	private Integer idPensum;

	@Column(name="semana_per_academico")
	private double semanaPerAcademico;

	private double vacaciones;

	public CalculoHorasExigible() {
	}

	public Integer getIdCalculoHoras() {
		return this.idCalculoHoras;
	}

	public void setIdCalculoHoras(Integer idCalculoHoras) {
		this.idCalculoHoras = idCalculoHoras;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public double getFeriados() {
		return this.feriados;
	}

	public void setFeriados(double feriados) {
		this.feriados = feriados;
	}

	public double getHorasSemanatc() {
		return this.horasSemanatc;
	}

	public void setHorasSemanatc(double horasSemanatc) {
		this.horasSemanatc = horasSemanatc;
	}

	public double getHorasSemanatp() {
		return this.horasSemanatp;
	}

	public void setHorasSemanatp(double horasSemanatp) {
		this.horasSemanatp = horasSemanatp;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public double getSemanaPerAcademico() {
		return this.semanaPerAcademico;
	}

	public void setSemanaPerAcademico(double semanaPerAcademico) {
		this.semanaPerAcademico = semanaPerAcademico;
	}

	public double getVacaciones() {
		return this.vacaciones;
	}

	public void setVacaciones(double vacaciones) {
		this.vacaciones = vacaciones;
	}

}