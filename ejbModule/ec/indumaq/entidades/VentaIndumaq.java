package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
@Table(name = "venta", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "VentaIndumaq.findAll", query = "SELECT v FROM VentaIndumaq v")
public class VentaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_venta")
	private Integer idVenta;

	@Column(name = "bono_venta")
	private String bonoVenta;

	@Column(name = "cantidad_venta")
	private Integer cantidadVenta;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_venta")
	private Date fechaVenta;

	@Column(name = "modificacion_producto_venta")
	private String modificacionProductoVenta;

	@Column(name = "subtotal_venta")
	private double subtotalVenta;

	@Column(name = "valor_adicional_venta")
	private double valorAdicionalVenta;

	@Column(name = "descuento_venta")
	private double descuentoVenta;

	@Column(name = "motivo_descuento_venta")
	private String motivoDescuentoVenta;

	// bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name = "id_factura")
	private FacturaIndumaq factura;

	// bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoIndumaq producto;

	public VentaIndumaq() {
	}

	public Integer getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public String getBonoVenta() {
		return this.bonoVenta;
	}

	public void setBonoVenta(String bonoVenta) {
		this.bonoVenta = bonoVenta;
	}

	public Integer getCantidadVenta() {
		return this.cantidadVenta;
	}

	public void setCantidadVenta(Integer cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}

	public Date getFechaVenta() {
		return this.fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getModificacionProductoVenta() {
		return this.modificacionProductoVenta;
	}

	public void setModificacionProductoVenta(String modificacionProductoVenta) {
		this.modificacionProductoVenta = modificacionProductoVenta;
	}

	public double getSubtotalVenta() {
		return this.subtotalVenta;
	}

	public void setSubtotalVenta(double subtotalVenta) {
		this.subtotalVenta = subtotalVenta;
	}

	public double getValorAdicionalVenta() {
		return this.valorAdicionalVenta;
	}

	public void setValorAdicionalVenta(double valorAdicionalVenta) {
		this.valorAdicionalVenta = valorAdicionalVenta;
	}

	public FacturaIndumaq getFactura() {
		return this.factura;
	}

	public void setFactura(FacturaIndumaq factura) {
		this.factura = factura;
	}

	public ProductoIndumaq getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoIndumaq producto) {
		this.producto = producto;
	}

	public double getDescuentoVenta() {
		return descuentoVenta;
	}

	public void setDescuentoVenta(double descuentoVenta) {
		this.descuentoVenta = descuentoVenta;
	}

	public String getMotivoDescuentoVenta() {
		return motivoDescuentoVenta;
	}

	public void setMotivoDescuentoVenta(String motivoDescuentoVenta) {
		this.motivoDescuentoVenta = motivoDescuentoVenta;
	}

}