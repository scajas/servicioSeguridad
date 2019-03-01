package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the eventos database table.
 * 
 */
@Entity
@Table(name = "eventos", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_eventos")
	private Integer idEventos;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_evento")
	private Date fechaFinEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_evento")
	private Date fechaInicioEvento;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_reserve_evento")
	private Date fechaReserveEvento;

	@Column(name = "hora_inicio_evento")
	private Time horaInicioEvento;

	@Column(name = "hpra_fin_evento")
	private Time hpraFinEvento;

	@Column(name = "nom_evento")
	private String nomEvento;

	@Column(name = "mail_cancelacion")
	private String mailCancelacion;

	public String getMailCancelacion() {
		return mailCancelacion;
	}

	public void setMailCancelacion(String mailCancelacion) {
		this.mailCancelacion = mailCancelacion;
	}

	@Column(name = "forma_reserva")
	private String formaReserva;

	public String getFormaReserva() {
		return formaReserva;
	}

	public void setFormaReserva(String formaReserva) {
		this.formaReserva = formaReserva;
	}

	// bi-directional many-to-one association to Alquiler
	@OneToMany(mappedBy = "evento")
	private Set<Alquiler> alquilers;

	// bi-directional many-to-one association to EventoEspacio
	@OneToMany(mappedBy = "evento")
	private Set<EventoEspacio> eventoEspacios;

	// bi-directional many-to-one association to EstadoEvento
	@ManyToOne
	@JoinColumn(name = "id_evento")
	private EstadoEvento estadoEvento;

	// bi-directional many-to-one association to Responsable
	@ManyToOne
	@JoinColumn(name = "id_responsable")
	private ResponsableInfra responsable;

	// bi-directional many-to-one association to TipoEvento
	@ManyToOne
	@JoinColumn(name = "id_tevento")
	private TipoEvento tipoEvento;

	public Evento() {
	}

	public Integer getIdEventos() {
		return this.idEventos;
	}

	public void setIdEventos(Integer idEventos) {
		this.idEventos = idEventos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFinEvento() {
		return this.fechaFinEvento;
	}

	public void setFechaFinEvento(Date fechaFinEvento) {
		this.fechaFinEvento = fechaFinEvento;
	}

	public Date getFechaInicioEvento() {
		return this.fechaInicioEvento;
	}

	public void setFechaInicioEvento(Date fechaInicioEvento) {
		this.fechaInicioEvento = fechaInicioEvento;
	}

	public Date getFechaReserveEvento() {
		return this.fechaReserveEvento;
	}

	public void setFechaReserveEvento(Date fechaReserveEvento) {
		this.fechaReserveEvento = fechaReserveEvento;
	}

	public Time getHoraInicioEvento() {
		return this.horaInicioEvento;
	}

	public void setHoraInicioEvento(Time horaInicioEvento) {
		this.horaInicioEvento = horaInicioEvento;
	}

	public Time getHpraFinEvento() {
		return this.hpraFinEvento;
	}

	public void setHpraFinEvento(Time hpraFinEvento) {
		this.hpraFinEvento = hpraFinEvento;
	}

	public String getNomEvento() {
		return this.nomEvento;
	}

	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}

	public Set<Alquiler> getAlquilers() {
		return this.alquilers;
	}

	public void setAlquilers(Set<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}

	public Set<EventoEspacio> getEventoEspacios() {
		return this.eventoEspacios;
	}

	public void setEventoEspacios(Set<EventoEspacio> eventoEspacios) {
		this.eventoEspacios = eventoEspacios;
	}

	public EstadoEvento getEstadoEvento() {
		return this.estadoEvento;
	}

	public void setEstadoEvento(EstadoEvento estadoEvento) {
		this.estadoEvento = estadoEvento;
	}

	public ResponsableInfra getResponsable() {
		return this.responsable;
	}

	public void setResponsable(ResponsableInfra responsable) {
		this.responsable = responsable;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

}