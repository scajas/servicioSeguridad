package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the anesc database table.
 * 
 */
@Entity
@NamedQuery(name="Anesc.findAll", query="SELECT a FROM Anesc a")
public class Anesc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_anesc")
	private Integer nsecAnesc;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_aprob")
	private Date fecAprob;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_calc")
	private Date fecCalc;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_cons")
	private Date fecCons;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_sis")
	private Date fecSis;

	@Temporal(TemporalType.DATE)
	@Column(name="frige_anesc")
	private Date frigeAnesc;

	@Column(name="punt_nec")
	private String puntNec;

	@Column(name="punt_obt")
	private String puntObt;

	@Column(name="sem_cons")
	private String semCons;

	private String usr;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	//bi-directional many-to-one association to Nescal
	@ManyToOne
	@JoinColumn(name="cod_nesc")
	private Nescal nescal;

	public Anesc() {
	}

	public Integer getNsecAnesc() {
		return this.nsecAnesc;
	}

	public void setNsecAnesc(Integer nsecAnesc) {
		this.nsecAnesc = nsecAnesc;
	}

	public Date getFecAprob() {
		return this.fecAprob;
	}

	public void setFecAprob(Date fecAprob) {
		this.fecAprob = fecAprob;
	}

	public Date getFecCalc() {
		return this.fecCalc;
	}

	public void setFecCalc(Date fecCalc) {
		this.fecCalc = fecCalc;
	}

	public Date getFecCons() {
		return this.fecCons;
	}

	public void setFecCons(Date fecCons) {
		this.fecCons = fecCons;
	}

	public Date getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Date fecSis) {
		this.fecSis = fecSis;
	}

	public Date getFrigeAnesc() {
		return this.frigeAnesc;
	}

	public void setFrigeAnesc(Date frigeAnesc) {
		this.frigeAnesc = frigeAnesc;
	}

	public String getPuntNec() {
		return this.puntNec;
	}

	public void setPuntNec(String puntNec) {
		this.puntNec = puntNec;
	}

	public String getPuntObt() {
		return this.puntObt;
	}

	public void setPuntObt(String puntObt) {
		this.puntObt = puntObt;
	}

	public String getSemCons() {
		return this.semCons;
	}

	public void setSemCons(String semCons) {
		this.semCons = semCons;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Nescal getNescal() {
		return this.nescal;
	}

	public void setNescal(Nescal nescal) {
		this.nescal = nescal;
	}

}