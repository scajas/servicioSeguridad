package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name="categoria_producto", catalog="`bddcorpepn`", schema="`indumaq`")
@NamedQuery(name="CategoriaProductoIndumaq.findAll", query="SELECT c FROM CategoriaProductoIndumaq c")
public class CategoriaProductoIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_categoria")
	private Integer idCategoria;

	@Column(name="descripcion_categoria")
	private String descripcionCategoria;

	@Column(name="nombre_categoria")
	private String nombreCategoria;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="categoria")
	private List<ProductoIndumaq> productos;

	public CategoriaProductoIndumaq() {
	}

	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return this.descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public String getNombreCategoria() {
		return this.nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<ProductoIndumaq> getProductos() {
		return this.productos;
	}

	public void setProductos(List<ProductoIndumaq> productos) {
		this.productos = productos;
	}

	public ProductoIndumaq addProducto(ProductoIndumaq producto) {
		getProductos().add(producto);
		producto.setCategoria(this);

		return producto;
	}

	public ProductoIndumaq removeProducto(ProductoIndumaq producto) {
		getProductos().remove(producto);
		producto.setCategoria(null);

		return producto;
	}

}