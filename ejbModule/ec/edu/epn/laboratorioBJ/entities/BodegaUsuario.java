package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bodega_usuario database table.
 * 
 */
@Entity
@Table(name = "`bodega_usuario`", catalog = "`bddcorpepn`", schema = "`Laboratorios`")
@NamedQuery(name="BodegaUsuario.findAll", query="SELECT b FROM BodegaUsuario b")
public class BodegaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BodegaUsuarioPK id;

	//bi-directional many-to-one association to laboratory
	@ManyToOne
	@JoinColumn(name="id_bodega",insertable=false, updatable=false)
	private laboratory bodega;

	public BodegaUsuario() {
	}

	public BodegaUsuarioPK getId() {
		return this.id;
	}

	public void setId(BodegaUsuarioPK id) {
		this.id = id;
	}

	public laboratory getBodega() {
		return this.bodega;
	}

	public void setBodega(laboratory bodega) {
		this.bodega = bodega;
	}

}