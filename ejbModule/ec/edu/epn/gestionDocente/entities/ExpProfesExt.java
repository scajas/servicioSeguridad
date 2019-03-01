package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the exp_profes_ext database table.
 * 
 */
@Entity
@Table(name = "exp_profes_ext", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "ExpProfesExt.findAll", query = "SELECT e FROM ExpProfesExt e order by e.fechaInicioTrabajo ")
public class ExpProfesExt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EXPERIENCIA_IDPUBLIC_GENERATOR", sequenceName = "exp_profes_ext_idepe_seq", allocationSize = 1, catalog = "bddcorpepn", schema = "`GestionDocente`")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPERIENCIA_IDPUBLIC_GENERATOR")
	@Column(name = "id_exp_prof")
	private Integer idExpProf;

	private Integer anio;

	@Column(name = "area_trabajo")
	private String areaTrabajo;

	@Column(name = "cargo_trabajo")
	private String cargoTrabajo;

	@Column(name = "descripcion_exp")
	private String descripcionExp;

	private String docente;

	private String epn;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_trabajo")
	private Date fechaFinTrabajo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_trabajo")
	private Date fechaInicioTrabajo;

	@Column(name = "fecha_sis")
	private Timestamp fechaSis;

	@Column(name = "lugar_trabajo")
	private String lugarTrabajo;

	private String nced;

	private String path;

	private String salida;

	@Column(name = "tiempo_meses")
	private Integer tiempoMeses;

	@Column(name = "usuario_log")
	private String usuarioLog;

	private String valida;

	private String validacion;

	private String validarevalorazion;
	private Date fechavalidarevaloriacion;
	private String validarecategorza;
	private Date fechavalidarecategoriza;
	private String tipo;

	public ExpProfesExt() {
	}

	public Integer getIdExpProf() {
		return this.idExpProf;
	}

	public void setIdExpProf(Integer idExpProf) {
		this.idExpProf = idExpProf;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getAreaTrabajo() {
		return this.areaTrabajo;
	}

	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}

	public String getCargoTrabajo() {
		return this.cargoTrabajo;
	}

	public void setCargoTrabajo(String cargoTrabajo) {
		this.cargoTrabajo = cargoTrabajo;
	}

	public String getDescripcionExp() {
		return this.descripcionExp;
	}

	public void setDescripcionExp(String descripcionExp) {
		this.descripcionExp = descripcionExp;
	}

	public String getDocente() {
		return this.docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getEpn() {
		return this.epn;
	}

	public void setEpn(String epn) {
		this.epn = epn;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaFinTrabajo() {
		return this.fechaFinTrabajo;
	}

	public void setFechaFinTrabajo(Date fechaFinTrabajo) {
		this.fechaFinTrabajo = fechaFinTrabajo;
	}

	public Date getFechaInicioTrabajo() {
		return this.fechaInicioTrabajo;
	}

	public void setFechaInicioTrabajo(Date fechaInicioTrabajo) {
		this.fechaInicioTrabajo = fechaInicioTrabajo;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	public String getLugarTrabajo() {
		return this.lugarTrabajo;
	}

	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSalida() {
		return this.salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public Integer getTiempoMeses() {
		return this.tiempoMeses;
	}

	public void setTiempoMeses(Integer tiempoMeses) {
		this.tiempoMeses = tiempoMeses;
	}

	public String getUsuarioLog() {
		return this.usuarioLog;
	}

	public void setUsuarioLog(String usuarioLog) {
		this.usuarioLog = usuarioLog;
	}

	public String getValida() {
		return this.valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}

	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getValidarevalorazion() {
		return validarevalorazion;
	}

	public void setValidarevalorazion(String validarevalorazion) {
		this.validarevalorazion = validarevalorazion;
	}

	public Date getFechavalidarevaloriacion() {
		return fechavalidarevaloriacion;
	}

	public void setFechavalidarevaloriacion(Date fechavalidarevaloriacion) {
		this.fechavalidarevaloriacion = fechavalidarevaloriacion;
	}

	public String getValidarecategorza() {
		return validarecategorza;
	}

	public void setValidarecategorza(String validarecategorza) {
		this.validarecategorza = validarecategorza;
	}

	public Date getFechavalidarecategoriza() {
		return fechavalidarecategoriza;
	}

	public void setFechavalidarecategoriza(Date fechavalidarecategoriza) {
		this.fechavalidarecategoriza = fechavalidarecategoriza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}