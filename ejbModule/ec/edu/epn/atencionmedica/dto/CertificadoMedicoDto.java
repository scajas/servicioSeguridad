package ec.edu.epn.atencionmedica.dto;

import java.util.Date;

public class CertificadoMedicoDto {
	
	private String varPaciente;
	private String varCedula;
	private String varDiagnostico;
	private String varCIE;
	private Integer varHoras;
	private Date varDesde;
	private Date varHasta;
	private String varNombreMedico;
	private String varCodigoMsp;
	private String varCedulaMedico;
	
	private Integer varHistoriaClinica;
	private String varApellidos;
	private String varNombres;
	private String varEspecialidad;	
	private String varPedidoExamen;
	
	//variables para examenes
	
	private String varBiometriaHematica;
	private String varPlaquetas;
	private String varGrupoRh;
	private String varReticulositos;
	private String varHematozoario;
	private String varCelula;
	private String varIndicesHematicos;
	private String varTProtrombina;
	private String varTiempoTParcial;
	private String varDrepanocitos;
	private String varCoombsDirecto;
	private String varCoombsIndirecto;
	
	private String varGlucosaEnAyunas;
	private String varGlucosa2Horas;
	private String varUrea;
	private String varCreatinina;
	private String varAcidoUrico;
	private String varBilirrubinas;
	private String varProteinas;
	private String varTransaminadaPiruvica;
	private String varTransaminsaOxalacetica;
	private String varFosfatasaAlcalina;
	private String varColesterolTotal;
	private String varColesterolHdl;
	private String varColesterolLdl;
	private String varTrigliceridos;
	
	private String varCoproparasitario;
	private String varSangreOculta;
	private String varInvPolimorfoNucleares;
	private String varRotavirus;
	
	private String varElementalMicroscopica;
	private String varGotaFresca;
	private String varGram;
	private String varPruebaEmbarazo;
	private String varCultivoAntibiograma;
	
	private String varGramBacteriologia;
	private String varZiehl;
	private String varHongos;
	private String varFresco;
	private String varCultivoAntibiogramaBacteriologia;
	
	private String varOtros;	
	
	private String varMotivo;
	private String varExamenFisico;
	private String varCIEDiagDefinitivo;
	
	private String varDescribirExamen;
	
	private String varRxConvencional;
	private String varTomografia;
	private String varResonancia;
	private String varEcografia;
	private String varProcedimiento;	
	
	private String varDiagPresuntivo;
	private String varDiagDefinitivo;
	
	
	public CertificadoMedicoDto() {
		super();
	}
	
	//Constructor para generar el certificado medico
	public CertificadoMedicoDto(String varPaciente, String varCedula, String varDiagnostico, String varCIE,
			Integer varHoras, Date varDesde, Date varHasta, String varNombreMedico, String varCodigoMsp, String varCedulaMedico) {
		super();
		this.varPaciente = varPaciente;
		this.varCedula = varCedula;
		this.varDiagnostico = varDiagnostico;
		this.varCIE = varCIE;
		this.varHoras = varHoras;
		this.varDesde = varDesde;
		this.varHasta = varHasta;
		this.varNombreMedico = varNombreMedico;
		this.varCodigoMsp = varCodigoMsp;
		this.varCedulaMedico= varCedulaMedico;
	}

	//Constructor para generar el certificado medico
	public CertificadoMedicoDto(String varPaciente, String varCedula, String varDiagnostico, String varCIE,
			Integer varHoras, Date varDesde, String varNombreMedico, String varCodigoMsp, String varCedulaMedico) {
		super();
		this.varPaciente = varPaciente;
		this.varCedula = varCedula;
		this.varDiagnostico = varDiagnostico;
		this.varCIE = varCIE;
		this.varHoras = varHoras;
		this.varDesde = varDesde;
		this.varNombreMedico = varNombreMedico;
		this.varCodigoMsp = varCodigoMsp;
		this.varCedulaMedico= varCedulaMedico;
	}
		
	
	//Constructor para generar el pedido de examen
	public CertificadoMedicoDto(String varCedula, Integer varHistoriaClinica,  String varApellidos,
			String varNombres, Date varDesde,  String varEspecialidad, String varNombreMedico, String varPedidoExamen, String varOtros, String varCodigoMsp, String varCedulaMedico) {
		super();
		this.varCedula = varCedula;
		this.varHistoriaClinica = varHistoriaClinica;
		this.varApellidos = varApellidos;
		this.varNombres = varNombres;
		this.varDesde = varDesde;
		this.varEspecialidad = varEspecialidad;
		this.varNombreMedico = varNombreMedico;		
		this.varPedidoExamen = varPedidoExamen;
		this.varOtros = varOtros;
		this.varCodigoMsp = varCodigoMsp;
		this.varCedulaMedico= varCedulaMedico;
	}
	
