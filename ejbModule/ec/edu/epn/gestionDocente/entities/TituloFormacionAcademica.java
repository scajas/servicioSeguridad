package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the titulo_formacion_academica database table.
 * 
 */
@Entity
@Table(name="titulo_formacion_academica" , catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQueries({
	@NamedQuery(name="TituloFormacionAcademica.findAll", query="SELECT t FROM TituloFormacionAcademica t")
		
})

public class TituloFormacionAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@SequenceGenerator(name = "TITULO_IDPUBLIC_GENERATOR", sequenceName="titulo_formacion_academica_idtfa_seq",allocationSize=1, catalog="bddcorpepn",schema="`GestionDocente`")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TITULO_IDPUBLIC_GENERATOR")
	
	
	@Column(name="id_titulo")
	private Integer idTitulo;

	private Integer año;

	@Column(name="cod_area_1")
	private String codArea1;

	@Column(name="cod_area_2")
	private String codArea2;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_fin_car")
	private Date fecFinCar;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_grado")
	private Date fecGrado;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_ini_car")
	private Date fecIniCar;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_reg_senescyt")
	private Date fecRegSenescyt;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_titulo")
	private Date fechaFinTitulo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_titulo")
	private Date fechaInicioTitulo;

	@Column(name="fecha_sis")
	private Timestamp fechaSis;

	@ManyToOne
	@JoinColumn(name = "id_area_con")
	private AreaConocimiento area;

	@ManyToOne
	@JoinColumn(name = "id_nivel_titulo")
	private NivelTitulo nivel;

	@ManyToOne
	@JoinColumn(name = "id_universid")
	private Universidad universidad;
	

	private String nced;

	@Column(name="nombre_titulo")
	private String nombreTitulo;

	@Column(name="path_titulo")
	private String pathTitulo;

	@Column(name="reg_senescyt")
	private String regSenescyt;

	private String si1;

	private String si2;

	@Column(name="usuario_log")
	private String usuarioLog;

	private String valida;

	private String validacion;

	private String validadgip;
	
	
	private String validarevalorazion ;
	private Date  fechavalidarevaloriacion;
	private String validarecategorza;
	private Date fechavalidarecategoriza;
	
	@Column(name="nivel_titulo")
	private String nivelTitulo;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="ies")
	private String ies;
	private String iddocalfresco;
	private String enviadoalf;

	public TituloFormacionAcademica() {
	}

	public Integer getIdTitulo() {
		return this.idTitulo;
	}

	public void setIdTitulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
	}

	public Integer getAño() {
		return this.año;
	}

	public void setAño(Integer año) {
		this.año = año;
	}

	public String getCodArea1() {
		return this.codArea1;
	}

	public void setCodArea1(String codArea1) {
		this.codArea1 = codArea1;
	}

	public String getCodArea2() {
		return this.codArea2;
	}

	public void setCodArea2(String codArea2) {
		this.codArea2 = codArea2;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecFinCar() {
		return this.fecFinCar;
	}

	public void setFecFinCar(Date fecFinCar) {
		this.fecFinCar = fecFinCar;
	}

	public Date getFecGrado() {
		return this.fecGrado;
	}

	public void setFecGrado(Date fecGrado) {
		this.fecGrado = fecGrado;
	}

	public Date getFecIniCar() {
		return this.fecIniCar;
	}

	public void setFecIniCar(Date fecIniCar) {
		this.fecIniCar = fecIniCar;
	}

	public Date getFecRegSenescyt() {
		return this.fecRegSenescyt;
	}

	public void setFecRegSenescyt(Date fecRegSenescyt) {
		this.fecRegSenescyt = fecRegSenescyt;
	}

	public Date getFechaFinTitulo() {
		return this.fechaFinTitulo;
	}

	public void setFechaFinTitulo(Date fechaFinTitulo) {
		this.fechaFinTitulo = fechaFinTitulo;
	}

	public Date getFechaInicioTitulo() {
		return this.fechaInicioTitulo;
	}

	public void setFechaInicioTitulo(Date fechaInicioTitulo) {
		this.fechaInicioTitulo = fechaInicioTitulo;
	}

	public Timestamp getFechaSis() {
		return this.fechaSis;
	}

	public void setFechaSis(Timestamp fechaSis) {
		this.fechaSis = fechaSis;
	}

	

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombreTitulo() {
		return this.nombreTitulo;
	}

	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}

	public String getPathTitulo() {
		return this.pathTitulo;
	}

	public void setPathTitulo(String pathTitulo) {
		this.pathTitulo = pathTitulo;
	}

	public String getRegSenescyt() {
		return this.regSenescyt;
	}

	public void setRegSenescyt(String regSenescyt) {
		this.regSenescyt = regSenescyt;
	}

	public String getSi1() {
		return this.si1;
	}

	public void setSi1(String si1) {
		this.si1 = si1;
	}

	public String getSi2() {
		return this.si2;
	}

	public void setSi2(String si2) {
		this.si2 = si2;
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

	public String getValidadgip() {
		return this.validadgip;
	}

	public void setValidadgip(String validadgip) {
		this.validadgip = validadgip;
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

	public AreaConocimiento getArea() {
		return area;
	}

	public void setArea(AreaConocimiento area) {
		this.area = area;
	}

	public NivelTitulo getNivel() {
		return nivel;
	}

	public void setNivel(NivelTitulo nivel) {
		this.nivel = nivel;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	/**
	 * @return the nivelTitulo
	 */
	public String getNivelTitulo() {
		return nivelTitulo;
	}

	/**
	 * @param nivelTitulo the nivelTitulo to set
	 */
	public void setNivelTitulo(String nivelTitulo) {
		this.nivelTitulo = nivelTitulo;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the ies
	 */
	public String getIes() {
		return ies;
	}

	/**
	 * @param ies the ies to set
	 */
	public void setIes(String ies) {
		this.ies = ies;
	}

	public String getIddocalfresco() {
		return iddocalfresco;
	}

	public void setIddocalfresco(String iddocalfresco) {
		this.iddocalfresco = iddocalfresco;
	}

	public String getEnviadoalf() {
		return enviadoalf;
	}

	public void setEnviadoalf(String enviadoalf) {
		this.enviadoalf = enviadoalf;
	}
	
	

}