package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity(name = "CiudadCatalogo")
@NamedQuery(name="CiudadCatalogo.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ciudad")
	private String idCiudad;

	@Column(name="id_provincia")
	private String idProvincia;

	@Column(name="nombre_ciudad")
	private String nombreCiudad;

	public Ciudad() {
	}

	public String getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

}