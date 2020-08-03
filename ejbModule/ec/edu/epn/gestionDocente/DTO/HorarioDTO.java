package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;

public class HorarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7859953758815161654L;
	private Integer id;
	private String idHora;
	private String carrera;
	private String codmateria;
	private String materia;
	private String paralelo;
	private String horasSemana;
	private String horasModulo;
	private String aula;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String sabado;
	private String fechaInicial;
	private String fechaFinal;

	private String catLunes;
	private String catMartes;
	private String catMiercoles;
	private String catJueves;
	private String catViernes;
	private String catSabado;
	
	private String marcaModular;

	public String getMarcaModular() {
		return marcaModular;
	}

	public void setMarcaModular(String marcaModular) {
		this.marcaModular = marcaModular;
	}

	public String getCatLunes() {
		return catLunes;
	}

	public void setCatLunes(String catLunes) {
		this.catLunes = catLunes;
	}

	public String getCatMartes() {
		return catMartes;
	}

	public void setCatMartes(String catMartes) {
		this.catMartes = catMartes;
	}

	public String getCatMiercoles() {
		return catMiercoles;
	}

	public void setCatMiercoles(String catMiercoles) {
		this.catMiercoles = catMiercoles;
	}

	public String getCatJueves() {
		return catJueves;
	}

	public void setCatJueves(String catJueves) {
		this.catJueves = catJueves;
	}

	public String getCatViernes() {
		return catViernes;
	}

	public void setCatViernes(String catViernes) {
		this.catViernes = catViernes;
	}

	public String getCatSabado() {
		return catSabado;
	}

	public void setCatSabado(String catSabado) {
		this.catSabado = catSabado;
	}

	public HorarioDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdHora() {
		return idHora;
	}

	public void setIdHora(String idHora) {
		this.idHora = idHora;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCodmateria() {
		return codmateria;
	}

	public void setCodmateria(String codmateria) {
		this.codmateria = codmateria;
	}

	public String getHorasSemana() {
		return horasSemana;
	}

	public void setHorasSemana(String horasSemana) {
		this.horasSemana = horasSemana;
	}

	public String getHorasModulo() {
		return horasModulo;
	}

	public void setHorasModulo(String horasModulo) {
		this.horasModulo = horasModulo;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getLunes() {
		return lunes;
	}

	public void setLunes(String lunes) {
		this.lunes = lunes;
	}

	public String getMartes() {
		return martes;
	}

	public void setMartes(String martes) {
		this.martes = martes;
	}

	public String getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}

	public String getJueves() {
		return jueves;
	}

	public void setJueves(String jueves) {
		this.jueves = jueves;
	}

	public String getViernes() {
		return viernes;
	}

	public void setViernes(String viernes) {
		this.viernes = viernes;
	}

	public String getSabado() {
		return sabado;
	}

	public void setSabado(String sabado) {
		this.sabado = sabado;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