	//Constructor para generar el pedido de examen
	public CertificadoMedicoDto(String varCedula, Integer varHistoriaClinica,  String varApellidos,
			String varNombres, Date varDesde,  String varEspecialidad, String varNombreMedico, String varBiometriaHematica, String varPlaquetas,
			String varGrupoRh, String varReticulositos, String varHematozoario, String varCelula, String varIndicesHematicos, String varTProtrombina,
			String varTiempoTParcial, String varDrepanocitos, String varCoombsDirecto, String varCoombsIndirecto,
			String varGlucosaEnAyunas, String varGlucosa2Horas, String varUrea, String varCreatinina, String varAcidoUrico, String varBilirrubinas,
			String varProteinas, String varTransaminadaPiruvica, String varTransaminsaOxalacetica, String varFosfatasaAlcalina, String varColesterolTotal,
			String varColesterolHdl, String varColesterolLdl, String varTrigliceridos,
			String varCoproparasitario, String varSangreOculta, String varInvPolimorfoNucleares, String varRotavirus,
			String varElementalMicroscopica, String varGotaFresca, String varGram, String varPruebaEmbarazo, String varCultivoAntibiograma,
			String varGramBacteriologia, String varZiehl, String varHongos, String varFresco, String varCultivoAntibiogramaBacteriologia, String varOtros,
			String varCodigoMsp, String varCedulaMedico) {
		super();
		this.varCedula = varCedula;
		this.varHistoriaClinica = varHistoriaClinica;
		this.varApellidos = varApellidos;
		this.varNombres = varNombres;
		this.varDesde = varDesde;
		this.varEspecialidad = varEspecialidad;
		this.varNombreMedico = varNombreMedico;		
		this.varBiometriaHematica = varBiometriaHematica;
		this.varPlaquetas = varPlaquetas;
		this.varGrupoRh = varGrupoRh;
		this.varReticulositos = varReticulositos;
		this.varHematozoario = varHematozoario;
		this.varCelula = varCelula;
		this.varIndicesHematicos = varIndicesHematicos;
		this.varTProtrombina = varTProtrombina;
		this.varTiempoTParcial = varTiempoTParcial;
		this.varDrepanocitos = varDrepanocitos;
		this.varCoombsDirecto = varCoombsDirecto;
		this.varCoombsIndirecto = varCoombsIndirecto;
		
		this.varGlucosaEnAyunas = varGlucosaEnAyunas;
		this.varGlucosa2Horas = varGlucosa2Horas;
		this.varUrea = varUrea;
		this.varCreatinina = varCreatinina;
		this.varAcidoUrico = varAcidoUrico;
		this.varBilirrubinas = varBilirrubinas;
		this.varProteinas = varProteinas;
		this.varTransaminadaPiruvica = varTransaminadaPiruvica;
		this.varTransaminsaOxalacetica = varTransaminsaOxalacetica;
		this.varFosfatasaAlcalina = varFosfatasaAlcalina;
		this.varColesterolTotal = varColesterolTotal;
		this.varColesterolHdl = varColesterolHdl;
		this.varColesterolLdl = varColesterolLdl;
		this.varTrigliceridos = varTrigliceridos;
		
		this.varCoproparasitario = varCoproparasitario;
		this.varSangreOculta = varSangreOculta;
		this.varInvPolimorfoNucleares = varInvPolimorfoNucleares;
		this.varRotavirus = varRotavirus;
		
		this.varElementalMicroscopica = varElementalMicroscopica;
		this.varGotaFresca = varGotaFresca;
		this.varGram = varGram;
		this.varPruebaEmbarazo = varPruebaEmbarazo;
		this.varCultivoAntibiograma = varCultivoAntibiograma;
		
		this.varGramBacteriologia = varGramBacteriologia;
		this.varZiehl = varZiehl;
		this.varHongos = varHongos;
		this.varFresco = varFresco;
		this.varCultivoAntibiogramaBacteriologia = varCultivoAntibiogramaBacteriologia;
		
		this.varOtros = varOtros;
		this.varCodigoMsp = varCodigoMsp;
		this.varCedulaMedico= varCedulaMedico;
	}

