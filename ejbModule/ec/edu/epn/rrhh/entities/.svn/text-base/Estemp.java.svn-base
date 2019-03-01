package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estemp database table.
 * 
 */
@Entity
@Table(name = "estemp", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Estemp.findAll", query="SELECT e FROM Estemp e")
public class Estemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_est")
	private String codEst;

	@Column(name="desc_est")
	private String descEst;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="estemp")
	private List<Emp> emps;

	public Estemp() {
	}

	public String getCodEst() {
		return this.codEst;
	}

	public void setCodEst(String codEst) {
		this.codEst = codEst;
	}

	public String getDescEst() {
		return this.descEst;
	}

	public void setDescEst(String descEst) {
		this.descEst = descEst;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setEstemp(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setEstemp(null);

		return emp;
	}

}