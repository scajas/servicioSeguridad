package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;



import ec.edu.epn.catalogos.entities.PaisCatalogo;
import ec.edu.epn.gestionDocente.entities.Pais;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the convenio database table.
 * 
 */
@Entity
@Table(name="convenio", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class Convenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_conv")
	private String idConv;

	private String ciudad;

	@Column(name="duracion_c")
	private Integer duracionC;

	private String estado;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_e")
	private Date fechaE;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_firma")
	private Date fechaFirma;

	private String feotro;

    @Temporal( TemporalType.DATE)
	@Column(name="fin_convenio")
	private Date finConvenio;

    @Temporal( TemporalType.DATE)
	@Column(name="fin_tentativo")
	private Date finTentativo;

	@Column(name="forma_e")
	private String formaE;

	@Column(name="forma_r")
	private String formaR;

	private String frotro;

	@Column(name="geografico_c")
	private String geograficoC;

	@Column(name="id_conv_r1")
	private String idConvR1;

	@Column(name="id_conv_r2")
	private String idConvR2;
	
	private String nuevo;


	private String investigacion;

	@Column(name="objetivo_c")
	private String objetivoC;

	private String observaciones;

	private String pasantias;

	private Integer serial;

	private String sprofesionales;

	private String tesis;

	@Column(name="titulo_c")
	private String tituloC;

	@Column(name="url_archivo")
	private String urlArchivo;

	private String varios;

	@Column(name="vigencia_c")
	private String vigenciaC;

	@Column(name="vigencia_estados")
	private String vigenciaEstados;

	//bi-directional many-to-one association to Actividade
	@OneToMany(mappedBy="convenio")
	private List<ActividadeConvenio> actividades;

	//bi-directional many-to-one association to Autoridad
    @ManyToOne
	@JoinColumn(name="id_autoridad")
	private Autoridad autoridad;
    
    @ManyToOne
	@JoinColumn(name="id_unidad")
	private UnidadConvenio unidad;
    

	//bi-directional many-to-one association to TipoC
    @ManyToOne
	@JoinColumn(name="id_tipoc")
	private TipoC tipoC;

	//bi-directional many-to-one association to OrgaAdic
	@OneToMany(mappedBy="convenio")
	private List<OrgaAdic> orgaAdics;

	//bi-directional many-to-one association to RegistroEstado
	@OneToMany(mappedBy="convenio")
	private List<RegistroEstado> registroEstados;
	
	 
	
	@OneToMany( mappedBy="convenio")
	private List<ConvOrganizacion> convorga ;
	
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;
	
	

    public Convenio() {
    }

	public String getIdConv() {
		return this.idConv;
	}

	public void setIdConv(String idConv) {
		this.idConv = idConv;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Integer getDuracionC() {
		return this.duracionC;
	}

	public void setDuracionC(Integer duracionC) {
		this.duracionC = duracionC;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaE() {
		return this.fechaE;
	}

	public void setFechaE(Date fechaE) {
		this.fechaE = fechaE;
	}

	public Date getFechaFirma() {
		return this.fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public String getFeotro() {
		return this.feotro;
	}

	public void setFeotro(String feotro) {
		this.feotro = feotro;
	}

	public Date getFinConvenio() {
		return this.finConvenio;
	}

	public void setFinConvenio(Date finConvenio) {
		this.finConvenio = finConvenio;
	}

	public Date getFinTentativo() {
		return this.finTentativo;
	}

	public void setFinTentativo(Date finTentativo) {
		this.finTentativo = finTentativo;
	}

	public String getFormaE() {
		return this.formaE;
	}

	public void setFormaE(String formaE) {
		this.formaE = formaE;
	}

	public String getFormaR() {
		return this.formaR;
	}

	public void setFormaR(String formaR) {
		this.formaR = formaR;
	}

	public String getFrotro() {
		return this.frotro;
	}

	public void setFrotro(String frotro) {
		this.frotro = frotro;
	}

	public String getGeograficoC() {
		return this.geograficoC;
	}

	public void setGeograficoC(String geograficoC) {
		this.geograficoC = geograficoC;
	}

	public String getIdConvR1() {
		return this.idConvR1;
	}

	public void setIdConvR1(String idConvR1) {
		this.idConvR1 = idConvR1;
	}

	public String getIdConvR2() {
		return this.idConvR2;
	}

	public void setIdConvR2(String idConvR2) {
		this.idConvR2 = idConvR2;
	}

	

	public String getInvestigacion() {
		return this.investigacion;
	}

	public void setInvestigacion(String investigacion) {
		this.investigacion = investigacion;
	}

	public String getObjetivoC() {
		return this.objetivoC;
	}

	public void setObjetivoC(String objetivoC) {
		this.objetivoC = objetivoC;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPasantias() {
		return this.pasantias;
	}

	public void setPasantias(String pasantias) {
		this.pasantias = pasantias;
	}

	public Integer getSerial() {
		return this.serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String getSprofesionales() {
		return this.sprofesionales;
	}

	public void setSprofesionales(String sprofesionales) {
		this.sprofesionales = sprofesionales;
	}

	public String getTesis() {
		return this.tesis;
	}

	public void setTesis(String tesis) {
		this.tesis = tesis;
	}

	public String getTituloC() {
		return this.tituloC;
	}

	public void setTituloC(String tituloC) {
		this.tituloC = tituloC;
	}

	public String getUrlArchivo() {
		return this.urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public String getVarios() {
		return this.varios;
	}

	public void setVarios(String varios) {
		this.varios = varios;
	}

	public String getVigenciaC() {
		return this.vigenciaC;
	}

	public void setVigenciaC(String vigenciaC) {
		this.vigenciaC = vigenciaC;
	}

	public String getVigenciaEstados() {
		return this.vigenciaEstados;
	}

	public void setVigenciaEstados(String vigenciaEstados) {
		this.vigenciaEstados = vigenciaEstados;
	}

	public List<ActividadeConvenio> getActividades() {
		return this.actividades;
	}

	public void setActividades(List<ActividadeConvenio> actividades) {
		this.actividades = actividades;
	}
	
	public Autoridad getAutoridad() {
		return this.autoridad;
	}

	public void setAutoridad(Autoridad autoridad) {
		this.autoridad = autoridad;
	}
	
	
	
	public TipoC getTipoC() {
		return this.tipoC;
	}

	public void setTipoC(TipoC tipoC) {
		this.tipoC = tipoC;
	}
	
	public List<OrgaAdic> getOrgaAdics() {
		return this.orgaAdics;
	}

	public void setOrgaAdics(List<OrgaAdic> orgaAdics) {
		this.orgaAdics = orgaAdics;
	}
	
	public List<RegistroEstado> getRegistroEstados() {
		return this.registroEstados;
	}

	public void setRegistroEstados(List<RegistroEstado> registroEstados) {
		this.registroEstados = registroEstados;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	

	public UnidadConvenio getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadConvenio unidad) {
		this.unidad = unidad;
	}

	public String getNuevo() {
		return nuevo;
	}

	public void setNuevo(String nuevo) {
		this.nuevo = nuevo;
	}

	public List<ConvOrganizacion> getConvorga() {
		return convorga;
	}

	public void setConvorga(List<ConvOrganizacion> convorga) {
		this.convorga = convorga;
	}
	
}