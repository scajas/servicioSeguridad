package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@Table(name = "factura", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "FacturaIndumaq.findAll", query = "SELECT f FROM FacturaIndumaq f")
public class FacturaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_factura")
	private Integer idFactura;

	@Column(name = "id_vendedor")
	private Integer idVendedor;

	@Column(name = "numero_factura")
	private String numeroFactura;

	@Column(name = "subtotal_factura")
	private Double SubtotalFactura;

	@Column(name = "descuentos_factura")
	private Double descuentosFactura;

	@Column(name = "iva_factura")
	private Double ivaFactura;

	@Column(name = "total_factura")
	private Double totalFactura;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_factura")
	private Date fechaFactura;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_modificacion_factura")
	private Date fechaModificacionFactura;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_emision_factura")
	private Date fechaEmisionFactura;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vencimiento_factura")
	private Date fechaVencimientoFactura;

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteIndumaq cliente;

	// bi-directional many-to-one association to EstadoFactura
	@ManyToOne
	@JoinColumn(name = "id_estado_factura")
	private EstadoFacturaIndumaq estadoFactura;

	// bi-directional many-to-one association to TipoFactura
	@ManyToOne
	@JoinColumn(name = "id_tipo_factura")
	private TipoFacturaIndumaq tipoFactura;

	// bi-directional many-to-one association to Venta
	@OneToMany(mappedBy = "factura")
	private List<VentaIndumaq> ventas;

	@OneToMany(mappedBy = "factura")
	private List<PagosFacturaIndumaq> pagosFacturas;

	public List<PagosFacturaIndumaq> getPagosFacturas() {
		return pagosFacturas;
	}

	public void setPagosFacturas(List<PagosFacturaIndumaq> pagosFacturas) {
		this.pagosFacturas = pagosFacturas;
	}

	public FacturaIndumaq() {
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Date getFechaFactura() {
		return this.fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Date getFechaModificacionFactura() {
		return this.fechaModificacionFactura;
	}

	public void setFechaModificacionFactura(Date fechaModificacionFactura) {
		this.fechaModificacionFactura = fechaModificacionFactura;
	}

	public ClienteIndumaq getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteIndumaq cliente) {
		this.cliente = cliente;
	}

	public EstadoFacturaIndumaq getEstadoFactura() {
		return this.estadoFactura;
	}

	public void setEstadoFactura(EstadoFacturaIndumaq estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	public TipoFacturaIndumaq getTipoFactura() {
		return this.tipoFactura;
	}

	public void setTipoFactura(TipoFacturaIndumaq tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public List<VentaIndumaq> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<VentaIndumaq> ventas) {
		this.ventas = ventas;
	}

	public Date getFechaEmisionFactura() {
		return fechaEmisionFactura;
	}

	public void setFechaEmisionFactura(Date fechaEmisionFactura) {
		this.fechaEmisionFactura = fechaEmisionFactura;
	}

	public Date getFechaVencimientoFactura() {
		return fechaVencimientoFactura;
	}

	public void setFechaVencimientoFactura(Date fechaVencimientoFactura) {
		this.fechaVencimientoFactura = fechaVencimientoFactura;
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Double getSubtotalFactura() {
		return SubtotalFactura;
	}

	public void setSubtotalFactura(Double subtotalFactura) {
		SubtotalFactura = subtotalFactura;
	}

	public Double getDescuentosFactura() {
		return descuentosFactura;
	}

	public void setDescuentosFactura(Double descuentosFactura) {
		this.descuentosFactura = descuentosFactura;
	}

	public Double getIvaFactura() {
		return ivaFactura;
	}

	public void setIvaFactura(Double ivaFactura) {
		this.ivaFactura = ivaFactura;
	}

	public Double getTotalFactura() {
		return totalFactura;
	}

	public void setTotalFactura(Double totalFactura) {
		this.totalFactura = totalFactura;
	}

	public VentaIndumaq addVenta(VentaIndumaq venta) {
		getVentas().add(venta);
		venta.setFactura(this);

		return venta;
	}

	public VentaIndumaq removeVenta(VentaIndumaq venta) {
		getVentas().remove(venta);
		venta.setFactura(null);

		return venta;
	}

}