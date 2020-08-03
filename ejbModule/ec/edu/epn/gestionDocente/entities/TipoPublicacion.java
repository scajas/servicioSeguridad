package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipo_publicacion database table.
 * 
 */
@Entity

@Table(name = "tipo_publicacion", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name="TipoPublicacion.findAll", query="SELECT t FROM TipoPublicacion t")
public class TipoPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_public")
	private String idTipoPublic;

	@Column(name="nombre_tipo_public")
	private String nombreTipoPublic;
	
	private String sigla;

	public TipoPublicacion() {
	}

	public String getIdTipoPublic() {
		return this.idTipoPublic;
	}

	public void setIdTipoPublic(String idTipoPublic) {
		this.idTipoPublic = idTipoPublic;
	}

	public String getNombreTipoPublic() {
		return this.nombreTipoPublic;
	}

	public void setNombreTipoPublic(String nombreTipoPublic) {
		this.nombreTipoPublic = nombreTipoPublic;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}