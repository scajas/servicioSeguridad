package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the estudios database table.
 * 
 */
@Entity
@Table(name = "estudios", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Estudio.findAll", query="SELECT e FROM Estudio e")
public class Estudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idestudios;

	private Integer aniofinestudios;

	@Column(name="anios_est")
	private Integer aniosEst;

	@Column(name="area_c")
	private String areaC;

	@Column(name="cod_nivelestudios")
	private Integer codNivelestudios;

	@Column(name="cod_nivelestudiosuperior")
	private Integer codNivelestudiosuperior;

	@Column(name="cod_tipotitulocuartonivel")
	private Integer codTipotitulocuartonivel;

	@Column(name="eg_tit")
	private String egTit;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_regse")
	private Date fecRegse;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_t")
	private Date fechaT;

	@Temporal(TemporalType.DATE)
	private Date fsisactestudios;

	@Temporal(TemporalType.DATE)
	private Date fsisingestudios;

	private String institucion;

	private String lugarestudios;

	private String nivelestudios;

	private String nivelestudiosuperior;

	@Column(name="nom_pais")
	private String nomPais;

	private String nombres;

	private String obsr;

	private String path;

	private String periodos;

	@Column(name="reg_senescyt")
	private String regSenescyt;

	private String tipotitulocuartonivel;

	private String titulo;

	private String usractestudios;

	private String usringestudios;

	@Column(name="usuario_log")
	private String usuarioLog;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	public Estudio() {
	}

	public Integer getIdestudios() {
		return this.idestudios;
	}

	public void setIdestudios(Integer idestudios) {
		this.idestudios = idestudios;
	}

	public Integer getAniofinestudios() {
		return this.aniofinestudios;
	}

	public void setAniofinestudios(Integer aniofinestudios) {
		this.aniofinestudios = aniofinestudios;
	}

	public Integer getAniosEst() {
		return this.aniosEst;
	}

	public void setAniosEst(Integer aniosEst) {
		this.aniosEst = aniosEst;
	}

	public String getAreaC() {
		return this.areaC;
	}

	public void setAreaC(String areaC) {
		this.areaC = areaC;
	}

	public Integer getCodNivelestudios() {
		return this.codNivelestudios;
	}

	public void setCodNivelestudios(Integer codNivelestudios) {
		this.codNivelestudios = codNivelestudios;
	}

	public Integer getCodNivelestudiosuperior() {
		return this.codNivelestudiosuperior;
	}

	public void setCodNivelestudiosuperior(Integer codNivelestudiosuperior) {
		this.codNivelestudiosuperior = codNivelestudiosuperior;
	}

	public Integer getCodTipotitulocuartonivel() {
		return this.codTipotitulocuartonivel;
	}

	public void setCodTipotitulocuartonivel(Integer codTipotitulocuartonivel) {
		this.codTipotitulocuartonivel = codTipotitulocuartonivel;
	}

	public String getEgTit() {
		return this.egTit;
	}

	public void setEgTit(String egTit) {
		this.egTit = egTit;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecRegse() {
		return this.fecRegse;
	}

	public void setFecRegse(Date fecRegse) {
		this.fecRegse = fecRegse;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public Date getFechaT() {
		return this.fechaT;
	}

	public void setFechaT(Date fechaT) {
		this.fechaT = fechaT;
	}

	public Date getFsisactestudios() {
		return this.fsisactestudios;
	}

	public void setFsisactestudios(Date fsisactestudios) {
		this.fsisactestudios = fsisactestudios;
	}

	public Date getFsisingestudios() {
		return this.fsisingestudios;
	}

	public void setFsisingestudios(Date fsisingestudios) {
		this.fsisingestudios = fsisingestudios;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getLugarestudios() {
		return this.lugarestudios;
	}

	public void setLugarestudios(String lugarestudios) {
		this.lugarestudios = lugarestudios;
	}

	public String getNivelestudios() {
		return this.nivelestudios;
	}

	public void setNivelestudios(String nivelestudios) {
		this.nivelestudios = nivelestudios;
	}

	public String getNivelestudiosuperior() {
		return this.nivelestudiosuperior;
	}

	public void setNivelestudiosuperior(String nivelestudiosuperior) {
		this.nivelestudiosuperior = nivelestudiosuperior;
	}

	public String getNomPais() {
		return this.nomPais;
	}

	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getObsr() {
		return this.obsr;
	}

	public void setObsr(String obsr) {
		this.obsr = obsr;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPeriodos() {
		return this.periodos;
	}

	public void setPeriodos(String periodos) {
		this.periodos = periodos;
	}

	public String getRegSenescyt() {
		return this.regSenescyt;
	}

	public void setRegSenescyt(String regSenescyt) {
		this.regSenescyt = regSenescyt;
	}

	public String getTipotitulocuartonivel() {
		return this.tipotitulocuartonivel;
	}

	public void setTipotitulocuartonivel(String tipotitulocuartonivel) {
		this.tipotitulocuartonivel = tipotitulocuartonivel;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUsractestudios() {
		return this.usractestudios;
	}

	public void setUsractestudios(String usractestudios) {
		this.usractestudios = usractestudios;
	}

	public String getUsringestudios() {
		return this.usringestudios;
	}

	public void setUsringestudios(String usringestudios) {
		this.usringestudios = usringestudios;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}