package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the vac database table.
 * 
 */
@Entity
@NamedQuery(name="Vac.findAll", query="SELECT v FROM Vac v")
public class Vac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nsec_vac")
	private Integer nsecVac;

	private String det;

	@Column(name="dias_conc")
	private BigDecimal diasConc;

	@Column(name="dias_util")
	private BigDecimal diasUtil;

	@Column(name="fcalc_vac")
	private Timestamp fcalcVac;

	@Column(name="fec_reg")
	private Timestamp fecReg;

	@Column(name="fec_sal")
	private Timestamp fecSal;

	@Column(name="fec_sis")
	private Timestamp fecSis;

	@Column(name="fsolic_vac")
	private Timestamp fsolicVac;

	@Column(name="hora_reg")
	private Timestamp horaReg;

	@Column(name="hora_sal")
	private Timestamp horaSal;

	private String nced;

	@Column(name="nom_aut")
	private String nomAut;

	private String periodo;

	@Column(name="saldo_vac")
	private BigDecimal saldoVac;

	private double tipdet;

	private String usr;

	public Vac() {
	}

	public Integer getNsecVac() {
		return this.nsecVac;
	}

	public void setNsecVac(Integer nsecVac) {
		this.nsecVac = nsecVac;
	}

	public String getDet() {
		return this.det;
	}

	public void setDet(String det) {
		this.det = det;
	}

	public BigDecimal getDiasConc() {
		return this.diasConc;
	}

	public void setDiasConc(BigDecimal diasConc) {
		this.diasConc = diasConc;
	}

	public BigDecimal getDiasUtil() {
		return this.diasUtil;
	}

	public void setDiasUtil(BigDecimal diasUtil) {
		this.diasUtil = diasUtil;
	}

	public Timestamp getFcalcVac() {
		return this.fcalcVac;
	}

	public void setFcalcVac(Timestamp fcalcVac) {
		this.fcalcVac = fcalcVac;
	}

	public Timestamp getFecReg() {
		return this.fecReg;
	}

	public void setFecReg(Timestamp fecReg) {
		this.fecReg = fecReg;
	}

	public Timestamp getFecSal() {
		return this.fecSal;
	}

	public void setFecSal(Timestamp fecSal) {
		this.fecSal = fecSal;
	}

	public Timestamp getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Timestamp fecSis) {
		this.fecSis = fecSis;
	}

	public Timestamp getFsolicVac() {
		return this.fsolicVac;
	}

	public void setFsolicVac(Timestamp fsolicVac) {
		this.fsolicVac = fsolicVac;
	}

	public Timestamp getHoraReg() {
		return this.horaReg;
	}

	public void setHoraReg(Timestamp horaReg) {
		this.horaReg = horaReg;
	}

	public Timestamp getHoraSal() {
		return this.horaSal;
	}

	public void setHoraSal(Timestamp horaSal) {
		this.horaSal = horaSal;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNomAut() {
		return this.nomAut;
	}

	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}

	public String getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public BigDecimal getSaldoVac() {
		return this.saldoVac;
	}

	public void setSaldoVac(BigDecimal saldoVac) {
		this.saldoVac = saldoVac;
	}

	public double getTipdet() {
		return this.tipdet;
	}

	public void setTipdet(double tipdet) {
		this.tipdet = tipdet;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

}