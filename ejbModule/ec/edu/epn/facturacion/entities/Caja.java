package ec.edu.epn.facturacion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caja database table.
 * 
 */
@Entity
@Table(name = "caja", catalog = "bddcorpepn", schema = "`Facturacion`")
@NamedQuery(name="Caja.findAll", query="SELECT c FROM Caja c")
public class Caja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_caja")
	private Integer idCaja;

	@Column(name="descripcion_caja")
	private String descripcionCaja;

	@Column(name="id_personal")
	private String idPersonal;

	@Column(name="secuencia_inicial_factura")
	private String secuenciaInicialFactura;

	@Column(name="secuencia_inicial_notac")
	private Integer secuenciaInicialNotac;

	@Column(name="secuencia_inicial_rcvcaja")
	private Integer secuenciaInicialRcvcaja;

	//bi-directional many-to-one association to PuntoFacturacion
	@ManyToOne
	@JoinColumn(name="id_punto_facturacion")
	private PuntoFacturacion puntoFacturacion;

	public Caja() {
	}

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public String getDescripcionCaja() {
		return this.descripcionCaja;
	}

	public void setDescripcionCaja(String descripcionCaja) {
		this.descripcionCaja = descripcionCaja;
	}

	public String getIdPersonal() {
		return this.idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getSecuenciaInicialFactura() {
		return this.secuenciaInicialFactura;
	}

	public void setSecuenciaInicialFactura(String secuenciaInicialFactura) {
		this.secuenciaInicialFactura = secuenciaInicialFactura;
	}

	public Integer getSecuenciaInicialNotac() {
		return this.secuenciaInicialNotac;
	}

	public void setSecuenciaInicialNotac(Integer secuenciaInicialNotac) {
		this.secuenciaInicialNotac = secuenciaInicialNotac;
	}

	public Integer getSecuenciaInicialRcvcaja() {
		return this.secuenciaInicialRcvcaja;
	}

	public void setSecuenciaInicialRcvcaja(Integer secuenciaInicialRcvcaja) {
		this.secuenciaInicialRcvcaja = secuenciaInicialRcvcaja;
	}

	public PuntoFacturacion getPuntoFacturacion() {
		return this.puntoFacturacion;
	}

	public void setPuntoFacturacion(PuntoFacturacion puntoFacturacion) {
		this.puntoFacturacion = puntoFacturacion;
	}

}