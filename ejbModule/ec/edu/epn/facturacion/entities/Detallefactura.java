package ec.edu.epn.facturacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detallefactura database table.
 * 
 */
@Entity
@Table(name = "detallefactura", catalog = "bddcorpepn", schema = "`Facturacion`")
@NamedQuery(name="Detallefactura.findAll", query="SELECT d FROM Detallefactura d")
public class Detallefactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detallefactura")
	private String idDetallefactura;

	@Column(name="control_unidades")
	private Integer controlUnidades;

	@Column(name="costo_df")
	private double costoDf;

	@Column(name="costot_df")
	private double costotDf;

	@Column(name="estado_serv")
	private String estadoServ;

	@Column(name="id_concepto")
	private String idConcepto;

	@Column(name="id_factura")
	private String idFactura;

	@Column(name="id_metodo")
	private String idMetodo;

	@Column(name="id_servicio")
	private String idServicio;

	@Column(name="mes_arriendo")
	private String mesArriendo;

	private String nombreser;

	private BigDecimal porcentajeiva;

	private double subtotal;

	@Column(name="unidades_df")
	private Integer unidadesDf;

	@Column(name="valor_iva")
	private double valorIva;

	public Detallefactura() {
	}

	public String getIdDetallefactura() {
		return this.idDetallefactura;
	}

	public void setIdDetallefactura(String idDetallefactura) {
		this.idDetallefactura = idDetallefactura;
	}

	public Integer getControlUnidades() {
		return this.controlUnidades;
	}

	public void setControlUnidades(Integer controlUnidades) {
		this.controlUnidades = controlUnidades;
	}

	public double getCostoDf() {
		return this.costoDf;
	}

	public void setCostoDf(double costoDf) {
		this.costoDf = costoDf;
	}

	public double getCostotDf() {
		return this.costotDf;
	}

	public void setCostotDf(double costotDf) {
		this.costotDf = costotDf;
	}

	public String getEstadoServ() {
		return this.estadoServ;
	}

	public void setEstadoServ(String estadoServ) {
		this.estadoServ = estadoServ;
	}

	public String getIdConcepto() {
		return this.idConcepto;
	}

	public void setIdConcepto(String idConcepto) {
		this.idConcepto = idConcepto;
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdMetodo() {
		return this.idMetodo;
	}

	public void setIdMetodo(String idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getMesArriendo() {
		return this.mesArriendo;
	}

	public void setMesArriendo(String mesArriendo) {
		this.mesArriendo = mesArriendo;
	}

	public String getNombreser() {
		return this.nombreser;
	}

	public void setNombreser(String nombreser) {
		this.nombreser = nombreser;
	}

	public BigDecimal getPorcentajeiva() {
		return this.porcentajeiva;
	}

	public void setPorcentajeiva(BigDecimal porcentajeiva) {
		this.porcentajeiva = porcentajeiva;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getUnidadesDf() {
		return this.unidadesDf;
	}

	public void setUnidadesDf(Integer unidadesDf) {
		this.unidadesDf = unidadesDf;
	}

	public double getValorIva() {
		return this.valorIva;
	}

	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}

}