package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_proyecto database table.
 * 
 */
@Entity
@Table(name="tipo_proyecto")
@NamedQuery(name="TipoProyecto.findAll", query="SELECT t FROM TipoProyecto t")
public class TipoProyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_proy")
	private String idTipoProy;

	@Column(name="tipo_proy")
	private String tipoProy;

	public TipoProyecto() {
	}

	public String getIdTipoProy() {
		return this.idTipoProy;
	}

	public void setIdTipoProy(String idTipoProy) {
		this.idTipoProy = idTipoProy;
	}

	public String getTipoProy() {
		return this.tipoProy;
	}

	public void setTipoProy(String tipoProy) {
		this.tipoProy = tipoProy;
	}

}