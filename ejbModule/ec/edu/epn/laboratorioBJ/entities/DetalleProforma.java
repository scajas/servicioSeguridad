package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_proforma database table.
 * 
 */
@Entity
@Table(name = "detalle_proforma", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="DetalleProforma.findAll", query="SELECT d FROM DetalleProforma d")
public class DetalleProforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detallepo")
	private String idDetallepo;

	@Column(name="cantidad_po")
	private Integer cantidadPo;

	@Column(name="id_laboratorio")
	private String idLaboratorio;

	@Column(name="totalservicio_po")
	private float totalservicioPo;

	@Column(name="valorunitario_po")
	private float valorunitarioPo;

	//bi-directional many-to-one association to Metodo
	@ManyToOne
	@JoinColumn(name="id_metodo")
	private Metodo metodo;

	//bi-directional many-to-one association to Proforma
	@ManyToOne
	@JoinColumn(name="id_proforma")
	private Proforma proforma;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="id_servicio")
	private Servicio servicio;

	public DetalleProforma() {
	}

	public String getIdDetallepo() {
		return this.idDetallepo;
	}

	public void setIdDetallepo(String idDetallepo) {
		this.idDetallepo = idDetallepo;
	}

	public Integer getCantidadPo() {
		return this.cantidadPo;
	}

	public void setCantidadPo(Integer cantidadPo) {
		this.cantidadPo = cantidadPo;
	}

	public String getIdLaboratorio() {
		return this.idLaboratorio;
	}

	public void setIdLaboratorio(String idLaboratorio) {
		this.idLaboratorio = idLaboratorio;
	}

	public float getTotalservicioPo() {
		return this.totalservicioPo;
	}

	public void setTotalservicioPo(float totalservicioPo) {
		this.totalservicioPo = totalservicioPo;
	}

	public float getValorunitarioPo() {
		return this.valorunitarioPo;
	}

	public void setValorunitarioPo(float valorunitarioPo) {
		this.valorunitarioPo = valorunitarioPo;
	}

	public Metodo getMetodo() {
		return this.metodo;
	}

	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}