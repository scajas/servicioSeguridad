package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;

/**
 * The persistent class for the evento_espacio database table.
 * 
 */
@Entity
@Table(name = "evento_espacio", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class EventoEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_eventoespacio")
	private Integer idEventoespacio;

	// bi-directional many-to-one association to Detalles_Evento
	@OneToMany(mappedBy = "eventoEspacio")
	private Set<Dias_Reserva> diasReserva;

	// bi-directional many-to-one association to Espacio
	@ManyToOne
	@JoinColumn(name = "id_espacio")
	private Espacio espacio;

	// bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name = "id_evento")
	private Evento evento;

	public EventoEspacio() {
	}

	public Integer getIdEventoespacio() {
		return this.idEventoespacio;
	}

	public void setIdEventoespacio(Integer idEventoespacio) {
		this.idEventoespacio = idEventoespacio;
	}

	public Set<Dias_Reserva> getDiasReserva() {
		return diasReserva;
	}

	public void setDiasReserva(Set<Dias_Reserva> diasReserva) {
		this.diasReserva = diasReserva;
	}

	public Espacio getEspacio() {
		return this.espacio;
	}

	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}