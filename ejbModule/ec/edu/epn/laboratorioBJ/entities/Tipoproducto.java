package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoproducto database table.
 * 
 */
@Entity
@Table(name = "tipoproducto", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Tipoproducto.findAll", query="SELECT t FROM Tipoproducto t")
public class Tipoproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOPRODUCTO_IDTIPOPRODUCTO_GENERATOR", sequenceName="secuencia_tipoproducto",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOPRODUCTO_IDTIPOPRODUCTO_GENERATOR")
	@Column(name="id_tipoprod")
	private int idTipoprod;

	@Column(name="descr_tprod")
	private String descrTprod;

	@Column(name="nombre_tprod")
	private String nombreTprod;

	//bi-directional many-to-one association to Existencia
	@OneToMany(mappedBy="tipoproducto")
	private List<Existencia> existencias;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="tipoproducto")
	private List<ProductoLab> productos;

	public Tipoproducto() {
	}

	public int getIdTipoprod() {
		return this.idTipoprod;
	}

	public void setIdTipoprod(int idTipoprod) {
		this.idTipoprod = idTipoprod;
	}

	public String getDescrTprod() {
		return this.descrTprod;
	}

	public void setDescrTprod(String descrTprod) {
		this.descrTprod = descrTprod;
	}

	public String getNombreTprod() {
		return this.nombreTprod;
	}

	public void setNombreTprod(String nombreTprod) {
		this.nombreTprod = nombreTprod;
	}

	public List<Existencia> getExistencias() {
		return this.existencias;
	}

	public void setExistencias(List<Existencia> existencias) {
		this.existencias = existencias;
	}

	public Existencia addExistencia(Existencia existencia) {
		getExistencias().add(existencia);
		existencia.setTipoproducto(this);

		return existencia;
	}

	public Existencia removeExistencia(Existencia existencia) {
		getExistencias().remove(existencia);
		existencia.setTipoproducto(null);

		return existencia;
	}

	public List<ProductoLab> getProductos() {
		return this.productos;
	}

	public void setProductos(List<ProductoLab> productos) {
		this.productos = productos;
	}

	public ProductoLab addProducto(ProductoLab producto) {
		getProductos().add(producto);
		producto.setTipoproducto(this);

		return producto;
	}

	public ProductoLab removeProducto(ProductoLab producto) {
		getProductos().remove(producto);
		producto.setTipoproducto(null);

		return producto;
	}

}