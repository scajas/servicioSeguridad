package ec.indumaq.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@Table(name = "sucursal", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "SucursalIndumaq.findAll", query = "SELECT s FROM SucursalIndumaq s")
public class SucursalIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_sucursal")
	private Integer idSucursal;

	@Column(name = "celular_sucursal")
	private String celularSucursal;

	@Column(name = "direccion_sucursal")
	private String direccionSucursal;

	@Column(name = "email_sucursal")
	private String emailSucursal;

	@Column(name = "nombre_sucursal")
	private String nombreSucursal;

	@Column(name = "telefono_sucursal")
	private String telefonoSucursal;

	@Column(name = "numero_sucursal")
	private String numeroSucursal;

	// bi-directional many-to-one association to Producto
	@OneToMany(mappedBy = "sucursal")
	private List<ProductoIndumaq> productos;

	@OneToMany(mappedBy = "sucursalCaja")
	private List<CajaIndumaq> cajas;

	public List<CajaIndumaq> getCajas() {
		return cajas;
	}

	public void setCajas(List<CajaIndumaq> cajas) {
		this.cajas = cajas;
	}

	public SucursalIndumaq() {
	}

	public Integer getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(Integer idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getCelularSucursal() {
		return this.celularSucursal;
	}

	public void setCelularSucursal(String celularSucursal) {
		this.celularSucursal = celularSucursal;
	}

	public String getDireccionSucursal() {
		return this.direccionSucursal;
	}

	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}

	public String getEmailSucursal() {
		return this.emailSucursal;
	}

	public void setEmailSucursal(String emailSucursal) {
		this.emailSucursal = emailSucursal;
	}

	public String getNombreSucursal() {
		return this.nombreSucursal;
	}

	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	public String getTelefonoSucursal() {
		return this.telefonoSucursal;
	}

	public void setTelefonoSucursal(String telefonoSucursal) {
		this.telefonoSucursal = telefonoSucursal;
	}

	public List<ProductoIndumaq> getProductos() {
		return this.productos;
	}

	public void setProductos(List<ProductoIndumaq> productos) {
		this.productos = productos;
	}

	public String getNumeroSucursal() {
		return numeroSucursal;
	}

	public void setNumeroSucursal(String numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	public ProductoIndumaq addProducto(ProductoIndumaq producto) {
		getProductos().add(producto);
		producto.setSucursal(this);

		return producto;
	}

	public ProductoIndumaq removeProducto(ProductoIndumaq producto) {
		getProductos().remove(producto);
		producto.setSucursal(null);

		return producto;
	}

}