	//Constructor para generar el pediddo de examne de imagen
	public CertificadoMedicoDto(String varCedula, Integer varHistoriaClinica,  String varApellidos,
			String varNombres, Date varDesde,  String varEspecialidad, String varNombreMedico, String varCodigoMsp, String varMotivo, String varCIE, String varExamenFisico,
			String varCIEDiagDefinitivo, String varPedidoExamen, String varDescribirExamen, String varDiagPresuntivo, String varDiagDefinitivo, String varCedulaMedico) {
		super();
		this.varCedula = varCedula;
		this.varHistoriaClinica = varHistoriaClinica;
		this.varApellidos = varApellidos;
		this.varNombres = varNombres;
		this.varDesde = varDesde;
		this.varEspecialidad = varEspecialidad;
		this.varNombreMedico = varNombreMedico;				
		this.varCodigoMsp = varCodigoMsp;
		this.varMotivo = varMotivo;
		this.varCIE = varCIE;
		this.varExamenFisico = varExamenFisico;
		this.varCIEDiagDefinitivo = varCIEDiagDefinitivo;
		this.varPedidoExamen = varPedidoExamen;
		this.varDescribirExamen = varDescribirExamen;
		this.varDiagPresuntivo = varDiagPresuntivo;
		this.varDiagDefinitivo = varDiagDefinitivo;
		this.varCedulaMedico= varCedulaMedico;
	}
	
	//Constructor para generar el pediddo de examne de imagen
	public CertificadoMedicoDto(String varCedula, Integer varHistoriaClinica,  String varApellidos,
			String varNombres, Date varDesde,  String varEspecialidad, String varNombreMedico, String varCodigoMsp, String varMotivo, String varCIE, String varExamenFisico,
			String varCIEDiagDefinitivo, String varPedidoExamen, String varDescribirExamen, String varRxConvencional, String varTomografia, String varResonancia,
			String varEcografia, String varProcedimiento, String varOtros, String varDiagPresuntivo, String varDiagDefinitivo, String varCedulaMedico) {
		super();
		this.varCedula = varCedula;
		this.varHistoriaClinica = varHistoriaClinica;
		this.varApellidos = varApellidos;
		this.varNombres = varNombres;
		this.varDesde = varDesde;
		this.varEspecialidad = varEspecialidad;
		this.varNombreMedico = varNombreMedico;				
		this.varCodigoMsp = varCodigoMsp;
		this.varMotivo = varMotivo;
		this.varCIE = varCIE;
		this.varExamenFisico = varExamenFisico;
		this.varCIEDiagDefinitivo = varCIEDiagDefinitivo;
		this.varPedidoExamen = varPedidoExamen;
		this.varDescribirExamen = varDescribirExamen;
		this.varRxConvencional = varRxConvencional;
		this.varTomografia = varTomografia;
		this.varResonancia = varResonancia;
		this.varEcografia = varEcografia;
		this.varProcedimiento = varProcedimiento;
		this.varOtros = varOtros;
		this.varDiagPresuntivo = varDiagPresuntivo;
		this.varDiagDefinitivo = varDiagDefinitivo;
		this.varCedulaMedico= varCedulaMedico;
	}
	
	
	public String getVarPaciente() {
		return varPaciente;
	}




	public void setVarPaciente(String varPaciente) {
		this.varPaciente = varPaciente;
	}




	public String getVarCedula() {
		return varCedula;
	}




	public void setVarCedula(String varCedula) {
		this.varCedula = varCedula;
	}




	public String getVarDiagnostico() {
		return varDiagnostico;
	}




	public void setVarDiagnostico(String varDiagnostico) {
		this.varDiagnostico = varDiagnostico;
	}




	public String getVarCIE() {
		return varCIE;
	}




	public void setVarCIE(String varCIE) {
		this.varCIE = varCIE;
	}




