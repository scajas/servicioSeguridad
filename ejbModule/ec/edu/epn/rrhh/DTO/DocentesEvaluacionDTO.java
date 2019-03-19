package ec.edu.epn.rrhh.DTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DocentesEvaluacionDTO {
	
	
	private Integer idEvalAcad;
	private String cedula;	
	private String nombre;
	private String apellido;
	private String cargo;
	private String nomDepartamento;
	private String relacionLab;
	private String periodo;
	private String estado;
	private String cargaAcademica;
	private String direccionTesis;
	private String idPeriodo;
	private String fechaIngresoEPN;
	private String tipoEval;
	private String tipoEval2;
	private String tipoDocente;
	private String docencia;
	private String investigacion; 
	private String gestion; 
	private String notaFinal;
	private String aprobEstudiantes;
	private Double totalAutoEval;
	private Double totalCoeEval;
	private Double totalHeteroEval;
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
	
	
	
	/**CAMPOS ADICIONALES*/
	private String cargoDocente; 
	private String dedicacion;
	private String tipo;
	
	
	
	public DocentesEvaluacionDTO(){
		
		
	}
	
	
	public void inicializarDatos(){
		try {
			cedula= "";	
			nombre= "";
			apellido= "";
			cargo= "";
			nomDepartamento="";
			relacionLab="";
			periodo="";
			cargaAcademica="";
			direccionTesis="";
			idPeriodo="";
			fechaIngresoEPN="";
			tipoEval="";
			tipoEval2="";
			tipoDocente="";
			docencia="";
			investigacion=""; 
			gestion="";
			notaFinal="";
			aprobEstudiantes="";
		} catch (Exception e) {
			
		}
	}

	
	public DocentesEvaluacionDTO(String cedula, String nombre, String apellido, String cargo, String cargaAcademica, String direccionTesis,
			String nomDepartamento, String relacionLab,  String periodo, String idPeriodo, String tipoEval, String fechaIngresoEPN,
			String tipoEval2, String tipoDocente) {
		super();
		
		this.cedula= cedula;
		this.nombre= nombre;
		this.apellido= apellido;
		this.cargo= cargo;
		this.cargaAcademica= cargaAcademica;
		this.direccionTesis= direccionTesis;
		this.nomDepartamento= nomDepartamento;
		this.relacionLab= relacionLab;
		this.periodo= periodo;
		this.idPeriodo= idPeriodo;
		this.fechaIngresoEPN= fechaIngresoEPN;
		this.tipoEval= tipoEval;
		this.tipoEval2= tipoEval2;
		this.tipoDocente= tipoDocente;
		
	}
	
	
	public DocentesEvaluacionDTO(String cedula, String nombre, String apellido, String cargo, String nomDepartamento, 
						String relacionLab, String periodo, String docencia, String investigacion, String gestion,
						String notaFinal, String aprobEstudiantes) {
		super();
		
		this.cedula= cedula;
		this.nombre= nombre;
		this.apellido= apellido;
		this.cargo= cargo;		
		this.nomDepartamento= nomDepartamento;
		this.relacionLab= relacionLab;
		this.periodo= periodo;
		this.notaFinal= notaFinal;
		this.docencia= docencia;
		this.investigacion= investigacion;
		this.gestion= gestion;
		this.aprobEstudiantes= aprobEstudiantes;
		
		
	}


	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}


	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}


	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}


	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	/**
	 * @return the cargaAcademica
	 */
	public String getCargaAcademica() {
		return cargaAcademica;
	}


	/**
	 * @param cargaAcademica the cargaAcademica to set
	 */
	public void setCargaAcademica(String cargaAcademica) {
		this.cargaAcademica = cargaAcademica;
	}


	/**
	 * @return the direccionTesis
	 */
	public String getDireccionTesis() {
		return direccionTesis;
	}


	/**
	 * @param direccionTesis the direccionTesis to set
	 */
	public void setDireccionTesis(String direccionTesis) {
		this.direccionTesis = direccionTesis;
	}


	/**
	 * @return the nomDepartamento
	 */
	public String getNomDepartamento() {
		return nomDepartamento;
	}


	/**
	 * @param nomDepartamento the nomDepartamento to set
	 */
	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}


	/**
	 * @return the relacionLab
	 */
	public String getRelacionLab() {
		return relacionLab;
	}


	/**
	 * @param relacionLab the relacionLab to set
	 */
	public void setRelacionLab(String relacionLab) {
		this.relacionLab = relacionLab;
	}


	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}


	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	/**
	 * @return the idPeriodo
	 */
	public String getIdPeriodo() {
		return idPeriodo;
	}


	/**
	 * @param idPeriodo the idPeriodo to set
	 */
	public void setIdPeriodo(String idPeriodo) {
		this.idPeriodo = idPeriodo;
	}


	/**
	 * @return the fechaIngresoEPN
	 */
	public String getFechaIngresoEPN() {
		return fechaIngresoEPN;
	}


	/**
	 * @param fechaIngresoEPN the fechaIngresoEPN to set
	 */
	public void setFechaIngresoEPN(String fechaIngresoEPN) {
		this.fechaIngresoEPN = fechaIngresoEPN;
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
	 * @return the tipoEval2
	 */
	public String getTipoEval2() {
		return tipoEval2;
	}


	/**
	 * @param tipoEval2 the tipoEval2 to set
	 */
	public void setTipoEval2(String tipoEval2) {
		this.tipoEval2 = tipoEval2;
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
	 * @return the docencia
	 */
	public String getDocencia() {
		return docencia;
	}


	/**
	 * @return the investigacion
	 */
	public String getInvestigacion() {
		return investigacion;
	}


	/**
	 * @return the gestion
	 */
	public String getGestion() {
		return gestion;
	}


	/**
	 * @return the notaFinal
	 */
	public String getNotaFinal() {
		return notaFinal;
	}


	/**
	 * @return the aprobEstudiantes
	 */
	public String getAprobEstudiantes() {
		return aprobEstudiantes;
	}


	/**
	 * @param docencia the docencia to set
	 */
	public void setDocencia(String docencia) {
		this.docencia = docencia;
	}


	/**
	 * @param investigacion the investigacion to set
	 */
	public void setInvestigacion(String investigacion) {
		this.investigacion = investigacion;
	}


	/**
	 * @param gestion the gestion to set
	 */
	public void setGestion(String gestion) {
		this.gestion = gestion;
	}


	/**
	 * @param notaFinal the notaFinal to set
	 */
	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}


	/**
	 * @param aprobEstudiantes the aprobEstudiantes to set
	 */
	public void setAprobEstudiantes(String aprobEstudiantes) {
		this.aprobEstudiantes = aprobEstudiantes;
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
	 * @return the totalHorasExigiblesDecimal
	 */
	public BigDecimal getTotalHorasExigiblesDecimal() {
		return totalHorasExigiblesDecimal;
	}


	/**
	 * @param totalHorasExigiblesDecimal the totalHorasExigiblesDecimal to set
	 */
	public void setTotalHorasExigiblesDecimal(BigDecimal totalHorasExigiblesDecimal) {
		this.totalHorasExigiblesDecimal = totalHorasExigiblesDecimal;
	}


	/**
	 * @return the renderVerEvalFinal
	 */
	public boolean isRenderVerEvalFinal() {
		return renderVerEvalFinal;
	}


	/**
	 * @param renderVerEvalFinal the renderVerEvalFinal to set
	 */
	public void setRenderVerEvalFinal(boolean renderVerEvalFinal) {
		this.renderVerEvalFinal = renderVerEvalFinal;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
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
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}


	/**
	 * @param dedicacion the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}


}	
