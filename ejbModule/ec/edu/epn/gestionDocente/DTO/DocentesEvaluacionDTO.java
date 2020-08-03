package ec.edu.epn.gestionDocente.DTO;


public class DocentesEvaluacionDTO {
	
	private String cedula;	
	private String nombre;
	private String apellido;
	private String cargo;
	private String nomDepartamento;
	private String relacionLab;
	private String periodo;
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


}	
