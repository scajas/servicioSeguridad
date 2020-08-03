package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@Table(name="proveedor", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proveedor")
	private Integer idProveedor;

	@Column(name="direccion_proveedor")
	private String direccionProveedor;

	@Column(name="email_proveedor")
	private String emailProveedor;

	@Column(name="nombre_empresa_proveedor")
	private String nombreEmpresaProveedor;

	@Column(name="nombrecontacto_proveedor")
	private String nombrecontactoProveedor;

	@Column(name="nomservpro_proveedor")
	private String nomservproProveedor;

	@Column(name="ruc_proveedor")
	private String rucProveedor;

	@Column(name="telefono_proveedor")
	private String telefonoProveedor;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy="proveedor")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	//bi-directional many-to-one association to Tipoproductoservicio
	@ManyToOne
	@JoinColumn(name="id_tipoproservicio")
	private Tipoproductoservicio tipoproductoservicio;

	public Proveedor() {
	}

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getDireccionProveedor() {
		return this.direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getEmailProveedor() {
		return this.emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	public String getNombreEmpresaProveedor() {
		return this.nombreEmpresaProveedor;
	}

	public void setNombreEmpresaProveedor(String nombreEmpresaProveedor) {
		this.nombreEmpresaProveedor = nombreEmpresaProveedor;
	}

	public String getNombrecontactoProveedor() {
		return this.nombrecontactoProveedor;
	}

	public void setNombrecontactoProveedor(String nombrecontactoProveedor) {
		this.nombrecontactoProveedor = nombrecontactoProveedor;
	}

	public String getNomservproProveedor() {
		return this.nomservproProveedor;
	}

	public void setNomservproProveedor(String nomservproProveedor) {
		this.nomservproProveedor = nomservproProveedor;
	}

	public String getRucProveedor() {
		return this.rucProveedor;
	}

	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}

	public String getTelefonoProveedor() {
		return this.telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setProveedor(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setProveedor(null);

		return equiposcalibracionequipo;
	}

	public Tipoproductoservicio getTipoproductoservicio() {
		return this.tipoproductoservicio;
	}

	public void setTipoproductoservicio(Tipoproductoservicio tipoproductoservicio) {
		this.tipoproductoservicio = tipoproductoservicio;
	}

}