package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clasemp database table.
 * 
 */
@Entity
@Table(name = "clasemp", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Clasemp.findAll", query="SELECT c FROM Clasemp c order by c.codClase")
public class Clasemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_clase")
	private String codClase;

	@Column(name="desc_clase")
	private String descClase;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="clasemp")
	private List<Emp> emps;

	public Clasemp() {
	}

	public String getCodClase() {
		return this.codClase;
	}

	public void setCodClase(String codClase) {
		this.codClase = codClase;
	}

	public String getDescClase() {
		return this.descClase;
	}

	public void setDescClase(String descClase) {
		this.descClase = descClase;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setClasemp(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setClasemp(null);

		return emp;
	}

}