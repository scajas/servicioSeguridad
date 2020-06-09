package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.LineasInvestigacion;

import java.sql.Array;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@Table(name = "proyecto", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ProyectoP implements Serializable {
	private static final long serialVersionUID = 1L;

	private double presaprob;
	private double presupaprobiva;
	private double presupeject;
	private Double avace;
	private String ingobjetivos;
	@Id
	@Column(name = "id_proy")
	private Integer idProy;

	@Column(name = "a_favor")
	private double aFavor;

	@Column(name = "alcance_pr")
	private String alcancePr;

	@Column(name = "beneficiario_pr")
	private String beneficiarioPr;

	@Column(name = "codigo_pr")
	private String codigoPr;

	private String estado;

	private double extra;

	private String nombrearea;

	private String pathact;

	private String pathfirma;
	private String patharcfirma;

	private String objetivos;

	private String coddep;

	private String descripcion;
	private String metodologia;
	private String justificacionequipo, responsable;

	@Temporal(TemporalType.DATE)
	private Date fechaaprobcomiex;

	@Temporal(TemporalType.DATE)
	private Date fechaaprobdept;

	@Temporal(TemporalType.DATE)
	private Date fechaf;

	@Temporal(TemporalType.DATE)
	private Date fechaini;

	@Temporal(TemporalType.DATE)
	private Date fechapresentacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"fechaPresentacion\"")
	private Date fechaPresentacion;

	private double porejectfin;
	@Column(name = "peticion_prorroga")
	private String peticionprorroga;
	@Temporal(TemporalType.DATE)
	@Column(name = "prorroga_hasta")
	private Date prorrogahasta;
	private String pathinffinal;
	private String pathactafin;
	@Temporal(TemporalType.DATE)
	private Date fechaaprob;

	@Temporal(TemporalType.DATE)
	private Date finisusp;
	@Temporal(TemporalType.DATE)
	private Date ffinsusp;
	@Temporal(TemporalType.DATE)
	private Date fproextra;

	@Temporal(TemporalType.DATE)
	private Date factafin;
	@Temporal(TemporalType.DATE)
	private Date fnotificafin;

	private String numresolaprprord, numresolprogextra, convenio, tieneconv, tipoorg;

	private String nced;

	@Column(name = "nombre_pr")
	private String nombrePr;

	@Column(name = "nro_public")
	private Integer nroPublic;

	@Column(name = "nro_tesis")
	private Integer nroTesis;

	@Column(name = "observaciones_comiex")
	private String observacionesComiex;

	@Column(name = "observaciones_jefedept")
	private String observacionesJefedept;

	private String observfinal;

	private Integer serial;
	private Integer anio;

	@Column(name = "path__final")
	private String pathFinal;

	@Column(name = "path_pr")
	private String pathPr;

	@Column(name = "presup_plani")
	private double presupPlani;

	@Column(name = "presup_pr")
	private double presupPr;

	@Column(name = "presup_prdisp")
	private double presupPrdisp;

	@Column(name = "presup_real")
	private double presupReal;

	private String resultados;

	@Column(name = "resumen_pr")
	private String resumenPr;

	private String area;

	private String palabras;

	private String relevancia;

	private String infraestructura;

	private String fondos;

	private String publicaciones;
	private String disertacion;
	private String titulacion;
	private String tesis;
	private String aplicacion;
	private String patente;
	private String perfil;
	private String pathcronograma;
	private String pathpresupuesto;
	private Double montofinepn;
	private String prorrogaaprob;
	private String observaprorroga;
	private String peticionprorrogaextra;
	private String aprobprorrgoaextra;
	private String observaproextra;

	private String memosolprogtec, resolcipsprogtec, progtecaprob, obsvprogtec;
	private Date ffinprogtec;

	public Date getFactafin() {
		return factafin;
	}

	public void setFactafin(Date factafin) {
		this.factafin = factafin;
	}

	public Date getFnotificafin() {
		return fnotificafin;
	}

	public void setFnotificafin(Date fnotificafin) {
		this.fnotificafin = fnotificafin;
	}

	public Double getMontofinepn() {
		return montofinepn;
	}

	public void setMontofinepn(Double montofinepn) {
		this.montofinepn = montofinepn;
	}

	public String getProrrogaaprob() {
		return prorrogaaprob;
	}

	public void setProrrogaaprob(String prorrogaaprob) {
		this.prorrogaaprob = prorrogaaprob;
	}

	public String getObservaprorroga() {
		return observaprorroga;
	}

	public void setObservaprorroga(String observaprorroga) {
		this.observaprorroga = observaprorroga;
	}

	public String getPeticionprorrogaextra() {
		return peticionprorrogaextra;
	}

	public void setPeticionprorrogaextra(String peticionprorrogaextra) {
		this.peticionprorrogaextra = peticionprorrogaextra;
	}

	public String getAprobprorrgoaextra() {
		return aprobprorrgoaextra;
	}

	public void setAprobprorrgoaextra(String aprobprorrgoaextra) {
		this.aprobprorrgoaextra = aprobprorrgoaextra;
	}

	public String getObservaproextra() {
		return observaproextra;
	}

	public void setObservaproextra(String observaproextra) {
		this.observaproextra = observaproextra;
	}

	// bi-directional many-to-one association to ActividadProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<ActividadProyectoP> actividadProyectos;

	// bi-directional many-to-one association to AuspicianteProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<AuspicianteProyecto> auspicianteProyectos;

	// bi-directional many-to-one association to Entregable
	@OneToMany(mappedBy = "proyecto")
	private List<Entregable> entregables;

	// bi-directional many-to-one association to HistoriaEstado
	@OneToMany(mappedBy = "proyecto")
	private List<HistoriaEstadoP> historiaEstados;

	// bi-directional many-to-one association to InvestigadorObservacione
	@OneToMany(mappedBy = "proyecto")
	private List<InvestigadorObservacione> investigadorObservaciones;

	// bi-directional many-to-one association to ObjetivoProyecto
	@OneToMany(mappedBy = "proyecto")
	private List<ObjetivoProyecto> objetivoProyectos;

	// bi-directional many-to-one association to Presupuesto
	@OneToMany(mappedBy = "proyecto")
	private List<Presupuesto> presupuestos;

	// bi-directional many-to-one association to ConvocatoriaVoto
	@ManyToOne
	@JoinColumn(name = "id_conv")
	private Convocatoria convocatoria;

	// bi-directional many-to-one association to TipoProyecto
	@ManyToOne
	@JoinColumn(name = "id_tipo_proy")
	private TipoProyectoP tipoProyecto;

	// bi-directional many-to-one association to RecursohPr
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "proyecto", cascade = CascadeType.ALL)
	@OrderBy("rolProyecto.idRolProy")
	private List<RecursohPr> recursohPrs;

	// bi-directional many-to-one association to Resultado
	@OneToMany(mappedBy = "proyecto")
	private List<ResultadoP> resultadosSet;

	// bi-directional many-to-one association to Resultado
	@OneToMany(mappedBy = "proyecto")
	private List<Comision> comisiones;
	@OneToMany(mappedBy = "proyecto")
	private List<Cronograma> cornogramas;

	private String memsolsusp, resolcipssusp, suspaprob, observsusp, memonotificainicio, camplio, cespecifico,
			cdetallado, territorial, imsocial, imcien, imeco, impol, imotro, resolcipsaprob;

	private Date fentregainffin;
	private String nromeminfobserv;
	private Date fentregainfcorre;
	private String codinfpropintel;
	private String obserpropintel;

	// @ManyToOne
	// @JoinColumn(name="id_linin")
	// private LineasInvestigacion lineasInvestigacion;

	// bi-directional many-to-one association to Lineasproy
	@OneToMany(mappedBy = "proyecto")
	private List<Lineasproy> lineasproys;

	public ProyectoP() {
	}

	public Integer getIdProy() {
		return this.idProy;
	}

	public void setIdProy(Integer idProy) {
		this.idProy = idProy;
	}

	public double getAFavor() {
		return this.aFavor;
	}

	public void setAFavor(double aFavor) {
		this.aFavor = aFavor;
	}

	public String getAlcancePr() {
		return this.alcancePr;
	}

	public void setAlcancePr(String alcancePr) {
		this.alcancePr = alcancePr;
	}

	public String getBeneficiarioPr() {
		return this.beneficiarioPr;
	}

	public void setBeneficiarioPr(String beneficiarioPr) {
		this.beneficiarioPr = beneficiarioPr;
	}

	public String getCodigoPr() {
		return this.codigoPr;
	}

	public void setCodigoPr(String codigoPr) {
		this.codigoPr = codigoPr;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getExtra() {
		return this.extra;
	}

	public void setExtra(double extra) {
		this.extra = extra;
	}

	public Date getFechaaprobcomiex() {
		return this.fechaaprobcomiex;
	}

	public void setFechaaprobcomiex(Date fechaaprobcomiex) {
		this.fechaaprobcomiex = fechaaprobcomiex;
	}

	public Date getFechaaprobdept() {
		return this.fechaaprobdept;
	}

	public void setFechaaprobdept(Date fechaaprobdept) {
		this.fechaaprobdept = fechaaprobdept;
	}

	public Date getFechaf() {
		return this.fechaf;
	}

	public void setFechaf(Date fechaf) {
		this.fechaf = fechaf;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechapresentacion() {
		return this.fechapresentacion;
	}

	public void setFechapresentacion(Date fechapresentacion) {
		this.fechapresentacion = fechapresentacion;
	}

	public Date getFechaPresentacion() {
		return this.fechaPresentacion;
	}

	public void setFechaPresentacion(Date fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombrePr() {
		return this.nombrePr;
	}

	public void setNombrePr(String nombrePr) {
		this.nombrePr = nombrePr;
	}

	public Integer getNroPublic() {
		return this.nroPublic;
	}

	public void setNroPublic(Integer nroPublic) {
		this.nroPublic = nroPublic;
	}

	public Integer getNroTesis() {
		return this.nroTesis;
	}

	public void setNroTesis(Integer nroTesis) {
		this.nroTesis = nroTesis;
	}

	public String getObservacionesComiex() {
		return this.observacionesComiex;
	}

	public void setObservacionesComiex(String observacionesComiex) {
		this.observacionesComiex = observacionesComiex;
	}

	public String getObservacionesJefedept() {
		return this.observacionesJefedept;
	}

	public void setObservacionesJefedept(String observacionesJefedept) {
		this.observacionesJefedept = observacionesJefedept;
	}

	public String getObservfinal() {
		return this.observfinal;
	}

	public void setObservfinal(String observfinal) {
		this.observfinal = observfinal;
	}

	public String getPathFinal() {
		return this.pathFinal;
	}

	public void setPathFinal(String pathFinal) {
		this.pathFinal = pathFinal;
	}

	public String getPathPr() {
		return this.pathPr;
	}

	public void setPathPr(String pathPr) {
		this.pathPr = pathPr;
	}

	public double getPresupPlani() {
		return this.presupPlani;
	}

	public void setPresupPlani(double presupPlani) {
		this.presupPlani = presupPlani;
	}

	public double getPresupPr() {
		return this.presupPr;
	}

	public void setPresupPr(double presupPr) {
		this.presupPr = presupPr;
	}

	public double getPresupPrdisp() {
		return this.presupPrdisp;
	}

	public void setPresupPrdisp(double presupPrdisp) {
		this.presupPrdisp = presupPrdisp;
	}

	public double getPresupReal() {
		return this.presupReal;
	}

	public void setPresupReal(double presupReal) {
		this.presupReal = presupReal;
	}

	public String getResultados() {
		return this.resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getResumenPr() {
		return this.resumenPr;
	}

	public void setResumenPr(String resumenPr) {
		this.resumenPr = resumenPr;
	}

	public List<ActividadProyectoP> getActividadProyectos() {
		return this.actividadProyectos;
	}

	public void setActividadProyectos(List<ActividadProyectoP> actividadProyectos) {
		this.actividadProyectos = actividadProyectos;
	}

	public List<AuspicianteProyecto> getAuspicianteProyectos() {
		return this.auspicianteProyectos;
	}

	public void setAuspicianteProyectos(List<AuspicianteProyecto> auspicianteProyectos) {
		this.auspicianteProyectos = auspicianteProyectos;
	}

	public List<Entregable> getEntregables() {
		return this.entregables;
	}

	public void setEntregables(List<Entregable> entregables) {
		this.entregables = entregables;
	}

	public List<HistoriaEstadoP> getHistoriaEstados() {
		return this.historiaEstados;
	}

	public void setHistoriaEstados(List<HistoriaEstadoP> historiaEstados) {
		this.historiaEstados = historiaEstados;
	}

	public List<InvestigadorObservacione> getInvestigadorObservaciones() {
		return this.investigadorObservaciones;
	}

	public void setInvestigadorObservaciones(List<InvestigadorObservacione> investigadorObservaciones) {
		this.investigadorObservaciones = investigadorObservaciones;
	}

	public List<ObjetivoProyecto> getObjetivoProyectos() {
		return this.objetivoProyectos;
	}

	public void setObjetivoProyectos(List<ObjetivoProyecto> objetivoProyectos) {
		this.objetivoProyectos = objetivoProyectos;
	}

	public List<Presupuesto> getPresupuestos() {
		return this.presupuestos;
	}

	public void setPresupuestos(List<Presupuesto> presupuestos) {
		this.presupuestos = presupuestos;
	}

	public Convocatoria getConvocatoria() {
		return this.convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public TipoProyectoP getTipoProyecto() {
		return this.tipoProyecto;
	}

	public void setTipoProyecto(TipoProyectoP tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	public List<RecursohPr> getRecursohPrs() {
		return this.recursohPrs;
	}

	public void setRecursohPrs(List<RecursohPr> recursohPrs) {
		this.recursohPrs = recursohPrs;
	}

	public List<ResultadoP> getResultadosSet() {
		return this.resultadosSet;
	}

	public void setResultadosSet(List<ResultadoP> resultadosSet) {
		this.resultadosSet = resultadosSet;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras = palabras;
	}

	public String getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(String relevancia) {
		this.relevancia = relevancia;
	}

	public List<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public String getNombrearea() {
		return nombrearea;
	}

	public void setNombrearea(String nombrearea) {
		this.nombrearea = nombrearea;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public String getJustificacionequipo() {
		return justificacionequipo;
	}

	public void setJustificacionequipo(String justificacionequipo) {
		this.justificacionequipo = justificacionequipo;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getInfraestructura() {
		return infraestructura;
	}

	public void setInfraestructura(String infraestructura) {
		this.infraestructura = infraestructura;
	}

	public String getFondos() {
		return fondos;
	}

	public void setFondos(String fondos) {
		this.fondos = fondos;
	}

	public List<Cronograma> getCornogramas() {
		return cornogramas;
	}

	public void setCornogramas(List<Cronograma> cornogramas) {
		this.cornogramas = cornogramas;
	}

	public String getPathact() {
		return pathact;
	}

	public void setPathact(String pathact) {
		this.pathact = pathact;
	}

	public String getPathfirma() {
		return pathfirma;
	}

	public void setPathfirma(String pathfirma) {
		this.pathfirma = pathfirma;
	}

	public String getPatharcfirma() {
		return patharcfirma;
	}

	public void setPatharcfirma(String patharcfirma) {
		this.patharcfirma = patharcfirma;
	}

	/**
	 * @return the lineasproys
	 */
	public List<Lineasproy> getLineasproys() {
		return lineasproys;
	}

	/**
	 * @param lineasproys the lineasproys to set
	 */
	public void setLineasproys(List<Lineasproy> lineasproys) {
		this.lineasproys = lineasproys;
	}

	/**
	 * @return the publicaciones
	 */
	public String getPublicaciones() {
		return publicaciones;
	}

	/**
	 * @param publicaciones the publicaciones to set
	 */
	public void setPublicaciones(String publicaciones) {
		this.publicaciones = publicaciones;
	}

	/**
	 * @return the disertacion
	 */
	public String getDisertacion() {
		return disertacion;
	}

	/**
	 * @param disertacion the disertacion to set
	 */
	public void setDisertacion(String disertacion) {
		this.disertacion = disertacion;
	}

	/**
	 * @return the titulacion
	 */
	public String getTitulacion() {
		return titulacion;
	}

	/**
	 * @param titulacion the titulacion to set
	 */
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	/**
	 * @return the tesis
	 */
	public String getTesis() {
		return tesis;
	}

	/**
	 * @param tesis the tesis to set
	 */
	public void setTesis(String tesis) {
		this.tesis = tesis;
	}

	/**
	 * @return the aplicacion
	 */
	public String getAplicacion() {
		return aplicacion;
	}

	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the coddep
	 */
	public String getCoddep() {
		return coddep;
	}

	/**
	 * @param coddep the coddep to set
	 */
	public void setCoddep(String coddep) {
		this.coddep = coddep;
	}

	public double getPresaprob() {
		return presaprob;
	}

	public void setPresaprob(double presaprob) {
		this.presaprob = presaprob;
	}

	public double getPresupaprobiva() {
		return presupaprobiva;
	}

	public void setPresupaprobiva(double presupaprobiva) {
		this.presupaprobiva = presupaprobiva;
	}

	public double getPresupeject() {
		return presupeject;
	}

	public void setPresupeject(double presupeject) {
		this.presupeject = presupeject;
	}

	public double getPorejectfin() {
		return porejectfin;
	}

	public void setPorejectfin(double porejectfin) {
		this.porejectfin = porejectfin;
	}

	public String getPeticionprorroga() {
		return peticionprorroga;
	}

	public void setPeticionprorroga(String peticionprorroga) {
		this.peticionprorroga = peticionprorroga;
	}

	public Date getProrrogahasta() {
		return prorrogahasta;
	}

	public void setProrrogahasta(Date prorrogahasta) {
		this.prorrogahasta = prorrogahasta;
	}

	public String getPathinffinal() {
		return pathinffinal;
	}

	public void setPathinffinal(String pathinffinal) {
		this.pathinffinal = pathinffinal;
	}

	public String getPathactafin() {
		return pathactafin;
	}

	public void setPathactafin(String pathactafin) {
		this.pathactafin = pathactafin;
	}

	public Date getFechaaprob() {
		return fechaaprob;
	}

	public void setFechaaprob(Date fechaaprob) {
		this.fechaaprob = fechaaprob;
	}

	public String getPathcronograma() {
		return pathcronograma;
	}

	public void setPathcronograma(String pathcronograma) {
		this.pathcronograma = pathcronograma;
	}

	public String getPathpresupuesto() {
		return pathpresupuesto;
	}

	public void setPathpresupuesto(String pathpresupuesto) {
		this.pathpresupuesto = pathpresupuesto;
	}

	public Date getFinisusp() {
		return finisusp;
	}

	public void setFinisusp(Date finisusp) {
		this.finisusp = finisusp;
	}

	public Date getFfinsusp() {
		return ffinsusp;
	}

	public void setFfinsusp(Date ffinsusp) {
		this.ffinsusp = ffinsusp;
	}

	public Date getFproextra() {
		return fproextra;
	}

	public void setFproextra(Date fproextra) {
		this.fproextra = fproextra;
	}

	public String getNumresolprogextra() {
		return numresolprogextra;
	}

	public void setNumresolprogextra(String numresolprogextra) {
		this.numresolprogextra = numresolprogextra;
	}

	public String getNumresolaprprord() {
		return numresolaprprord;
	}

	public void setNumresolaprprord(String numresolaprprord) {
		this.numresolaprprord = numresolaprprord;
	}

	public Double getAvace() {
		return avace;
	}

	public void setAvace(Double avace) {
		this.avace = avace;
	}

	public String getIngobjetivos() {
		return ingobjetivos;
	}

	public void setIngobjetivos(String ingobjetivos) {
		this.ingobjetivos = ingobjetivos;
	}

	public double getaFavor() {
		return aFavor;
	}

	public void setaFavor(double aFavor) {
		this.aFavor = aFavor;
	}

	public String getMemsolsusp() {
		return memsolsusp;
	}

	public void setMemsolsusp(String memsolsusp) {
		this.memsolsusp = memsolsusp;
	}

	public String getResolcipssusp() {
		return resolcipssusp;
	}

	public void setResolcipssusp(String resolcipssusp) {
		this.resolcipssusp = resolcipssusp;
	}

	public String getSuspaprob() {
		return suspaprob;
	}

	public void setSuspaprob(String suspaprob) {
		this.suspaprob = suspaprob;
	}

	public String getObservsusp() {
		return observsusp;
	}

	public void setObservsusp(String observsusp) {
		this.observsusp = observsusp;
	}

	public String getMemonotificainicio() {
		return memonotificainicio;
	}

	public void setMemonotificainicio(String memonotificainicio) {
		this.memonotificainicio = memonotificainicio;
	}

	public String getCamplio() {
		return camplio;
	}

	public void setCamplio(String camplio) {
		this.camplio = camplio;
	}

	public String getCespecifico() {
		return cespecifico;
	}

	public void setCespecifico(String cespecifico) {
		this.cespecifico = cespecifico;
	}

	public String getCdetallado() {
		return cdetallado;
	}

	public void setCdetallado(String cdetallado) {
		this.cdetallado = cdetallado;
	}

	public String getTerritorial() {
		return territorial;
	}

	public void setTerritorial(String territorial) {
		this.territorial = territorial;
	}

	public String getImsocial() {
		return imsocial;
	}

	public void setImsocial(String imsocial) {
		this.imsocial = imsocial;
	}

	public String getImcien() {
		return imcien;
	}

	public void setImcien(String imcien) {
		this.imcien = imcien;
	}

	public String getImeco() {
		return imeco;
	}

	public void setImeco(String imeco) {
		this.imeco = imeco;
	}

	public String getImpol() {
		return impol;
	}

	public void setImpol(String impol) {
		this.impol = impol;
	}

	public String getImotro() {
		return imotro;
	}

	public void setImotro(String imotro) {
		this.imotro = imotro;
	}

	public String getResolcipsaprob() {
		return resolcipsaprob;
	}

	public void setResolcipsaprob(String resolcipsaprob) {
		this.resolcipsaprob = resolcipsaprob;
	}

	public Date getFentregainffin() {
		return fentregainffin;
	}

	public void setFentregainffin(Date fentregainffin) {
		this.fentregainffin = fentregainffin;
	}

	public String getNromeminfobserv() {
		return nromeminfobserv;
	}

	public void setNromeminfobserv(String nromeminfobserv) {
		this.nromeminfobserv = nromeminfobserv;
	}

	public Date getFentregainfcorre() {
		return fentregainfcorre;
	}

	public void setFentregainfcorre(Date fentregainfcorre) {
		this.fentregainfcorre = fentregainfcorre;
	}

	public String getCodinfpropintel() {
		return codinfpropintel;
	}

	public void setCodinfpropintel(String codinfpropintel) {
		this.codinfpropintel = codinfpropintel;
	}

	public String getObserpropintel() {
		return obserpropintel;
	}

	public void setObserpropintel(String obserpropintel) {
		this.obserpropintel = obserpropintel;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public String getTieneconv() {
		return tieneconv;
	}

	public void setTieneconv(String tieneconv) {
		this.tieneconv = tieneconv;
	}

	public String getTipoorg() {
		return tipoorg;
	}

	public void setTipoorg(String tipoorg) {
		this.tipoorg = tipoorg;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getMemosolprogtec() {
		return memosolprogtec;
	}

	public void setMemosolprogtec(String memosolprogtec) {
		this.memosolprogtec = memosolprogtec;
	}

	public String getResolcipsprogtec() {
		return resolcipsprogtec;
	}

	public void setResolcipsprogtec(String resolcipsprogtec) {
		this.resolcipsprogtec = resolcipsprogtec;
	}

	public String getObsvprogtec() {
		return obsvprogtec;
	}

	public void setObsvprogtec(String obsvprogtec) {
		this.obsvprogtec = obsvprogtec;
	}

	public String getProgtecaprob() {
		return progtecaprob;
	}

	public void setProgtecaprob(String progtecaprob) {
		this.progtecaprob = progtecaprob;
	}

	public Date getFfinprogtec() {
		return ffinprogtec;
	}

	public void setFfinprogtec(Date ffinprogtec) {
		this.ffinprogtec = ffinprogtec;
	}

}