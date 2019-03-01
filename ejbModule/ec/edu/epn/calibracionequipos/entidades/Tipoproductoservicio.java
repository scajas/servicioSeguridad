package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoproductoservicio database table.
 * 
 */
@Entity
@Table(name="tipoproductoservicio", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipoproductoservicio.findAll", query="SELECT t FROM Tipoproductoservicio t")
public class Tipoproductoservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoproservicio")
	private Integer idTipoproservicio;

	@Column(name="descripcion_tipoproservicio")
	private String descripcionTipoproservicio;

	@Column(name="nombre_tipoproservicio")
	private String nombreTipoproservicio;

	//bi-directional many-to-one association to Proveedor
	@OneToMany(mappedBy="tipoproductoservicio")
	private List<Proveedor> proveedors;

	public Tipoproductoservicio() {
	}

	public Integer getIdTipoproservicio() {
		return this.idTipoproservicio;
	}

	public void setIdTipoproservicio(Integer idTipoproservicio) {
		this.idTipoproservicio = idTipoproservicio;
	}

	public String getDescripcionTipoproservicio() {
		return this.descripcionTipoproservicio;
	}

	public void setDescripcionTipoproservicio(String descripcionTipoproservicio) {
		this.descripcionTipoproservicio = descripcionTipoproservicio;
	}

	public String getNombreTipoproservicio() {
		return this.nombreTipoproservicio;
	}

	public void setNombreTipoproservicio(String nombreTipoproservicio) {
		this.nombreTipoproservicio = nombreTipoproservicio;
	}

	public List<Proveedor> getProveedors() {
		return this.proveedors;
	}

	public void setProveedors(List<Proveedor> proveedors) {
		this.proveedors = proveedors;
	}

	public Proveedor addProveedor(Proveedor proveedor) {
		getProveedors().add(proveedor);
		proveedor.setTipoproductoservicio(this);

		return proveedor;
	}

	public Proveedor removeProveedor(Proveedor proveedor) {
		getProveedors().remove(proveedor);
		proveedor.setTipoproductoservicio(null);

		return proveedor;
	}

}