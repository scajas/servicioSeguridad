package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the partidas_presupuestarias_pedido database table.
 * 
 */
@Entity
@Table(name = "partidas", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Contratos\".secuencia_partidas")
	@SequenceGenerator(name = "\"Contratos\".secuencia_partidas", sequenceName = "\"Contratos\".secuencia_partidas", allocationSize = 1)
	@Column(name = "id_partida")
	private Integer idPartida;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_pedido_partida")
	private Date fechaPedidoPartida;

	// bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_partidalib")
	private PartidasLibre pl;

	public PartidasLibre getPl() {
		return pl;
	}

	public void setPl(PartidasLibre pl) {
		this.pl = pl;
	}

	public Partida() {
	}

	public Integer getIdPartida() {
		return this.idPartida;
	}

	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	public Date getFechaPedidoPartida() {
		return this.fechaPedidoPartida;
	}

	public void setFechaPedidoPartida(Date fechaPedidoPartida) {
		this.fechaPedidoPartida = fechaPedidoPartida;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}