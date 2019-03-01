package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.List;
import java.util.Set;

/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@Table(name = "horario", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_horario")
	private Integer idHorario;
	
	@OneToMany(mappedBy = "hora")
	private List<PreferenciaHorario> preferenciahorarios;
	
	@OneToMany(mappedBy = "hora")
	private List<Sesione> sesiones;

	public List<Sesione> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesione> sesiones) {
		this.sesiones = sesiones;
	}

	public List<PreferenciaHorario> getPreferenciahorarios() {
		return preferenciahorarios;
	}

	public void setPreferenciahorarios(List<PreferenciaHorario> preferenciahorarios) {
		this.preferenciahorarios = preferenciahorarios;
	}

	@Column(name = "descripcion_horario")
	private String descripcionHorario;

	@Column(name = "hora_fin")
	private Time horaFin;

	@Column(name = "hora_inicio")
	private Time horaInicio;

	// bi-directional many-to-one association to HorarioEspacio
	@OneToMany(mappedBy = "horario")
	private Set<HorarioEspacio> horarioEspacios;

	public Horario() {
	}

	public Integer getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getDescripcionHorario() {
		return this.descripcionHorario;
	}

	public void setDescripcionHorario(String descripcionHorario) {
		this.descripcionHorario = descripcionHorario;
	}

	public Time getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Set<HorarioEspacio> getHorarioEspacios() {
		return this.horarioEspacios;
	}

	public void setHorarioEspacios(Set<HorarioEspacio> horarioEspacios) {
		this.horarioEspacios = horarioEspacios;
	}

}