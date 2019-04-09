package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the saldo_existencia database table.
 * 
 */
@Entity
@Table(name = "saldo_existencia", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="SaldoExistencia.findAll", query="SELECT s FROM SaldoExistencia s")
public class SaldoExistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SaldoExistenciaPK id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="nombre_usuario")
	private String nombreUsuario;

	@Column(name="saldo_e")
	private BigDecimal saldoE;

	public SaldoExistencia() {
	}

	public SaldoExistenciaPK getId() {
		return this.id;
	}

	public void setId(SaldoExistenciaPK id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public BigDecimal getSaldoE() {
		return this.saldoE;
	}

	public void setSaldoE(BigDecimal saldoE) {
		this.saldoE = saldoE;
	}

}