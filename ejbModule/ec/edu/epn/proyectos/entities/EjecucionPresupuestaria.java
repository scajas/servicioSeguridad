package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ejecucion_presupuestaria database table.
 * 
 */
@Entity
@Table(name="ejecucion_presupuestaria", catalog = "bddcorpepn", schema = "`Proyectos`")
public class EjecucionPresupuestaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_epres_pr")
	private Integer idEpresPr;

	@Column(name="cert_ep")
	private String certEp;

	@Column(name="documento_ep")
	private String documentoEp;

	@Column(name="estado_ep")
	private String estadoEp;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_pedido")
	private Date fechaPedido;

	@Column(name="monto_cert_ep")
	private double montoCertEp;

	@Column(name="monto_real")
	private double montoReal;

	@Column(name="requerimiento_ep")
	private String requerimientoEp;

	//bi-directional many-to-one association to Presupuesto
    @ManyToOne
	@JoinColumn(name="id_pres_pr")
	private Presupuesto presupuesto;

    public EjecucionPresupuestaria() {
    }

	public Integer getIdEpresPr() {
		return this.idEpresPr;
	}

	public void setIdEpresPr(Integer idEpresPr) {
		this.idEpresPr = idEpresPr;
	}

	public String getCertEp() {
		return this.certEp;
	}

	public void setCertEp(String certEp) {
		this.certEp = certEp;
	}

	public String getDocumentoEp() {
		return this.documentoEp;
	}

	public void setDocumentoEp(String documentoEp) {
		this.documentoEp = documentoEp;
	}

	public String getEstadoEp() {
		return this.estadoEp;
	}

	public void setEstadoEp(String estadoEp) {
		this.estadoEp = estadoEp;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaPedido() {
		return this.fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public double getMontoCertEp() {
		return this.montoCertEp;
	}

	public void setMontoCertEp(double montoCertEp) {
		this.montoCertEp = montoCertEp;
	}

	public double getMontoReal() {
		return this.montoReal;
	}

	public void setMontoReal(double montoReal) {
		this.montoReal = montoReal;
	}

	public String getRequerimientoEp() {
		return this.requerimientoEp;
	}

	public void setRequerimientoEp(String requerimientoEp) {
		this.requerimientoEp = requerimientoEp;
	}

	public Presupuesto getPresupuesto() {
		return this.presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	
}