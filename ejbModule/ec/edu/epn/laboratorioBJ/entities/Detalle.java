package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the detalle database table.
 * 
 */
@Entity
@NamedQuery(name="Detalle.findAll", query="SELECT d FROM Detalle d")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detalle")
	private String idDetalle;

	@Column(name="cantidad_dmt")
	private float cantidadDmt;

	@Column(name="cantidad_mov")
	private BigDecimal cantidadMov;

	@Column(name="cantidad_po")
	private Integer cantidadPo;

	@Column(name="codigo_e")
	private String codigoE;

	@Column(name="comision_tc")
	private double comisionTc;

	@Column(name="cuenta_corriente_pa")
	private String cuentaCorrientePa;

	@Column(name="envase_mov")
	private String envaseMov;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_analisis")
	private Date fechaFinAnalisis;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_analisis")
	private Date fechaInicioAnalisis;

	@Column(name="fin_drc")
	private BigDecimal finDrc;

	@Column(name="horas_trabajo")
	private double horasTrabajo;

	@Column(name="id_bancos")
	private Integer idBancos;

	@Column(name="id_bodega")
	private String idBodega;

	@Column(name="id_detallefactura")
	private String idDetallefactura;

	@Column(name="id_dti")
	private String idDti;

	@Column(name="id_existencia")
	private String idExistencia;

	@Column(name="id_factura")
	private String idFactura;

	@Column(name="id_forma_pago")
	private String idFormaPago;

	@Column(name="id_metodo")
	private String idMetodo;

	@Column(name="id_muestra")
	private String idMuestra;

	@Column(name="id_nc")
	private String idNc;

	@Column(name="id_orden")
	private String idOrden;

	@Column(name="id_personal")
	private String idPersonal;

	@Column(name="id_proforma")
	private String idProforma;

	@Column(name="id_servicio")
	private String idServicio;

	@Column(name="id_tc")
	private String idTc;

	@Column(name="id_ti")
	private String idTi;

	@Column(name="id_tipojust")
	private String idTipojust;

	@Column(name="id_umedida")
	private String idUmedida;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="inicio_drc")
	private BigDecimal inicioDrc;

	@Column(name="mes_arriendo")
	private String mesArriendo;

	@Column(name="metodo_dot")
	private String metodoDot;

	@Column(name="monto_pa")
	private BigDecimal montoPa;

	@Column(name="nombre_pr")
	private String nombrePr;

	@Column(name="numero_documento_pa")
	private String numeroDocumentoPa;

	@Column(name="observaciones_mov")
	private String observacionesMov;

	@Column(name="preciocompra_mov")
	private double preciocompraMov;

	@Column(name="saldo_pa")
	private BigDecimal saldoPa;

	@Column(name="totalservicio_po")
	private BigDecimal totalservicioPo;

	private String transferencia;

	@Column(name="valorunitario_po")
	private BigDecimal valorunitarioPo;

	public Detalle() {
	}

	public String getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(String idDetalle) {
		this.idDetalle = idDetalle;
	}

	public float getCantidadDmt() {
		return this.cantidadDmt;
	}

	public void setCantidadDmt(float cantidadDmt) {
		this.cantidadDmt = cantidadDmt;
	}

	public BigDecimal getCantidadMov() {
		return this.cantidadMov;
	}

	public void setCantidadMov(BigDecimal cantidadMov) {
		this.cantidadMov = cantidadMov;
	}

	public Integer getCantidadPo() {
		return this.cantidadPo;
	}

	public void setCantidadPo(Integer cantidadPo) {
		this.cantidadPo = cantidadPo;
	}

	public String getCodigoE() {
		return this.codigoE;
	}

	public void setCodigoE(String codigoE) {
		this.codigoE = codigoE;
	}

	public double getComisionTc() {
		return this.comisionTc;
	}

	public void setComisionTc(double comisionTc) {
		this.comisionTc = comisionTc;
	}

	public String getCuentaCorrientePa() {
		return this.cuentaCorrientePa;
	}

	public void setCuentaCorrientePa(String cuentaCorrientePa) {
		this.cuentaCorrientePa = cuentaCorrientePa;
	}

	public String getEnvaseMov() {
		return this.envaseMov;
	}

	public void setEnvaseMov(String envaseMov) {
		this.envaseMov = envaseMov;
	}

	public Date getFechaFinAnalisis() {
		return this.fechaFinAnalisis;
	}

	public void setFechaFinAnalisis(Date fechaFinAnalisis) {
		this.fechaFinAnalisis = fechaFinAnalisis;
	}

	public Date getFechaInicioAnalisis() {
		return this.fechaInicioAnalisis;
	}

	public void setFechaInicioAnalisis(Date fechaInicioAnalisis) {
		this.fechaInicioAnalisis = fechaInicioAnalisis;
	}

	public BigDecimal getFinDrc() {
		return this.finDrc;
	}

	public void setFinDrc(BigDecimal finDrc) {
		this.finDrc = finDrc;
	}

	public double getHorasTrabajo() {
		return this.horasTrabajo;
	}

	public void setHorasTrabajo(double horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public Integer getIdBancos() {
		return this.idBancos;
	}

	public void setIdBancos(Integer idBancos) {
		this.idBancos = idBancos;
	}

	public String getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}

	public String getIdDetallefactura() {
		return this.idDetallefactura;
	}

	public void setIdDetallefactura(String idDetallefactura) {
		this.idDetallefactura = idDetallefactura;
	}

	public String getIdDti() {
		return this.idDti;
	}

	public void setIdDti(String idDti) {
		this.idDti = idDti;
	}

	public String getIdExistencia() {
		return this.idExistencia;
	}

	public void setIdExistencia(String idExistencia) {
		this.idExistencia = idExistencia;
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdFormaPago() {
		return this.idFormaPago;
	}

	public void setIdFormaPago(String idFormaPago) {
		this.idFormaPago = idFormaPago;
	}

	public String getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(String idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getIdMuestra() {
		return this.idMuestra;
	}

	public void setIdMuestra(String idMuestra) {
		this.idMuestra = idMuestra;
	}

	public String getIdNc() {
		return this.idNc;
	}

	public void setIdNc(String idNc) {
		this.idNc = idNc;
	}

	public String getIdOrden() {
		return this.idOrden;
	}

	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}

	public String getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getIdProforma() {
		return this.idProforma;
	}

	public void setIdProforma(String idProforma) {
		this.idProforma = idProforma;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getIdTc() {
		return this.idTc;
	}

	public void setIdTc(String idTc) {
		this.idTc = idTc;
	}

	public String getIdTi() {
		return this.idTi;
	}

	public void setIdTi(String idTi) {
		this.idTi = idTi;
	}

	public String getIdTipojust() {
		return this.idTipojust;
	}

	public void setIdTipojust(String idTipojust) {
		this.idTipojust = idTipojust;
	}

	public String getIdUmedida() {
		return this.idUmedida;
	}

	public void setIdUmedida(String idUmedida) {
		this.idUmedida = idUmedida;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigDecimal getInicioDrc() {
		return this.inicioDrc;
	}

	public void setInicioDrc(BigDecimal inicioDrc) {
		this.inicioDrc = inicioDrc;
	}

	public String getMesArriendo() {
		return this.mesArriendo;
	}

	public void setMesArriendo(String mesArriendo) {
		this.mesArriendo = mesArriendo;
	}

	public String getMetodoDot() {
		return this.metodoDot;
	}

	public void setMetodoDot(String metodoDot) {
		this.metodoDot = metodoDot;
	}

	public BigDecimal getMontoPa() {
		return this.montoPa;
	}

	public void setMontoPa(BigDecimal montoPa) {
		this.montoPa = montoPa;
	}

	public String getNombrePr() {
		return this.nombrePr;
	}

	public void setNombrePr(String nombrePr) {
		this.nombrePr = nombrePr;
	}

	public String getNumeroDocumentoPa() {
		return this.numeroDocumentoPa;
	}

	public void setNumeroDocumentoPa(String numeroDocumentoPa) {
		this.numeroDocumentoPa = numeroDocumentoPa;
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

	public BigDecimal getSaldoPa() {
		return this.saldoPa;
	}

	public void setSaldoPa(BigDecimal saldoPa) {
		this.saldoPa = saldoPa;
	}

	public BigDecimal getTotalservicioPo() {
		return this.totalservicioPo;
	}

	public void setTotalservicioPo(BigDecimal totalservicioPo) {
		this.totalservicioPo = totalservicioPo;
	}

	public String getTransferencia() {
		return this.transferencia;
	}

	public void setTransferencia(String transferencia) {
		this.transferencia = transferencia;
	}

	public BigDecimal getValorunitarioPo() {
		return this.valorunitarioPo;
	}

	public void setValorunitarioPo(BigDecimal valorunitarioPo) {
		this.valorunitarioPo = valorunitarioPo;
	}

}