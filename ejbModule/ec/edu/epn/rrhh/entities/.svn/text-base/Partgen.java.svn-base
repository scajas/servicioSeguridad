package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the partgen database table.
 * 
 */
@Entity
@NamedQuery(name="Partgen.findAll", query="SELECT p FROM Partgen p")
public class Partgen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_pgen")
	private String codPgen;

	private String activ;

	public Partgen() {
	}

	public String getCodPgen() {
		return this.codPgen;
	}

	public void setCodPgen(String codPgen) {
		this.codPgen = codPgen;
	}

	public String getActiv() {
		return this.activ;
	}

	public void setActiv(String activ) {
		this.activ = activ;
	}

}