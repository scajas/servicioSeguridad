package ec.edu.epn.acreditacion.reportes.dto;

import java.io.Serializable;

public class E112ADTO implements Serializable {

	private static final long serialVersionUID = 3574385754496084840L;

	/** Variables **/
	private String codcar, IdentificacionTut, Tutor, CodigoEstud, EstudianteIdentif, Estudiante, FechaNacEstud,
			CelularEstud, EmailEstudiante, EmailEstudEPN, CredAcum, MateriasPerdidas, promedio, IRA, PracticasPre,
			tipoTitulacion, Graduado, Facultad, Carrera, RegFactor, Factor, Observacion, Departamento, Dedicacion,
			Categoria;

	/** Setter y Getters **/

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public String getDedicacion() {
		return Dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		Dedicacion = dedicacion;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public String getCodcar() {
		return codcar;
	}

	public void setCodcar(String codcar) {
		this.codcar = codcar;
	}

	public String getIdentificacionTut() {
		return IdentificacionTut;
	}

	public void setIdentificacionTut(String identificacionTut) {
		IdentificacionTut = identificacionTut;
	}

	public String getTutor() {
		return Tutor;
	}

	public void setTutor(String tutor) {
		Tutor = tutor;
	}

	public String getCodigoEstud() {
		return CodigoEstud;
	}

	public void setCodigoEstud(String codigoEstud) {
		CodigoEstud = codigoEstud;
	}

	public String getEstudianteIdentif() {
		return EstudianteIdentif;
	}

	public void setEstudianteIdentif(String estudianteIdentif) {
		EstudianteIdentif = estudianteIdentif;
	}

	public String getEstudiante() {
		return Estudiante;
	}

	public void setEstudiante(String estudiante) {
		Estudiante = estudiante;
	}

	public String getFechaNacEstud() {
		return FechaNacEstud;
	}

	public void setFechaNacEstud(String fechaNacEstud) {
		FechaNacEstud = fechaNacEstud;
	}

	public String getCelularEstud() {
		return CelularEstud;
	}

	public void setCelularEstud(String celularEstud) {
		CelularEstud = celularEstud;
	}

	public String getEmailEstudiante() {
		return EmailEstudiante;
	}

	public void setEmailEstudiante(String emailEstudiante) {
		EmailEstudiante = emailEstudiante;
	}

	public String getEmailEstudEPN() {
		return EmailEstudEPN;
	}

	public void setEmailEstudEPN(String emailEstudEPN) {
		EmailEstudEPN = emailEstudEPN;
	}

	public String getCredAcum() {
		return CredAcum;
	}

	public void setCredAcum(String credAcum) {
		CredAcum = credAcum;
	}

	public String getMateriasPerdidas() {
		return MateriasPerdidas;
	}

	public void setMateriasPerdidas(String materiasPerdidas) {
		MateriasPerdidas = materiasPerdidas;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
	}

	public String getIRA() {
		return IRA;
	}

	public void setIRA(String iRA) {
		IRA = iRA;
	}

	public String getPracticasPre() {
		return PracticasPre;
	}

	public void setPracticasPre(String practicasPre) {
		PracticasPre = practicasPre;
	}

	public String getTipoTitulacion() {
		return tipoTitulacion;
	}

	public void setTipoTitulacion(String tipoTitulacion) {
		this.tipoTitulacion = tipoTitulacion;
	}

	public String getGraduado() {
		return Graduado;
	}

	public void setGraduado(String graduado) {
		Graduado = graduado;
	}

	public String getFacultad() {
		return Facultad;
	}

	public void setFacultad(String facultad) {
		Facultad = facultad;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	public String getRegFactor() {
		return RegFactor;
	}

	public void setRegFactor(String regFactor) {
		RegFactor = regFactor;
	}

	public String getFactor() {
		return Factor;
	}

	public void setFactor(String factor) {
		Factor = factor;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}

}
