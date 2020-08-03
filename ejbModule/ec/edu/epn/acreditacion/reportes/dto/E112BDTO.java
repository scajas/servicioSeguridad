package ec.edu.epn.acreditacion.reportes.dto;

import java.io.Serializable;

public class E112BDTO implements Serializable {

	private static final long serialVersionUID = 3574385754496084840L;

	/** Variables **/
	private String facultad, carrera, identificacionTutor, tutor, departamento, dedicacion, categoria,
			tutorisEstudiantes, tutoriasRealizadas, tutoriasNoRealizadas, tutoriasRegistradasConFactor,
			tutoriasregistrasSinFactor, tutoriasPorcentaje, totalEstudiantesSinTutoria, sinTutoriaPorcentaje,
			totalEstudiantesSinCita, totalEstudiantesNoAsistenTutoria, citasVigentes, codEstudiante, estudiante;

	/** Setter y Getters **/
	public String getCodEstudiante() {
		return codEstudiante;
	}

	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public String getTutoriasNoRealizadas() {
		return tutoriasNoRealizadas;
	}

	public void setTutoriasNoRealizadas(String tutoriasNoRealizadas) {
		this.tutoriasNoRealizadas = tutoriasNoRealizadas;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getIdentificacionTutor() {
		return identificacionTutor;
	}

	public void setIdentificacionTutor(String identificacionTutor) {
		this.identificacionTutor = identificacionTutor;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
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

	public String getTutorisEstudiantes() {
		return tutorisEstudiantes;
	}

	public void setTutorisEstudiantes(String tutorisEstudiantes) {
		this.tutorisEstudiantes = tutorisEstudiantes;
	}

	public String getTutoriasRealizadas() {
		return tutoriasRealizadas;
	}

	public void setTutoriasRealizadas(String tutoriasRealizadas) {
		this.tutoriasRealizadas = tutoriasRealizadas;
	}

	public String getTutoriasRegistradasConFactor() {
		return tutoriasRegistradasConFactor;
	}

	public void setTutoriasRegistradasConFactor(String tutoriasRegistradasConFactor) {
		this.tutoriasRegistradasConFactor = tutoriasRegistradasConFactor;
	}

	public String getTutoriasregistrasSinFactor() {
		return tutoriasregistrasSinFactor;
	}

	public void setTutoriasregistrasSinFactor(String tutoriasregistrasSinFactor) {
		this.tutoriasregistrasSinFactor = tutoriasregistrasSinFactor;
	}

	public String getTutoriasPorcentaje() {
		return tutoriasPorcentaje;
	}

	public void setTutoriasPorcentaje(String tutoriasPorcentaje) {
		this.tutoriasPorcentaje = tutoriasPorcentaje;
	}

	public String getTotalEstudiantesSinTutoria() {
		return totalEstudiantesSinTutoria;
	}

	public void setTotalEstudiantesSinTutoria(String totalEstudiantesSinTutoria) {
		this.totalEstudiantesSinTutoria = totalEstudiantesSinTutoria;
	}

	public String getSinTutoriaPorcentaje() {
		return sinTutoriaPorcentaje;
	}

	public void setSinTutoriaPorcentaje(String sinTutoriaPorcentaje) {
		this.sinTutoriaPorcentaje = sinTutoriaPorcentaje;
	}

	public String getTotalEstudiantesSinCita() {
		return totalEstudiantesSinCita;
	}

	public void setTotalEstudiantesSinCita(String totalEstudiantesSinCita) {
		this.totalEstudiantesSinCita = totalEstudiantesSinCita;
	}

	public String getTotalEstudiantesNoAsistenTutoria() {
		return totalEstudiantesNoAsistenTutoria;
	}

	public void setTotalEstudiantesNoAsistenTutoria(String totalEstudiantesNoAsistenTutoria) {
		this.totalEstudiantesNoAsistenTutoria = totalEstudiantesNoAsistenTutoria;
	}

	public String getCitasVigentes() {
		return citasVigentes;
	}

	public void setCitasVigentes(String citasVigentes) {
		this.citasVigentes = citasVigentes;
	}

}
