package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the pagos_factura database table.
 * 
 */
@Entity
@Table(name = "pagos_factura", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "PagosFacturaIndumaq.findAll", query = "SELECT p FROM PagosFacturaIndumaq p")
public class PagosFacturaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pago_factura")
	private Integer idPagoFactura;

	@Column(name = "monto_pago_factura")
	private double montoPagoFactura;

	@Column(name = "saldo_pago_factura")
	private double saldoPagoFactura;

	// bi-directional many-to-one association to FormaPagosFactura
	@ManyToOne
	@JoinColumn(name = "id_forma_pago")
	private FormaPagosFacturaIndumaq formaPagosFactura;

	@ManyToOne
	@JoinColumn(name = "id_factura")
	private FacturaIndumaq factura;

	public FacturaIndumaq getFactura() {
		return factura;
	}

	public void setFactura(FacturaIndumaq factura) {
		this.factura = factura;
	}

	public PagosFacturaIndumaq() {
	}

	public Integer getIdPagoFactura() {
		return this.idPagoFactura;
	}

	public void setIdPagoFactura(Integer idPagoFactura) {
		this.idPagoFactura = idPagoFactura;
	}

	public double getMontoPagoFactura() {
		return this.montoPagoFactura;
	}

	public void setMontoPagoFactura(double montoPagoFactura) {
		this.montoPagoFactura = montoPagoFactura;
	}

	public double getSaldoPagoFactura() {
		return this.saldoPagoFactura;
	}

	public void setSaldoPagoFactura(double saldoPagoFactura) {
		this.saldoPagoFactura = saldoPagoFactura;
	}

	public FormaPagosFacturaIndumaq getFormaPagosFactura() {
		return this.formaPagosFactura;
	}

	public void setFormaPagosFactura(FormaPagosFacturaIndumaq formaPagosFactura) {
		this.formaPagosFactura = formaPagosFactura;
	}

}