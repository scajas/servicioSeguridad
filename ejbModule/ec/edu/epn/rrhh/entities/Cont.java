package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.contratos.entities.Pensum;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the cont database table.
 * 
 */
@Entity
@Table(name = "cont", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name = "Cont.findAll", query = "SELECT c FROM Cont c")
public class Cont implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nro_cont")
	private String nroCont;

	private String advertidoa;

	private String alala;

	private String alla;

	private String autcont;

	private String autoridad;

	private String basel;

	private String becadoa;

	@Column(name = "ben_inst")
	private String benInst;

	@Column(name = "ben_ley")
	private String benLey;

	private String cargoaut;

	private String cargoc;

	private String cargosolicont;

	private String carr1;

	private String carr2;

	private String carr3;

	private String carr4;

	private String carr5;

	private String carr6;

	private String carr7;

	private String carrerabecado;

	private String cencostos;

	private String contint;

	private String contratadoa;

	@Column(name = "dcto_pinf")
	private String dctoPinf;

	private String delcont;

	private String deldela;

	private String dispresup;

	@Column(name = "durac_cont")
	private String duracCont;

	private String elella;

	private String ella;

	private String elladep;

	private String ellamay;

	private String ellamin;

	private String ellatiptit;

	private String estc;

	private String fac1;

	private String fac2;

	private String fac3;

	private String fac4;

	private String fac5;

	private String fac6;

	private String fac7;

	private Timestamp fautcont;

	@Column(name = "fec_pinf")
	private Timestamp fecPinf;

	@Column(name = "fec_sis")
	private Timestamp fecSis;

	@Column(name = "fec_solec")
	private Timestamp fecSolec;

	@Column(name = "\"FECTERMCONT\"")
	private Timestamp fectermcont;

	@Temporal(TemporalType.DATE)
	private Date fecultcateg;

	@Column(name = "felab_cont")
	private Timestamp felabCont;

	@Column(name = "\"FELABTERMCONT\"")
	private Timestamp felabtermcont;

	@Column(name = "ffin_cont")
	private Timestamp ffinCont;

	@Column(name = "\"FINFORMEN\"")
	private String finformen;

	private Timestamp finfpl;

	private Timestamp fndispres;

	private String fndispresm;

	private Timestamp frecrrhh;

	@Column(name = "frige_cont")
	private Timestamp frigeCont;

	private Timestamp fsolicfondos;

	private String fsolicfondosm;

	private Timestamp fsolicinfpl;

	private Timestamp fsolicont;

	private String fsolicontm;

	private String habilitadoa;

	private String horario;

	private Integer horas;

	private String incursoa;

	private String infpl;

	private String initresp;

	private String mat1;

	private String mat2;

	private String mat3;

	private String mat4;

	private String mat5;

	private String mat6;

	private String mat7;

	private String mes1;

	private String mes2;

	private String mes3;

	private String mes4;

	private String mes5;

	private String mes6;

	private BigDecimal montototal;

	@Column(name = "mto_mens")
	private BigDecimal mtoMens;

	private BigDecimal multaporhora;

	private String multaporhoralet;

	private String ndispres;

	private Integer nhoras1;

	private Integer nhoras2;

	private Integer nhoras3;

	private Integer nhoras4;

	private Integer nhoras5;

	private Integer nhoras6;

	private Integer nhoras7;

	@Column(name = "\"NHORASTAREA1\"")
	private Integer nhorastarea1;

	@Column(name = "\"NHORASTAREA10\"")
	private Integer nhorastarea10;

	@Column(name = "\"NHORASTAREA2\"")
	private Integer nhorastarea2;

	@Column(name = "\"NHORASTAREA3\"")
	private Integer nhorastarea3;

	@Column(name = "\"NHORASTAREA4\"")
	private Integer nhorastarea4;

	@Column(name = "\"NHORASTAREA5\"")
	private Integer nhorastarea5;

	@Column(name = "\"NHORASTAREA6\"")
	private Integer nhorastarea6;

	@Column(name = "\"NHORASTAREA7\"")
	private Integer nhorastarea7;

	@Column(name = "\"NHORASTAREA8\"")
	private Integer nhorastarea8;

	@Column(name = "\"NHORASTAREA9\"")
	private Integer nhorastarea9;

	private Integer nhormat1mes1;

	private Integer nhormat1mes2;

	private Integer nhormat1mes3;

	private Integer nhormat1mes4;

	private Integer nhormat1mes5;

	private Integer nhormat1mes6;

	private Integer nhormat2mes1;

	private Integer nhormat2mes2;

	private Integer nhormat2mes3;

	private Integer nhormat2mes4;

	private Integer nhormat2mes5;

	private Integer nhormat2mes6;

	private Integer nhormat3mes1;

	private Integer nhormat3mes2;

	private Integer nhormat3mes3;

	private Integer nhormat3mes4;

	private Integer nhormat3mes5;

	private Integer nhormat3mes6;

	private Integer nhormat4mes1;

	private Integer nhormat4mes2;

	private Integer nhormat4mes3;

	private Integer nhormat4mes4;

	private Integer nhormat4mes5;

	private Integer nhormat4mes6;

	private Integer nhormat5mes1;

	private Integer nhormat5mes2;

	private Integer nhormat5mes3;

	private Integer nhormat5mes4;

	private Integer nhormat5mes5;

	private Integer nhormat5mes6;

	private Integer nhormat6mes1;

	private Integer nhormat6mes2;

	private Integer nhormat6mes3;

	private Integer nhormat6mes4;

	private Integer nhormat6mes5;

	private Integer nhormat6mes6;

	private Integer nhormat7mes1;

	private Integer nhormat7mes2;

	private Integer nhormat7mes3;

	private Integer nhormat7mes4;

	private Integer nhormat7mes5;

	private Integer nhormat7mes6;

	private String nomsolicont;

	@Column(name = "\"NROTERMCONT\"")
	private String nrotermcont;

	@Column(name = "nsec_cont")
	private Integer nsecCont;

	private String nuevorenov;

	private String obj;

	private String objeto;

	private String obsr;
	
	private String path;

	@Column(name = "\"PARALELO1\"")
	private String paralelo1;

	@Column(name = "\"PARALELO2\"")
	private String paralelo2;

	@Column(name = "\"PARALELO3\"")
	private String paralelo3;

	@Column(name = "\"PARALELO4\"")
	private String paralelo4;

	@Column(name = "\"PARALELO5\"")
	private String paralelo5;

	@Column(name = "\"PARALELO6\"")
	private String paralelo6;

	@Column(name = "\"PARALELO7\"")
	private String paralelo7;

	private String partaplic;

	private String remlet;

	private String remlettotal;

	private String solec;

	private String solicfondos;

	private String solicinfpl;

	private String solicont;

	private Integer supl1;

	private Integer supl2;

	private Integer supl3;

	private Integer supl4;

	private Integer supl5;

	private Integer supl6;

	private Integer supl7;

	@Column(name = "\"TAREA1\"")
	private String tarea1;

	@Column(name = "\"TAREA10\"")
	private String tarea10;

	@Column(name = "\"TAREA2\"")
	private String tarea2;

	@Column(name = "\"TAREA3\"")
	private String tarea3;

	@Column(name = "\"TAREA4\"")
	private String tarea4;

	@Column(name = "\"TAREA5\"")
	private String tarea5;

	@Column(name = "\"TAREA6\"")
	private String tarea6;

	@Column(name = "\"TAREA7\"")
	private String tarea7;

	@Column(name = "\"TAREA8\"")
	private String tarea8;

	@Column(name = "\"TAREA9\"")
	private String tarea9;

	private String titpercont;

	@Column(name = "\"TOTHORASTAREAS\"")
	private Integer tothorastareas;

	@Column(name = "upfsis_cont")
	private Timestamp upfsisCont;

	@Column(name = "upusr_cont")
	private String upusrCont;

	private String usr;

	private BigDecimal valhor;

	private BigDecimal valhor1;

	private BigDecimal valhor2;

	private BigDecimal valhor3;

	private BigDecimal valhor4;

	private BigDecimal valhor5;

	private BigDecimal valhor6;

	private BigDecimal valhor7;

	private BigDecimal valtot1;

	private BigDecimal valtot2;

	private BigDecimal valtot3;

	private BigDecimal valtot4;

	private BigDecimal valtot5;

	private BigDecimal valtot6;

	private BigDecimal valtot7;

	@Column(name = "\"VIATICOS\"")
	private String viaticos;
	
	


	// bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name = "nced")
	private Emp emp;

	// bi-directional many-to-one association to Tcont
	@ManyToOne
	@JoinColumn(name = "tcont")
	private Tcont tcontBean;

	// bi-directional many-to-one association to Controlpago
	@OneToMany(mappedBy = "cont")
	private List<Controlpago> controlpagos;
	
	@ManyToOne
	@JoinColumn(name = "id_pensum")
	private Pensum pensum;

	public Cont() {
	}

	public String getNroCont() {
		return this.nroCont;
	}

	public void setNroCont(String nroCont) {
		this.nroCont = nroCont;
	}

	public String getAdvertidoa() {
		return this.advertidoa;
	}

	public void setAdvertidoa(String advertidoa) {
		this.advertidoa = advertidoa;
	}

	public String getAlala() {
		return this.alala;
	}

	public void setAlala(String alala) {
		this.alala = alala;
	}

	public String getAlla() {
		return this.alla;
	}

	public void setAlla(String alla) {
		this.alla = alla;
	}

	public String getAutcont() {
		return this.autcont;
	}

	public void setAutcont(String autcont) {
		this.autcont = autcont;
	}

	public String getAutoridad() {
		return this.autoridad;
	}

	public void setAutoridad(String autoridad) {
		this.autoridad = autoridad;
	}

	public String getBasel() {
		return this.basel;
	}

	public void setBasel(String basel) {
		this.basel = basel;
	}

	public String getBecadoa() {
		return this.becadoa;
	}

	public void setBecadoa(String becadoa) {
		this.becadoa = becadoa;
	}

	public String getBenInst() {
		return this.benInst;
	}

	public void setBenInst(String benInst) {
		this.benInst = benInst;
	}

	public String getBenLey() {
		return this.benLey;
	}

	public void setBenLey(String benLey) {
		this.benLey = benLey;
	}

	public String getCargoaut() {
		return this.cargoaut;
	}

	public void setCargoaut(String cargoaut) {
		this.cargoaut = cargoaut;
	}

	public String getCargoc() {
		return this.cargoc;
	}

	public void setCargoc(String cargoc) {
		this.cargoc = cargoc;
	}

	public String getCargosolicont() {
		return this.cargosolicont;
	}

	public void setCargosolicont(String cargosolicont) {
		this.cargosolicont = cargosolicont;
	}

	public String getCarr1() {
		return this.carr1;
	}

	public void setCarr1(String carr1) {
		this.carr1 = carr1;
	}

	public String getCarr2() {
		return this.carr2;
	}

	public void setCarr2(String carr2) {
		this.carr2 = carr2;
	}

	public String getCarr3() {
		return this.carr3;
	}

	public void setCarr3(String carr3) {
		this.carr3 = carr3;
	}

	public String getCarr4() {
		return this.carr4;
	}

	public void setCarr4(String carr4) {
		this.carr4 = carr4;
	}

	public String getCarr5() {
		return this.carr5;
	}

	public void setCarr5(String carr5) {
		this.carr5 = carr5;
	}

	public String getCarr6() {
		return this.carr6;
	}

	public void setCarr6(String carr6) {
		this.carr6 = carr6;
	}

	public String getCarr7() {
		return this.carr7;
	}

	public void setCarr7(String carr7) {
		this.carr7 = carr7;
	}

	public String getCarrerabecado() {
		return this.carrerabecado;
	}

	public void setCarrerabecado(String carrerabecado) {
		this.carrerabecado = carrerabecado;
	}

	public String getCencostos() {
		return this.cencostos;
	}

	public void setCencostos(String cencostos) {
		this.cencostos = cencostos;
	}

	public String getContint() {
		return this.contint;
	}

	public void setContint(String contint) {
		this.contint = contint;
	}

	public String getContratadoa() {
		return this.contratadoa;
	}

	public void setContratadoa(String contratadoa) {
		this.contratadoa = contratadoa;
	}

	public String getDctoPinf() {
		return this.dctoPinf;
	}

	public void setDctoPinf(String dctoPinf) {
		this.dctoPinf = dctoPinf;
	}

	public String getDelcont() {
		return this.delcont;
	}

	public void setDelcont(String delcont) {
		this.delcont = delcont;
	}

	public String getDeldela() {
		return this.deldela;
	}

	public void setDeldela(String deldela) {
		this.deldela = deldela;
	}

	public String getDispresup() {
		return this.dispresup;
	}

	public void setDispresup(String dispresup) {
		this.dispresup = dispresup;
	}

	public String getDuracCont() {
		return this.duracCont;
	}

	public void setDuracCont(String duracCont) {
		this.duracCont = duracCont;
	}

	public String getElella() {
		return this.elella;
	}

	public void setElella(String elella) {
		this.elella = elella;
	}

	public String getElla() {
		return this.ella;
	}

	public void setElla(String ella) {
		this.ella = ella;
	}

	public String getElladep() {
		return this.elladep;
	}

	public void setElladep(String elladep) {
		this.elladep = elladep;
	}

	public String getEllamay() {
		return this.ellamay;
	}

	public void setEllamay(String ellamay) {
		this.ellamay = ellamay;
	}

	public String getEllamin() {
		return this.ellamin;
	}

	public void setEllamin(String ellamin) {
		this.ellamin = ellamin;
	}

	public String getEllatiptit() {
		return this.ellatiptit;
	}

	public void setEllatiptit(String ellatiptit) {
		this.ellatiptit = ellatiptit;
	}

	public String getEstc() {
		return this.estc;
	}

	public void setEstc(String estc) {
		this.estc = estc;
	}

	public String getFac1() {
		return this.fac1;
	}

	public void setFac1(String fac1) {
		this.fac1 = fac1;
	}

	public String getFac2() {
		return this.fac2;
	}

	public void setFac2(String fac2) {
		this.fac2 = fac2;
	}

	public String getFac3() {
		return this.fac3;
	}

	public void setFac3(String fac3) {
		this.fac3 = fac3;
	}

	public String getFac4() {
		return this.fac4;
	}

	public void setFac4(String fac4) {
		this.fac4 = fac4;
	}

	public String getFac5() {
		return this.fac5;
	}

	public void setFac5(String fac5) {
		this.fac5 = fac5;
	}

	public String getFac6() {
		return this.fac6;
	}

	public void setFac6(String fac6) {
		this.fac6 = fac6;
	}

	public String getFac7() {
		return this.fac7;
	}

	public void setFac7(String fac7) {
		this.fac7 = fac7;
	}

	public Timestamp getFautcont() {
		return this.fautcont;
	}

	public void setFautcont(Timestamp fautcont) {
		this.fautcont = fautcont;
	}

	public Timestamp getFecPinf() {
		return this.fecPinf;
	}

	public void setFecPinf(Timestamp fecPinf) {
		this.fecPinf = fecPinf;
	}

	public Timestamp getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Timestamp fecSis) {
		this.fecSis = fecSis;
	}

	public Timestamp getFecSolec() {
		return this.fecSolec;
	}

	public void setFecSolec(Timestamp fecSolec) {
		this.fecSolec = fecSolec;
	}

	public Timestamp getFectermcont() {
		return this.fectermcont;
	}

	public void setFectermcont(Timestamp fectermcont) {
		this.fectermcont = fectermcont;
	}

	public Date getFecultcateg() {
		return this.fecultcateg;
	}

	public void setFecultcateg(Date fecultcateg) {
		this.fecultcateg = fecultcateg;
	}

	public Timestamp getFelabCont() {
		return this.felabCont;
	}

	public void setFelabCont(Timestamp felabCont) {
		this.felabCont = felabCont;
	}

	public Timestamp getFelabtermcont() {
		return this.felabtermcont;
	}

	public void setFelabtermcont(Timestamp felabtermcont) {
		this.felabtermcont = felabtermcont;
	}

	public Timestamp getFfinCont() {
		return this.ffinCont;
	}

	public void setFfinCont(Timestamp ffinCont) {
		this.ffinCont = ffinCont;
	}

	public String getFinformen() {
		return this.finformen;
	}

	public void setFinformen(String finformen) {
		this.finformen = finformen;
	}

	public Timestamp getFinfpl() {
		return this.finfpl;
	}

	public void setFinfpl(Timestamp finfpl) {
		this.finfpl = finfpl;
	}

	public Timestamp getFndispres() {
		return this.fndispres;
	}

	public void setFndispres(Timestamp fndispres) {
		this.fndispres = fndispres;
	}

	public String getFndispresm() {
		return this.fndispresm;
	}

	public void setFndispresm(String fndispresm) {
		this.fndispresm = fndispresm;
	}

	public Timestamp getFrecrrhh() {
		return this.frecrrhh;
	}

	public void setFrecrrhh(Timestamp frecrrhh) {
		this.frecrrhh = frecrrhh;
	}

	public Timestamp getFrigeCont() {
		return this.frigeCont;
	}

	public void setFrigeCont(Timestamp frigeCont) {
		this.frigeCont = frigeCont;
	}

	public Timestamp getFsolicfondos() {
		return this.fsolicfondos;
	}

	public void setFsolicfondos(Timestamp fsolicfondos) {
		this.fsolicfondos = fsolicfondos;
	}

	public String getFsolicfondosm() {
		return this.fsolicfondosm;
	}

	public void setFsolicfondosm(String fsolicfondosm) {
		this.fsolicfondosm = fsolicfondosm;
	}

	public Timestamp getFsolicinfpl() {
		return this.fsolicinfpl;
	}

	public void setFsolicinfpl(Timestamp fsolicinfpl) {
		this.fsolicinfpl = fsolicinfpl;
	}

	public Timestamp getFsolicont() {
		return this.fsolicont;
	}

	public void setFsolicont(Timestamp fsolicont) {
		this.fsolicont = fsolicont;
	}

	public String getFsolicontm() {
		return this.fsolicontm;
	}

	public void setFsolicontm(String fsolicontm) {
		this.fsolicontm = fsolicontm;
	}

	public String getHabilitadoa() {
		return this.habilitadoa;
	}

	public void setHabilitadoa(String habilitadoa) {
		this.habilitadoa = habilitadoa;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getHoras() {
		return this.horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getIncursoa() {
		return this.incursoa;
	}

	public void setIncursoa(String incursoa) {
		this.incursoa = incursoa;
	}

	public String getInfpl() {
		return this.infpl;
	}

	public void setInfpl(String infpl) {
		this.infpl = infpl;
	}

	public String getInitresp() {
		return this.initresp;
	}

	public void setInitresp(String initresp) {
		this.initresp = initresp;
	}

	public String getMat1() {
		return this.mat1;
	}

	public void setMat1(String mat1) {
		this.mat1 = mat1;
	}

	public String getMat2() {
		return this.mat2;
	}

	public void setMat2(String mat2) {
		this.mat2 = mat2;
	}

	public String getMat3() {
		return this.mat3;
	}

	public void setMat3(String mat3) {
		this.mat3 = mat3;
	}

	public String getMat4() {
		return this.mat4;
	}

	public void setMat4(String mat4) {
		this.mat4 = mat4;
	}

	public String getMat5() {
		return this.mat5;
	}

	public void setMat5(String mat5) {
		this.mat5 = mat5;
	}

	public String getMat6() {
		return this.mat6;
	}

	public void setMat6(String mat6) {
		this.mat6 = mat6;
	}

	public String getMat7() {
		return this.mat7;
	}

	public void setMat7(String mat7) {
		this.mat7 = mat7;
	}

	public String getMes1() {
		return this.mes1;
	}

	public void setMes1(String mes1) {
		this.mes1 = mes1;
	}

	public String getMes2() {
		return this.mes2;
	}

	public void setMes2(String mes2) {
		this.mes2 = mes2;
	}

	public String getMes3() {
		return this.mes3;
	}

	public void setMes3(String mes3) {
		this.mes3 = mes3;
	}

	public String getMes4() {
		return this.mes4;
	}

	public void setMes4(String mes4) {
		this.mes4 = mes4;
	}

	public String getMes5() {
		return this.mes5;
	}

	public void setMes5(String mes5) {
		this.mes5 = mes5;
	}

	public String getMes6() {
		return this.mes6;
	}

	public void setMes6(String mes6) {
		this.mes6 = mes6;
	}

	public BigDecimal getMontototal() {
		return this.montototal;
	}

	public void setMontototal(BigDecimal montototal) {
		this.montototal = montototal;
	}

	public BigDecimal getMtoMens() {
		return this.mtoMens;
	}

	public void setMtoMens(BigDecimal mtoMens) {
		this.mtoMens = mtoMens;
	}

	public BigDecimal getMultaporhora() {
		return this.multaporhora;
	}

	public void setMultaporhora(BigDecimal multaporhora) {
		this.multaporhora = multaporhora;
	}

	public String getMultaporhoralet() {
		return this.multaporhoralet;
	}

	public void setMultaporhoralet(String multaporhoralet) {
		this.multaporhoralet = multaporhoralet;
	}

	public String getNdispres() {
		return this.ndispres;
	}

	public void setNdispres(String ndispres) {
		this.ndispres = ndispres;
	}

	public Integer getNhoras1() {
		return this.nhoras1;
	}

	public void setNhoras1(Integer nhoras1) {
		this.nhoras1 = nhoras1;
	}

	public Integer getNhoras2() {
		return this.nhoras2;
	}

	public void setNhoras2(Integer nhoras2) {
		this.nhoras2 = nhoras2;
	}

	public Integer getNhoras3() {
		return this.nhoras3;
	}

	public void setNhoras3(Integer nhoras3) {
		this.nhoras3 = nhoras3;
	}

	public Integer getNhoras4() {
		return this.nhoras4;
	}

	public void setNhoras4(Integer nhoras4) {
		this.nhoras4 = nhoras4;
	}

	public Integer getNhoras5() {
		return this.nhoras5;
	}

	public void setNhoras5(Integer nhoras5) {
		this.nhoras5 = nhoras5;
	}

	public Integer getNhoras6() {
		return this.nhoras6;
	}

	public void setNhoras6(Integer nhoras6) {
		this.nhoras6 = nhoras6;
	}

	public Integer getNhoras7() {
		return this.nhoras7;
	}

	public void setNhoras7(Integer nhoras7) {
		this.nhoras7 = nhoras7;
	}

	public Integer getNhorastarea1() {
		return this.nhorastarea1;
	}

	public void setNhorastarea1(Integer nhorastarea1) {
		this.nhorastarea1 = nhorastarea1;
	}

	public Integer getNhorastarea10() {
		return this.nhorastarea10;
	}

	public void setNhorastarea10(Integer nhorastarea10) {
		this.nhorastarea10 = nhorastarea10;
	}

	public Integer getNhorastarea2() {
		return this.nhorastarea2;
	}

	public void setNhorastarea2(Integer nhorastarea2) {
		this.nhorastarea2 = nhorastarea2;
	}

	public Integer getNhorastarea3() {
		return this.nhorastarea3;
	}

	public void setNhorastarea3(Integer nhorastarea3) {
		this.nhorastarea3 = nhorastarea3;
	}

	public Integer getNhorastarea4() {
		return this.nhorastarea4;
	}

	public void setNhorastarea4(Integer nhorastarea4) {
		this.nhorastarea4 = nhorastarea4;
	}

	public Integer getNhorastarea5() {
		return this.nhorastarea5;
	}

	public void setNhorastarea5(Integer nhorastarea5) {
		this.nhorastarea5 = nhorastarea5;
	}

	public Integer getNhorastarea6() {
		return this.nhorastarea6;
	}

	public void setNhorastarea6(Integer nhorastarea6) {
		this.nhorastarea6 = nhorastarea6;
	}

	public Integer getNhorastarea7() {
		return this.nhorastarea7;
	}

	public void setNhorastarea7(Integer nhorastarea7) {
		this.nhorastarea7 = nhorastarea7;
	}

	public Integer getNhorastarea8() {
		return this.nhorastarea8;
	}

	public void setNhorastarea8(Integer nhorastarea8) {
		this.nhorastarea8 = nhorastarea8;
	}

	public Integer getNhorastarea9() {
		return this.nhorastarea9;
	}

	public void setNhorastarea9(Integer nhorastarea9) {
		this.nhorastarea9 = nhorastarea9;
	}

	public Integer getNhormat1mes1() {
		return this.nhormat1mes1;
	}

	public void setNhormat1mes1(Integer nhormat1mes1) {
		this.nhormat1mes1 = nhormat1mes1;
	}

	public Integer getNhormat1mes2() {
		return this.nhormat1mes2;
	}

	public void setNhormat1mes2(Integer nhormat1mes2) {
		this.nhormat1mes2 = nhormat1mes2;
	}

	public Integer getNhormat1mes3() {
		return this.nhormat1mes3;
	}

	public void setNhormat1mes3(Integer nhormat1mes3) {
		this.nhormat1mes3 = nhormat1mes3;
	}

	public Integer getNhormat1mes4() {
		return this.nhormat1mes4;
	}

	public void setNhormat1mes4(Integer nhormat1mes4) {
		this.nhormat1mes4 = nhormat1mes4;
	}

	public Integer getNhormat1mes5() {
		return this.nhormat1mes5;
	}

	public void setNhormat1mes5(Integer nhormat1mes5) {
		this.nhormat1mes5 = nhormat1mes5;
	}

	public Integer getNhormat1mes6() {
		return this.nhormat1mes6;
	}

	public void setNhormat1mes6(Integer nhormat1mes6) {
		this.nhormat1mes6 = nhormat1mes6;
	}

	public Integer getNhormat2mes1() {
		return this.nhormat2mes1;
	}

	public void setNhormat2mes1(Integer nhormat2mes1) {
		this.nhormat2mes1 = nhormat2mes1;
	}

	public Integer getNhormat2mes2() {
		return this.nhormat2mes2;
	}

	public void setNhormat2mes2(Integer nhormat2mes2) {
		this.nhormat2mes2 = nhormat2mes2;
	}

	public Integer getNhormat2mes3() {
		return this.nhormat2mes3;
	}

	public void setNhormat2mes3(Integer nhormat2mes3) {
		this.nhormat2mes3 = nhormat2mes3;
	}

	public Integer getNhormat2mes4() {
		return this.nhormat2mes4;
	}

	public void setNhormat2mes4(Integer nhormat2mes4) {
		this.nhormat2mes4 = nhormat2mes4;
	}

	public Integer getNhormat2mes5() {
		return this.nhormat2mes5;
	}

	public void setNhormat2mes5(Integer nhormat2mes5) {
		this.nhormat2mes5 = nhormat2mes5;
	}

	public Integer getNhormat2mes6() {
		return this.nhormat2mes6;
	}

	public void setNhormat2mes6(Integer nhormat2mes6) {
		this.nhormat2mes6 = nhormat2mes6;
	}

	public Integer getNhormat3mes1() {
		return this.nhormat3mes1;
	}

	public void setNhormat3mes1(Integer nhormat3mes1) {
		this.nhormat3mes1 = nhormat3mes1;
	}

	public Integer getNhormat3mes2() {
		return this.nhormat3mes2;
	}

	public void setNhormat3mes2(Integer nhormat3mes2) {
		this.nhormat3mes2 = nhormat3mes2;
	}

	public Integer getNhormat3mes3() {
		return this.nhormat3mes3;
	}

	public void setNhormat3mes3(Integer nhormat3mes3) {
		this.nhormat3mes3 = nhormat3mes3;
	}

	public Integer getNhormat3mes4() {
		return this.nhormat3mes4;
	}

	public void setNhormat3mes4(Integer nhormat3mes4) {
		this.nhormat3mes4 = nhormat3mes4;
	}

	public Integer getNhormat3mes5() {
		return this.nhormat3mes5;
	}

	public void setNhormat3mes5(Integer nhormat3mes5) {
		this.nhormat3mes5 = nhormat3mes5;
	}

	public Integer getNhormat3mes6() {
		return this.nhormat3mes6;
	}

	public void setNhormat3mes6(Integer nhormat3mes6) {
		this.nhormat3mes6 = nhormat3mes6;
	}

	public Integer getNhormat4mes1() {
		return this.nhormat4mes1;
	}

	public void setNhormat4mes1(Integer nhormat4mes1) {
		this.nhormat4mes1 = nhormat4mes1;
	}

	public Integer getNhormat4mes2() {
		return this.nhormat4mes2;
	}

	public void setNhormat4mes2(Integer nhormat4mes2) {
		this.nhormat4mes2 = nhormat4mes2;
	}

	public Integer getNhormat4mes3() {
		return this.nhormat4mes3;
	}

	public void setNhormat4mes3(Integer nhormat4mes3) {
		this.nhormat4mes3 = nhormat4mes3;
	}

	public Integer getNhormat4mes4() {
		return this.nhormat4mes4;
	}

	public void setNhormat4mes4(Integer nhormat4mes4) {
		this.nhormat4mes4 = nhormat4mes4;
	}

	public Integer getNhormat4mes5() {
		return this.nhormat4mes5;
	}

	public void setNhormat4mes5(Integer nhormat4mes5) {
		this.nhormat4mes5 = nhormat4mes5;
	}

	public Integer getNhormat4mes6() {
		return this.nhormat4mes6;
	}

	public void setNhormat4mes6(Integer nhormat4mes6) {
		this.nhormat4mes6 = nhormat4mes6;
	}

	public Integer getNhormat5mes1() {
		return this.nhormat5mes1;
	}

	public void setNhormat5mes1(Integer nhormat5mes1) {
		this.nhormat5mes1 = nhormat5mes1;
	}

	public Integer getNhormat5mes2() {
		return this.nhormat5mes2;
	}

	public void setNhormat5mes2(Integer nhormat5mes2) {
		this.nhormat5mes2 = nhormat5mes2;
	}

	public Integer getNhormat5mes3() {
		return this.nhormat5mes3;
	}

	public void setNhormat5mes3(Integer nhormat5mes3) {
		this.nhormat5mes3 = nhormat5mes3;
	}

	public Integer getNhormat5mes4() {
		return this.nhormat5mes4;
	}

	public void setNhormat5mes4(Integer nhormat5mes4) {
		this.nhormat5mes4 = nhormat5mes4;
	}

	public Integer getNhormat5mes5() {
		return this.nhormat5mes5;
	}

	public void setNhormat5mes5(Integer nhormat5mes5) {
		this.nhormat5mes5 = nhormat5mes5;
	}

	public Integer getNhormat5mes6() {
		return this.nhormat5mes6;
	}

	public void setNhormat5mes6(Integer nhormat5mes6) {
		this.nhormat5mes6 = nhormat5mes6;
	}

	public Integer getNhormat6mes1() {
		return this.nhormat6mes1;
	}

	public void setNhormat6mes1(Integer nhormat6mes1) {
		this.nhormat6mes1 = nhormat6mes1;
	}

	public Integer getNhormat6mes2() {
		return this.nhormat6mes2;
	}

	public void setNhormat6mes2(Integer nhormat6mes2) {
		this.nhormat6mes2 = nhormat6mes2;
	}

	public Integer getNhormat6mes3() {
		return this.nhormat6mes3;
	}

	public void setNhormat6mes3(Integer nhormat6mes3) {
		this.nhormat6mes3 = nhormat6mes3;
	}

	public Integer getNhormat6mes4() {
		return this.nhormat6mes4;
	}

	public void setNhormat6mes4(Integer nhormat6mes4) {
		this.nhormat6mes4 = nhormat6mes4;
	}

	public Integer getNhormat6mes5() {
		return this.nhormat6mes5;
	}

	public void setNhormat6mes5(Integer nhormat6mes5) {
		this.nhormat6mes5 = nhormat6mes5;
	}

	public Integer getNhormat6mes6() {
		return this.nhormat6mes6;
	}

	public void setNhormat6mes6(Integer nhormat6mes6) {
		this.nhormat6mes6 = nhormat6mes6;
	}

	public Integer getNhormat7mes1() {
		return this.nhormat7mes1;
	}

	public void setNhormat7mes1(Integer nhormat7mes1) {
		this.nhormat7mes1 = nhormat7mes1;
	}

	public Integer getNhormat7mes2() {
		return this.nhormat7mes2;
	}

	public void setNhormat7mes2(Integer nhormat7mes2) {
		this.nhormat7mes2 = nhormat7mes2;
	}

	public Integer getNhormat7mes3() {
		return this.nhormat7mes3;
	}

	public void setNhormat7mes3(Integer nhormat7mes3) {
		this.nhormat7mes3 = nhormat7mes3;
	}

	public Integer getNhormat7mes4() {
		return this.nhormat7mes4;
	}

	public void setNhormat7mes4(Integer nhormat7mes4) {
		this.nhormat7mes4 = nhormat7mes4;
	}

	public Integer getNhormat7mes5() {
		return this.nhormat7mes5;
	}

	public void setNhormat7mes5(Integer nhormat7mes5) {
		this.nhormat7mes5 = nhormat7mes5;
	}

	public Integer getNhormat7mes6() {
		return this.nhormat7mes6;
	}

	public void setNhormat7mes6(Integer nhormat7mes6) {
		this.nhormat7mes6 = nhormat7mes6;
	}

	public String getNomsolicont() {
		return this.nomsolicont;
	}

	public void setNomsolicont(String nomsolicont) {
		this.nomsolicont = nomsolicont;
	}

	public String getNrotermcont() {
		return this.nrotermcont;
	}

	public void setNrotermcont(String nrotermcont) {
		this.nrotermcont = nrotermcont;
	}

	public Integer getNsecCont() {
		return this.nsecCont;
	}

	public void setNsecCont(Integer nsecCont) {
		this.nsecCont = nsecCont;
	}

	public String getNuevorenov() {
		return this.nuevorenov;
	}

	public void setNuevorenov(String nuevorenov) {
		this.nuevorenov = nuevorenov;
	}

	public String getObj() {
		return this.obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getObjeto() {
		return this.objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
	}

	public String getParalelo1() {
		return this.paralelo1;
	}

	public void setParalelo1(String paralelo1) {
		this.paralelo1 = paralelo1;
	}

	public String getParalelo2() {
		return this.paralelo2;
	}

	public void setParalelo2(String paralelo2) {
		this.paralelo2 = paralelo2;
	}

	public String getParalelo3() {
		return this.paralelo3;
	}

	public void setParalelo3(String paralelo3) {
		this.paralelo3 = paralelo3;
	}

	public String getParalelo4() {
		return this.paralelo4;
	}

	public void setParalelo4(String paralelo4) {
		this.paralelo4 = paralelo4;
	}

	public String getParalelo5() {
		return this.paralelo5;
	}

	public void setParalelo5(String paralelo5) {
		this.paralelo5 = paralelo5;
	}

	public String getParalelo6() {
		return this.paralelo6;
	}

	public void setParalelo6(String paralelo6) {
		this.paralelo6 = paralelo6;
	}

	public String getParalelo7() {
		return this.paralelo7;
	}

	public void setParalelo7(String paralelo7) {
		this.paralelo7 = paralelo7;
	}

	public String getPartaplic() {
		return this.partaplic;
	}

	public void setPartaplic(String partaplic) {
		this.partaplic = partaplic;
	}

	public String getRemlet() {
		return this.remlet;
	}

	public void setRemlet(String remlet) {
		this.remlet = remlet;
	}

	public String getRemlettotal() {
		return this.remlettotal;
	}

	public void setRemlettotal(String remlettotal) {
		this.remlettotal = remlettotal;
	}

	public String getSolec() {
		return this.solec;
	}

	public void setSolec(String solec) {
		this.solec = solec;
	}

	public String getSolicfondos() {
		return this.solicfondos;
	}

	public void setSolicfondos(String solicfondos) {
		this.solicfondos = solicfondos;
	}

	public String getSolicinfpl() {
		return this.solicinfpl;
	}

	public void setSolicinfpl(String solicinfpl) {
		this.solicinfpl = solicinfpl;
	}

	public String getSolicont() {
		return this.solicont;
	}

	public void setSolicont(String solicont) {
		this.solicont = solicont;
	}

	public Integer getSupl1() {
		return this.supl1;
	}

	public void setSupl1(Integer supl1) {
		this.supl1 = supl1;
	}

	public Integer getSupl2() {
		return this.supl2;
	}

	public void setSupl2(Integer supl2) {
		this.supl2 = supl2;
	}

	public Integer getSupl3() {
		return this.supl3;
	}

	public void setSupl3(Integer supl3) {
		this.supl3 = supl3;
	}

	public Integer getSupl4() {
		return this.supl4;
	}

	public void setSupl4(Integer supl4) {
		this.supl4 = supl4;
	}

	public Integer getSupl5() {
		return this.supl5;
	}

	public void setSupl5(Integer supl5) {
		this.supl5 = supl5;
	}

	public Integer getSupl6() {
		return this.supl6;
	}

	public void setSupl6(Integer supl6) {
		this.supl6 = supl6;
	}

	public Integer getSupl7() {
		return this.supl7;
	}

	public void setSupl7(Integer supl7) {
		this.supl7 = supl7;
	}

	public String getTarea1() {
		return this.tarea1;
	}

	public void setTarea1(String tarea1) {
		this.tarea1 = tarea1;
	}

	public String getTarea10() {
		return this.tarea10;
	}

	public void setTarea10(String tarea10) {
		this.tarea10 = tarea10;
	}

	public String getTarea2() {
		return this.tarea2;
	}

	public void setTarea2(String tarea2) {
		this.tarea2 = tarea2;
	}

	public String getTarea3() {
		return this.tarea3;
	}

	public void setTarea3(String tarea3) {
		this.tarea3 = tarea3;
	}

	public String getTarea4() {
		return this.tarea4;
	}

	public void setTarea4(String tarea4) {
		this.tarea4 = tarea4;
	}

	public String getTarea5() {
		return this.tarea5;
	}

	public void setTarea5(String tarea5) {
		this.tarea5 = tarea5;
	}

	public String getTarea6() {
		return this.tarea6;
	}

	public void setTarea6(String tarea6) {
		this.tarea6 = tarea6;
	}

	public String getTarea7() {
		return this.tarea7;
	}

	public void setTarea7(String tarea7) {
		this.tarea7 = tarea7;
	}

	public String getTarea8() {
		return this.tarea8;
	}

	public void setTarea8(String tarea8) {
		this.tarea8 = tarea8;
	}

	public String getTarea9() {
		return this.tarea9;
	}

	public void setTarea9(String tarea9) {
		this.tarea9 = tarea9;
	}

	public String getTitpercont() {
		return this.titpercont;
	}

	public void setTitpercont(String titpercont) {
		this.titpercont = titpercont;
	}

	public Integer getTothorastareas() {
		return this.tothorastareas;
	}

	public void setTothorastareas(Integer tothorastareas) {
		this.tothorastareas = tothorastareas;
	}

	public Timestamp getUpfsisCont() {
		return this.upfsisCont;
	}

	public void setUpfsisCont(Timestamp upfsisCont) {
		this.upfsisCont = upfsisCont;
	}

	public String getUpusrCont() {
		return this.upusrCont;
	}

	public void setUpusrCont(String upusrCont) {
		this.upusrCont = upusrCont;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public BigDecimal getValhor() {
		return this.valhor;
	}

	public void setValhor(BigDecimal valhor) {
		this.valhor = valhor;
	}

	public BigDecimal getValhor1() {
		return this.valhor1;
	}

	public void setValhor1(BigDecimal valhor1) {
		this.valhor1 = valhor1;
	}

	public BigDecimal getValhor2() {
		return this.valhor2;
	}

	public void setValhor2(BigDecimal valhor2) {
		this.valhor2 = valhor2;
	}

	public BigDecimal getValhor3() {
		return this.valhor3;
	}

	public void setValhor3(BigDecimal valhor3) {
		this.valhor3 = valhor3;
	}

	public BigDecimal getValhor4() {
		return this.valhor4;
	}

	public void setValhor4(BigDecimal valhor4) {
		this.valhor4 = valhor4;
	}

	public BigDecimal getValhor5() {
		return this.valhor5;
	}

	public void setValhor5(BigDecimal valhor5) {
		this.valhor5 = valhor5;
	}

	public BigDecimal getValhor6() {
		return this.valhor6;
	}

	public void setValhor6(BigDecimal valhor6) {
		this.valhor6 = valhor6;
	}

	public BigDecimal getValhor7() {
		return this.valhor7;
	}

	public void setValhor7(BigDecimal valhor7) {
		this.valhor7 = valhor7;
	}

	public BigDecimal getValtot1() {
		return this.valtot1;
	}

	public void setValtot1(BigDecimal valtot1) {
		this.valtot1 = valtot1;
	}

	public BigDecimal getValtot2() {
		return this.valtot2;
	}

	public void setValtot2(BigDecimal valtot2) {
		this.valtot2 = valtot2;
	}

	public BigDecimal getValtot3() {
		return this.valtot3;
	}

	public void setValtot3(BigDecimal valtot3) {
		this.valtot3 = valtot3;
	}

	public BigDecimal getValtot4() {
		return this.valtot4;
	}

	public void setValtot4(BigDecimal valtot4) {
		this.valtot4 = valtot4;
	}

	public BigDecimal getValtot5() {
		return this.valtot5;
	}

	public void setValtot5(BigDecimal valtot5) {
		this.valtot5 = valtot5;
	}

	public BigDecimal getValtot6() {
		return this.valtot6;
	}

	public void setValtot6(BigDecimal valtot6) {
		this.valtot6 = valtot6;
	}

	public BigDecimal getValtot7() {
		return this.valtot7;
	}

	public void setValtot7(BigDecimal valtot7) {
		this.valtot7 = valtot7;
	}

	public String getViaticos() {
		return this.viaticos;
	}

	public void setViaticos(String viaticos) {
		this.viaticos = viaticos;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Tcont getTcontBean() {
		return this.tcontBean;
	}

	public void setTcontBean(Tcont tcontBean) {
		this.tcontBean = tcontBean;
	}

	public List<Controlpago> getControlpagos() {
		return this.controlpagos;
	}

	public void setControlpagos(List<Controlpago> controlpagos) {
		this.controlpagos = controlpagos;
	}

	public Controlpago addControlpago(Controlpago controlpago) {
		getControlpagos().add(controlpago);
		controlpago.setCont(this);

		return controlpago;
	}

	public Controlpago removeControlpago(Controlpago controlpago) {
		getControlpagos().remove(controlpago);
		controlpago.setCont(null);

		return controlpago;
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