	public Integer getVarHoras() {
		return varHoras;
	}




	public void setVarHoras(Integer varHoras) {
		this.varHoras = varHoras;
	}




	public Date getVarDesde() {
		return varDesde;
	}




	public void setVarDesde(Date varDesde) {
		this.varDesde = varDesde;
	}




	public Date getVarHasta() {
		return varHasta;
	}




	public void setVarHasta(Date varHasta) {
		this.varHasta = varHasta;
	}




	public String getVarNombreMedico() {
		return varNombreMedico;
	}




	public void setVarNombreMedico(String varNombreMedico) {
		this.varNombreMedico = varNombreMedico;
	}




	public String getVarCodigoMsp() {
		return varCodigoMsp;
	}




	public void setVarCodigoMsp(String varCodigoMsp) {
		this.varCodigoMsp = varCodigoMsp;
	}

	public Integer getVarHistoriaClinica() {
		return varHistoriaClinica;
	}

	public void setVarHistoriaClinica(Integer varHistoriaClinica) {
		this.varHistoriaClinica = varHistoriaClinica;
	}

	public String getVarApellidos() {
		return varApellidos;
	}

	public void setVarApellidos(String varApellidos) {
		this.varApellidos = varApellidos;
	}

	public String getVarNombres() {
		return varNombres;
	}

	public void setVarNombres(String varNombres) {
		this.varNombres = varNombres;
	}

	public String getVarEspecialidad() {
		return varEspecialidad;
	}

	public void setVarEspecialidad(String varEspecialidad) {
		this.varEspecialidad = varEspecialidad;
	}

	public String getVarPedidoExamen() {
		return varPedidoExamen;
	}

	public void setVarPedidoExamen(String varPedidoExamen) {
		this.varPedidoExamen = varPedidoExamen;
	}

	public String getVarBiometriaHematica() {
		return varBiometriaHematica;
	}

	public void setVarBiometriaHematica(String varBiometriaHematica) {
		this.varBiometriaHematica = varBiometriaHematica;
	}

	public String getVarPlaquetas() {
		return varPlaquetas;
	}

	public void setVarPlaquetas(String varPlaquetas) {
		this.varPlaquetas = varPlaquetas;
	}

	public String getVarGrupoRh() {
		return varGrupoRh;
	}

	public void setVarGrupoRh(String varGrupoRh) {
		this.varGrupoRh = varGrupoRh;
	}

	public String getVarReticulositos() {
		return varReticulositos;
	}

	public void setVarReticulositos(String varReticulositos) {
		this.varReticulositos = varReticulositos;
	}

	public String getVarHematozoario() {
		return varHematozoario;
	}

	public void setVarHematozoario(String varHematozoario) {
		this.varHematozoario = varHematozoario;
	}

	public String getVarCelula() {
		return varCelula;
	}

	public void setVarCelula(String varCelula) {
		this.varCelula = varCelula;
	}

	public String getVarIndicesHematicos() {
		return varIndicesHematicos;
	}

	public void setVarIndicesHematicos(String varIndicesHematicos) {
		this.varIndicesHematicos = varIndicesHematicos;
	}

	public String getVarTProtrombina() {
		return varTProtrombina;
	}

	public void setVarTProtrombina(String varTProtrombina) {
		this.varTProtrombina = varTProtrombina;
	}

	public String getVarTiempoTParcial() {
		return varTiempoTParcial;
	}

	public void setVarTiempoTParcial(String varTiempoTParcial) {
		this.varTiempoTParcial = varTiempoTParcial;
	}

	public String getVarDrepanocitos() {
		return varDrepanocitos;
	}

	public void setVarDrepanocitos(String varDrepanocitos) {
		this.varDrepanocitos = varDrepanocitos;
	}

	public String getVarCoombsDirecto() {
		return varCoombsDirecto;
	}

	public void setVarCoombsDirecto(String varCoombsDirecto) {
		this.varCoombsDirecto = varCoombsDirecto;
	}

	public String getVarCoombsIndirecto() {
		return varCoombsIndirecto;
	}

	public void setVarCoombsIndirecto(String varCoombsIndirecto) {
		this.varCoombsIndirecto = varCoombsIndirecto;
	}

