package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the partidas_libres database table.
 * 
 */
@Entity
@Table(name = "partidas_libres", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class PartidasLibre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partida")
	private Integer idPartida;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_emision")
	private Date fechaEmision;

	@OneToMany(mappedBy = "pl")
	private List<Partida> partidasl;

	public List<Partida> getPartidasl() {
		return partidasl;
	}

	public void setPartidasl(List<Partida> partidasl) {
		this.partidasl = partidasl;
	}

	@Column(name = "monto")
	private double monto;

	@Column(name = "numero")
	private String numero;

	@Column(name = "saldo")
	private double saldo;

	@Column(name = "nro_memo")
	private String nroMemo;
	
	@Column(name = "partida_inicial")
	private double partidaInicial;


	// bi-directional many-to-one association to Partidas
	// @ManyToOne
	// @JoinColumn(name = "id_t_cont")
	// private TipoContrato tipoContrato;
	@OneToOne
	@JoinColumn(name = "id_t_cont")
	private TipoContrato tipoContrato;

	public PartidasLibre() {
	}

	public Integer getIdPartida() {
		return this.idPartida;
	}

	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEmision() {
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getNroMemo() {
		return nroMemo;
	}

	public void setNroMemo(String nroMemo) {
		this.nroMemo = nroMemo;
	}

	public double getPartidaInicial() {
		return partidaInicial;
	}

	public void setPartidaInicial(double partidaInicial) {
		this.partidaInicial = partidaInicial;
	}

}