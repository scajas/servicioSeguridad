package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ecivil database table.
 * 
 */
@Entity
@Table(name = "ecivil", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Ecivil.findAll", query="SELECT e FROM Ecivil e")
public class Ecivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_ecivil")
	private String codEcivil;

	@Column(name="desc_ecivil")
	private String descEcivil;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="ecivil")
	private List<Emp> emps;

	public Ecivil() {
	}

	public String getCodEcivil() {
		return this.codEcivil;
	}

	public void setCodEcivil(String codEcivil) {
		this.codEcivil = codEcivil;
	}

	public String getDescEcivil() {
		return this.descEcivil;
	}

	public void setDescEcivil(String descEcivil) {
		this.descEcivil = descEcivil;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setEcivil(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setEcivil(null);

		return emp;
	}

}