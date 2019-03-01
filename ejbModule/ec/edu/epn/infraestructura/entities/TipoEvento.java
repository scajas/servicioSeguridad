package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;

/**
 * The persistent class for the tipo_evento database table.
 * 
 */
@Entity
@Table(name = "tipo_evento", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class TipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tevento")
	private Integer idTevento;

	@Column(name = "descripcion_tevento")
	private String descripcionTevento;

	@Column(name = "tipo_evento")
	private String tipoEvento;

	// bi-directional many-to-one association to Evento
	@OneToMany(mappedBy = "tipoEvento")
	private Set<Evento> eventos;

	public TipoEvento() {
	}

	public Integer getIdTevento() {
		return this.idTevento;
	}

	public void setIdTevento(Integer idTevento) {
		this.idTevento = idTevento;
	}

	public String getDescripcionTevento() {
		return this.descripcionTevento;
	}

	public void setDescripcionTevento(String descripcionTevento) {
		this.descripcionTevento = descripcionTevento;
	}

	public String getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Set<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

}