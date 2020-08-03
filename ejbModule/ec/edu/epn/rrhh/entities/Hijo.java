package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hijos database table.
 * 
 */
@Entity
@Table(name="hijos")
@NamedQuery(name="Hijo.findAll", query="SELECT h FROM Hijo h")
public class Hijo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_hijo")
	private Integer nsecHijo;

	@Column(name="apel_hijo")
	private String apelHijo;

	@Temporal(TemporalType.DATE)
	@Column(name="fnac_hijo")
	private Date fnacHijo;

	@Column(name="nom_hijo")
	private String nomHijo;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public Hijo() {
	}

	public Integer getNsecHijo() {
		return this.nsecHijo;
	}

	public void setNsecHijo(Integer nsecHijo) {
		this.nsecHijo = nsecHijo;
	}

	public String getApelHijo() {
		return this.apelHijo;
	}

	public void setApelHijo(String apelHijo) {
		this.apelHijo = apelHijo;
	}

	public Date getFnacHijo() {
		return this.fnacHijo;
	}

	public void setFnacHijo(Date fnacHijo) {
		this.fnacHijo = fnacHijo;
	}

	public String getNomHijo() {
		return this.nomHijo;
	}

	public void setNomHijo(String nomHijo) {
		this.nomHijo = nomHijo;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}