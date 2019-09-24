package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the movimientosinventario database table.
 * 
 */
@Entity
@Table(name = "movimientosinventario", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Movimientosinventario.findAll", query="SELECT m FROM Movimientosinventario m")
public class Movimientosinventario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVINVENTARIO_IDMOVIMIENTO_GENERATOR", sequenceName="secuencia_movinventario",allocationSize=1, catalog="bddcorpepn",schema="`Laboratorios`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVINVENTARIO_IDMOVIMIENTO_GENERATOR")
	@Column(name="id_movimiento")
	private int idMovimiento;

	private String aux1;

	private String aux2;

	@Column(name="cantidad_dmt")
	private int cantidadDmt;

	@Column(name="cantidad_mov")
	private BigDecimal cantidadMov;

	private BigDecimal dism;

	@Column(name="envase_mov")
	private String envaseMov;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_mi")
	private Date fechaMi;

	@Column(name="id_existencia")
	private String idExistencia;

	@Column(name="id_tipojust")
	private String idTipojust;

	private BigDecimal increm;

	@Column(name="observaciones_mov")
	private String observacionesMov;

	@Column(name="preciocompra_mov")
	private double preciocompraMov;

	@Column(name="saldo_e")
	private BigDecimal saldoE;

	private String toi;

	//bi-directional many-to-one association to Ordeninventario
	@ManyToOne
	@JoinColumn(name="id_ordeninventario")
	private Ordeninventario ordeninventario;

	public Movimientosinventario() {
	}

	public int getIdMovimiento() {
		return this.idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getAux1() {
		return this.aux1;
	}

	public void setAux1(String aux1) {
		this.aux1 = aux1;
	}

	public String getAux2() {
		return this.aux2;
	}

	public void setAux2(String aux2) {
		this.aux2 = aux2;
	}

	public int getCantidadDmt() {
		return this.cantidadDmt;
	}

	public void setCantidadDmt(int cantidadDmt) {
		this.cantidadDmt = cantidadDmt;
	}

	public BigDecimal getCantidadMov() {
		return this.cantidadMov;
	}

	public void setCantidadMov(BigDecimal cantidadMov) {
		this.cantidadMov = cantidadMov;
	}

	public BigDecimal getDism() {
		return this.dism;
	}

	public void setDism(BigDecimal dism) {
		this.dism = dism;
	}

	public String getEnvaseMov() {
		return this.envaseMov;
	}

	public void setEnvaseMov(String envaseMov) {
		this.envaseMov = envaseMov;
	}

	public Date getFechaMi() {
		return this.fechaMi;
	}

	public void setFechaMi(Date fechaMi) {
		this.fechaMi = fechaMi;
	}

	public String getIdExistencia() {
		return this.idExistencia;
	}

	public void setIdExistencia(String idExistencia) {
		this.idExistencia = idExistencia;
	}

	public String getIdTipojust() {
		return this.idTipojust;
	}

	public void setIdTipojust(String idTipojust) {
		this.idTipojust = idTipojust;
	}

	public BigDecimal getIncrem() {
		return this.increm;
	}

	public void setIncrem(BigDecimal increm) {
		this.increm = increm;
	}

	public String getObservacionesMov() {
		return this.observacionesMov;
	}

	public void setObservacionesMov(String observacionesMov) {
		this.observacionesMov = observacionesMov;
	}

	public double getPreciocompraMov() {
		return this.preciocompraMov;
	}

	public void setPreciocompraMov(double preciocompraMov) {
		this.preciocompraMov = preciocompraMov;
	}

	public BigDecimal getSaldoE() {
		return this.saldoE;
	}

	public void setSaldoE(BigDecimal saldoE) {
		this.saldoE = saldoE;
	}

	public String getToi() {
		return this.toi;
	}

	public void setToi(String toi) {
		this.toi = toi;
	}

	public Ordeninventario getOrdeninventario() {
		return this.ordeninventario;
	}

	public void setOrdeninventario(Ordeninventario ordeninventario) {
		this.ordeninventario = ordeninventario;
	}

}