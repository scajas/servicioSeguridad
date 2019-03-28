package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;



/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
@Table(name = "tipocliente", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Tipocliente.findAll", query="SELECT t FROM Tipocliente t")
public class Tipocliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOCLIENTE_IDTIPOCLIENTE_GENERATOR", sequenceName="secuencia_tipocliente",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOCLIENTE_IDTIPOCLIENTE_GENERATOR")
	@Column(name="id_tipocliente")
	private int idTipocliente;

	@Column(name="descr_tcl")
	private String descrTcl;

	@Column(name="factura_tcl")
	private String facturaTcl;

	@Column(name="iva_tcl")
	private BigDecimal ivaTcl;

	@Column(name="tipo_tcl")
	private String tipoTcl;

	//bi-directional many-to-one association to Cliente
	//@OneToMany(mappedBy="tipocliente")
	//private List<Cliente> clientes;

	public Tipocliente() {
	}

	

	public int getIdTipocliente() {
		return idTipocliente;
	}



	public void setIdTipocliente(int idTipocliente) {
		this.idTipocliente = idTipocliente;
	}



	public String getDescrTcl() {
		return this.descrTcl;
	}

	public void setDescrTcl(String descrTcl) {
		this.descrTcl = descrTcl;
	}

	public String getFacturaTcl() {
		return this.facturaTcl;
	}

	public void setFacturaTcl(String facturaTcl) {
		this.facturaTcl = facturaTcl;
	}

	public BigDecimal getIvaTcl() {
		return this.ivaTcl;
	}

	public void setIvaTcl(BigDecimal ivaTcl) {
		this.ivaTcl = ivaTcl;
	}

	public String getTipoTcl() {
		return this.tipoTcl;
	}

	public void setTipoTcl(String tipoTcl) {
		this.tipoTcl = tipoTcl;
	}

	/*public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setTipocliente(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setTipocliente(null);

		return cliente;
	}*/

}