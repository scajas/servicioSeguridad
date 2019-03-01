package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the emp database table.
 * 
 */
@Entity
@Table(name = "emp", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Emp.findAll", query="SELECT e FROM Emp e")
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nced;

	private String apel;

	@Column(name="apel_con")
	private String apelCon;

	@Column(name="apel_contacto")
	private String apelContacto;

	@Column(name="asis_con")
	private String asisCon;

	@Column(name="calle_principal")
	private String callePrincipal;

	@Column(name="calle_secundaria")
	private String calleSecundaria;

	private String cargook;

	private String categoria;

	@Column(name="cel_contacto")
	private String celContacto;

	@Column(name="ciudad_nac")
	private String ciudadNac;

	@Column(name="\"COD_DEDICACION\"")
	private String codDedicacion;

	@Column(name="cod_depa")
	private String codDepa;

	@Column(name="cod_depok")
	private String codDepok;

	@Column(name="cod_pindmin")
	private String codPindmin;

	@Column(name="cod_tiporelacionlab")
	private String codTiporelacionlab;

	private String codtim;

	private String direc;

	private String discapacidad;

	private String email1;

	private String email2;

	private String enfermedades;

	private String estado;

	private String etindigena;

	private String etnia;

	private String expepn;

	private String ext,acreditasenescyt;
	
	
	@Column(name="cod_dep_jefe")
	private String codDepJefe;
	

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingepn")
	private Date fecIngepn;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ingsp")
	private Date fecIngsp;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_sis")
	private Date fecSis;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Temporal(TemporalType.DATE)
	private Date fechaexpira;

	@Temporal(TemporalType.DATE)
	private Date fechapub;

	@Temporal(TemporalType.DATE)
	private Date fecharev;

	@Temporal(TemporalType.DATE)
	private Date fechaupd;

	@Temporal(TemporalType.DATE)
	private Date fnac;

	private String foto;

	private byte[] foto1;

	private String funciontipica;

	@Column(name="id_evidencia")
	private String idEvidencia;

	private String intereses;

	private String investiga;

	private String lnac;

	@Column(name="ltrab_espec")
	private String ltrabEspec;

	private String lugtim;

	private String mbienes;

	private String modalidad;

	private String nafil;

	private Integer ncargas;

	private String ncedm;

	private String nom;

	@Column(name="nom_con")
	private String nomCon;

	@Column(name="nom_contacto")
	private String nomContacto;

	@Column(name="nom_jefe")
	private String nomJefe;

	private String nrocarnetconadis;

	private String nrocasa;

	@Column(name="ocup_con")
	private String ocupCon;

	private String oficina;

	private String ordjer;

	@Column(name="otros_rel")
	private String otrosRel;

	private String paginaweb;

	private String pais;

	@Column(name="par_contacto")
	private String parContacto;

	@Column(name="parroquia_dom")
	private String parroquiaDom;

	private String path;

	private String path1;

	private String pathcv;

	private String porcendiscap;

	@Column(name="pos_con")
	private String posCon;

	private String provincia;

	@Column(name="referencia_dom")
	private String referenciaDom;

	private Integer residencia;

	private String reubica;

	private String revision;

	private String tcedm;

	private String tdoc;

	private String tdocumento;

	private String telefcel;

	private String telf;

	@Column(name="telf_contacto")
	private String telfContacto;

	private String telf1;

	private String tipo;

	private String tipodiscap;

	private String tipsan;

	private String ubicacion;

	@Temporal(TemporalType.DATE)
	@Column(name="upfsis_emp")
	private Date upfsisEmp;

	@Column(name="upusr_emp")
	private String upusrEmp;

	private String url1;

	private String url2;

	private String url3;

	private String url4;

	private String usr;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String visa;

	private String voto;
	
	
	private String recategoriza;
	private Date fecharecate;
	private String revaloriza;
	private Date fecharevalo;

	private String categoriarevaloriza;
	private String categoriarecategoriza;
	 private String estadorevaloriza ;
	private String estadorecategoriza; 
	
	private String cambiodept;
	private Integer idusuariolog;
	private Date fechacambiodept;
	
	
	private String cambiorel ;
	private Integer idusuariocambiorel ;
	private Date fechacambiorel;
	private String cambioest;
	private String cambiotipo;
	private String cambiocorreo;

	//bi-directional many-to-one association to Anesc
	@OneToMany(mappedBy="emp")
	private List<Anesc> anescs;

	//bi-directional many-to-one association to Aper
	@OneToMany(mappedBy="emp")
	private List<Aper> apers;

	//bi-directional many-to-one association to Cadic
	@OneToMany(mappedBy="emp")
	private List<Cadic> cadics;

	//bi-directional many-to-one association to Comfincont
	@OneToMany(mappedBy="emp")
	private List<Comfincont> comfinconts;

	

	//bi-directional many-to-one association to DeclarJur
	@OneToMany(mappedBy="emp")
	private List<DeclarJur> declarJurs;

	//bi-directional many-to-one association to Deteventocapac
	@OneToMany(mappedBy="emp")
	private List<Deteventocapac> deteventocapacs;

	//bi-directional many-to-one association to Clasemp
	@ManyToOne
	@JoinColumn(name="cod_clase")
	private Clasemp clasemp;

	//bi-directional many-to-one association to Dep
	@ManyToOne
	@JoinColumn(name="cod_dep")
	private Dep dep;

	//bi-directional many-to-one association to Ecivil
	@ManyToOne
	@JoinColumn(name="cod_ecivil")
	private Ecivil ecivil;

	//bi-directional many-to-one association to Estemp
	@ManyToOne
	@JoinColumn(name="cod_est")
	private Estemp estemp;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="cod_sexo")
	private Genero genero;

	//bi-directional many-to-one association to Nac
	@ManyToOne
	@JoinColumn(name="cod_nac")
	private Nac nac;

	//bi-directional many-to-one association to Prov
	@ManyToOne
	@JoinColumn(name="cod_prov")
	private Prov prov;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="emp")
	private List<Equipo> equipos;

	//bi-directional many-to-one association to Estudio
	@OneToMany(mappedBy="emp")
	private List<Estudio> estudios;

	//bi-directional many-to-one association to Evalde
	@OneToMany(mappedBy="emp")
	private List<Evalde> evaldes;

	//bi-directional many-to-one association to Familiare
	@OneToMany(mappedBy="emp")
	private List<Familiare> familiares;

	//bi-directional many-to-one association to Funcione
	@OneToMany(mappedBy="emp")
	private List<Funcione> funciones;

	//bi-directional many-to-one association to Hijo
	@OneToMany(mappedBy="emp")
	private List<Hijo> hijos;

	//bi-directional many-to-one association to PubliPart
	@OneToMany(mappedBy="emp")
	private List<PubliPart> publiParts;

	//bi-directional many-to-one association to SolicitudEquipo
	@OneToMany(mappedBy="emp")
	private List<SolicitudEquipo> solicitudEquipos;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="emp")
	private List<Vehiculo> vehiculos;
	
	//bi-directional many-to-one association to Vaca
	@OneToMany(mappedBy="emp")
	private List<Vaca> vacas;

	

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

	public String getApelContacto() {
		return this.apelContacto;
	}

	public void setApelContacto(String apelContacto) {
		this.apelContacto = apelContacto;
	}

	public String getAsisCon() {
		return this.asisCon;
	}

	public void setAsisCon(String asisCon) {
		this.asisCon = asisCon;
	}

	public String getCallePrincipal() {
		return this.callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public String getCalleSecundaria() {
		return this.calleSecundaria;
	}

	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}

	public String getCargook() {
		return this.cargook;
	}

	public void setCargook(String cargook) {
		this.cargook = cargook;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCelContacto() {
		return this.celContacto;
	}

	public void setCelContacto(String celContacto) {
		this.celContacto = celContacto;
	}

	public String getCiudadNac() {
		return this.ciudadNac;
	}

	public void setCiudadNac(String ciudadNac) {
		this.ciudadNac = ciudadNac;
	}

	public String getCodDedicacion() {
		return this.codDedicacion;
	}

	public void setCodDedicacion(String codDedicacion) {
		this.codDedicacion = codDedicacion;
	}

	public String getCodDepa() {
		return this.codDepa;
	}

	public void setCodDepa(String codDepa) {
		this.codDepa = codDepa;
	}

	public String getCodDepok() {
		return this.codDepok;
	}

	public void setCodDepok(String codDepok) {
		this.codDepok = codDepok;
	}

	public String getCodPindmin() {
		return this.codPindmin;
	}

	public void setCodPindmin(String codPindmin) {
		this.codPindmin = codPindmin;
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

	public String getDiscapacidad() {
		return this.discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
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

	public String getEnfermedades() {
		return this.enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEtindigena() {
		return this.etindigena;
	}

	public void setEtindigena(String etindigena) {
		this.etindigena = etindigena;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getExpepn() {
		return this.expepn;
	}

	public void setExpepn(String expepn) {
		this.expepn = expepn;
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

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public Date getFechaexpira() {
		return this.fechaexpira;
	}

	public void setFechaexpira(Date fechaexpira) {
		this.fechaexpira = fechaexpira;
	}

	public Date getFechapub() {
		return this.fechapub;
	}

	public void setFechapub(Date fechapub) {
		this.fechapub = fechapub;
	}

	public Date getFecharev() {
		return this.fecharev;
	}

	public void setFecharev(Date fecharev) {
		this.fecharev = fecharev;
	}

	public Date getFechaupd() {
		return this.fechaupd;
	}

	public void setFechaupd(Date fechaupd) {
		this.fechaupd = fechaupd;
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

	public byte[] getFoto1() {
		return this.foto1;
	}

	public void setFoto1(byte[] foto1) {
		this.foto1 = foto1;
	}

	public String getFunciontipica() {
		return this.funciontipica;
	}

	public void setFunciontipica(String funciontipica) {
		this.funciontipica = funciontipica;
	}

	public String getIdEvidencia() {
		return this.idEvidencia;
	}

	public void setIdEvidencia(String idEvidencia) {
		this.idEvidencia = idEvidencia;
	}

	public String getIntereses() {
		return this.intereses;
	}

	public void setIntereses(String intereses) {
		this.intereses = intereses;
	}

	public String getInvestiga() {
		return this.investiga;
	}

	public void setInvestiga(String investiga) {
		this.investiga = investiga;
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

	public String getMbienes() {
		return this.mbienes;
	}

	public void setMbienes(String mbienes) {
		this.mbienes = mbienes;
	}

	public String getModalidad() {
		return this.modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
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

	public String getNomContacto() {
		return this.nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	public String getNomJefe() {
		return this.nomJefe;
	}

	public void setNomJefe(String nomJefe) {
		this.nomJefe = nomJefe;
	}

	public String getNrocarnetconadis() {
		return this.nrocarnetconadis;
	}

	public void setNrocarnetconadis(String nrocarnetconadis) {
		this.nrocarnetconadis = nrocarnetconadis;
	}

	public String getNrocasa() {
		return this.nrocasa;
	}

	public void setNrocasa(String nrocasa) {
		this.nrocasa = nrocasa;
	}

	public String getOcupCon() {
		return this.ocupCon;
	}

	public void setOcupCon(String ocupCon) {
		this.ocupCon = ocupCon;
	}

	public String getOficina() {
		return this.oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getOrdjer() {
		return this.ordjer;
	}

	public void setOrdjer(String ordjer) {
		this.ordjer = ordjer;
	}

	public String getOtrosRel() {
		return this.otrosRel;
	}

	public void setOtrosRel(String otrosRel) {
		this.otrosRel = otrosRel;
	}

	public String getPaginaweb() {
		return this.paginaweb;
	}

	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getParContacto() {
		return this.parContacto;
	}

	public void setParContacto(String parContacto) {
		this.parContacto = parContacto;
	}

	public String getParroquiaDom() {
		return this.parroquiaDom;
	}

	public void setParroquiaDom(String parroquiaDom) {
		this.parroquiaDom = parroquiaDom;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath1() {
		return this.path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}

	public String getPathcv() {
		return this.pathcv;
	}

	public void setPathcv(String pathcv) {
		this.pathcv = pathcv;
	}

	public String getPorcendiscap() {
		return this.porcendiscap;
	}

	public void setPorcendiscap(String porcendiscap) {
		this.porcendiscap = porcendiscap;
	}

	public String getPosCon() {
		return this.posCon;
	}

	public void setPosCon(String posCon) {
		this.posCon = posCon;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getReferenciaDom() {
		return this.referenciaDom;
	}

	public void setReferenciaDom(String referenciaDom) {
		this.referenciaDom = referenciaDom;
	}

	public Integer getResidencia() {
		return this.residencia;
	}

	public void setResidencia(Integer residencia) {
		this.residencia = residencia;
	}

	public String getReubica() {
		return this.reubica;
	}

	public void setReubica(String reubica) {
		this.reubica = reubica;
	}

	public String getRevision() {
		return this.revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getTcedm() {
		return this.tcedm;
	}

	public void setTcedm(String tcedm) {
		this.tcedm = tcedm;
	}

	public String getTdoc() {
		return this.tdoc;
	}

	public void setTdoc(String tdoc) {
		this.tdoc = tdoc;
	}

	public String getTdocumento() {
		return this.tdocumento;
	}

	public void setTdocumento(String tdocumento) {
		this.tdocumento = tdocumento;
	}

	public String getTelefcel() {
		return this.telefcel;
	}

	public void setTelefcel(String telefcel) {
		this.telefcel = telefcel;
	}

	public String getTelf() {
		return this.telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getTelfContacto() {
		return this.telfContacto;
	}

	public void setTelfContacto(String telfContacto) {
		this.telfContacto = telfContacto;
	}

	public String getTelf1() {
		return this.telf1;
	}

	public void setTelf1(String telf1) {
		this.telf1 = telf1;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipodiscap() {
		return this.tipodiscap;
	}

	public void setTipodiscap(String tipodiscap) {
		this.tipodiscap = tipodiscap;
	}

	public String getTipsan() {
		return this.tipsan;
	}

	public void setTipsan(String tipsan) {
		this.tipsan = tipsan;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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

	public String getUrl1() {
		return this.url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return this.url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}

	public String getUrl3() {
		return this.url3;
	}

	public void setUrl3(String url3) {
		this.url3 = url3;
	}

	public String getUrl4() {
		return this.url4;
	}

	public void setUrl4(String url4) {
		this.url4 = url4;
	}

	public String getUsr() {
		return this.usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public String getVisa() {
		return this.visa;
	}

	public void setVisa(String visa) {
		this.visa = visa;
	}

	public String getVoto() {
		return this.voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public List<Anesc> getAnescs() {
		return this.anescs;
	}

	public void setAnescs(List<Anesc> anescs) {
		this.anescs = anescs;
	}

	public Anesc addAnesc(Anesc anesc) {
		getAnescs().add(anesc);
		anesc.setEmp(this);

		return anesc;
	}

	public Anesc removeAnesc(Anesc anesc) {
		getAnescs().remove(anesc);
		anesc.setEmp(null);

		return anesc;
	}

	public List<Aper> getApers() {
		return this.apers;
	}

	public void setApers(List<Aper> apers) {
		this.apers = apers;
	}

	public Aper addAper(Aper aper) {
		getApers().add(aper);
		aper.setEmp(this);

		return aper;
	}

	public Aper removeAper(Aper aper) {
		getApers().remove(aper);
		aper.setEmp(null);

		return aper;
	}

	public List<Cadic> getCadics() {
		return this.cadics;
	}

	public void setCadics(List<Cadic> cadics) {
		this.cadics = cadics;
	}

	public Cadic addCadic(Cadic cadic) {
		getCadics().add(cadic);
		cadic.setEmp(this);

		return cadic;
	}

	public Cadic removeCadic(Cadic cadic) {
		getCadics().remove(cadic);
		cadic.setEmp(null);

		return cadic;
	}

	public List<Comfincont> getComfinconts() {
		return this.comfinconts;
	}

	public void setComfinconts(List<Comfincont> comfinconts) {
		this.comfinconts = comfinconts;
	}

	public Comfincont addComfincont(Comfincont comfincont) {
		getComfinconts().add(comfincont);
		comfincont.setEmp(this);

		return comfincont;
	}

	public Comfincont removeComfincont(Comfincont comfincont) {
		getComfinconts().remove(comfincont);
		comfincont.setEmp(null);

		return comfincont;
	}

	

	public List<DeclarJur> getDeclarJurs() {
		return this.declarJurs;
	}

	public void setDeclarJurs(List<DeclarJur> declarJurs) {
		this.declarJurs = declarJurs;
	}

	public DeclarJur addDeclarJur(DeclarJur declarJur) {
		getDeclarJurs().add(declarJur);
		declarJur.setEmp(this);

		return declarJur;
	}

	public DeclarJur removeDeclarJur(DeclarJur declarJur) {
		getDeclarJurs().remove(declarJur);
		declarJur.setEmp(null);

		return declarJur;
	}

	public List<Deteventocapac> getDeteventocapacs() {
		return this.deteventocapacs;
	}

	public void setDeteventocapacs(List<Deteventocapac> deteventocapacs) {
		this.deteventocapacs = deteventocapacs;
	}

	public Deteventocapac addDeteventocapac(Deteventocapac deteventocapac) {
		getDeteventocapacs().add(deteventocapac);
		deteventocapac.setEmp(this);

		return deteventocapac;
	}

	public Deteventocapac removeDeteventocapac(Deteventocapac deteventocapac) {
		getDeteventocapacs().remove(deteventocapac);
		deteventocapac.setEmp(null);

		return deteventocapac;
	}

	public Clasemp getClasemp() {
		return this.clasemp;
	}

	public void setClasemp(Clasemp clasemp) {
		this.clasemp = clasemp;
	}

	public Dep getDep() {
		return this.dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public Ecivil getEcivil() {
		return this.ecivil;
	}

	public void setEcivil(Ecivil ecivil) {
		this.ecivil = ecivil;
	}

	public Estemp getEstemp() {
		return this.estemp;
	}

	public void setEstemp(Estemp estemp) {
		this.estemp = estemp;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Nac getNac() {
		return this.nac;
	}

	public void setNac(Nac nac) {
		this.nac = nac;
	}

	public Prov getProv() {
		return this.prov;
	}

	public void setProv(Prov prov) {
		this.prov = prov;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setEmp(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setEmp(null);

		return equipo;
	}

	public List<Estudio> getEstudios() {
		return this.estudios;
	}

	public void setEstudios(List<Estudio> estudios) {
		this.estudios = estudios;
	}

	public Estudio addEstudio(Estudio estudio) {
		getEstudios().add(estudio);
		estudio.setEmp(this);

		return estudio;
	}

	public Estudio removeEstudio(Estudio estudio) {
		getEstudios().remove(estudio);
		estudio.setEmp(null);

		return estudio;
	}

	public List<Evalde> getEvaldes() {
		return this.evaldes;
	}

	public void setEvaldes(List<Evalde> evaldes) {
		this.evaldes = evaldes;
	}

	public Evalde addEvalde(Evalde evalde) {
		getEvaldes().add(evalde);
		evalde.setEmp(this);

		return evalde;
	}

	public Evalde removeEvalde(Evalde evalde) {
		getEvaldes().remove(evalde);
		evalde.setEmp(null);

		return evalde;
	}

	public List<Familiare> getFamiliares() {
		return this.familiares;
	}

	public void setFamiliares(List<Familiare> familiares) {
		this.familiares = familiares;
	}

	public Familiare addFamiliare(Familiare familiare) {
		getFamiliares().add(familiare);
		familiare.setEmp(this);

		return familiare;
	}

	public Familiare removeFamiliare(Familiare familiare) {
		getFamiliares().remove(familiare);
		familiare.setEmp(null);

		return familiare;
	}

	public List<Funcione> getFunciones() {
		return this.funciones;
	}

	public void setFunciones(List<Funcione> funciones) {
		this.funciones = funciones;
	}

	public Funcione addFuncione(Funcione funcione) {
		getFunciones().add(funcione);
		funcione.setEmp(this);

		return funcione;
	}

	public Funcione removeFuncione(Funcione funcione) {
		getFunciones().remove(funcione);
		funcione.setEmp(null);

		return funcione;
	}

	public List<Hijo> getHijos() {
		return this.hijos;
	}

	public void setHijos(List<Hijo> hijos) {
		this.hijos = hijos;
	}

	public Hijo addHijo(Hijo hijo) {
		getHijos().add(hijo);
		hijo.setEmp(this);

		return hijo;
	}

	public Hijo removeHijo(Hijo hijo) {
		getHijos().remove(hijo);
		hijo.setEmp(null);

		return hijo;
	}

	public List<PubliPart> getPubliParts() {
		return this.publiParts;
	}

	public void setPubliParts(List<PubliPart> publiParts) {
		this.publiParts = publiParts;
	}

	public PubliPart addPubliPart(PubliPart publiPart) {
		getPubliParts().add(publiPart);
		publiPart.setEmp(this);

		return publiPart;
	}

	public PubliPart removePubliPart(PubliPart publiPart) {
		getPubliParts().remove(publiPart);
		publiPart.setEmp(null);

		return publiPart;
	}

	public List<SolicitudEquipo> getSolicitudEquipos() {
		return this.solicitudEquipos;
	}

	public void setSolicitudEquipos(List<SolicitudEquipo> solicitudEquipos) {
		this.solicitudEquipos = solicitudEquipos;
	}

	public SolicitudEquipo addSolicitudEquipo(SolicitudEquipo solicitudEquipo) {
		getSolicitudEquipos().add(solicitudEquipo);
		solicitudEquipo.setEmp(this);

		return solicitudEquipo;
	}

	public SolicitudEquipo removeSolicitudEquipo(SolicitudEquipo solicitudEquipo) {
		getSolicitudEquipos().remove(solicitudEquipo);
		solicitudEquipo.setEmp(null);

		return solicitudEquipo;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setEmp(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setEmp(null);

		return vehiculo;
	}

	public String getRecategoriza() {
		return recategoriza;
	}

	public void setRecategoriza(String recategoriza) {
		this.recategoriza = recategoriza;
	}

	public Date getFecharecate() {
		return fecharecate;
	}

	public void setFecharecate(Date fecharecate) {
		this.fecharecate = fecharecate;
	}

	public String getRevaloriza() {
		return revaloriza;
	}

	public void setRevaloriza(String revaloriza) {
		this.revaloriza = revaloriza;
	}

	public Date getFecharevalo() {
		return fecharevalo;
	}

	public void setFecharevalo(Date fecharevalo) {
		this.fecharevalo = fecharevalo;
	}

	public String getCategoriarevaloriza() {
		return categoriarevaloriza;
	}

	public void setCategoriarevaloriza(String categoriarevaloriza) {
		this.categoriarevaloriza = categoriarevaloriza;
	}

	public String getCategoriarecategoriza() {
		return categoriarecategoriza;
	}

	public void setCategoriarecategoriza(String categoriarecategoriza) {
		this.categoriarecategoriza = categoriarecategoriza;
	}

	public String getEstadorevaloriza() {
		return estadorevaloriza;
	}

	public void setEstadorevaloriza(String estadorevaloriza) {
		this.estadorevaloriza = estadorevaloriza;
	}

	public String getEstadorecategoriza() {
		return estadorecategoriza;
	}

	public void setEstadorecategoriza(String estadorecategoriza) {
		this.estadorecategoriza = estadorecategoriza;
	}

	public String getCambiodept() {
		return cambiodept;
	}

	public void setCambiodept(String cambiodept) {
		this.cambiodept = cambiodept;
	}

	public Integer getIdusuariolog() {
		return idusuariolog;
	}

	public void setIdusuariolog(Integer idusuariolog) {
		this.idusuariolog = idusuariolog;
	}

	public Date getFechacambiodept() {
		return fechacambiodept;
	}

	public void setFechacambiodept(Date fechacambiodept) {
		this.fechacambiodept = fechacambiodept;
	}

	public String getCambiorel() {
		return cambiorel;
	}

	public void setCambiorel(String cambiorel) {
		this.cambiorel = cambiorel;
	}

	public Integer getIdusuariocambiorel() {
		return idusuariocambiorel;
	}

	public void setIdusuariocambiorel(Integer idusuariocambiorel) {
		this.idusuariocambiorel = idusuariocambiorel;
	}

	public Date getFechacambiorel() {
		return fechacambiorel;
	}

	public void setFechacambiorel(Date fechacambiorel) {
		this.fechacambiorel = fechacambiorel;
	}

	public String getCambioest() {
		return cambioest;
	}

	public void setCambioest(String cambioest) {
		this.cambioest = cambioest;
	}

	public String getCambiotipo() {
		return cambiotipo;
	}

	public void setCambiotipo(String cambiotipo) {
		this.cambiotipo = cambiotipo;
	}

	public String getCambiocorreo() {
		return cambiocorreo;
	}

	public void setCambiocorreo(String cambiocorreo) {
		this.cambiocorreo = cambiocorreo;
	}

	/**
	 * @return the codDepJefe
	 */
	public String getCodDepJefe() {
		return codDepJefe;
	}

	/**
	 * @param codDepJefe the codDepJefe to set
	 */
	public void setCodDepJefe(String codDepJefe) {
		this.codDepJefe = codDepJefe;
	}

	public String getAcreditasenescyt() {
		return acreditasenescyt;
	}

	public void setAcreditasenescyt(String acreditasenescyt) {
		this.acreditasenescyt = acreditasenescyt;
	}
	
	public List<Vaca> getVacas() {
		return vacas;
	}

	public void setVacas(List<Vaca> vacas) {
		this.vacas = vacas;
	}

}