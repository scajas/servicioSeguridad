package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the recorrido_pedido database table.
 * 
 */
@Entity
@Table(name = "recorrido_pedido", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class RecorridoPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_recorrido")
	private Integer idRecorrido;

	@Column(name = "enviado_por")
	private String enviadoPor;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_envio")
	private Date fechaEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_recibido")
	private Date fechaRecibido;

	@Column(name = "recibido_por")
	private String recibidoPor;

	@Column(name = "estado_pedido")
	private String estadoPedido;

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	@ManyToOne
	@JoinColumn(name = "id_pedido_tabla")
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public RecorridoPedido() {
	}

	public Integer getIdRecorrido() {
		return this.idRecorrido;
	}

	public void setIdRecorrido(Integer idRecorrido) {
		this.idRecorrido = idRecorrido;
	}

	public String getEnviadoPor() {
		return this.enviadoPor;
	}

	public void setEnviadoPor(String enviadoPor) {
		this.enviadoPor = enviadoPor;
	}

	public Date getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaRecibido() {
		return this.fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public String getRecibidoPor() {
		return this.recibidoPor;
	}

	public void setRecibidoPor(String recibidoPor) {
		this.recibidoPor = recibidoPor;
	}

}