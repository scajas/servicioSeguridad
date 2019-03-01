package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the laboratorio database table.
 * 
 */
@Entity
@NamedQuery(name="Laboratorio.findAll", query="SELECT l FROM Laboratorio l")
public class Laboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lab")
	private String idLab;

	@Column(name="id_facultad")
	private String idFacultad;

	@Column(name="nom_lab")
	private String nomLab;

	public Laboratorio() {
	}

	public String getIdLab() {
		return this.idLab;
	}

	public void setIdLab(String idLab) {
		this.idLab = idLab;
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomLab() {
		return this.nomLab;
	}

	public void setNomLab(String nomLab) {
		this.nomLab = nomLab;
	}

}