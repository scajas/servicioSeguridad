package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
@Table(name = "`compra`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_compra")
	private String idCompra;

	private Integer auxidcompra;

	@Column(name="descr_compra")
	private String descrCompra;

	@Column(name="documento_co")
	private String documentoCo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_co")
	private Date fechaCo;

	@Column(name="monto_co")
	private double montoCo;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private ProveedorLab proveedor;

	//bi-directional many-to-one association to Unidad
	@ManyToOne
	@JoinColumn(name="id_unidad")
	private UnidadLabo unidad;

	//bi-directional many-to-one association to Ordeninventario
	@OneToMany(mappedBy="compra")
	private List<Ordeninventario> ordeninventarios;

	public Compra() {
	}

	public String getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getAuxidcompra() {
		return this.auxidcompra;
	}

	public void setAuxidcompra(Integer auxidcompra) {
		this.auxidcompra = auxidcompra;
	}

	public String getDescrCompra() {
		return this.descrCompra;
	}

	public void setDescrCompra(String descrCompra) {
		this.descrCompra = descrCompra;
	}

	public String getDocumentoCo() {
		return this.documentoCo;
	}

	public void setDocumentoCo(String documentoCo) {
		this.documentoCo = documentoCo;
	}

	public Date getFechaCo() {
		return this.fechaCo;
	}

	public void setFechaCo(Date fechaCo) {
		this.fechaCo = fechaCo;
	}

	public double getMontoCo() {
		return this.montoCo;
	}

	public void setMontoCo(double montoCo) {
		this.montoCo = montoCo;
	}

	public ProveedorLab getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(ProveedorLab proveedor) {
		this.proveedor = proveedor;
	}

	public UnidadLabo getUnidad() {
		return this.unidad;
	}

	public void setUnidad(UnidadLabo unidad) {
		this.unidad = unidad;
	}

	public List<Ordeninventario> getOrdeninventarios() {
		return this.ordeninventarios;
	}

	public void setOrdeninventarios(List<Ordeninventario> ordeninventarios) {
		this.ordeninventarios = ordeninventarios;
	}

	public Ordeninventario addOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().add(ordeninventario);
		ordeninventario.setCompra(this);

		return ordeninventario;
	}

	public Ordeninventario removeOrdeninventario(Ordeninventario ordeninventario) {
		getOrdeninventarios().remove(ordeninventario);
		ordeninventario.setCompra(null);

		return ordeninventario;
	}

}