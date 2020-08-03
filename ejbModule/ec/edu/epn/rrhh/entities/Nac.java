package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nac database table.
 * 
 */
@Entity
@Table(name = "nac", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Nac.findAll", query="SELECT n FROM Nac n")
public class Nac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_nac")
	private String codNac;

	@Column(name="desc_nac")
	private String descNac;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="nac")
	private List<Emp> emps;

	public Nac() {
	}

	public String getCodNac() {
		return this.codNac;
	}

	public void setCodNac(String codNac) {
		this.codNac = codNac;
	}

	public String getDescNac() {
		return this.descNac;
	}

	public void setDescNac(String descNac) {
		this.descNac = descNac;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setNac(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setNac(null);

		return emp;
	}

}