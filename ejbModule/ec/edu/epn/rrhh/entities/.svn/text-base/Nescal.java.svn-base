package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nescal database table.
 * 
 */
@Entity
@NamedQuery(name="Nescal.findAll", query="SELECT n FROM Nescal n")
public class Nescal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_nesc")
	private Integer codNesc;

	@Column(name="desc_nesc")
	private String descNesc;

	//bi-directional many-to-one association to Anesc
	@OneToMany(mappedBy="nescal")
	private List<Anesc> anescs;

	public Nescal() {
	}

	public Integer getCodNesc() {
		return this.codNesc;
	}

	public void setCodNesc(Integer codNesc) {
		this.codNesc = codNesc;
	}

	public String getDescNesc() {
		return this.descNesc;
	}

	public void setDescNesc(String descNesc) {
		this.descNesc = descNesc;
	}

	public List<Anesc> getAnescs() {
		return this.anescs;
	}

	public void setAnescs(List<Anesc> anescs) {
		this.anescs = anescs;
	}

	public Anesc addAnesc(Anesc anesc) {
		getAnescs().add(anesc);
		anesc.setNescal(this);

		return anesc;
	}

	public Anesc removeAnesc(Anesc anesc) {
		getAnescs().remove(anesc);
		anesc.setNescal(null);

		return anesc;
	}

}