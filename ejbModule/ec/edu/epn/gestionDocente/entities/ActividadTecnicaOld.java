package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the actividad_tecnica_old database table.
 * 
 */
@Entity
@Table(name="actividad_tecnica_old")
@NamedQuery(name="ActividadTecnicaOld.findAll", query="SELECT a FROM ActividadTecnicaOld a")
public class ActividadTecnicaOld implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_activid_tecadm")
	private String idActividTecadm;

	@Column(name="descripcion_ata")
	private String descripcionAta;

	private String descripcion1;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_ata")
	private Date fechaFinAta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_ata")
	private Date fechaInicioAta;

	@Column(name="id_periodo")
	private String idPeriodo;

	private String nced;

	@Column(name="nombre_ata")
	private String nombreAta;

	@Column(name="num_horas_ata")
	private double numHorasAta;

	@Column(name="num_horas_semana")
	private double numHorasSemana;

	private String semestre;

	public ActividadTecnicaOld() {
	}

	public String getIdActividTecadm() {
		return this.idActividTecadm;
	}

	public void setIdActividTecadm(String idActividTecadm) {
		this.idActividTecadm = idActividTecadm;
	}

	public String getDescripcionAta() {
		return this.descripcionAta;
	}

	public void setDescripcionAta(String descripcionAta) {
		this.descripcionAta = descripcionAta;
	}

	public String getDescripcion1() {
		return this.descripcion1;
	}

	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	public Date getFechaFinAta() {
		return this.fechaFinAta;
	}

	public void setFechaFinAta(Date fechaFinAta) {
		this.fechaFinAta = fechaFinAta;
	}

	public Date getFechaInicioAta() {
		return this.fechaInicioAta;
	}

	public void setFechaInicioAta(Date fechaInicioAta) {
		this.fechaInicioAta = fechaInicioAta;
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

	public String getNombreAta() {
		return this.nombreAta;
	}

	public void setNombreAta(String nombreAta) {
		this.nombreAta = nombreAta;
	}

	public double getNumHorasAta() {
		return this.numHorasAta;
	}

	public void setNumHorasAta(double numHorasAta) {
		this.numHorasAta = numHorasAta;
	}

	public double getNumHorasSemana() {
		return this.numHorasSemana;
	}

	public void setNumHorasSemana(double numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}