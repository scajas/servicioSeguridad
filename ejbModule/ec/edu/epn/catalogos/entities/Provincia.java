package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity(name = "provinciaCatalogo")
@Table(name="provincia" ,catalog = "bddcorpepn", schema = "\"Catalogos\"")
@NamedQuery(name="ProvinciaCatalogo.findAll", query="SELECT p FROM provinciaCatalogo p order by p.nomProv")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_prov")
	private String idProv;

	@Column(name="id_pais")
	private String idPais;

	@Column(name="nom_prov")
	private String nomProv;

	public Provincia() {
	}

	public String getIdProv() {
		return this.idProv;
	}

	public void setIdProv(String idProv) {
		this.idProv = idProv;
	}

	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getNomProv() {
		return this.nomProv;
	}

	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
	}

}