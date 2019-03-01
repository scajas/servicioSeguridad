package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evaldes database table.
 * 
 */
@Entity
@Table(name="evaldes")
@NamedQuery(name="Evalde.findAll", query="SELECT e FROM Evalde e")
public class Evalde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_evaldes")
	private Integer nsecEvaldes;

	@Temporal(TemporalType.DATE)
	private Date feceval;

	@Temporal(TemporalType.DATE)
	@Column(name="fecsis_declarjur")
	private Date fecsisDeclarjur;

	private String nomjefe;

	private String obsr;

	private String perspints;

	private String perspprocint;

	private String persprechum;

	private String perspusrext;

	private String semeval;

	@Column(name="usr_declarjur")
	private String usrDeclarjur;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public Evalde() {
	}

	public Integer getNsecEvaldes() {
		return this.nsecEvaldes;
	}

	public void setNsecEvaldes(Integer nsecEvaldes) {
		this.nsecEvaldes = nsecEvaldes;
	}

	public Date getFeceval() {
		return this.feceval;
	}

	public void setFeceval(Date feceval) {
		this.feceval = feceval;
	}

	public Date getFecsisDeclarjur() {
		return this.fecsisDeclarjur;
	}

	public void setFecsisDeclarjur(Date fecsisDeclarjur) {
		this.fecsisDeclarjur = fecsisDeclarjur;
	}

	public String getNomjefe() {
		return this.nomjefe;
	}

	public void setNomjefe(String nomjefe) {
		this.nomjefe = nomjefe;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
	}

	public String getPerspints() {
		return this.perspints;
	}

	public void setPerspints(String perspints) {
		this.perspints = perspints;
	}

	public String getPerspprocint() {
		return this.perspprocint;
	}

	public void setPerspprocint(String perspprocint) {
		this.perspprocint = perspprocint;
	}

	public String getPersprechum() {
		return this.persprechum;
	}

	public void setPersprechum(String persprechum) {
		this.persprechum = persprechum;
	}

	public String getPerspusrext() {
		return this.perspusrext;
	}

	public void setPerspusrext(String perspusrext) {
		this.perspusrext = perspusrext;
	}

	public String getSemeval() {
		return this.semeval;
	}

	public void setSemeval(String semeval) {
		this.semeval = semeval;
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