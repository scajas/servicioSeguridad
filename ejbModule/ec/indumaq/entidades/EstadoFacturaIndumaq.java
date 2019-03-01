package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_factura database table.
 * 
 */
@Entity
@Table(name="estado_factura", catalog="`bddcorpepn`", schema="`indumaq`")
@NamedQuery(name="EstadoFacturaIndumaq.findAll", query="SELECT e FROM EstadoFacturaIndumaq e")
public class EstadoFacturaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado_factura")
	private Integer idEstadoFactura;

	@Column(name="activo_estado_factura")
	private String activoEstadoFactura;

	@Column(name="descripcion_estado_factura")
	private String descripcionEstadoFactura;

	@Column(name="nombre_esatdo_factura")
	private String nombreEsatdoFactura;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="estadoFactura")
	private List<FacturaIndumaq> facturas;

	public EstadoFacturaIndumaq() {
	}

	public Integer getIdEstadoFactura() {
		return this.idEstadoFactura;
	}

	public void setIdEstadoFactura(Integer idEstadoFactura) {
		this.idEstadoFactura = idEstadoFactura;
	}

	public String getActivoEstadoFactura() {
		return this.activoEstadoFactura;
	}

	public void setActivoEstadoFactura(String activoEstadoFactura) {
		this.activoEstadoFactura = activoEstadoFactura;
	}

	public String getDescripcionEstadoFactura() {
		return this.descripcionEstadoFactura;
	}

	public void setDescripcionEstadoFactura(String descripcionEstadoFactura) {
		this.descripcionEstadoFactura = descripcionEstadoFactura;
	}

	public String getNombreEsatdoFactura() {
		return this.nombreEsatdoFactura;
	}

	public void setNombreEsatdoFactura(String nombreEsatdoFactura) {
		this.nombreEsatdoFactura = nombreEsatdoFactura;
	}

	public List<FacturaIndumaq> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<FacturaIndumaq> facturas) {
		this.facturas = facturas;
	}

	public FacturaIndumaq addFactura(FacturaIndumaq factura) {
		getFacturas().add(factura);
		factura.setEstadoFactura(this);

		return factura;
	}

	public FacturaIndumaq removeFactura(FacturaIndumaq factura) {
		getFacturas().remove(factura);
		factura.setEstadoFactura(null);

		return factura;
	}

}