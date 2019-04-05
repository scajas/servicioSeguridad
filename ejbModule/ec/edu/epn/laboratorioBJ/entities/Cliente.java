package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "`cliente`", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@SequenceGenerator(name = "CLIENTE_IDCLIENTE_GENERATOR", sequenceName = "secuencia_cliente", allocationSize = 1, catalog = "bddcorpepn", schema = "`Laboratorios`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_IDCLIENTE_GENERATOR")

	@Column(name = "id_cliente")
	private int idCliente;
 
	private String cedula;

	@Column(name = "celular_cl")
	private String celularCl;

	@Column(name = "contacto_cl")
	private String contactoCl;

	@Column(name = "direccion_cl")
	private String direccionCl;

	@Column(name = "email_cl")
	private String emailCl;

	@Column(name = "fax_cl")
	private String faxCl;

	private Timestamp fechatrans;

	@Column(name = "nombre_cl")
	private String nombreCl;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column(name = "otrofono_cl")
	private String otrofonoCl;

	@Column(name = "pasaporte_cl")
	private String pasaporteCl;

	@Column(name = "ruc_cl")
	private String rucCl;

	@Column(name = "telefono_cl")
	private String telefonoCl;

	// bi-directional many-to-one association to Tipocliente
	@ManyToOne
	@JoinColumn(name = "id_tipocliente")
	private Tipocliente tipocliente;

	// bi-directional many-to-one association to OrdenTrabajo
	@OneToMany(mappedBy = "cliente")
	private List<OrdenTrabajo> ordenTrabajos;

	// bi-directional many-to-one association to Proforma
	@OneToMany(mappedBy = "cliente")
	private List<Proforma> proformas;

	public Cliente() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelularCl() {
		return this.celularCl;
	}

	public void setCelularCl(String celularCl) {
		this.celularCl = celularCl;
	}

	public String getContactoCl() {
		return this.contactoCl;
	}

	public void setContactoCl(String contactoCl) {
		this.contactoCl = contactoCl;
	}

	public String getDireccionCl() {
		return this.direccionCl;
	}

	public void setDireccionCl(String direccionCl) {
		this.direccionCl = direccionCl;
	}

	public String getEmailCl() {
		return this.emailCl;
	}

	public void setEmailCl(String emailCl) {
		this.emailCl = emailCl;
	}

	public String getFaxCl() {
		return this.faxCl;
	}

	public void setFaxCl(String faxCl) {
		this.faxCl = faxCl;
	}

	public Timestamp getFechatrans() {
		return this.fechatrans;
	}

	public void setFechatrans(Timestamp fechatrans) {
		this.fechatrans = fechatrans;
	}

	public String getNombreCl() {
		return this.nombreCl;
	}

	public void setNombreCl(String nombreCl) {
		this.nombreCl = nombreCl;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getOtrofonoCl() {
		return this.otrofonoCl;
	}

	public void setOtrofonoCl(String otrofonoCl) {
		this.otrofonoCl = otrofonoCl;
	}

	public String getPasaporteCl() {
		return this.pasaporteCl;
	}

	public void setPasaporteCl(String pasaporteCl) {
		this.pasaporteCl = pasaporteCl;
	}

	public String getRucCl() {
		return this.rucCl;
	}

	public void setRucCl(String rucCl) {
		this.rucCl = rucCl;
	}

	public String getTelefonoCl() {
		return this.telefonoCl;
	}

	public void setTelefonoCl(String telefonoCl) {
		this.telefonoCl = telefonoCl;
	}

	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}

	public List<OrdenTrabajo> getOrdenTrabajos() {
		return this.ordenTrabajos;
	}

	public void setOrdenTrabajos(List<OrdenTrabajo> ordenTrabajos) {
		this.ordenTrabajos = ordenTrabajos;
	}

	public OrdenTrabajo addOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		getOrdenTrabajos().add(ordenTrabajo);
		ordenTrabajo.setCliente(this);

		return ordenTrabajo;
	}

	public OrdenTrabajo removeOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
		getOrdenTrabajos().remove(ordenTrabajo);
		ordenTrabajo.setCliente(null);

		return ordenTrabajo;
	}

	public List<Proforma> getProformas() {
		return this.proformas;
	}

	public void setProformas(List<Proforma> proformas) {
		this.proformas = proformas;
	}

	public Proforma addProforma(Proforma proforma) {
		getProformas().add(proforma);
		proforma.setCliente(this);

		return proforma;
	}

	public Proforma removeProforma(Proforma proforma) {
		getProformas().remove(proforma);
		proforma.setCliente(null);

		return proforma;
	}

}