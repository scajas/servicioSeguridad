package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the "detalles_Evento" database table.
 * 
 */
@Entity
@Table(name = "dias_reserva", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Dias_Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_dia_reserva")
	private Integer idDiaReserva;

	@Column(name = "observacion")
	private String Observacion;

	@Column(name = "estado")
	private String estado;
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_diaevento")
	private Date fecha;

	@Column(name = "hora_fin")
	private Time horaFin;

	@Column(name = "hora_inicio")
	private Time horaInicio;

	// bi-directional many-to-one association to EventoEspacio
	@ManyToOne
	@JoinColumn(name = "id_evento_espacio")
	private EventoEspacio eventoEspacio;

	@OneToMany(mappedBy = "diaReserva")
	private Set<Detalle_Actividad_Evento> detalleActEvento;

	public Integer getIdDiaReserva() {
		return idDiaReserva;
	}

	public void setIdDiaReserva(Integer idDiaReserva) {
		this.idDiaReserva = idDiaReserva;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public EventoEspacio getEventoEspacio() {
		return eventoEspacio;
	}

	public void setEventoEspacio(EventoEspacio eventoEspacio) {
		this.eventoEspacio = eventoEspacio;
	}

	public Set<Detalle_Actividad_Evento> getDetalleActEvento() {
		return detalleActEvento;
	}

	public void setDetalleActEvento(Set<Detalle_Actividad_Evento> detalleActEvento) {
		this.detalleActEvento = detalleActEvento;
	}

	
}