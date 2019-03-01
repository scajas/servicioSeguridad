package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the estado_evento database table.
 * 
 */
@Entity
@Table(name = "estado_evento", catalog = "bddcorpepn", schema = "`Infraestructura`")

public class EstadoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evento")
	private Integer idEvento;

	@Column(name="descripcion_eevento")
	private String descripcionEevento;

	@Column(name="estado_evento")
	private String estadoEvento;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="estadoEvento")
	private Set<Evento> eventos;

    public EstadoEvento() {
    }

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcionEevento() {
		return this.descripcionEevento;
	}

	public void setDescripcionEevento(String descripcionEevento) {
		this.descripcionEevento = descripcionEevento;
	}

	public String getEstadoEvento() {
		return this.estadoEvento;
	}

	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}

	public Set<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}
	
}