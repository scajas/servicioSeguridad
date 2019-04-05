package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordeninventario database table.
 * 
 */
@Entity
@Table(name = "ordeninventario", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Ordeninventario.findAll", query="SELECT o FROM Ordeninventario o")
public class Ordeninventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDENINVENTARIO_IDORDENINVENTARIO_GENERATOR", sequenceName="secuencia_oi",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDENINVENTARIO_IDORDENINVENTARIO_GENERATOR")
	@Column(name="id_ordeninventario")
	private String idOrdeninventario;

	@Column(name="auxid_oi")
	private Integer auxidOi;

	@Column(name="descr_oi")
	private String descrOi;

	@Column(name="estado_oi")
	private String estadoOi;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaingreso_oi")
	private Date fechaingresoOi;

	@Column(name="motivo_estado")
	private String motivoEstado;

	@Column(name="responsable_oi")
	private String responsableOi;

	//bi-directional many-to-one association to Movimientosinventario
	@OneToMany(mappedBy="ordeninventario")
	private List<Movimientosinventario> movimientosinventarios;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="id_compra")
	private Compra compra;

	//bi-directional many-to-one association to Detalleorden
	@ManyToOne
	@JoinColumn(name="id_detalleorden")
	private Detalleorden detalleorden;

	//bi-directional many-to-one association to Tipordeninv
	@ManyToOne
	@JoinColumn(name="id_tipordeninv")
	private Tipordeninv tipordeninv;

	//bi-directional many-to-one association to Unidad
	@ManyToOne
	@JoinColumn(name="id_unidad")
	private UnidadLabo unidad;

	public Ordeninventario() {
	}

	public String getIdOrdeninventario() {
		return this.idOrdeninventario;
	}

	public void setIdOrdeninventario(String idOrdeninventario) {
		this.idOrdeninventario = idOrdeninventario;
	}

	public Integer getAuxidOi() {
		return this.auxidOi;
	}

	public void setAuxidOi(Integer auxidOi) {
		this.auxidOi = auxidOi;
	}

	public String getDescrOi() {
		return this.descrOi;
	}

	public void setDescrOi(String descrOi) {
		this.descrOi = descrOi;
	}

	public String getEstadoOi() {
		return this.estadoOi;
	}

	public void setEstadoOi(String estadoOi) {
		this.estadoOi = estadoOi;
	}

	public Date getFechaingresoOi() {
		return this.fechaingresoOi;
	}

	public void setFechaingresoOi(Date fechaingresoOi) {
		this.fechaingresoOi = fechaingresoOi;
	}

	public String getMotivoEstado() {
		return this.motivoEstado;
	}

	public void setMotivoEstado(String motivoEstado) {
		this.motivoEstado = motivoEstado;
	}

	public String getResponsableOi() {
		return this.responsableOi;
	}

	public void setResponsableOi(String responsableOi) {
		this.responsableOi = responsableOi;
	}

	public List<Movimientosinventario> getMovimientosinventarios() {
		return this.movimientosinventarios;
	}

	public void setMovimientosinventarios(List<Movimientosinventario> movimientosinventarios) {
		this.movimientosinventarios = movimientosinventarios;
	}

	public Movimientosinventario addMovimientosinventario(Movimientosinventario movimientosinventario) {
		getMovimientosinventarios().add(movimientosinventario);
		movimientosinventario.setOrdeninventario(this);

		return movimientosinventario;
	}

	public Movimientosinventario removeMovimientosinventario(Movimientosinventario movimientosinventario) {
		getMovimientosinventarios().remove(movimientosinventario);
		movimientosinventario.setOrdeninventario(null);

		return movimientosinventario;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Detalleorden getDetalleorden() {
		return this.detalleorden;
	}

	public void setDetalleorden(Detalleorden detalleorden) {
		this.detalleorden = detalleorden;
	}

	public Tipordeninv getTipordeninv() {
		return this.tipordeninv;
	}

	public void setTipordeninv(Tipordeninv tipordeninv) {
		this.tipordeninv = tipordeninv;
	}

	public UnidadLabo getUnidad() {
		return this.unidad;
	}

	public void setUnidad(UnidadLabo unidad) {
		this.unidad = unidad;
	}

}