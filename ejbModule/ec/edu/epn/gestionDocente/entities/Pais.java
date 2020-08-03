package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity(name="Pais")
@Table(name="pais",catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQueries({

	@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p order by p.nomPais"),
	@NamedQuery(name="Pais.findNombre", query="SELECT p FROM Pais p WHERE UPPER(p.nomPais) like :nombre ORDER BY p.nomPais"),
})

public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pais")
	private String idPais;

	@Column(name="nom_pais")
	private String nomPais;	
	
	
	public Pais() {
		super();
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