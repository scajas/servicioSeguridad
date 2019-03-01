package ec.indumaq.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "cliente", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "ClienteIndumaq.findAll", query = "SELECT c FROM ClienteIndumaq c")
public class ClienteIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "cedula_cliente")
	private String cedulaCliente;

	@Column(name = "direccion_cliente")
	private String direccionCliente;

	@Column(name = "email_cliente")
	private String emailCliente;

	@Column(name = "nombre_cliente")
	private String nombreCliente;

	@Column(name = "telefono_cliente")
	private String telefonoCliente;

	// bi-directional many-to-one association to Factura
	@OneToMany(mappedBy = "cliente")
	private List<FacturaIndumaq> facturas;

	public ClienteIndumaq() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCedulaCliente() {
		return this.cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public String getDireccionCliente() {
		return this.direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<FacturaIndumaq> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<FacturaIndumaq> facturas) {
		this.facturas = facturas;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public FacturaIndumaq addFactura(FacturaIndumaq factura) {
		getFacturas().add(factura);
		factura.setCliente(this);

		return factura;
	}

	public FacturaIndumaq removeFactura(FacturaIndumaq factura) {
		getFacturas().remove(factura);
		factura.setCliente(null);

		return factura;
	}

}