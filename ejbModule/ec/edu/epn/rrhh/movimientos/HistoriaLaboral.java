package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.edu.epn.rrhh.entities.Emp;


/**
 * The persistent class for the historia_laboral database table.
 * 
 */
@Entity
@Table(name = "historia_laboral", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="HistoriaLaboral.findAll", query="SELECT h FROM HistoriaLaboral h")
public class HistoriaLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoriaLaboralPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	private String motivo;

	@Column(name="nro_documento")
	private String nroDocumento;
	
	@Column(name="partida_general")
	private String partidaGeneral;
	
	@Column(name="partida_individual")
	private String partidaIndividual;

	private String observaciones;
	//Columna referente al numero de documento de la situaci�n actual 
	//correspondiente a esta accion de personal
	@Column(name="nro_documento_sit_actual")
	private String numeroDocSituacionActual;
	
	@Column(name="nro_documento_a_finalizar")
	private String numeroDocAFinalizar;

	private Double remreal;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_prevista_fin")
	private Date fechaPrevistaFin;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_rige")
	private Date fechaRige;
	
	@Column(name="id_designacion_multiple_actual")
	private Integer idDesignacionMultipleActual;
	
	public Date getFechaRige() {
		return this.fechaRige;
	}

	public void setFechaRige(Date fechaRige) {
		this.fechaRige = fechaRige;
	}

	public Date getFechaPrevistaFin() {
		return fechaPrevistaFin;
	}

	public void setFechaPrevistaFin(Date fechaPrevistaFin) {
		this.fechaPrevistaFin = fechaPrevistaFin;
	}

	//bi-directional many-to-one association to Docadjunto
	@OneToMany(mappedBy="historiaLaboral", cascade=CascadeType.ALL)
	private List<Docadjunto> docadjuntos;

	//bi-directional many-to-one association to AccionP
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.REFRESH, CascadeType.DETACH})
	@JoinColumns({
		@JoinColumn(name="fecha_ini", referencedColumnName="fecha_ini"),
		@JoinColumn(name="id_accionp", referencedColumnName="id_accionp")
		})
	
	private AccionP accionP;

	//bi-directional many-to-one association to Cargosm
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_cargo")
	private Cargosm cargosm;

	//bi-directional many-to-one association to Clase
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_clase")
	private Clase clase;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cod_dep")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Designacion
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_designacion")
	private Designacion designacion;

	//bi-directional many-to-one association to Distributivo
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_distributivo")
	private Distributivo distributivo;

	//bi-directional many-to-one association to Emp
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_emp")
	private Emp emp;

	//bi-directional many-to-one association to TipoRelacion
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_tr")
	private TipoRelacion tipoRelacion;
	
	//bi-directional many-to-one association to DocuContrato
	@ManyToOne
	@JoinColumn(name="doc_tipo")
	private DocuContrato docuContrato;
	
	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaRegistro\"")
	private Date fechaRegistro;
	
	@Column(name="usuario_registra_cont")
	private String usuarioRegistraCont;

	public String getUsuarioRegistraCont() {
		return usuarioRegistraCont;
	}

	public void setUsuarioRegistraCont(String usuarioRegistraCont) {
		this.usuarioRegistraCont = usuarioRegistraCont;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public DocuContrato getDocuContrato() {
		return docuContrato;
	}

	public void setDocuContrato(DocuContrato docuContrato) {
		this.docuContrato = docuContrato;
	}

	public HistoriaLaboral() {
	}

	public HistoriaLaboralPK getId() {
		return this.id;
	}

	public void setId(HistoriaLaboralPK id) {
		this.id = id;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Double getRemreal() {
		return this.remreal;
	}

	public void setRemreal(Double remreal) {
		this.remreal = remreal;
	}

	public List<Docadjunto> getDocadjuntos() {
		return this.docadjuntos;
	}

	public void setDocadjuntos(List<Docadjunto> docadjuntos) {
		this.docadjuntos = docadjuntos;
	}

	public Docadjunto addDocadjunto(Docadjunto docadjunto) {
		getDocadjuntos().add(docadjunto);
		docadjunto.setHistoriaLaboral(this);

		return docadjunto;
	}

	public Docadjunto removeDocadjunto(Docadjunto docadjunto) {
		getDocadjuntos().remove(docadjunto);
		docadjunto.setHistoriaLaboral(null);

		return docadjunto;
	}

	public AccionP getAccionP() {
		return this.accionP;
	}

	public void setAccionP(AccionP accionP) {
		this.accionP = accionP;
	}

	public Cargosm getCargosm() {
		return this.cargosm;
	}

	public void setCargosm(Cargosm cargosm) {
		this.cargosm = cargosm;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Designacion getDesignacion() {
		return this.designacion;
	}

	public void setDesignacion(Designacion designacion) {
		this.designacion = designacion;
	}

	public Distributivo getDistributivo() {
		return this.distributivo;
	}

	public void setDistributivo(Distributivo distributivo) {
		this.distributivo = distributivo;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public TipoRelacion getTipoRelacion() {
		return this.tipoRelacion;
	}

	public void setTipoRelacion(TipoRelacion tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	public String getPartidaGeneral() {
		return partidaGeneral;
	}

	public void setPartidaGeneral(String partidaGeneral) {
		this.partidaGeneral = partidaGeneral;
	}

	public String getPartidaIndividual() {
		return partidaIndividual;
	}

	public void setPartidaIndividual(String partidaIndividual) {
		this.partidaIndividual = partidaIndividual;
	}

	public String getNumeroDocSituacionActual() {
		return numeroDocSituacionActual;
	}

	public void setNumeroDocSituacionActual(String numeroDocSituacionActual) {
		this.numeroDocSituacionActual = numeroDocSituacionActual;
	}

	public String getNumeroDocAFinalizar() {
		return numeroDocAFinalizar;
	}

	public void setNumeroDocAFinalizar(String numeroDocAFinalizar) {
		this.numeroDocAFinalizar = numeroDocAFinalizar;
	}

	public Integer getIdDesignacionMultipleActual() {
		return idDesignacionMultipleActual;
	}

	public void setIdDesignacionMultipleActual(Integer idDesignacionMultipleActual) {
		this.idDesignacionMultipleActual = idDesignacionMultipleActual;
	}
	

	
	
	
	
	

}