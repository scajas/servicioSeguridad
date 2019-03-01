package ec.indumaq.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "proveedor", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "ProveedorIndumaq.findAll", query = "SELECT p FROM ProveedorIndumaq p")
public class ProveedorIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "nombre_proveedor")
	private String nombreProveedor;

	@Column(name = "ruc_proveedor")
	private String rucProveedor;

	@Column(name = "email_proveedor")
	private String emailProveedor;

	@Column(name = "telf_proveedor")
	private String telfProveedor;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getRucProveedor() {
		return rucProveedor;
	}

	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	public String getTelfProveedor() {
		return telfProveedor;
	}

	public void setTelfProveedor(String telfProveedor) {
		this.telfProveedor = telfProveedor;
	}

}