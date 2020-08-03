package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the almuerzo database table.
 * 
 */
@Entity
@NamedQuery(name="Almuerzo.findAll", query="SELECT a FROM Almuerzo a")
public class Almuerzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nced;

	private String apel;

	private String nom;

	public Almuerzo() {
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getApel() {
		return this.apel;
	}

	public void setApel(String apel) {
		this.apel = apel;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}