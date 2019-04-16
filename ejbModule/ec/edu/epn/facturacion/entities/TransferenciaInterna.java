package ec.edu.epn.facturacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the transferencia_interna database table.
 * 
 */
@Entity
@Table(name = "transferencia_interna", catalog = "bddcorpepn", schema = "`Facturacion`")
@NamedQuery(name="TransferenciaInterna.findAll", query="SELECT t FROM TransferenciaInterna t")
public class TransferenciaInterna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ti")
	private String idTi;

	@Column(name="estado_ti")
	private String estadoTi;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_caja")
	private Integer idCaja;

	@Column(name="id_proforma")
	private String idProforma;

	@Column(name="id_punto_facturacion")
	private String idPuntoFacturacion;

	@Column(name="iva_ti")
	private BigDecimal ivaTi;

	@Column(name="subtotal_ti")
	private BigDecimal subtotalTi;

	@Column(name="total_ti")
	private BigDecimal totalTi;

	public TransferenciaInterna() {
	}

	public String getIdTi() {
		return this.idTi;
	}

	public void setIdTi(String idTi) {
		this.idTi = idTi;
	}

	public String getEstadoTi() {
		return this.estadoTi;
	}

	public void setEstadoTi(String estadoTi) {
		this.estadoTi = estadoTi;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public String getIdProforma() {
		return this.idProforma;
	}

	public void setIdProforma(String idProforma) {
		this.idProforma = idProforma;
	}

	public String getIdPuntoFacturacion() {
		return this.idPuntoFacturacion;
	}

	public void setIdPuntoFacturacion(String idPuntoFacturacion) {
		this.idPuntoFacturacion = idPuntoFacturacion;
	}

	public BigDecimal getIvaTi() {
		return this.ivaTi;
	}

	public void setIvaTi(BigDecimal ivaTi) {
		this.ivaTi = ivaTi;
	}

	public BigDecimal getSubtotalTi() {
		return this.subtotalTi;
	}

	public void setSubtotalTi(BigDecimal subtotalTi) {
		this.subtotalTi = subtotalTi;
	}

	public BigDecimal getTotalTi() {
		return this.totalTi;
	}

	public void setTotalTi(BigDecimal totalTi) {
		this.totalTi = totalTi;
	}

}