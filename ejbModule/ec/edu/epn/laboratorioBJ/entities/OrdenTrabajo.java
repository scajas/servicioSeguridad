package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the orden_trabajo database table.
 * 
 */
@Entity
@Table(name = "orden_trabajo", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name = "OrdenTrabajo.findAll", query = "SELECT o FROM OrdenTrabajo o")
public class OrdenTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_orden")
	private String idOrden;

	@Column(name = "aux_ordent")
	private Integer auxOrdent;

	@Column(name = "estado_ot")
	private String estadoOt;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_cierre")
	private Date fechaCierre;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaentrega_ot")
	private Date fechaentregaOt;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaorden_ot")
	private Date fechaordenOt;

	@Column(name = "id_factura")
	private String idFactura;

	@Column(name = "id_ti")
	private String idTi;

	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "numeromuestra_ot")
	private Integer numeromuestraOt;

	@Column(name = "observ_ot")
	private String observOt;

	@Column(name = "responsable_ot")
	private String responsableOt;

	@Column(name = "tipo_ot")
	private String tipoOt;

	// bi-directional many-to-one association to Detalleorden
	@OneToMany(mappedBy = "ordenTrabajo")
	private List<Detalleorden> detalleordens;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public OrdenTrabajo() {
	}

	public String getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public Integer getAuxOrdent() {
		return this.auxOrdent;
	}

	public void setAuxOrdent(Integer auxOrdent) {
		this.auxOrdent = auxOrdent;
	}

	public String getEstadoOt() {
		return this.estadoOt;
	}

	public void setEstadoOt(String estadoOt) {
		this.estadoOt = estadoOt;
	}

	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Date getFechaentregaOt() {
		return this.fechaentregaOt;
	}

	public void setFechaentregaOt(Date fechaentregaOt) {
		this.fechaentregaOt = fechaentregaOt;
	}

	public Date getFechaordenOt() {
		return this.fechaordenOt;
	}

	public void setFechaordenOt(Date fechaordenOt) {
		this.fechaordenOt = fechaordenOt;
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdTi() {
		return this.idTi;
	}

	public void setIdTi(String idTi) {
		this.idTi = idTi;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getNumeromuestraOt() {
		return this.numeromuestraOt;
	}

	public void setNumeromuestraOt(Integer numeromuestraOt) {
		this.numeromuestraOt = numeromuestraOt;
	}

	public String getObservOt() {
		return this.observOt;
	}

	public void setObservOt(String observOt) {
		this.observOt = observOt;
	}

	public String getResponsableOt() {
		return this.responsableOt;
	}

	public void setResponsableOt(String responsableOt) {
		this.responsableOt = responsableOt;
	}

	public String getTipoOt() {
		return this.tipoOt;
	}

	public void setTipoOt(String tipoOt) {
		this.tipoOt = tipoOt;
	}

	public List<Detalleorden> getDetalleordens() {
		return this.detalleordens;
	}

	public void setDetalleordens(List<Detalleorden> detalleordens) {
		this.detalleordens = detalleordens;
	}

	public Detalleorden addDetalleorden(Detalleorden detalleorden) {
		getDetalleordens().add(detalleorden);
		detalleorden.setOrdenTrabajo(this);

		return detalleorden;
	}

	public Detalleorden removeDetalleorden(Detalleorden detalleorden) {
		getDetalleordens().remove(detalleorden);
		detalleorden.setOrdenTrabajo(null);

		return detalleorden;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}