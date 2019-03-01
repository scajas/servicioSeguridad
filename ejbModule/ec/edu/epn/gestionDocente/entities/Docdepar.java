package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the docdepar database table.
 * 
 */
@Entity
@NamedQuery(name="Docdepar.findAll", query="SELECT d FROM Docdepar d")
public class Docdepar implements Serializable {
	private static final long serialVersionUID = 1L;

	private String apel;

	@Id
	private String nced;

	private String nom;

	@Column(name="nom_dep")
	private String nomDep;

	public Docdepar() {
	}

	public String getApel() {
		return this.apel;
	}

	public void setApel(String apel) {
		this.apel = apel;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomDep() {
		return this.nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

}