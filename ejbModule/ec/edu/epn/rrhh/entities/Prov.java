package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prov database table.
 * 
 */
@Entity
@Table(name = "prov", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Prov.findAll", query="SELECT p FROM Prov p")
public class Prov implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_prov")
	private String codProv;

	@Column(name="desc_prov")
	private String descProv;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="prov")
	private List<Emp> emps;

	public Prov() {
	}

	public String getCodProv() {
		return this.codProv;
	}

	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}

	public String getDescProv() {
		return this.descProv;
	}

	public void setDescProv(String descProv) {
		this.descProv = descProv;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setProv(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setProv(null);

		return emp;
	}

}