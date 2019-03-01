package ec.edu.epn.catalogos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity(name = "PaisCatalogo")
@Table(name="pais" ,catalog = "bddcorpepn", schema = "\"Catalogos\"")
public class PaisCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pais")
	private String idPais;

	@Column(name="nom_pais")
	private String nomPais;

	

	public PaisCatalogo() {
	}

	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}


}