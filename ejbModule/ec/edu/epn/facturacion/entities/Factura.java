package ec.edu.epn.facturacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@Table(name = "factura", catalog = "bddcorpepn", schema = "`Facturacion`")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_factura")
	private String idFactura;

	private String ambiente;

	private String aux;

	private Integer auxsecuencia;

	@Column(name="carrera_e")
	private String carreraE;

	@Column(name="cedula_cli")
	private String cedulaCli;

	@Column(name="cedula_e")
	private String cedulaE;

	private String claveacceso;

	private String concepto;

	@Column(name="descuento_f")
	private double descuentoF;

	@Column(name="direccion_cli")
	private String direccionCli;

	@Column(name="direccion_e")
	private String direccionE;

	@Column(name="email_cl")
	private String emailCl;

	private String emision;

	@Column(name="estado_sri")
	private String estadoSri;

	private String estadomail;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_comprom_pago")
	private Date fecCompromPago;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_max_nc")
	private Date fecMaxNc;

	private String fechaautoriza;

	@Column(name="fechafac_f")
	private Timestamp fechafacF;

	@Column(name="fechafac_f2")
	private Timestamp fechafacF2;

	@Column(name="fechafac_pend")
	private Timestamp fechafacPend;

	@Column(name="id_caja")
	private Integer idCaja;

	@Column(name="id_cliente")
	private String idCliente;

	@Column(name="id_estado_factura")
	private String idEstadoFactura;

	@Column(name="id_estudiante")
	private String idEstudiante;

	@Column(name="id_forma_pago")
	private String idFormaPago;

	@Column(name="id_proforma")
	private String idProforma;

	@Column(name="id_punto_facturacion")
	private String idPuntoFacturacion;

	@Column(name="iva_f")
	private double ivaF;

	@Column(name="motivoestado_f")
	private String motivoestadoF;

	@Column(name="nombre_cli")
	private String nombreCli;

	@Column(name="nombre_e")
	private String nombreE;

	private Integer nropagos;

	private String num1;

	private String num2;

	private String num3;

	private String numautoriza;

	private String path;

	private String pathxml;

	private BigDecimal porcentajeiva;

	@Column(name="ruc_cli")
	private String rucCli;

	@Column(name="subtotal_f")
	private double subtotalF;

	@Column(name="telefono_cli")
	private String telefonoCli;

	@Column(name="telefono_e")
	private String telefonoE;

	@Column(name="tipo_f")
	private String tipoF;

	@Column(name="total_f")
	private double totalF;

	private String xml;

	public Factura() {
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getAmbiente() {
		return this.ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getAux() {
		return this.aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	public Integer getAuxsecuencia() {
		return this.auxsecuencia;
	}

	public void setAuxsecuencia(Integer auxsecuencia) {
		this.auxsecuencia = auxsecuencia;
	}

	public String getCarreraE() {
		return this.carreraE;
	}

	public void setCarreraE(String carreraE) {
		this.carreraE = carreraE;
	}

	public String getCedulaCli() {
		return this.cedulaCli;
	}

	public void setCedulaCli(String cedulaCli) {
		this.cedulaCli = cedulaCli;
	}

	public String getCedulaE() {
		return this.cedulaE;
	}

	public void setCedulaE(String cedulaE) {
		this.cedulaE = cedulaE;
	}

	public String getClaveacceso() {
		return this.claveacceso;
	}

	public void setClaveacceso(String claveacceso) {
		this.claveacceso = claveacceso;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getDescuentoF() {
		return this.descuentoF;
	}

	public void setDescuentoF(double descuentoF) {
		this.descuentoF = descuentoF;
	}

	public String getDireccionCli() {
		return this.direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public String getDireccionE() {
		return this.direccionE;
	}

	public void setDireccionE(String direccionE) {
		this.direccionE = direccionE;
	}

	public String getEmailCl() {
		return this.emailCl;
	}

	public void setEmailCl(String emailCl) {
		this.emailCl = emailCl;
	}

	public String getEmision() {
		return this.emision;
	}

	public void setEmision(String emision) {
		this.emision = emision;
	}

	public String getEstadoSri() {
		return this.estadoSri;
	}

	public void setEstadoSri(String estadoSri) {
		this.estadoSri = estadoSri;
	}

	public String getEstadomail() {
		return this.estadomail;
	}

	public void setEstadomail(String estadomail) {
		this.estadomail = estadomail;
	}

	public Date getFecCompromPago() {
		return this.fecCompromPago;
	}

	public void setFecCompromPago(Date fecCompromPago) {
		this.fecCompromPago = fecCompromPago;
	}

	public Date getFecMaxNc() {
		return this.fecMaxNc;
	}

	public void setFecMaxNc(Date fecMaxNc) {
		this.fecMaxNc = fecMaxNc;
	}

	public String getFechaautoriza() {
		return this.fechaautoriza;
	}

	public void setFechaautoriza(String fechaautoriza) {
		this.fechaautoriza = fechaautoriza;
	}

	public Timestamp getFechafacF() {
		return this.fechafacF;
	}

	public void setFechafacF(Timestamp fechafacF) {
		this.fechafacF = fechafacF;
	}

	public Timestamp getFechafacF2() {
		return this.fechafacF2;
	}

	public void setFechafacF2(Timestamp fechafacF2) {
		this.fechafacF2 = fechafacF2;
	}

	public Timestamp getFechafacPend() {
		return this.fechafacPend;
	}

	public void setFechafacPend(Timestamp fechafacPend) {
		this.fechafacPend = fechafacPend;
	}

	public Integer getIdCaja() {
		return this.idCaja;
	}

	public void setIdCaja(Integer idCaja) {
		this.idCaja = idCaja;
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdEstadoFactura() {
		return this.idEstadoFactura;
	}

	public void setIdEstadoFactura(String idEstadoFactura) {
		this.idEstadoFactura = idEstadoFactura;
	}

	public String getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getIdFormaPago() {
		return this.idFormaPago;
	}

	public void setIdFormaPago(String idFormaPago) {
		this.idFormaPago = idFormaPago;
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

	public double getIvaF() {
		return this.ivaF;
	}

	public void setIvaF(double ivaF) {
		this.ivaF = ivaF;
	}

	public String getMotivoestadoF() {
		return this.motivoestadoF;
	}

	public void setMotivoestadoF(String motivoestadoF) {
		this.motivoestadoF = motivoestadoF;
	}

	public String getNombreCli() {
		return this.nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public String getNombreE() {
		return this.nombreE;
	}

	public void setNombreE(String nombreE) {
		this.nombreE = nombreE;
	}

	public Integer getNropagos() {
		return this.nropagos;
	}

	public void setNropagos(Integer nropagos) {
		this.nropagos = nropagos;
	}

	public String getNum1() {
		return this.num1;
	}

	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return this.num2;
	}

	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return this.num3;
	}

	public void setNum3(String num3) {
		this.num3 = num3;
	}

	public String getNumautoriza() {
		return this.numautoriza;
	}

	public void setNumautoriza(String numautoriza) {
		this.numautoriza = numautoriza;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPathxml() {
		return this.pathxml;
	}

	public void setPathxml(String pathxml) {
		this.pathxml = pathxml;
	}

	public BigDecimal getPorcentajeiva() {
		return this.porcentajeiva;
	}

	public void setPorcentajeiva(BigDecimal porcentajeiva) {
		this.porcentajeiva = porcentajeiva;
	}

	public String getRucCli() {
		return this.rucCli;
	}

	public void setRucCli(String rucCli) {
		this.rucCli = rucCli;
	}

	public double getSubtotalF() {
		return this.subtotalF;
	}

	public void setSubtotalF(double subtotalF) {
		this.subtotalF = subtotalF;
	}

	public String getTelefonoCli() {
		return this.telefonoCli;
	}

	public void setTelefonoCli(String telefonoCli) {
		this.telefonoCli = telefonoCli;
	}

	public String getTelefonoE() {
		return this.telefonoE;
	}

	public void setTelefonoE(String telefonoE) {
		this.telefonoE = telefonoE;
	}

	public String getTipoF() {
		return this.tipoF;
	}

	public void setTipoF(String tipoF) {
		this.tipoF = tipoF;
	}

	public double getTotalF() {
		return this.totalF;
	}

	public void setTotalF(double totalF) {
		this.totalF = totalF;
	}

	public String getXml() {
		return this.xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

}