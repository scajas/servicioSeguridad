package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * The persistent class for the "detalles_Evento" database table.
 * 
 */
@Entity
@Table(name = "detalle_actividad_evento", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Detalle_Actividad_Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_actividad")
	private Integer idActividad;

	@Column(name = "actividad")
	private String actividad;

	@Column(name = "actor")
	private String actor;

	@Column(name = "hora_fin_act")
	private Time horaFin;

	@Column(name = "hora_inicio_act")
	private Time horaInicio;

	// bi-directional many-to-one association to EventoEspacio
	@ManyToOne
	@JoinColumn(name = "id_dia_reserva")
	private Dias_Reserva diaReserva;

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Time getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Dias_Reserva getDiaReserva() {
		return diaReserva;
	}

	public void setDiaReserva(Dias_Reserva diaReserva) {
		this.diaReserva = diaReserva;
	}

}