package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the aper database table.
 * 
 */
@Entity
@Table(name = "aper", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="Aper.findAll", query="SELECT a FROM Aper a")
public class Aper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="nro_accion")
	private String nroAccion;

	@Column(name="cargo_aut")
	private String cargoAut;

	@Column(name="cargo_drh")
	private String cargoDrh;

	@Column(name="cargo_psolic")
	private String cargoPsolic;

	private String cargoa;

	private String cargop;

	private String clasea;

	private String clasep;
	@Column(name="path")
	private String path;

    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	@Column(name="cod_dep")
	private String codDep;

	@Column(name="cod_pgena")
	private String codPgena;

	@Column(name="cod_pgenp")
	private String codPgenp;

	@Column(name="cod_pinda")
	private String codPinda;

	@Column(name="cod_pindmina")
	private String codPindmina;

	@Column(name="cod_pindminp")
	private String codPindminp;

	@Column(name="cod_pindp")
	private String codPindp;

	@Column(name="dcto_resp")
	private String dctoResp;

	private String depa;

	private String depp;

	@Column(name="durac_aper")
	private String duracAper;

	private String est;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_dresp")
	private Date fecDresp;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_sis")
	private Date fecSis;

	@Temporal(TemporalType.DATE)
	@Column(name="fecdispres")
	private Date fecdispres;

	@Temporal(TemporalType.DATE)
	@Column(name="felab_aper")
	private Date felabAper;

	@Temporal(TemporalType.DATE)
	@Column(name="ffin_aper")
	private Date ffinAper;

	@Temporal(TemporalType.DATE)
	@Column(name="frige_aper")
	private Date frigeAper;

	private String motivo;

	@Column(name="nom_aut")
	private String nomAut;

	@Column(name="nom_drh")
	private String nomDrh;

	@Column(name="nsec_aper")
	private Integer nsecAper;

	@Column(name="numdispres")
	private String numdispres;

	private String obsr;

	private String ordencargo;

	@Column(name="per_solic")
	private String perSolic;

	private BigDecimal sueldoa;

	private BigDecimal sueldop;

	@Temporal(TemporalType.DATE)
	@Column(name="upfsis_aper")
	private Date upfsisAper;

	@Column(name="upusr_aper")
	private String upusrAper;

	private String usr;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	//bi-directional many-to-one association to Taper
	@ManyToOne
	@JoinColumn(name="taper")
	private Taper taperBean;

	public Aper() {
	}

	public String getNroAccion() {
		return this.nroAccion;
	}

	public void setNroAccion(String nroAccion) {
		this.nroAccion = nroAccion;
	}

	public String getCargoAut() {
		return this.cargoAut;
	}

	public void setCargoAut(String cargoAut) {
		this.cargoAut = cargoAut;
	}

	public String getCargoDrh() {
		return this.cargoDrh;
	}

	public void setCargoDrh(String cargoDrh) {
		this.cargoDrh = cargoDrh;
	}

	public String getCargoPsolic() {
		return this.cargoPsolic;
	}

	public void setCargoPsolic(String cargoPsolic) {
		this.cargoPsolic = cargoPsolic;
	}

	public String getCargoa() {
		return this.cargoa;
	}

	public void setCargoa(String cargoa) {
		this.cargoa = cargoa;
	}

	public String getCargop() {
		return this.cargop;
	}

	public void setCargop(String cargop) {
		this.cargop = cargop;
	}

	public String getClasea() {
		return this.clasea;
	}

	public void setClasea(String clasea) {
		this.clasea = clasea;
	}

	public String getClasep() {
		return this.clasep;
	}

	public void setClasep(String clasep) {
		this.clasep = clasep;
	}

	public String getCodDep() {
		return this.codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getCodPgena() {
		return this.codPgena;
	}

	public void setCodPgena(String codPgena) {
		this.codPgena = codPgena;
	}

	public String getCodPgenp() {
		return this.codPgenp;
	}

	public void setCodPgenp(String codPgenp) {
		this.codPgenp = codPgenp;
	}

	public String getCodPinda() {
		return this.codPinda;
	}

	public void setCodPinda(String codPinda) {
		this.codPinda = codPinda;
	}

	public String getCodPindmina() {
		return this.codPindmina;
	}

	public void setCodPindmina(String codPindmina) {
		this.codPindmina = codPindmina;
	}

	public String getCodPindminp() {
		return this.codPindminp;
	}

	public void setCodPindminp(String codPindminp) {
		this.codPindminp = codPindminp;
	}

	public String getCodPindp() {
		return this.codPindp;
	}

	public void setCodPindp(String codPindp) {
		this.codPindp = codPindp;
	}

	public String getDctoResp() {
		return this.dctoResp;
	}

	public void setDctoResp(String dctoResp) {
		this.dctoResp = dctoResp;
	}

	public String getDepa() {
		return this.depa;
	}

	public void setDepa(String depa) {
		this.depa = depa;
	}

	public String getDepp() {
		return this.depp;
	}

	public void setDepp(String depp) {
		this.depp = depp;
	}

	public String getDuracAper() {
		return this.duracAper;
	}

	public void setDuracAper(String duracAper) {
		this.duracAper = duracAper;
	}

	public String getEst() {
		return this.est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public Date getFecDresp() {
		return this.fecDresp;
	}

	public void setFecDresp(Date fecDresp) {
		this.fecDresp = fecDresp;
	}

	public Date getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Date fecSis) {
		this.fecSis = fecSis;
	}

	public Date getFecdispres() {
		return this.fecdispres;
	}

	public void setFecdispres(Date fecdispres) {
		this.fecdispres = fecdispres;
	}

	public Date getFelabAper() {
		return this.felabAper;
	}

	public void setFelabAper(Date felabAper) {
		this.felabAper = felabAper;
	}

	public Date getFfinAper() {
		return this.ffinAper;
	}

	public void setFfinAper(Date ffinAper) {
		this.ffinAper = ffinAper;
	}

	public Date getFrigeAper() {
		return this.frigeAper;
	}

	public void setFrigeAper(Date frigeAper) {
		this.frigeAper = frigeAper;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNomAut() {
		return this.nomAut;
	}

	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}

	public String getNomDrh() {
		return this.nomDrh;
	}

	public void setNomDrh(String nomDrh) {
		this.nomDrh = nomDrh;
	}

	public Integer getNsecAper() {
		return this.nsecAper;
	}

	public void setNsecAper(Integer nsecAper) {
		this.nsecAper = nsecAper;
	}

	public String getNumdispres() {
		return this.numdispres;
	}

	public void setNumdispres(String numdispres) {
		this.numdispres = numdispres;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
	}

	public String getOrdencargo() {
		return this.ordencargo;
	}

	public void setOrdencargo(String ordencargo) {
		this.ordencargo = ordencargo;
	}

	public String getPerSolic() {
		return this.perSolic;
	}

	public void setPerSolic(String perSolic) {
		this.perSolic = perSolic;
	}

	public BigDecimal getSueldoa() {
		return this.sueldoa;
	}

	public void setSueldoa(BigDecimal sueldoa) {
		this.sueldoa = sueldoa;
	}

	public BigDecimal getSueldop() {
		return this.sueldop;
	}

	public void setSueldop(BigDecimal sueldop) {
		this.sueldop = sueldop;
	}

	public Date getUpfsisAper() {
		return this.upfsisAper;
	}

	public void setUpfsisAper(Date upfsisAper) {
		this.upfsisAper = upfsisAper;
	}

	public String getUpusrAper() {
		return this.upusrAper;
	}

	public void setUpusrAper(String upusrAper) {
		this.upusrAper = upusrAper;
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

	public Taper getTaperBean() {
		return this.taperBean;
	}

	public void setTaperBean(Taper taperBean) {
		this.taperBean = taperBean;
	}

}