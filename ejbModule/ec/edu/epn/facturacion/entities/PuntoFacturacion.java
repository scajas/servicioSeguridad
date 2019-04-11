package ec.edu.epn.facturacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the punto_facturacion database table.
 * 
 */
@Entity
@Table(name = "punto_facturacion", catalog = "bddcorpepn", schema = "`Facturacion`")
@NamedQuery(name="PuntoFacturacion.findAll", query="SELECT p FROM PuntoFacturacion p")
public class PuntoFacturacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_punto_facturacion")
	private String idPuntoFacturacion;

	private String activo;

	@Column(name="descripcion_pfa")
	private String descripcionPfa;

	@Column(name="id_establecimiento")
	private String idEstablecimiento;

	@Column(name="id_persona")
	private String idPersona;

	@Column(name="id_unidad")
	private Integer idUnidad;

	@Column(name="nombre_pfa")
	private String nombrePfa;

	@Column(name="ruc_pfa")
	private String rucPfa;

	@Column(name="secuencia_inicial_archivo")
	private Integer secuenciaInicialArchivo;

	@Column(name="secuencia_inicial_factura")
	private String secuenciaInicialFactura;

	@Column(name="secuencia_inicial_notac")
	private Integer secuenciaInicialNotac;

	@Column(name="secuencia_inicial_rcvcaja")
	private Integer secuenciaInicialRcvcaja;

	private double serial;

	@Column(name="ubicacion_pfa")
	private String ubicacionPfa;

	//bi-directional many-to-one association to Caja
	@OneToMany(mappedBy="puntoFacturacion")
	private List<Caja> cajas;

	public PuntoFacturacion() {
	}

	public String getIdPuntoFacturacion() {
		return this.idPuntoFacturacion;
	}

	public void setIdPuntoFacturacion(String idPuntoFacturacion) {
		this.idPuntoFacturacion = idPuntoFacturacion;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDescripcionPfa() {
		return this.descripcionPfa;
	}

	public void setDescripcionPfa(String descripcionPfa) {
		this.descripcionPfa = descripcionPfa;
	}

	public String getIdEstablecimiento() {
		return this.idEstablecimiento;
	}

	public void setIdEstablecimiento(String idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public String getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdUnidad() {
		return this.idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getNombrePfa() {
		return this.nombrePfa;
	}

	public void setNombrePfa(String nombrePfa) {
		this.nombrePfa = nombrePfa;
	}

	public String getRucPfa() {
		return this.rucPfa;
	}

	public void setRucPfa(String rucPfa) {
		this.rucPfa = rucPfa;
	}

	public Integer getSecuenciaInicialArchivo() {
		return this.secuenciaInicialArchivo;
	}

	public void setSecuenciaInicialArchivo(Integer secuenciaInicialArchivo) {
		this.secuenciaInicialArchivo = secuenciaInicialArchivo;
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

	public double getSerial() {
		return this.serial;
	}

	public void setSerial(double serial) {
		this.serial = serial;
	}

	public String getUbicacionPfa() {
		return this.ubicacionPfa;
	}

	public void setUbicacionPfa(String ubicacionPfa) {
		this.ubicacionPfa = ubicacionPfa;
	}

	public List<Caja> getCajas() {
		return this.cajas;
	}

	public void setCajas(List<Caja> cajas) {
		this.cajas = cajas;
	}

	public Caja addCaja(Caja caja) {
		getCajas().add(caja);
		caja.setPuntoFacturacion(this);

		return caja;
	}

	public Caja removeCaja(Caja caja) {
		getCajas().remove(caja);
		caja.setPuntoFacturacion(null);

		return caja;
	}

}