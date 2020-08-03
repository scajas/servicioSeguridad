package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estudios database table.
 * 
 */
@Entity
@Table(name = "estudios", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class EstudioContratos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estudios")
	private Integer idEstudios;

	@Column(name="num_registro")
	private String numRegistro;

	@Column(name="titulo_docente")
	private String tituloDocente;
	
	//bi-directional many-to-one association to Pedido
    @ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

    public EstudioContratos() {
    }

	public Integer getIdEstudios() {
		return this.idEstudios;
	}

	public void setIdEstudios(Integer idEstudios) {
		this.idEstudios = idEstudios;
	}

	public String getNumRegistro() {
		return this.numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getTituloDocente() {
		return this.tituloDocente;
	}

	public void setTituloDocente(String tituloDocente) {
		this.tituloDocente = tituloDocente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}