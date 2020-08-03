package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tnomb database table.
 * 
 */
@Entity
@Table(name = "tnomb", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="Tnomb.findAll", query="SELECT t FROM Tnomb t")
public class Tnomb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tnomb;

	@Column(name="cod_clase")
	private String codClase;

	@Column(name="desc_tnomb")
	private String descTnomb;

	public Tnomb() {
	}

	public String getTnomb() {
		return this.tnomb;
	}

	public void setTnomb(String tnomb) {
		this.tnomb = tnomb;
	}

	public String getCodClase() {
		return this.codClase;
	}

	public void setCodClase(String codClase) {
		this.codClase = codClase;
	}

	public String getDescTnomb() {
		return this.descTnomb;
	}

	public void setDescTnomb(String descTnomb) {
		this.descTnomb = descTnomb;
	}

}