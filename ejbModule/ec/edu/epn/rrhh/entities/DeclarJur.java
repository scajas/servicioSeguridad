package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the declar_jur database table.
 * 
 */
@Entity
@Table(name="declar_jur")
@NamedQuery(name="DeclarJur.findAll", query="SELECT d FROM DeclarJur d")
public class DeclarJur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_declarjur")
	private Integer idDeclarjur;

	private String contral;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_declarjur")
	private Date fecDeclarjur;

	@Temporal(TemporalType.DATE)
	@Column(name="fecsis_declarjur")
	private Date fecsisDeclarjur;

	private String obsr;

	@Column(name="usr_declarjur")
	private String usrDeclarjur;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public DeclarJur() {
	}

	public Integer getIdDeclarjur() {
		return this.idDeclarjur;
	}

	public void setIdDeclarjur(Integer idDeclarjur) {
		this.idDeclarjur = idDeclarjur;
	}

	public String getContral() {
		return this.contral;
	}

	public void setContral(String contral) {
		this.contral = contral;
	}

	public Date getFecDeclarjur() {
		return this.fecDeclarjur;
	}

	public void setFecDeclarjur(Date fecDeclarjur) {
		this.fecDeclarjur = fecDeclarjur;
	}

	public Date getFecsisDeclarjur() {
		return this.fecsisDeclarjur;
	}

	public void setFecsisDeclarjur(Date fecsisDeclarjur) {
		this.fecsisDeclarjur = fecsisDeclarjur;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
	}

	public String getUsrDeclarjur() {
		return this.usrDeclarjur;
	}

	public void setUsrDeclarjur(String usrDeclarjur) {
		this.usrDeclarjur = usrDeclarjur;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}