	public String getVarGlucosaEnAyunas() {
		return varGlucosaEnAyunas;
	}

	public void setVarGlucosaEnAyunas(String varGlucosaEnAyunas) {
		this.varGlucosaEnAyunas = varGlucosaEnAyunas;
	}

	public String getVarGlucosa2Horas() {
		return varGlucosa2Horas;
	}

	public void setVarGlucosa2Horas(String varGlucosa2Horas) {
		this.varGlucosa2Horas = varGlucosa2Horas;
	}

	public String getVarUrea() {
		return varUrea;
	}

	public void setVarUrea(String varUrea) {
		this.varUrea = varUrea;
	}

	public String getVarCreatinina() {
		return varCreatinina;
	}

	public void setVarCreatinina(String varCreatinina) {
		this.varCreatinina = varCreatinina;
	}

	public String getVarAcidoUrico() {
		return varAcidoUrico;
	}

	public void setVarAcidoUrico(String varAcidoUrico) {
		this.varAcidoUrico = varAcidoUrico;
	}

	public String getVarBilirrubinas() {
		return varBilirrubinas;
	}

	public void setVarBilirrubinas(String varBilirrubinas) {
		this.varBilirrubinas = varBilirrubinas;
	}

	public String getVarProteinas() {
		return varProteinas;
	}

	public void setVarProteinas(String varProteinas) {
		this.varProteinas = varProteinas;
	}

	public String getVarTransaminadaPiruvica() {
		return varTransaminadaPiruvica;
	}

	public void setVarTransaminadaPiruvica(String varTransaminadaPiruvica) {
		this.varTransaminadaPiruvica = varTransaminadaPiruvica;
	}

	public String getVarTransaminsaOxalacetica() {
		return varTransaminsaOxalacetica;
	}

	public void setVarTransaminsaOxalacetica(String varTransaminsaOxalacetica) {
		this.varTransaminsaOxalacetica = varTransaminsaOxalacetica;
	}

	public String getVarFosfatasaAlcalina() {
		return varFosfatasaAlcalina;
	}

	public void setVarFosfatasaAlcalina(String varFosfatasaAlcalina) {
		this.varFosfatasaAlcalina = varFosfatasaAlcalina;
	}

	public String getVarColesterolTotal() {
		return varColesterolTotal;
	}

	public void setVarColesterolTotal(String varColesterolTotal) {
		this.varColesterolTotal = varColesterolTotal;
	}

	public String getVarColesterolHdl() {
		return varColesterolHdl;
	}

	public void setVarColesterolHdl(String varColesterolHdl) {
		this.varColesterolHdl = varColesterolHdl;
	}

	public String getVarColesterolLdl() {
		return varColesterolLdl;
	}

	public void setVarColesterolLdl(String varColesterolLdl) {
		this.varColesterolLdl = varColesterolLdl;
	}

	public String getVarTrigliceridos() {
		return varTrigliceridos;
	}

	public void setVarTrigliceridos(String varTrigliceridos) {
		this.varTrigliceridos = varTrigliceridos;
	}

	public String getVarCoproparasitario() {
		return varCoproparasitario;
	}

	public void setVarCoproparasitario(String varCoproparasitario) {
		this.varCoproparasitario = varCoproparasitario;
	}

	public String getVarSangreOculta() {
		return varSangreOculta;
	}

	public void setVarSangreOculta(String varSangreOculta) {
		this.varSangreOculta = varSangreOculta;
	}

	public String getVarInvPolimorfoNucleares() {
		return varInvPolimorfoNucleares;
	}

	public void setVarInvPolimorfoNucleares(String varInvPolimorfoNucleares) {
		this.varInvPolimorfoNucleares = varInvPolimorfoNucleares;
	}

	public String getVarRotavirus() {
		return varRotavirus;
	}

	public void setVarRotavirus(String varRotavirus) {
		this.varRotavirus = varRotavirus;
	}

	public String getVarElementalMicroscopica() {
		return varElementalMicroscopica;
	}

	public void setVarElementalMicroscopica(String varElementalMicroscopica) {
		this.varElementalMicroscopica = varElementalMicroscopica;
	}

	public String getVarGotaFresca() {
		return varGotaFresca;
	}

	public void setVarGotaFresca(String varGotaFresca) {
		this.varGotaFresca = varGotaFresca;
	}

