package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_extension database table.
 * 
 */
@Entity
@Table(name="tipo_extension")
@NamedQuery(name="TipoExtension.findAll", query="SELECT t FROM TipoExtension t")
public class TipoExtension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_ext")
	private String idTipoExt;

	@Column(name="tipo_ext")
	private String tipoExt;

	public TipoExtension() {
	}

	public String getIdTipoExt() {
		return this.idTipoExt;
	}

	public void setIdTipoExt(String idTipoExt) {
		this.idTipoExt = idTipoExt;
	}

	public String getTipoExt() {
		return this.tipoExt;
	}

	public void setTipoExt(String tipoExt) {
		this.tipoExt = tipoExt;
	}

}