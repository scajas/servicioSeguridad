package ec.indumaq.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the pagos_factura database table.
 * 
 */
@Entity
@Table(name = "caja", catalog = "`bddcorpepn`", schema = "`indumaq`")
@NamedQuery(name = "CajaIndumaq.findAll", query = "SELECT p FROM CajaIndumaq p")
public class CajaIndumaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_caja")
	private Integer idCaja;

	@Column(name = "id_usuario_caja")
	private Integer idUsuario;

	@Column(name = "secuencial_factura")
	private Integer secuenciaFactura;

	@Column(name = "nombre_caja")
	private String nombreCaja;

	@Column(name = "descripcion_caja")
	private String descripcionCaja;

	@Column(name = "numero_caja")
	private String numeroCaja;

	// bi-directional many-to-one association to FormaPagosFactura
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private SucursalIndumaq sucursalCaja;

	public SucursalIndumaq getSucursalCaja() {
		return sucursalCaja;
	}

	public void setSucursalCaja(SucursalIndumaq sucursalCaja) {
		this.sucursalCaja = sucursalCaja;
	}

	public Integer getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getSecuenciaFactura() {
		return secuenciaFactura;
	}

	public void setSecuenciaFactura(Integer secuenciaFactura) {
		this.secuenciaFactura = secuenciaFactura;
	}

	public String getNombreCaja() {
		return nombreCaja;
	}

	public void setNombreCaja(String nombreCaja) {
		this.nombreCaja = nombreCaja;
	}

	public String getDescripcionCaja() {
		return descripcionCaja;
	}

	public void setDescripcionCaja(String descripcionCaja) {
		this.descripcionCaja = descripcionCaja;
	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

}