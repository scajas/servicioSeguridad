package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pureza database table.
 * 
 */
@Entity
@NamedQuery(name="Pureza.findAll", query="SELECT p FROM Pureza p")
public class Pureza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pureza")
	private String idPureza;

	@Column(name="descr_pureza")
	private String descrPureza;

	@Column(name="nombre_pureza")
	private String nombrePureza;

	public Pureza() {
	}

	public String getIdPureza() {
		return this.idPureza;
	}

	public void setIdPureza(String idPureza) {
		this.idPureza = idPureza;
	}

	public String getDescrPureza() {
		return this.descrPureza;
	}

	public void setDescrPureza(String descrPureza) {
		this.descrPureza = descrPureza;
	}

	public String getNombrePureza() {
		return this.nombrePureza;
	}

	public void setNombrePureza(String nombrePureza) {
		this.nombrePureza = nombrePureza;
	}

}