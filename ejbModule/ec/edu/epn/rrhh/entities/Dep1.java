package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dep1 database table.
 * 
 */
@Entity
@NamedQuery(name="Dep1.findAll", query="SELECT d FROM Dep1 d")
public class Dep1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_dep")
	private String codDep;

	private String elladep;

	@Column(name="ext_dep")
	private String extDep;

	@Column(name="nom_dep")
	private String nomDep;

	@Column(name="tipo_dep")
	private String tipoDep;

	public Dep1() {
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getElladep() {
		return this.elladep;
	}

	public void setElladep(String elladep) {
		this.elladep = elladep;
	}

	public String getExtDep() {
		return this.extDep;
	}

	public void setExtDep(String extDep) {
		this.extDep = extDep;
	}

	public String getNomDep() {
		return this.nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	public String getTipoDep() {
		return this.tipoDep;
	}

	public void setTipoDep(String tipoDep) {
		this.tipoDep = tipoDep;
	}

}