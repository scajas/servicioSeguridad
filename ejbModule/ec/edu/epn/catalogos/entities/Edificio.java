package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the edificio database table.
 * 
 */
@Entity(name = "EdificiCatalogo")
@NamedQuery(name="EdificioCatalogo.findAll", query="SELECT e FROM Edificio e")
public class Edificio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_edificio")
	private String idEdificio;

	@Column(name="nom_edificio")
	private String nomEdificio;

	@Column(name="num_pisos")
	private Integer numPisos;

	public Edificio() {
	}

	public String getIdEdificio() {
		return this.idEdificio;
	}

	public void setIdEdificio(String idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getNomEdificio() {
		return this.nomEdificio;
	}

	public void setNomEdificio(String nomEdificio) {
		this.nomEdificio = nomEdificio;
	}

	public Integer getNumPisos() {
		return this.numPisos;
	}

	public void setNumPisos(Integer numPisos) {
		this.numPisos = numPisos;
	}

}