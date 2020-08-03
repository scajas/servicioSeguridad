package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genero database table.
 * 
 */
@Entity
@Table(name = "genero", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cod_sexo")
	private String codSexo;

	@Column(name="desc_sexo")
	private String descSexo;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="genero")
	private List<Emp> emps;

	public Genero() {
	}

	public String getCodSexo() {
		return this.codSexo;
	}

	public void setCodSexo(String codSexo) {
		this.codSexo = codSexo;
	}

	public String getDescSexo() {
		return this.descSexo;
	}

	public void setDescSexo(String descSexo) {
		this.descSexo = descSexo;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setGenero(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setGenero(null);

		return emp;
	}

}