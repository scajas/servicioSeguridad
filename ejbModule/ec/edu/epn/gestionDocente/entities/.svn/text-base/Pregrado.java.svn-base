package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pregrado database table.
 * 
 */
@Entity
@NamedQuery(name="Pregrado.findAll", query="SELECT p FROM Pregrado p")
public class Pregrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pregrado")
	private String idPregrado;

	@Column(name="id_facultad")
	private String idFacultad;

	@Column(name="nom_pregrado")
	private String nomPregrado;

	public Pregrado() {
	}

	public String getIdPregrado() {
		return this.idPregrado;
	}

	public void setIdPregrado(String idPregrado) {
		this.idPregrado = idPregrado;
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomPregrado() {
		return this.nomPregrado;
	}

	public void setNomPregrado(String nomPregrado) {
		this.nomPregrado = nomPregrado;
	}

}