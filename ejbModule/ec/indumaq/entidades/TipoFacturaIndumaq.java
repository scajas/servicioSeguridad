package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_factura database table.
 * 
 */
@Entity
@Table(name="tipo_factura", catalog="`bddcorpepn`", schema="`indumaq`")
@NamedQuery(name="TipoFacturaIndumaq.findAll", query="SELECT t FROM TipoFacturaIndumaq t")
public class TipoFacturaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_factura")
	private Integer idTipoFactura;

	@Column(name="activo_tipo_factura")
	private String activoTipoFactura;

	@Column(name="descripcion_tipo_factura")
	private String descripcionTipoFactura;

	@Column(name="nombre_tipo_factura")
	private String nombreTipoFactura;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="tipoFactura")
	private List<FacturaIndumaq> facturas;

	public TipoFacturaIndumaq() {
	}

	public Integer getIdTipoFactura() {
		return this.idTipoFactura;
	}

	public void setIdTipoFactura(Integer idTipoFactura) {
		this.idTipoFactura = idTipoFactura;
	}

	public String getActivoTipoFactura() {
		return this.activoTipoFactura;
	}

	public void setActivoTipoFactura(String activoTipoFactura) {
		this.activoTipoFactura = activoTipoFactura;
	}

	public String getDescripcionTipoFactura() {
		return this.descripcionTipoFactura;
	}

	public void setDescripcionTipoFactura(String descripcionTipoFactura) {
		this.descripcionTipoFactura = descripcionTipoFactura;
	}

	public String getNombreTipoFactura() {
		return this.nombreTipoFactura;
	}

	public void setNombreTipoFactura(String nombreTipoFactura) {
		this.nombreTipoFactura = nombreTipoFactura;
	}

	public List<FacturaIndumaq> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<FacturaIndumaq> facturas) {
		this.facturas = facturas;
	}

	public FacturaIndumaq addFactura(FacturaIndumaq factura) {
		getFacturas().add(factura);
		factura.setTipoFactura(this);

		return factura;
	}

	public FacturaIndumaq removeFactura(FacturaIndumaq factura) {
		getFacturas().remove(factura);
		factura.setTipoFactura(null);

		return factura;
	}

}