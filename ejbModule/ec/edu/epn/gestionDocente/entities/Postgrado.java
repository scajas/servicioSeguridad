package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the postgrado database table.
 * 
 */
@Entity
@NamedQuery(name="Postgrado.findAll", query="SELECT p FROM Postgrado p")
public class Postgrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_postgrado")
	private String idPostgrado;

	@Column(name="id_facultad")
	private String idFacultad;

	@Column(name="nom_postgrado")
	private String nomPostgrado;

	public Postgrado() {
	}

	public String getIdPostgrado() {
		return this.idPostgrado;
	}

	public void setIdPostgrado(String idPostgrado) {
		this.idPostgrado = idPostgrado;
	}

	public String getIdFacultad() {
		return this.idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomPostgrado() {
		return this.nomPostgrado;
	}

	public void setNomPostgrado(String nomPostgrado) {
		this.nomPostgrado = nomPostgrado;
	}

}