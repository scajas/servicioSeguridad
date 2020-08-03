package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the emp database table.
 * 
 */
@Entity(name= "EmpGD")
@NamedQuery(name="EmpDG.findAll", query="SELECT e FROM Emp e")
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nced;

	private String apel;

	@Column(name="apel_con")
	private String apelCon;

	@Column(name="asis_con")
	private String asisCon;

	@Column(name="ciudad_nac")
	private String ciudadNac;

	@Column(name="cod_depa")
	private String codDepa;

	@Column(name="cod_tiporelacionlab")
	private String codTiporelacionlab;

	private String codtim;

	private String direc;

	private String email1;

	private String email2;

	private String ext;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingepn")
	private Date fecIngepn;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingsp")
	private Date fecIngsp;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_sis")
	private Date fecSis;

	@Temporal(TemporalType.DATE)
	private Date fnac;

	private String foto;

	private String funciontipica;

	@Column(name="id_categ")
	private String idCateg;

	@Column(name="id_dedic")
	private String idDedic;

	@Column(name="id_edificio")
	private String idEdificio;

	private String lnac;

	@Column(name="ltrab_espec")
	private String ltrabEspec;

	private String lugtim;

	private String mbienes2;

	private String nafil;

	private Integer ncargas;

	private String ncedm;

	private String nom;

	@Column(name="nom_con")
	private String nomCon;

	@Column(name="nom_jefe")
	private String nomJefe;

	@Column(name="ocup_con")
	private String ocupCon;

	private String ordjer;

	private String tcedm;

	private String tdoc2;

	private String telf;

	private String telf1;

	private String tipsan2;

	@Temporal(TemporalType.DATE)
	@Column(name="upfsis_emp")
	private Date upfsisEmp;

	@Column(name="upusr_emp")
	private String upusrEmp;

	private String usr;

	public Emp() {
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getApel() {
		return this.apel;
	}

	public void setApel(String apel) {
		this.apel = apel;
	}

	public String getApelCon() {
		return this.apelCon;
	}

	public void setApelCon(String apelCon) {
		this.apelCon = apelCon;
	}

	public String getAsisCon() {
		return this.asisCon;
	}

	public void setAsisCon(String asisCon) {
		this.asisCon = asisCon;
	}

	public String getCiudadNac() {
		return this.ciudadNac;
	}

	public void setCiudadNac(String ciudadNac) {
		this.ciudadNac = ciudadNac;
	}

	public String getCodDepa() {
		return this.codDepa;
	}

	public void setCodDepa(String codDepa) {
		this.codDepa = codDepa;
	}

	public String getCodTiporelacionlab() {
		return this.codTiporelacionlab;
	}

	public void setCodTiporelacionlab(String codTiporelacionlab) {
		this.codTiporelacionlab = codTiporelacionlab;
	}

	public String getCodtim() {
		return this.codtim;
	}

	public void setCodtim(String codtim) {
		this.codtim = codtim;
	}

	public String getDirec() {
		return this.direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getExt() {
		return this.ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Date getFecIngepn() {
		return this.fecIngepn;
	}

	public void setFecIngepn(Date fecIngepn) {
		this.fecIngepn = fecIngepn;
	}

	public Date getFecIngsp() {
		return this.fecIngsp;
	}

	public void setFecIngsp(Date fecIngsp) {
		this.fecIngsp = fecIngsp;
	}

	public Date getFecSis() {
		return this.fecSis;
	}

	public void setFecSis(Date fecSis) {
		this.fecSis = fecSis;
	}

	public Date getFnac() {
		return this.fnac;
	}

	public void setFnac(Date fnac) {
		this.fnac = fnac;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFunciontipica() {
		return this.funciontipica;
	}

	public void setFunciontipica(String funciontipica) {
		this.funciontipica = funciontipica;
	}

	public String getIdCateg() {
		return this.idCateg;
	}

	public void setIdCateg(String idCateg) {
		this.idCateg = idCateg;
	}

	public String getIdDedic() {
		return this.idDedic;
	}

	public void setIdDedic(String idDedic) {
		this.idDedic = idDedic;
	}

	public String getIdEdificio() {
		return this.idEdificio;
	}

	public void setIdEdificio(String idEdificio) {
		this.idEdificio = idEdificio;
	}

	public String getLnac() {
		return this.lnac;
	}

	public void setLnac(String lnac) {
		this.lnac = lnac;
	}

	public String getLtrabEspec() {
		return this.ltrabEspec;
	}

	public void setLtrabEspec(String ltrabEspec) {
		this.ltrabEspec = ltrabEspec;
	}

	public String getLugtim() {
		return this.lugtim;
	}

	public void setLugtim(String lugtim) {
		this.lugtim = lugtim;
	}

	public String getMbienes2() {
		return this.mbienes2;
	}

	public void setMbienes2(String mbienes2) {
		this.mbienes2 = mbienes2;
	}

	public String getNafil() {
		return this.nafil;
	}

	public void setNafil(String nafil) {
		this.nafil = nafil;
	}

	public Integer getNcargas() {
		return this.ncargas;
	}

	public void setNcargas(Integer ncargas) {
		this.ncargas = ncargas;
	}

	public String getNcedm() {
		return this.ncedm;
	}

	public void setNcedm(String ncedm) {
		this.ncedm = ncedm;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomCon() {
		return this.nomCon;
	}

	public void setNomCon(String nomCon) {
		this.nomCon = nomCon;
	}

	public String getNomJefe() {
		return this.nomJefe;
	}

	public void setNomJefe(String nomJefe) {
		this.nomJefe = nomJefe;
	}

	public String getOcupCon() {
		return this.ocupCon;
	}

	public void setOcupCon(String ocupCon) {
		this.ocupCon = ocupCon;
	}

	public String getOrdjer() {
		return this.ordjer;
	}

	public void setOrdjer(String ordjer) {
		this.ordjer = ordjer;
	}

	public String getTcedm() {
		return this.tcedm;
	}

	public void setTcedm(String tcedm) {
		this.tcedm = tcedm;
	}

	public String getTdoc2() {
		return this.tdoc2;
	}

	public void setTdoc2(String tdoc2) {
		this.tdoc2 = tdoc2;
	}

	public String getTelf() {
		return this.telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getTelf1() {
		return this.telf1;
	}

	public void setTelf1(String telf1) {
		this.telf1 = telf1;
	}

	public String getTipsan2() {
		return this.tipsan2;
	}

	public void setTipsan2(String tipsan2) {
		this.tipsan2 = tipsan2;
	}

	public Date getUpfsisEmp() {
		return this.upfsisEmp;
	}

	public void setUpfsisEmp(Date upfsisEmp) {
		this.upfsisEmp = upfsisEmp;
	}

	public String getUpusrEmp() {
		return this.upusrEmp;
	}

	public void setUpusrEmp(String upusrEmp) {
		this.upusrEmp = upusrEmp;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

}