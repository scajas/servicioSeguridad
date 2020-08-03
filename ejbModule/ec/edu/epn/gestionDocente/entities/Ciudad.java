package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ciudad")
	private String idCiudad;

	@Column(name="id_prov")
	private String idProv;

	@Column(name="nom_ciudad")
	private String nomCiudad;

	public Ciudad() {
	}

	public String getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getIdProv() {
		return this.idProv;
	}

	public void setIdProv(String idProv) {
		this.idProv = idProv;
	}

	public String getNomCiudad() {
		return this.nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

}