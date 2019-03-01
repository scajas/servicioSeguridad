package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the nosenescyt database table.
 * 
 */
@Entity

@Table(name = "nosenescyt", catalog = "bddcorpepn", schema = "`GestionDocente`")

public class Nosenescyt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cedula;

	public Nosenescyt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}