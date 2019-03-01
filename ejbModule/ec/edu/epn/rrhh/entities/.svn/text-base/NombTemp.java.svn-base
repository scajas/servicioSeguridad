package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.contratos.entities.Pensum;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the nomb_temp database table.
 * 
 */
@Entity
@Table(name="nomb_temp", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="NombTemp.findAll", query="SELECT n FROM NombTemp n")
public class NombTemp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nro_nomb")
	private Integer nroNomb;

	@Column(name="anio_reg")
	private String anioReg;

	@Column(name="cargo_aut")
	private String cargoAut;

	@Column(name="cod_dep")
	private String codDep;

	@Column(name="cod_pgen")
	private String codPgen;

	@Column(name="cod_pind")
	private String codPind;

	@Column(name="dcto_info")
	private String dctoInfo;

	@Column(name="dcto_pact")
	private String dctoPact;

	@Column(name="dcto_ped")
	private String dctoPed;

	@Column(name="durac_nomb")
	private Integer duracNomb;

	@Column(name="fec_aprob")
	private Timestamp fecAprob;

	@Column(name="fec_aut")
	private Timestamp fecAut;

	@Column(name="fec_calc")
	private Timestamp fecCalc;

	@Column(name="fec_cons")
	private Timestamp fecCons;

	@Column(name="fec_info")
	private Timestamp fecInfo;

	@Column(name="fec_pact")
	private Timestamp fecPact;

	@Column(name="fec_ped")
	private Timestamp fecPed;

	@Column(name="fec_pos")
	private Timestamp fecPos;

	@Column(name="fec_recrh")
	private Timestamp fecRecrh;

	@Column(name="fec_sis")
	private Timestamp fecSis;

	@Column(name="ffin_nomb")
	private Timestamp ffinNomb;

	@Column(name="frige_nomb")
	private Timestamp frigeNomb;

	private String mbienes;

	private String nced;

	@Column(name="nom_aut")
	private String nomAut;

	@Column(name="nro_acuerdo")
	private String nroAcuerdo;

	@Column(name="nro_reg")
	private Integer nroReg;

	private String obsr;

	@Column(name="punt_nec")
	private String puntNec;

	@Column(name="punt_obt")
	private String puntObt;

	private BigDecimal remunif;

	private String renvac;

	@Column(name="sem_cons")
	private String semCons;

	private BigDecimal sueldob;

	private String tnomb;

	@Column(name="upfsis_nomb")
	private Timestamp upfsisNomb;

	@Column(name="upusr_nomb")
	private String upusrNomb;

	private String usr;
	private String duracnom;
	

	public String getDuracnom() {
		return duracnom;
	}

	public void setDuracnom(String duracnom) {
		this.duracnom = duracnom;
	}

	private String path;
	
	
	@ManyToOne
	@JoinColumn(name = "id_pensum")
	private Pensum pensum;


	public NombTemp() {
	}

	public Integer getNroNomb() {
		return this.nroNomb;
	}

	public void setNroNomb(Integer nroNomb) {
		this.nroNomb = nroNomb;
	}

	public String getAnioReg() {
		return this.anioReg;
	}

	public void setAnioReg(String anioReg) {
		this.anioReg = anioReg;
	}

	public String getCargoAut() {
		return this.cargoAut;
	}

	public void setCargoAut(String cargoAut) {
		this.cargoAut = cargoAut;
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getCodPgen() {
		return this.codPgen;
	}

	public void setCodPgen(String codPgen) {
		this.codPgen = codPgen;
	}

	public String getCodPind() {
		return this.codPind;
	}

	public void setCodPind(String codPind) {
		this.codPind = codPind;
	}

	public String getDctoInfo() {
		return this.dctoInfo;
	}

	public void setDctoInfo(String dctoInfo) {
		this.dctoInfo = dctoInfo;
	}

	public String getDctoPact() {
		return this.dctoPact;
	}

	public void setDctoPact(String dctoPact) {
		this.dctoPact = dctoPact;
	}

	public String getDctoPed() {
		return this.dctoPed;
	}

	public void setDctoPed(String dctoPed) {
		this.dctoPed = dctoPed;
	}

	public Integer getDuracNomb() {
		return this.duracNomb;
	}

	public void setDuracNomb(Integer duracNomb) {
		this.duracNomb = duracNomb;
	}

	public Timestamp getFecAprob() {
		return this.fecAprob;
	}

	public void setFecAprob(Timestamp fecAprob) {
		this.fecAprob = fecAprob;
	}

	public Timestamp getFecAut() {
		return this.fecAut;
	}

	public void setFecAut(Timestamp fecAut) {
		this.fecAut = fecAut;
	}

	public Timestamp getFecCalc() {
		return this.fecCalc;
	}

	public void setFecCalc(Timestamp fecCalc) {
		this.fecCalc = fecCalc;
	}

	public Timestamp getFecCons() {
		return this.fecCons;
	}

	public void setFecCons(Timestamp fecCons) {
		this.fecCons = fecCons;
	}

	public Timestamp getFecInfo() {
		return this.fecInfo;
	}

	public void setFecInfo(Timestamp fecInfo) {
		this.fecInfo = fecInfo;
	}

	public Timestamp getFecPact() {
		return this.fecPact;
	}

	public void setFecPact(Timestamp fecPact) {
		this.fecPact = fecPact;
	}

	public Timestamp getFecPed() {
		return this.fecPed;
	}

	public void setFecPed(Timestamp fecPed) {
		this.fecPed = fecPed;
	}

	public Timestamp getFecPos() {
		return this.fecPos;
	}

	public void setFecPos(Timestamp fecPos) {
		this.fecPos = fecPos;
	}

	public Timestamp getFecRecrh() {
		return this.fecRecrh;
	}

	public void setFecRecrh(Timestamp fecRecrh) {
		this.fecRecrh = fecRecrh;
	}

	public Timestamp getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Timestamp fecSis) {
		this.fecSis = fecSis;
	}

	public Timestamp getFfinNomb() {
		return this.ffinNomb;
	}

	public void setFfinNomb(Timestamp ffinNomb) {
		this.ffinNomb = ffinNomb;
	}

	public Timestamp getFrigeNomb() {
		return this.frigeNomb;
	}

	public void setFrigeNomb(Timestamp frigeNomb) {
		this.frigeNomb = frigeNomb;
	}

	public String getMbienes() {
		return this.mbienes;
	}

	public void setMbienes(String mbienes) {
		this.mbienes = mbienes;
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

	public String getNroAcuerdo() {
		return this.nroAcuerdo;
	}

	public void setNroAcuerdo(String nroAcuerdo) {
		this.nroAcuerdo = nroAcuerdo;
	}

	public Integer getNroReg() {
		return this.nroReg;
	}

	public void setNroReg(Integer nroReg) {
		this.nroReg = nroReg;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
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

	public BigDecimal getRemunif() {
		return this.remunif;
	}

	public void setRemunif(BigDecimal remunif) {
		this.remunif = remunif;
	}

	public String getRenvac() {
		return this.renvac;
	}

	public void setRenvac(String renvac) {
		this.renvac = renvac;
	}

	public String getSemCons() {
		return this.semCons;
	}

	public void setSemCons(String semCons) {
		this.semCons = semCons;
	}

	public BigDecimal getSueldob() {
		return this.sueldob;
	}

	public void setSueldob(BigDecimal sueldob) {
		this.sueldob = sueldob;
	}

	public String getTnomb() {
		return this.tnomb;
	}

	public void setTnomb(String tnomb) {
		this.tnomb = tnomb;
	}

	public Timestamp getUpfsisNomb() {
		return this.upfsisNomb;
	}

	public void setUpfsisNomb(Timestamp upfsisNomb) {
		this.upfsisNomb = upfsisNomb;
	}

	public String getUpusrNomb() {
		return this.upusrNomb;
	}

	public void setUpusrNomb(String upusrNomb) {
		this.upusrNomb = upusrNomb;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the pensum
	 */
	public Pensum getPensum() {
		return pensum;
	}

	/**
	 * @param pensum the pensum to set
	 */
	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

}