	public String getVarGram() {
		return varGram;
	}

	public void setVarGram(String varGram) {
		this.varGram = varGram;
	}

	public String getVarPruebaEmbarazo() {
		return varPruebaEmbarazo;
	}

	public void setVarPruebaEmbarazo(String varPruebaEmbarazo) {
		this.varPruebaEmbarazo = varPruebaEmbarazo;
	}

	public String getVarCultivoAntibiograma() {
		return varCultivoAntibiograma;
	}

	public void setVarCultivoAntibiograma(String varCultivoAntibiograma) {
		this.varCultivoAntibiograma = varCultivoAntibiograma;
	}

	public String getVarGramBacteriologia() {
		return varGramBacteriologia;
	}

	public void setVarGramBacteriologia(String varGramBacteriologia) {
		this.varGramBacteriologia = varGramBacteriologia;
	}

	public String getVarZiehl() {
		return varZiehl;
	}

	public void setVarZiehl(String varZiehl) {
		this.varZiehl = varZiehl;
	}

	public String getVarHongos() {
		return varHongos;
	}

	public void setVarHongos(String varHongos) {
		this.varHongos = varHongos;
	}

	public String getVarFresco() {
		return varFresco;
	}

	public void setVarFresco(String varFresco) {
		this.varFresco = varFresco;
	}

	public String getVarCultivoAntibiogramaBacteriologia() {
		return varCultivoAntibiogramaBacteriologia;
	}

	public void setVarCultivoAntibiogramaBacteriologia(String varCultivoAntibiogramaBacteriologia) {
		this.varCultivoAntibiogramaBacteriologia = varCultivoAntibiogramaBacteriologia;
	}

	
	public String getVarOtros() {
		return varOtros;
	}

	public void setVarOtros(String varOtros) {
		this.varOtros = varOtros;
	}

	public String getVarMotivo() {
		return varMotivo;
	}

	public void setVarMotivo(String varMotivo) {
		this.varMotivo = varMotivo;
	}

	public String getVarExamenFisico() {
		return varExamenFisico;
	}

	public void setVarExamenFisico(String varExamenFisico) {
		this.varExamenFisico = varExamenFisico;
	}


	public String getVarDescribirExamen() {
		return varDescribirExamen;
	}

	public void setVarDescribirExamen(String varDescribirExamen) {
		this.varDescribirExamen = varDescribirExamen;
	}

	public String getVarRxConvencional() {
		return varRxConvencional;
	}

	public void setVarRxConvencional(String varRxConvencional) {
		this.varRxConvencional = varRxConvencional;
	}

	public String getVarTomografia() {
		return varTomografia;
	}

	public void setVarTomografia(String varTomografia) {
		this.varTomografia = varTomografia;
	}

	public String getVarResonancia() {
		return varResonancia;
	}

	public void setVarResonancia(String varResonancia) {
		this.varResonancia = varResonancia;
	}

	public String getVarEcografia() {
		return varEcografia;
	}

	public void setVarEcografia(String varEcografia) {
		this.varEcografia = varEcografia;
	}

	public String getVarProcedimiento() {
		return varProcedimiento;
	}

	public void setVarProcedimiento(String varProcedimiento) {
		this.varProcedimiento = varProcedimiento;
	}

	public String getVarCIEDiagDefinitivo() {
		return varCIEDiagDefinitivo;
	}

	public void setVarCIEDiagDefinitivo(String varCIEDiagDefinitivo) {
		this.varCIEDiagDefinitivo = varCIEDiagDefinitivo;
	}

	public String getVarDiagPresuntivo() {
		return varDiagPresuntivo;
	}

	public void setVarDiagPresuntivo(String varDiagPresuntivo) {
		this.varDiagPresuntivo = varDiagPresuntivo;
	}

	public String getVarDiagDefinitivo() {
		return varDiagDefinitivo;
	}

	public void setVarDiagDefinitivo(String varDiagDefinitivo) {
		this.varDiagDefinitivo = varDiagDefinitivo;
	}

	public String getVarCedulaMedico() {
		return varCedulaMedico;
	}

	public void setVarCedulaMedico(String varCedulaMedico) {
		this.varCedulaMedico = varCedulaMedico;
	}
	
	
	

}
