package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity
@Table(name = "estado" , catalog = "`bddcorpepn`", schema = "`Contratos`")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estado")
	private Integer idEstado;

	@Column(name="descr_estado")
	private String descrEstado;

	@Column(name="nombre_estado")
	private String nombreEstado;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="estado")
	private List<Pedido> pedidos;

    public Estado() {
    }

	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescrEstado() {
		return this.descrEstado;
	}

	public void setDescrEstado(String descrEstado) {
		this.descrEstado = descrEstado;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	
	
}