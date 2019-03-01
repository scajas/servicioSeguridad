package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dep database table.
 * 
 */
@Entity
@Table(name = "dep", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQueries({
	@NamedQuery(name="Dep.findAll", query="SELECT d FROM Dep d order by d.nomDep "),
	@NamedQuery(name="Dep.findDepOrder", query="SELECT d FROM Dep d WHERE d.nomDep like :nombre"),
})
public class Dep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_dep")
	private String codDep;

	@Column(name="ext_dep")
	private String extDep;

	private String mailjefe;

	@Column(name="nom_dep")
	private String nomDep;

	@Column(name="tipo_dep")
	private String tipoDep;
	
	private String sigla;
	
	@Column(name="id_facultad")
	private Integer idFacultad;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="dep")
	private List<Emp> emps;
	
	
	

	public Dep() {
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getExtDep() {
		return this.extDep;
	}

	public void setExtDep(String extDep) {
		this.extDep = extDep;
	}

	public String getMailjefe() {
		return this.mailjefe;
	}

	public void setMailjefe(String mailjefe) {
		this.mailjefe = mailjefe;
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

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setDep(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setDep(null);

		return emp;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(Integer idFacultad) {
		this.idFacultad = idFacultad;
	}

}