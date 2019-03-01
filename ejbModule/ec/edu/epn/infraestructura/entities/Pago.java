package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the pagos database table.
 * 
 */
@Entity
@Table(name = "pagos", catalog = "bddcorpepn", schema = "`Infraestructura`")

public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pago")
	private Integer idPago;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_pago")
	private Date fechaPago;

	private double monto;

	private double saldo;

	//bi-directional many-to-one association to Alquiler
    @ManyToOne
	@JoinColumn(name="id_alquiler")
	private Alquiler alquiler;

    public Pago() {
    }

	public Integer getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Alquiler getAlquiler() {
		return this.alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}
	
}