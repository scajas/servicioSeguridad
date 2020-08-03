package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

/**
 * The persistent class for the alquiler database table.
 * 
 */
@Entity
@Table(name = "alquiler", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_alquiler")
	private Integer idAlquiler;

	@Column(name = "costo_alquiler")
	private double costoAlquiler;

	@Column(name = "descripcion_alquiler")
	private String descripcionAlquiler;

	@Column(name = "saldo_alquiler")
	private double saldoAlquiler;

	// bi-directional many-to-one association to EstadoAlquiler
	@ManyToOne
	@JoinColumn(name = "id_ealquiler")
	private EstadoAlquiler estadoAlquiler;

	// bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name = "id_eventos")
	private Evento evento;

	// bi-directional many-to-one association to Pago
	@OneToMany(mappedBy = "alquiler")
	private Set<Pago> pagos;

	public Alquiler() {
	}

	public Integer getIdAlquiler() {
		return this.idAlquiler;
	}

	public void setIdAlquiler(Integer idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public double getCostoAlquiler() {
		return this.costoAlquiler;
	}

	public void setCostoAlquiler(double costoAlquiler) {
		this.costoAlquiler = costoAlquiler;
	}

	public String getDescripcionAlquiler() {
		return this.descripcionAlquiler;
	}

	public void setDescripcionAlquiler(String descripcionAlquiler) {
		this.descripcionAlquiler = descripcionAlquiler;
	}

	public double getSaldoAlquiler() {
		return this.saldoAlquiler;
	}

	public void setSaldoAlquiler(double saldoAlquiler) {
		this.saldoAlquiler = saldoAlquiler;
	}

	public EstadoAlquiler getEstadoAlquiler() {
		return this.estadoAlquiler;
	}

	public void setEstadoAlquiler(EstadoAlquiler estadoAlquiler) {
		this.estadoAlquiler = estadoAlquiler;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Set<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

}