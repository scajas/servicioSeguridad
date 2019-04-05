package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proforma database table.
 * 
 */
@Entity
@Table(name = "`proforma`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="Proforma.findAll", query="SELECT p FROM Proforma p")
public class Proforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_proforma")
	private String idProforma;

	@Column(name="auxid_proforma")
	private Integer auxidProforma;

	@Column(name="estado_po")
	private String estadoPo;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="iva_po")
	private double ivaPo;

	@Column(name="motivo_estadopo")
	private String motivoEstadopo;

	@Column(name="obser_po")
	private String obserPo;

	@Column(name="representante_po")
	private String representantePo;

	@Column(name="subtotal_po")
	private double subtotalPo;

	@Column(name="total_po")
	private double totalPo;

	//bi-directional many-to-one association to DetalleProforma
	@OneToMany(mappedBy="proforma")
	private List<DetalleProforma> detalleProformas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	public Proforma() {
	}

	public String getIdProforma() {
		return this.idProforma;
	}

	public void setIdProforma(String idProforma) {
		this.idProforma = idProforma;
	}

	public Integer getAuxidProforma() {
		return this.auxidProforma;
	}

	public void setAuxidProforma(Integer auxidProforma) {
		this.auxidProforma = auxidProforma;
	}

	public String getEstadoPo() {
		return this.estadoPo;
	}

	public void setEstadoPo(String estadoPo) {
		this.estadoPo = estadoPo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getIvaPo() {
		return this.ivaPo;
	}

	public void setIvaPo(double ivaPo) {
		this.ivaPo = ivaPo;
	}

	public String getMotivoEstadopo() {
		return this.motivoEstadopo;
	}

	public void setMotivoEstadopo(String motivoEstadopo) {
		this.motivoEstadopo = motivoEstadopo;
	}

	public String getObserPo() {
		return this.obserPo;
	}

	public void setObserPo(String obserPo) {
		this.obserPo = obserPo;
	}

	public String getRepresentantePo() {
		return this.representantePo;
	}

	public void setRepresentantePo(String representantePo) {
		this.representantePo = representantePo;
	}

	public double getSubtotalPo() {
		return this.subtotalPo;
	}

	public void setSubtotalPo(double subtotalPo) {
		this.subtotalPo = subtotalPo;
	}

	public double getTotalPo() {
		return this.totalPo;
	}

	public void setTotalPo(double totalPo) {
		this.totalPo = totalPo;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleProformas;
	}

	public void setDetalleProformas(List<DetalleProforma> detalleProformas) {
		this.detalleProformas = detalleProformas;
	}

	public DetalleProforma addDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().add(detalleProforma);
		detalleProforma.setProforma(this);

		return detalleProforma;
	}

	public DetalleProforma removeDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().remove(detalleProforma);
		detalleProforma.setProforma(null);

		return detalleProforma;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}