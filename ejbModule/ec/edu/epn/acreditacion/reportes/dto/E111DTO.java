package ec.edu.epn.acreditacion.reportes.dto;

import java.io.Serializable;

public class E111DTO implements Serializable {

	private static final long serialVersionUID = 3574385754496084840L;

	/** Variables **/
	private String Codigo, Estudiante, CedulaEstudiante, FechaNacimientoEstud, CelularEstudiante,
			EmailPersonalEstudiante, EmailEPNEstudiante, MateriasPerdidas, ultimopermatri, carreraultmatri,
			facultadultmatri, Practicas, promedio, tipoTitulacion, Graduado, CredAcum, IRA, CodigoTutor, Tutor;

	/** Setter y Getters **/

	public String getCarreraultmatri() {
		return carreraultmatri;
	}

	public void setCarreraultmatri(String carreraultmatri) {
		this.carreraultmatri = carreraultmatri;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getEstudiante() {
		return Estudiante;
	}

	public void setEstudiante(String estudiante) {
		Estudiante = estudiante;
	}

	public String getCedulaEstudiante() {
		return CedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		CedulaEstudiante = cedulaEstudiante;
	}

	public String getFechaNacimientoEstud() {
		return FechaNacimientoEstud;
	}

	public void setFechaNacimientoEstud(String fechaNacimientoEstud) {
		FechaNacimientoEstud = fechaNacimientoEstud;
	}

	public String getCelularEstudiante() {
		return CelularEstudiante;
	}

	public void setCelularEstudiante(String celularEstudiante) {
		CelularEstudiante = celularEstudiante;
	}

	public String getEmailPersonalEstudiante() {
		return EmailPersonalEstudiante;
	}

	public void setEmailPersonalEstudiante(String emailPersonalEstudiante) {
		EmailPersonalEstudiante = emailPersonalEstudiante;
	}

	public String getEmailEPNEstudiante() {
		return EmailEPNEstudiante;
	}

	public void setEmailEPNEstudiante(String emailEPNEstudiante) {
		EmailEPNEstudiante = emailEPNEstudiante;
	}

	public String getMateriasPerdidas() {
		return MateriasPerdidas;
	}

	public void setMateriasPerdidas(String materiasPerdidas) {
		MateriasPerdidas = materiasPerdidas;
	}

	public String getUltimopermatri() {
		return ultimopermatri;
	}

	public void setUltimopermatri(String ultimopermatri) {
		this.ultimopermatri = ultimopermatri;
	}

	public String getFacultadultmatri() {
		return facultadultmatri;
	}

	public void setFacultadultmatri(String facultadultmatri) {
		this.facultadultmatri = facultadultmatri;
	}

	public String getPracticas() {
		return Practicas;
	}

	public void setPracticas(String practicas) {
		Practicas = practicas;
	}

	public String getPromedio() {
		return promedio;
	}

	public void setPromedio(String promedio) {
		this.promedio = promedio;
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

	public String getCredAcum() {
		return CredAcum;
	}

	public void setCredAcum(String credAcum) {
		CredAcum = credAcum;
	}

	public String getIRA() {
		return IRA;
	}

	public void setIRA(String iRA) {
		IRA = iRA;
	}

	public String getCodigoTutor() {
		return CodigoTutor;
	}

	public void setCodigoTutor(String codigoTutor) {
		CodigoTutor = codigoTutor;
	}

	public String getTutor() {
		return Tutor;
	}

	public void setTutor(String tutor) {
		Tutor = tutor;
	}

	public E111DTO() {
	}

}
