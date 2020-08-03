package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_depart")
	private String idDepart;

	@Column(name="id_facultad")
	private String idFacultad;

	@Column(name="nom_depart")
	private String nomDepart;

	public Departamento() {
	}

	public String getIdDepart() {
		return this.idDepart;
	}

	public void setIdDepart(String idDepart) {
		this.idDepart = idDepart;
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomDepart() {
		return this.nomDepart;
	}

	public void setNomDepart(String nomDepart) {
		this.nomDepart = nomDepart;
	}

}