package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name = "proveedor", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name = "ProveedorLab.findAll", query = "SELECT p FROM ProveedorLab p")
public class ProveedorLab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROVEEDOR_IDPROVEEDOR_GENERATOR", sequenceName = "secuencia_proveedor", allocationSize = 1, catalog = "bddcorpepn", schema = "`Laboratorios`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_IDPROVEEDOR_GENERATOR")
	@Column(name = "id_proveedor")
	private int idProveedor;

	@Column(name = "descr_pv")
	private String descrPv;

	@Column(name = "direccion_pv")
	private String direccionPv;

	@Column(name = "email_pv")
	private String emailPv;

	@Column(name = "nombre_pv")
	private String nombrePv;

	@Column(name = "ruc_pv")
	private String rucPv;

	@Column(name = "telefono_pv")
	private String telefonoPv;

	// bi-directional many-to-one association to Compra
	@OneToMany(mappedBy = "proveedor")
	private List<Compra> compras;

	// bi-directional many-to-one association to Tipoproveedor
	@ManyToOne
	@JoinColumn(name = "id_tipoproveedor")
	private Tipoproveedor tipoproveedor;

	public ProveedorLab() {
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getDescrPv() {
		return this.descrPv;
	}

	public void setDescrPv(String descrPv) {
		this.descrPv = descrPv;
	}

	public String getDireccionPv() {
		return this.direccionPv;
	}

	public void setDireccionPv(String direccionPv) {
		this.direccionPv = direccionPv;
	}

	public String getEmailPv() {
		return this.emailPv;
	}

	public void setEmailPv(String emailPv) {
		this.emailPv = emailPv;
	}

	public String getNombrePv() {
		return this.nombrePv;
	}

	public void setNombrePv(String nombrePv) {
		this.nombrePv = nombrePv;
	}

	public String getRucPv() {
		return this.rucPv;
	}

	public void setRucPv(String rucPv) {
		this.rucPv = rucPv;
	}

	public String getTelefonoPv() {
		return this.telefonoPv;
	}

	public void setTelefonoPv(String telefonoPv) {
		this.telefonoPv = telefonoPv;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setProveedor(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setProveedor(null);

		return compra;
	}

	public Tipoproveedor getTipoproveedor() {
		return this.tipoproveedor;
	}

	public void setTipoproveedor(Tipoproveedor tipoproveedor) {
		this.tipoproveedor = tipoproveedor;
	}

} 