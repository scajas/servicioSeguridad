package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medio_publicacion database table.
 * 
 */
@Entity
@Table(name="medio_publicacion")
@NamedQuery(name="MedioPublicacion.findAll", query="SELECT m FROM MedioPublicacion m")
public class MedioPublicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medio_public")
	private String idMedioPublic;

	@Column(name="medio_public")
	private String medioPublic;

	@Column(name="nombre_medio_public")
	private String nombreMedioPublic;

	public MedioPublicacion() {
	}

	public String getIdMedioPublic() {
		return this.idMedioPublic;
	}

	public void setIdMedioPublic(String idMedioPublic) {
		this.idMedioPublic = idMedioPublic;
	}

	public String getMedioPublic() {
		return this.medioPublic;
	}

	public void setMedioPublic(String medioPublic) {
		this.medioPublic = medioPublic;
	}

	public String getNombreMedioPublic() {
		return this.nombreMedioPublic;
	}

	public void setNombreMedioPublic(String nombreMedioPublic) {
		this.nombreMedioPublic = nombreMedioPublic;
	}

}