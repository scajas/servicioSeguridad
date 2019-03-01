package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the detalle_producto database table.
 * 
 */
@Entity
@Table(name = "detalle_producto", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "DetalleProductoIndumaq.findAll", query = "SELECT d FROM DetalleProductoIndumaq d")
public class DetalleProductoIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_detalle_producto")
	private Integer idDetalleProducto;

	@Column(name = "nombre_detalle_producto")
	private String nombreDetalleProducto;

	@Column(name = "valor_detalle_producto")
	private double valorDetalleProducto;

	// bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoIndumaq producto;

	public DetalleProductoIndumaq() {
	}

	public Integer getIdDetalleProducto() {
		return this.idDetalleProducto;
	}

	public void setIdDetalleProducto(Integer idDetalleProducto) {
		this.idDetalleProducto = idDetalleProducto;
	}

	public String getNombreDetalleProducto() {
		return this.nombreDetalleProducto;
	}

	public void setNombreDetalleProducto(String nombreDetalleProducto) {
		this.nombreDetalleProducto = nombreDetalleProducto;
	}

	public ProductoIndumaq getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoIndumaq producto) {
		this.producto = producto;
	}

	public double getValorDetalleProducto() {
		return valorDetalleProducto;
	}

	public void setValorDetalleProducto(double valorDetalleProducto) {
		this.valorDetalleProducto = valorDetalleProducto;
	}

}