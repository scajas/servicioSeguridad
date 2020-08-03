package ec.edu.epn.contratos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name = "proyecto_pedido", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class ProyectoPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_proyecto_pedido")
	private Integer idProyectoPedido;

	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "cod_proyecto")
	private String codProyecto;

	/**
	 * @return the idProyectoPedido
	 */
	public Integer getIdProyectoPedido() {
		return idProyectoPedido;
	}

	/**
	 * @return the idPedido
	 */
	public Integer getIdPedido() {
		return idPedido;
	}

	/**
	 * @return the codProyecto
	 */
	public String getCodProyecto() {
		return codProyecto;
	}

	/**
	 * @param idProyectoPedido the idProyectoPedido to set
	 */
	public void setIdProyectoPedido(Integer idProyectoPedido) {
		this.idProyectoPedido = idProyectoPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @param codProyecto the codProyecto to set
	 */
	public void setCodProyecto(String codProyecto) {
		this.codProyecto = codProyecto;
	}

	
}