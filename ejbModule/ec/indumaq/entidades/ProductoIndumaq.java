package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "producto", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "ProductoIndumaq.findAll", query = "SELECT p FROM ProductoIndumaq p")
public class ProductoIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_producto")
	private Integer idProducto;

	@Column(name = "descripcion_producto")
	private String descripcionProducto;

	@Column(name = "nombre_producto")
	private String nombreProducto;

	@Column(name = "stock_producto")
	private Integer stockProducto;

	@Column(name = "valor_unitario_producto")
	private double valorUnitarioProducto;

	// bi-directional many-to-one association to DetalleProducto
	@OneToMany(mappedBy = "producto")
	private List<DetalleProductoIndumaq> detalleProductos;

	// bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaProductoIndumaq categoria;

	// bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private SucursalIndumaq sucursal;

	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private ProveedorIndumaq proveedor;

	// bi-directional many-to-one association to Venta
	@OneToMany(mappedBy = "producto")
	private List<VentaIndumaq> ventas;

	public ProductoIndumaq() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcionProducto() {
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getStockProducto() {
		return this.stockProducto;
	}

	public void setStockProducto(Integer stockProducto) {
		this.stockProducto = stockProducto;
	}

	public double getValorUnitarioProducto() {
		return this.valorUnitarioProducto;
	}

	public void setValorUnitarioProducto(double valorUnitarioProducto) {
		this.valorUnitarioProducto = valorUnitarioProducto;
	}

	public List<DetalleProductoIndumaq> getDetalleProductos() {
		return this.detalleProductos;
	}

	public void setDetalleProductos(List<DetalleProductoIndumaq> detalleProductos) {
		this.detalleProductos = detalleProductos;
	}

	public DetalleProductoIndumaq addDetalleProducto(DetalleProductoIndumaq detalleProducto) {
		getDetalleProductos().add(detalleProducto);
		detalleProducto.setProducto(this);

		return detalleProducto;
	}

	public DetalleProductoIndumaq removeDetalleProducto(DetalleProductoIndumaq detalleProducto) {
		getDetalleProductos().remove(detalleProducto);
		detalleProducto.setProducto(null);

		return detalleProducto;
	}

	public CategoriaProductoIndumaq getCategoria() {
		return this.categoria;
	}

	public void setCategoria(CategoriaProductoIndumaq categoria) {
		this.categoria = categoria;
	}

	public SucursalIndumaq getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(SucursalIndumaq sucursal) {
		this.sucursal = sucursal;
	}

	public List<VentaIndumaq> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<VentaIndumaq> ventas) {
		this.ventas = ventas;
	}

	public ProveedorIndumaq getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorIndumaq proveedor) {
		this.proveedor = proveedor;
	}

	public VentaIndumaq addVenta(VentaIndumaq venta) {
		getVentas().add(venta);
		venta.setProducto(this);

		return venta;
	}

	public VentaIndumaq removeVenta(VentaIndumaq venta) {
		getVentas().remove(venta);
		venta.setProducto(null);

		return venta;
	}

}