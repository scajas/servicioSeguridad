package ec.edu.epn.rrhh.DTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class DocenteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8874718821598902077L;
	private String nCed;
	private String apel;
	private String nombre;
	private String cargo;
	private Date fechaIngresoEPN;
	private Date fechaIngresoSP;;
	private String relacionLab;

	private ArrayList<DocenteDTO> docentesArray;
	private int idUsuario;

	// OTROS
	private String idFacultad;
	private String nomFacultad;
	private String idDepartamento;
	private String nomDepartamento;
	private String dedicacion;
	private String categoria;
	private String auxFechaIngresoEPN;

	private String fechaContrat;

	private String periodo;
	private String idPeriodo;

	// VARIABLES ADICIONALES CURRICULUM

	private String extTelef;
	private String email1;
	private String email2;
	
	/**VARIABLES ADICIONALES PARA AUTO EVALAUCIÓN Y COEVALUACIÓN - 04-05-2017*/
	private String tipoDocente;
	private String tipoEval;
	private String tipoCoEval;
	private String notaFinal;
	private String docencia;
	private String investigacion;
	private String gestion;
	private String aprobEstudiantes;
	private String estado;	
	private String observacionPlanificacion;
	
	private Double totalAutoEval;
	private Double totalCoeEval;
	private Double totalHeteroEval;
	private Double totalHorasPlanificacion;	
	private String path;
	private String contrato;
	private String pathContrato;	
	private double semanasDocDentro;
	private boolean presentacion;
	private boolean existePeriodo;
	
	
	
	private String tipoEval2;
	
	/**VARIABLES PARA RESULTADOS GENERALES*/
	private Double autoDocencia;
	private Double autoInvestigacion;
	private Double autoGestion;
	private Double coeDocencia;
	private Double coeInvestigacion;
	private Double coeGestion;
	private Double horasEjecutadas;
	private Double horasPlanificadas;
	private Double dedicacionHrsDoc;
	private Double dedicacionHrsInv;
	private Double dedicacionHrsGest;
	private Double dedicacionPorcentajeDoc;
	private Double dedicacionPorcentajeInv;
	private Double dedicacionPorcentajeGest;
	private Double calfPonderadaDoc;
	private Double calfPonderadaInv;
	private Double calfPonderadaGest;
	private Double calificacionFInal;
	
	
	/**VARIABLES PARA RESULTADOS GENERALES BIGDECIMAL*/
	private BigDecimal totalHeteroEvalDecimal;
	private BigDecimal autoDocenciaDecimal;
	private BigDecimal autoInvestigacionDecimal;
	private BigDecimal autoGestionDecimal;
	private BigDecimal coeDocenciaDecimal;
	private BigDecimal coeInvestigacionDecimal;
	private BigDecimal coeGestionDecimal;
	private BigDecimal horasEjecutadasDecimal;
	private BigDecimal totalHorasPlanificadasDecimal;
	private BigDecimal dedicacionHrsDocDecimal;
	private BigDecimal dedicacionHrsInvDecimal;
	private BigDecimal dedicacionHrsGestDecimal;
	private BigDecimal dedicacionPorcentajeDocDecimal;
	private BigDecimal dedicacionPorcentajeInvDecimal;
	private BigDecimal dedicacionPorcentajeGestDecimal;
	private BigDecimal calfPonderadaDocDecimal;
	private BigDecimal calfPonderadaInvDecimal;
	private BigDecimal calfPonderadaGestDecimal;
	private BigDecimal calificacionFInalDecimal;
	private BigDecimal totalHorasExigiblesDecimal;
	
	private BigDecimal totalAutoEvalDecimal;
	private BigDecimal totalCoeEvalDecimal;
	
	
	private BigDecimal horasPlanificadasDocenciaDecimal;
	private BigDecimal horasPlanificadasInvestDecimal;
	private BigDecimal horasPlanificadasGestDecimal;
	
	
	private BigDecimal horasPlanifDocDentroDecimal;
	private BigDecimal horasPlanifDocFueraDecimal;
	private BigDecimal horasPlanifClasesDecimal;
	
	
	private boolean renderVerEvalFinal;
	
	
	
	
	private boolean renderVerPlanif;
	private boolean renderVerAuto;
	private boolean renderVerCoe;
	
	
	
	
	/**CAMPOS ADICIONALES*/
	private String cargoDocente;
	private String tipo;
	
	/**CAMPO ADICIONAL JUSTIFICACION HORAS PLANIFICADAS*/
	private String justificacionHorasPlanif; 
	
	private Integer idEvalAcad;
	

	public DocenteDTO() {
		super();
	}

	public DocenteDTO(String nCed, String apel, String nombre, String cargo, int idUsuario, String idFacultad,
			String nomFacultad, String idDepartamento, String nomDepartamento, String dedicacion, String categoria,
			Date fechaIngresoEPN, String auxFechaIngresoEPN, String relacionLab) {
		super();
		this.nCed = nCed;
		this.apel = apel;
		this.nombre = nombre;
		this.cargo = cargo;
		this.idUsuario = idUsuario;
		this.idFacultad = idFacultad;
		this.nomFacultad = nomFacultad;
		this.idDepartamento = idDepartamento;
		this.nomDepartamento = nomDepartamento;
		this.dedicacion = dedicacion;
		this.categoria = categoria;
		this.fechaIngresoEPN = fechaIngresoEPN;
		this.auxFechaIngresoEPN = auxFechaIngresoEPN;
		this.relacionLab = relacionLab;
	}

	public String getnCed() {
		return nCed;
	}

	public void setnCed(String nCed) {
		this.nCed = nCed;
	}

	public String getApel() {
		return apel;
	}

	public void setApel(String apel) {
		this.apel = apel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFechaIngresoEPN() {
		return fechaIngresoEPN;
	}

	public void setFechaIngresoEPN(Date fechaIngresoEPN) {
		this.fechaIngresoEPN = fechaIngresoEPN;
	}

	public Date getFechaIngresoSP() {
		return fechaIngresoSP;
	}

	public void setFechaIngresoSP(Date fechaIngresoSP) {
		this.fechaIngresoSP = fechaIngresoSP;
	}

	public String getRelacionLab() {
		return relacionLab;
	}

	public void setRelacionLab(String relacionLab) {
		this.relacionLab = relacionLab;
	}

	public ArrayList<DocenteDTO> getDocentesArray() {
		return docentesArray;
	}

	public void setDocentesArray(ArrayList<DocenteDTO> docentesArray) {
		this.docentesArray = docentesArray;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNomFacultad() {
		return nomFacultad;
	}

	public void setNomFacultad(String nomFacultad) {
		this.nomFacultad = nomFacultad;
	}

	public String getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNomDepartamento() {
		return nomDepartamento;
	}

	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}

	public String getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAuxFechaIngresoEPN() {
		return auxFechaIngresoEPN;
	}

	public void setAuxFechaIngresoEPN(String auxFechaIngresoEPN) {
		this.auxFechaIngresoEPN = auxFechaIngresoEPN;
	}

	public String getFechaContrat() {
		return fechaContrat;
	}

	public void setFechaContrat(String fechaContrat) {
		this.fechaContrat = fechaContrat;
	}

	public String getExtTelef() {
		return extTelef;
	}

	public void setExtTelef(String extTelef) {
		this.extTelef = extTelef;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	/**
	 * @return the tipoDocente
	 */
	public String getTipoDocente() {
		return tipoDocente;
	}

	/**
	 * @param tipoDocente the tipoDocente to set
	 */
	public void setTipoDocente(String tipoDocente) {
		this.tipoDocente = tipoDocente;
	}

	/**
	 * @return the tipoEval
	 */
	public String getTipoEval() {
		return tipoEval;
	}

	/**
	 * @param tipoEval the tipoEval to set
	 */
	public void setTipoEval(String tipoEval) {
		this.tipoEval = tipoEval;
	}

	/**
	 * @return the tipoCoEval
	 */
	public String getTipoCoEval() {
		return tipoCoEval;
	}

	/**
	 * @param tipoCoEval the tipoCoEval to set
	 */
	public void setTipoCoEval(String tipoCoEval) {
		this.tipoCoEval = tipoCoEval;
	}

	/**
	 * @return the notaFinal
	 */
	public String getNotaFinal() {
		return notaFinal;
	}

	/**
	 * @param notaFinal the notaFinal to set
	 */
	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}

	/**
	 * @return the docencia
	 */
	public String getDocencia() {
		return docencia;
	}

	/**
	 * @param docencia the docencia to set
	 */
	public void setDocencia(String docencia) {
		this.docencia = docencia;
	}

	/**
	 * @return the investigacion
	 */
	public String getInvestigacion() {
		return investigacion;
	}

	/**
	 * @param investigacion the investigacion to set
	 */
	public void setInvestigacion(String investigacion) {
		this.investigacion = investigacion;
	}

	/**
	 * @return the gestion
	 */
	public String getGestion() {
		return gestion;
	}

	/**
	 * @param gestion the gestion to set
	 */
	public void setGestion(String gestion) {
		this.gestion = gestion;
	}

	/**
	 * @return the aprobEstudiantes
	 */
	public String getAprobEstudiantes() {
		return aprobEstudiantes;
	}

	/**
	 * @param aprobEstudiantes the aprobEstudiantes to set
	 */
	public void setAprobEstudiantes(String aprobEstudiantes) {
		this.aprobEstudiantes = aprobEstudiantes;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @return the observacionPlanificacion
	 */
	public String getObservacionPlanificacion() {
		return observacionPlanificacion;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @param observacionPlanificacion the observacionPlanificacion to set
	 */
	public void setObservacionPlanificacion(String observacionPlanificacion) {
		this.observacionPlanificacion = observacionPlanificacion;
	}

	/**
	 * @return the totalAutoEval
	 */
	public Double getTotalAutoEval() {
		return totalAutoEval;
	}

	/**
	 * @return the totalCoeEval
	 */
	public Double getTotalCoeEval() {
		return totalCoeEval;
	}

	/**
	 * @return the totalHeteroEval
	 */
	public Double getTotalHeteroEval() {
		return totalHeteroEval;
	}

	/**
	 * @return the totalHorasPlanificacion
	 */
	public Double getTotalHorasPlanificacion() {
		return totalHorasPlanificacion;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @return the pathContrato
	 */
	public String getPathContrato() {
		return pathContrato;
	}

	/**
	 * @return the semanasDocDentro
	 */
	public double getSemanasDocDentro() {
		return semanasDocDentro;
	}

	/**
	 * @param totalAutoEval the totalAutoEval to set
	 */
	public void setTotalAutoEval(Double totalAutoEval) {
		this.totalAutoEval = totalAutoEval;
	}

	/**
	 * @param totalCoeEval the totalCoeEval to set
	 */
	public void setTotalCoeEval(Double totalCoeEval) {
		this.totalCoeEval = totalCoeEval;
	}

	/**
	 * @param totalHeteroEval the totalHeteroEval to set
	 */
	public void setTotalHeteroEval(Double totalHeteroEval) {
		this.totalHeteroEval = totalHeteroEval;
	}

	/**
	 * @param totalHorasPlanificacion the totalHorasPlanificacion to set
	 */
	public void setTotalHorasPlanificacion(Double totalHorasPlanificacion) {
		this.totalHorasPlanificacion = totalHorasPlanificacion;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @param pathContrato the pathContrato to set
	 */
	public void setPathContrato(String pathContrato) {
		this.pathContrato = pathContrato;
	}

	/**
	 * @param semanasDocDentro the semanasDocDentro to set
	 */
	public void setSemanasDocDentro(double semanasDocDentro) {
		this.semanasDocDentro = semanasDocDentro;
	}

	/**
	 * @return the presentacion
	 */
	public boolean isPresentacion() {
		return presentacion;
	}

	/**
	 * @param presentacion the presentacion to set
	 */
	public void setPresentacion(boolean presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * @return the existePeriodo
	 */
	public boolean isExistePeriodo() {
		return existePeriodo;
	}

	/**
	 * @param existePeriodo the existePeriodo to set
	 */
	public void setExistePeriodo(boolean existePeriodo) {
		this.existePeriodo = existePeriodo;
	}

	/**
	 * @return the tipoEval2
	 */
	public String getTipoEval2() {
		return tipoEval2;
	}

	/**
	 * @return the autoDocencia
	 */
	public Double getAutoDocencia() {
		return autoDocencia;
	}

	/**
	 * @return the autoInvestigacion
	 */
	public Double getAutoInvestigacion() {
		return autoInvestigacion;
	}

	/**
	 * @return the autoGestion
	 */
	public Double getAutoGestion() {
		return autoGestion;
	}

	/**
	 * @return the coeDocencia
	 */
	public Double getCoeDocencia() {
		return coeDocencia;
	}

	/**
	 * @return the coeInvestigacion
	 */
	public Double getCoeInvestigacion() {
		return coeInvestigacion;
	}

	/**
	 * @return the coeGestion
	 */
	public Double getCoeGestion() {
		return coeGestion;
	}

	/**
	 * @return the horasEjecutadas
	 */
	public Double getHorasEjecutadas() {
		return horasEjecutadas;
	}

	/**
	 * @return the horasPlanificadas
	 */
	public Double getHorasPlanificadas() {
		return horasPlanificadas;
	}

	/**
	 * @return the dedicacionHrsDoc
	 */
	public Double getDedicacionHrsDoc() {
		return dedicacionHrsDoc;
	}

	/**
	 * @return the dedicacionHrsInv
	 */
	public Double getDedicacionHrsInv() {
		return dedicacionHrsInv;
	}

	/**
	 * @return the dedicacionHrsGest
	 */
	public Double getDedicacionHrsGest() {
		return dedicacionHrsGest;
	}

	/**
	 * @return the dedicacionPorcentajeDoc
	 */
	public Double getDedicacionPorcentajeDoc() {
		return dedicacionPorcentajeDoc;
	}

	/**
	 * @return the dedicacionPorcentajeInv
	 */
	public Double getDedicacionPorcentajeInv() {
		return dedicacionPorcentajeInv;
	}

	/**
	 * @return the dedicacionPorcentajeGest
	 */
	public Double getDedicacionPorcentajeGest() {
		return dedicacionPorcentajeGest;
	}

	/**
	 * @return the calfPonderadaDoc
	 */
	public Double getCalfPonderadaDoc() {
		return calfPonderadaDoc;
	}

	/**
	 * @return the calfPonderadaInv
	 */
	public Double getCalfPonderadaInv() {
		return calfPonderadaInv;
	}

	/**
	 * @return the calfPonderadaGest
	 */
	public Double getCalfPonderadaGest() {
		return calfPonderadaGest;
	}

	/**
	 * @return the calificacionFInal
	 */
	public Double getCalificacionFInal() {
		return calificacionFInal;
	}

	/**
	 * @return the totalHeteroEvalDecimal
	 */
	public BigDecimal getTotalHeteroEvalDecimal() {
		return totalHeteroEvalDecimal;
	}

	/**
	 * @return the autoDocenciaDecimal
	 */
	public BigDecimal getAutoDocenciaDecimal() {
		return autoDocenciaDecimal;
	}

	/**
	 * @return the autoInvestigacionDecimal
	 */
	public BigDecimal getAutoInvestigacionDecimal() {
		return autoInvestigacionDecimal;
	}

	/**
	 * @return the autoGestionDecimal
	 */
	public BigDecimal getAutoGestionDecimal() {
		return autoGestionDecimal;
	}

	/**
	 * @return the coeDocenciaDecimal
	 */
	public BigDecimal getCoeDocenciaDecimal() {
		return coeDocenciaDecimal;
	}

	/**
	 * @return the coeInvestigacionDecimal
	 */
	public BigDecimal getCoeInvestigacionDecimal() {
		return coeInvestigacionDecimal;
	}

	/**
	 * @return the coeGestionDecimal
	 */
	public BigDecimal getCoeGestionDecimal() {
		return coeGestionDecimal;
	}

	/**
	 * @return the horasEjecutadasDecimal
	 */
	public BigDecimal getHorasEjecutadasDecimal() {
		return horasEjecutadasDecimal;
	}

	/**
	 * @return the totalHorasPlanificadasDecimal
	 */
	public BigDecimal getTotalHorasPlanificadasDecimal() {
		return totalHorasPlanificadasDecimal;
	}

	/**
	 * @return the dedicacionHrsDocDecimal
	 */
	public BigDecimal getDedicacionHrsDocDecimal() {
		return dedicacionHrsDocDecimal;
	}

	/**
	 * @return the dedicacionHrsInvDecimal
	 */
	public BigDecimal getDedicacionHrsInvDecimal() {
		return dedicacionHrsInvDecimal;
	}

	/**
	 * @return the dedicacionHrsGestDecimal
	 */
	public BigDecimal getDedicacionHrsGestDecimal() {
		return dedicacionHrsGestDecimal;
	}

	/**
	 * @return the dedicacionPorcentajeDocDecimal
	 */
	public BigDecimal getDedicacionPorcentajeDocDecimal() {
		return dedicacionPorcentajeDocDecimal;
	}

	/**
	 * @return the dedicacionPorcentajeInvDecimal
	 */
	public BigDecimal getDedicacionPorcentajeInvDecimal() {
		return dedicacionPorcentajeInvDecimal;
	}

	/**
	 * @return the dedicacionPorcentajeGestDecimal
	 */
	public BigDecimal getDedicacionPorcentajeGestDecimal() {
		return dedicacionPorcentajeGestDecimal;
	}

	/**
	 * @return the calfPonderadaDocDecimal
	 */
	public BigDecimal getCalfPonderadaDocDecimal() {
		return calfPonderadaDocDecimal;
	}

	/**
	 * @return the calfPonderadaInvDecimal
	 */
	public BigDecimal getCalfPonderadaInvDecimal() {
		return calfPonderadaInvDecimal;
	}

	/**
	 * @return the calfPonderadaGestDecimal
	 */
	public BigDecimal getCalfPonderadaGestDecimal() {
		return calfPonderadaGestDecimal;
	}

	/**
	 * @return the calificacionFInalDecimal
	 */
	public BigDecimal getCalificacionFInalDecimal() {
		return calificacionFInalDecimal;
	}

	/**
	 * @return the totalHorasExigiblesDecimal
	 */
	public BigDecimal getTotalHorasExigiblesDecimal() {
		return totalHorasExigiblesDecimal;
	}

	/**
	 * @return the totalAutoEvalDecimal
	 */
	public BigDecimal getTotalAutoEvalDecimal() {
		return totalAutoEvalDecimal;
	}

	/**
	 * @return the totalCoeEvalDecimal
	 */
	public BigDecimal getTotalCoeEvalDecimal() {
		return totalCoeEvalDecimal;
	}

	/**
	 * @return the horasPlanificadasDocenciaDecimal
	 */
	public BigDecimal getHorasPlanificadasDocenciaDecimal() {
		return horasPlanificadasDocenciaDecimal;
	}

	/**
	 * @return the horasPlanificadasInvestDecimal
	 */
	public BigDecimal getHorasPlanificadasInvestDecimal() {
		return horasPlanificadasInvestDecimal;
	}

	/**
	 * @return the horasPlanificadasGestDecimal
	 */
	public BigDecimal getHorasPlanificadasGestDecimal() {
		return horasPlanificadasGestDecimal;
	}

	/**
	 * @return the horasPlanifDocDentroDecimal
	 */
	public BigDecimal getHorasPlanifDocDentroDecimal() {
		return horasPlanifDocDentroDecimal;
	}

	/**
	 * @return the horasPlanifDocFueraDecimal
	 */
	public BigDecimal getHorasPlanifDocFueraDecimal() {
		return horasPlanifDocFueraDecimal;
	}

	/**
	 * @return the horasPlanifClasesDecimal
	 */
	public BigDecimal getHorasPlanifClasesDecimal() {
		return horasPlanifClasesDecimal;
	}

	/**
	 * @return the renderVerEvalFinal
	 */
	public boolean isRenderVerEvalFinal() {
		return renderVerEvalFinal;
	}

	/**
	 * @return the cargoDocente
	 */
	public String getCargoDocente() {
		return cargoDocente;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the justificacionHorasPlanif
	 */
	public String getJustificacionHorasPlanif() {
		return justificacionHorasPlanif;
	}

	/**
	 * @param tipoEval2 the tipoEval2 to set
	 */
	public void setTipoEval2(String tipoEval2) {
		this.tipoEval2 = tipoEval2;
	}

	/**
	 * @param autoDocencia the autoDocencia to set
	 */
	public void setAutoDocencia(Double autoDocencia) {
		this.autoDocencia = autoDocencia;
	}

	/**
	 * @param autoInvestigacion the autoInvestigacion to set
	 */
	public void setAutoInvestigacion(Double autoInvestigacion) {
		this.autoInvestigacion = autoInvestigacion;
	}

	/**
	 * @param autoGestion the autoGestion to set
	 */
	public void setAutoGestion(Double autoGestion) {
		this.autoGestion = autoGestion;
	}

	/**
	 * @param coeDocencia the coeDocencia to set
	 */
	public void setCoeDocencia(Double coeDocencia) {
		this.coeDocencia = coeDocencia;
	}

	/**
	 * @param coeInvestigacion the coeInvestigacion to set
	 */
	public void setCoeInvestigacion(Double coeInvestigacion) {
		this.coeInvestigacion = coeInvestigacion;
	}

	/**
	 * @param coeGestion the coeGestion to set
	 */
	public void setCoeGestion(Double coeGestion) {
		this.coeGestion = coeGestion;
	}

	/**
	 * @param horasEjecutadas the horasEjecutadas to set
	 */
	public void setHorasEjecutadas(Double horasEjecutadas) {
		this.horasEjecutadas = horasEjecutadas;
	}

	/**
	 * @param horasPlanificadas the horasPlanificadas to set
	 */
	public void setHorasPlanificadas(Double horasPlanificadas) {
		this.horasPlanificadas = horasPlanificadas;
	}

	/**
	 * @param dedicacionHrsDoc the dedicacionHrsDoc to set
	 */
	public void setDedicacionHrsDoc(Double dedicacionHrsDoc) {
		this.dedicacionHrsDoc = dedicacionHrsDoc;
	}

	/**
	 * @param dedicacionHrsInv the dedicacionHrsInv to set
	 */
	public void setDedicacionHrsInv(Double dedicacionHrsInv) {
		this.dedicacionHrsInv = dedicacionHrsInv;
	}

	/**
	 * @param dedicacionHrsGest the dedicacionHrsGest to set
	 */
	public void setDedicacionHrsGest(Double dedicacionHrsGest) {
		this.dedicacionHrsGest = dedicacionHrsGest;
	}

	/**
	 * @param dedicacionPorcentajeDoc the dedicacionPorcentajeDoc to set
	 */
	public void setDedicacionPorcentajeDoc(Double dedicacionPorcentajeDoc) {
		this.dedicacionPorcentajeDoc = dedicacionPorcentajeDoc;
	}

	/**
	 * @param dedicacionPorcentajeInv the dedicacionPorcentajeInv to set
	 */
	public void setDedicacionPorcentajeInv(Double dedicacionPorcentajeInv) {
		this.dedicacionPorcentajeInv = dedicacionPorcentajeInv;
	}

	/**
	 * @param dedicacionPorcentajeGest the dedicacionPorcentajeGest to set
	 */
	public void setDedicacionPorcentajeGest(Double dedicacionPorcentajeGest) {
		this.dedicacionPorcentajeGest = dedicacionPorcentajeGest;
	}

	/**
	 * @param calfPonderadaDoc the calfPonderadaDoc to set
	 */
	public void setCalfPonderadaDoc(Double calfPonderadaDoc) {
		this.calfPonderadaDoc = calfPonderadaDoc;
	}

	/**
	 * @param calfPonderadaInv the calfPonderadaInv to set
	 */
	public void setCalfPonderadaInv(Double calfPonderadaInv) {
		this.calfPonderadaInv = calfPonderadaInv;
	}

	/**
	 * @param calfPonderadaGest the calfPonderadaGest to set
	 */
	public void setCalfPonderadaGest(Double calfPonderadaGest) {
		this.calfPonderadaGest = calfPonderadaGest;
	}

	/**
	 * @param calificacionFInal the calificacionFInal to set
	 */
	public void setCalificacionFInal(Double calificacionFInal) {
		this.calificacionFInal = calificacionFInal;
	}

	/**
	 * @param totalHeteroEvalDecimal the totalHeteroEvalDecimal to set
	 */
	public void setTotalHeteroEvalDecimal(BigDecimal totalHeteroEvalDecimal) {
		this.totalHeteroEvalDecimal = totalHeteroEvalDecimal;
	}

	/**
	 * @param autoDocenciaDecimal the autoDocenciaDecimal to set
	 */
	public void setAutoDocenciaDecimal(BigDecimal autoDocenciaDecimal) {
		this.autoDocenciaDecimal = autoDocenciaDecimal;
	}

	/**
	 * @param autoInvestigacionDecimal the autoInvestigacionDecimal to set
	 */
	public void setAutoInvestigacionDecimal(BigDecimal autoInvestigacionDecimal) {
		this.autoInvestigacionDecimal = autoInvestigacionDecimal;
	}

	/**
	 * @param autoGestionDecimal the autoGestionDecimal to set
	 */
	public void setAutoGestionDecimal(BigDecimal autoGestionDecimal) {
		this.autoGestionDecimal = autoGestionDecimal;
	}

	/**
	 * @param coeDocenciaDecimal the coeDocenciaDecimal to set
	 */
	public void setCoeDocenciaDecimal(BigDecimal coeDocenciaDecimal) {
		this.coeDocenciaDecimal = coeDocenciaDecimal;
	}

	/**
	 * @param coeInvestigacionDecimal the coeInvestigacionDecimal to set
	 */
	public void setCoeInvestigacionDecimal(BigDecimal coeInvestigacionDecimal) {
		this.coeInvestigacionDecimal = coeInvestigacionDecimal;
	}

	/**
	 * @param coeGestionDecimal the coeGestionDecimal to set
	 */
	public void setCoeGestionDecimal(BigDecimal coeGestionDecimal) {
		this.coeGestionDecimal = coeGestionDecimal;
	}

	/**
	 * @param horasEjecutadasDecimal the horasEjecutadasDecimal to set
	 */
	public void setHorasEjecutadasDecimal(BigDecimal horasEjecutadasDecimal) {
		this.horasEjecutadasDecimal = horasEjecutadasDecimal;
	}

	/**
	 * @param totalHorasPlanificadasDecimal the totalHorasPlanificadasDecimal to set
	 */
	public void setTotalHorasPlanificadasDecimal(BigDecimal totalHorasPlanificadasDecimal) {
		this.totalHorasPlanificadasDecimal = totalHorasPlanificadasDecimal;
	}

	/**
	 * @param dedicacionHrsDocDecimal the dedicacionHrsDocDecimal to set
	 */
	public void setDedicacionHrsDocDecimal(BigDecimal dedicacionHrsDocDecimal) {
		this.dedicacionHrsDocDecimal = dedicacionHrsDocDecimal;
	}

	/**
	 * @param dedicacionHrsInvDecimal the dedicacionHrsInvDecimal to set
	 */
	public void setDedicacionHrsInvDecimal(BigDecimal dedicacionHrsInvDecimal) {
		this.dedicacionHrsInvDecimal = dedicacionHrsInvDecimal;
	}

	/**
	 * @param dedicacionHrsGestDecimal the dedicacionHrsGestDecimal to set
	 */
	public void setDedicacionHrsGestDecimal(BigDecimal dedicacionHrsGestDecimal) {
		this.dedicacionHrsGestDecimal = dedicacionHrsGestDecimal;
	}

	/**
	 * @param dedicacionPorcentajeDocDecimal the dedicacionPorcentajeDocDecimal to set
	 */
	public void setDedicacionPorcentajeDocDecimal(BigDecimal dedicacionPorcentajeDocDecimal) {
		this.dedicacionPorcentajeDocDecimal = dedicacionPorcentajeDocDecimal;
	}

	/**
	 * @param dedicacionPorcentajeInvDecimal the dedicacionPorcentajeInvDecimal to set
	 */
	public void setDedicacionPorcentajeInvDecimal(BigDecimal dedicacionPorcentajeInvDecimal) {
		this.dedicacionPorcentajeInvDecimal = dedicacionPorcentajeInvDecimal;
	}

	/**
	 * @param dedicacionPorcentajeGestDecimal the dedicacionPorcentajeGestDecimal to set
	 */
	public void setDedicacionPorcentajeGestDecimal(BigDecimal dedicacionPorcentajeGestDecimal) {
		this.dedicacionPorcentajeGestDecimal = dedicacionPorcentajeGestDecimal;
	}

	/**
	 * @param calfPonderadaDocDecimal the calfPonderadaDocDecimal to set
	 */
	public void setCalfPonderadaDocDecimal(BigDecimal calfPonderadaDocDecimal) {
		this.calfPonderadaDocDecimal = calfPonderadaDocDecimal;
	}

	/**
	 * @param calfPonderadaInvDecimal the calfPonderadaInvDecimal to set
	 */
	public void setCalfPonderadaInvDecimal(BigDecimal calfPonderadaInvDecimal) {
		this.calfPonderadaInvDecimal = calfPonderadaInvDecimal;
	}

	/**
	 * @param calfPonderadaGestDecimal the calfPonderadaGestDecimal to set
	 */
	public void setCalfPonderadaGestDecimal(BigDecimal calfPonderadaGestDecimal) {
		this.calfPonderadaGestDecimal = calfPonderadaGestDecimal;
	}

	/**
	 * @param calificacionFInalDecimal the calificacionFInalDecimal to set
	 */
	public void setCalificacionFInalDecimal(BigDecimal calificacionFInalDecimal) {
		this.calificacionFInalDecimal = calificacionFInalDecimal;
	}

	/**
	 * @param totalHorasExigiblesDecimal the totalHorasExigiblesDecimal to set
	 */
	public void setTotalHorasExigiblesDecimal(BigDecimal totalHorasExigiblesDecimal) {
		this.totalHorasExigiblesDecimal = totalHorasExigiblesDecimal;
	}

	/**
	 * @param totalAutoEvalDecimal the totalAutoEvalDecimal to set
	 */
	public void setTotalAutoEvalDecimal(BigDecimal totalAutoEvalDecimal) {
		this.totalAutoEvalDecimal = totalAutoEvalDecimal;
	}

	/**
	 * @param totalCoeEvalDecimal the totalCoeEvalDecimal to set
	 */
	public void setTotalCoeEvalDecimal(BigDecimal totalCoeEvalDecimal) {
		this.totalCoeEvalDecimal = totalCoeEvalDecimal;
	}

	/**
	 * @param horasPlanificadasDocenciaDecimal the horasPlanificadasDocenciaDecimal to set
	 */
	public void setHorasPlanificadasDocenciaDecimal(BigDecimal horasPlanificadasDocenciaDecimal) {
		this.horasPlanificadasDocenciaDecimal = horasPlanificadasDocenciaDecimal;
	}

	/**
	 * @param horasPlanificadasInvestDecimal the horasPlanificadasInvestDecimal to set
	 */
	public void setHorasPlanificadasInvestDecimal(BigDecimal horasPlanificadasInvestDecimal) {
		this.horasPlanificadasInvestDecimal = horasPlanificadasInvestDecimal;
	}

	/**
	 * @param horasPlanificadasGestDecimal the horasPlanificadasGestDecimal to set
	 */
	public void setHorasPlanificadasGestDecimal(BigDecimal horasPlanificadasGestDecimal) {
		this.horasPlanificadasGestDecimal = horasPlanificadasGestDecimal;
	}

	/**
	 * @param horasPlanifDocDentroDecimal the horasPlanifDocDentroDecimal to set
	 */
	public void setHorasPlanifDocDentroDecimal(BigDecimal horasPlanifDocDentroDecimal) {
		this.horasPlanifDocDentroDecimal = horasPlanifDocDentroDecimal;
	}

	/**
	 * @param horasPlanifDocFueraDecimal the horasPlanifDocFueraDecimal to set
	 */
	public void setHorasPlanifDocFueraDecimal(BigDecimal horasPlanifDocFueraDecimal) {
		this.horasPlanifDocFueraDecimal = horasPlanifDocFueraDecimal;
	}

	/**
	 * @param horasPlanifClasesDecimal the horasPlanifClasesDecimal to set
	 */
	public void setHorasPlanifClasesDecimal(BigDecimal horasPlanifClasesDecimal) {
		this.horasPlanifClasesDecimal = horasPlanifClasesDecimal;
	}

	/**
	 * @param renderVerEvalFinal the renderVerEvalFinal to set
	 */
	public void setRenderVerEvalFinal(boolean renderVerEvalFinal) {
		this.renderVerEvalFinal = renderVerEvalFinal;
	}

	/**
	 * @param cargoDocente the cargoDocente to set
	 */
	public void setCargoDocente(String cargoDocente) {
		this.cargoDocente = cargoDocente;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param justificacionHorasPlanif the justificacionHorasPlanif to set
	 */
	public void setJustificacionHorasPlanif(String justificacionHorasPlanif) {
		this.justificacionHorasPlanif = justificacionHorasPlanif;
	}

	/**
	 * @return the idEvalAcad
	 */
	public Integer getIdEvalAcad() {
		return idEvalAcad;
	}

	/**
	 * @param idEvalAcad the idEvalAcad to set
	 */
	public void setIdEvalAcad(Integer idEvalAcad) {
		this.idEvalAcad = idEvalAcad;
	}

	/**
	 * @return the renderVerPlanif
	 */
	public boolean isRenderVerPlanif() {
		return renderVerPlanif;
	}

	/**
	 * @return the renderVerAuto
	 */
	public boolean isRenderVerAuto() {
		return renderVerAuto;
	}

	/**
	 * @return the renderVerCoe
	 */
	public boolean isRenderVerCoe() {
		return renderVerCoe;
	}

	/**
	 * @param renderVerPlanif the renderVerPlanif to set
	 */
	public void setRenderVerPlanif(boolean renderVerPlanif) {
		this.renderVerPlanif = renderVerPlanif;
	}

	/**
	 * @param renderVerAuto the renderVerAuto to set
	 */
	public void setRenderVerAuto(boolean renderVerAuto) {
		this.renderVerAuto = renderVerAuto;
	}

	/**
	 * @param renderVerCoe the renderVerCoe to set
	 */
	public void setRenderVerCoe(boolean renderVerCoe) {
		this.renderVerCoe = renderVerCoe;
	}

}
