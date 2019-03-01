package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the forma_pagos_factura database table.
 * 
 */
@Entity
@Table(name = "forma_pagos_factura", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name="FormaPagosFacturaIndumaq.findAll", query="SELECT f FROM FormaPagosFacturaIndumaq f")
public class FormaPagosFacturaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_forma_pago")
	private Integer idFormaPago;

	@Column(name="descripcion_forma_pago")
	private String descripcionFormaPago;

	@Column(name="nombre_forma_pago")
	private String nombreFormaPago;

	//bi-directional many-to-one association to PagosFactura
	@OneToMany(mappedBy="formaPagosFactura")
	private List<PagosFacturaIndumaq> pagosFacturas;

	public FormaPagosFacturaIndumaq() {
	}

	public Integer getIdFormaPago() {
		return this.idFormaPago;
	}

	public void setIdFormaPago(Integer idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getDescripcionFormaPago() {
		return this.descripcionFormaPago;
	}

	public void setDescripcionFormaPago(String descripcionFormaPago) {
		this.descripcionFormaPago = descripcionFormaPago;
	}

	public String getNombreFormaPago() {
		return this.nombreFormaPago;
	}

	public void setNombreFormaPago(String nombreFormaPago) {
		this.nombreFormaPago = nombreFormaPago;
	}

	public List<PagosFacturaIndumaq> getPagosFacturas() {
		return this.pagosFacturas;
	}

	public void setPagosFacturas(List<PagosFacturaIndumaq> pagosFacturas) {
		this.pagosFacturas = pagosFacturas;
	}

	public PagosFacturaIndumaq addPagosFactura(PagosFacturaIndumaq pagosFactura) {
		getPagosFacturas().add(pagosFactura);
		pagosFactura.setFormaPagosFactura(this);

		return pagosFactura;
	}

	public PagosFacturaIndumaq removePagosFactura(PagosFacturaIndumaq pagosFactura) {
		getPagosFacturas().remove(pagosFactura);
		pagosFactura.setFormaPagosFactura(null);

		return pagosFactura;
	}

}