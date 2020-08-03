package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categ")
	private String idCateg;

	@Column(name="nom_categ")
	private String nomCateg;

	public Categoria() {
	}

	public String getIdCateg() {
		return this.idCateg;
	}

	public void setIdCateg(String idCateg) {
		this.idCateg = idCateg;
	}

	public String getNomCateg() {
		return this.nomCateg;
	}

	public void setNomCateg(String nomCateg) {
		this.nomCateg = nomCateg;
	}

}