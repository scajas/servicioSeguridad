package ec.edu.epn.gestionDocente.DTO;

public class TesisDocenteDTO {

		
	private String nroTesis;
	private String periodo;
	private String tema;
	private String tipoTesis;
	private String estudiante;
	private String fechaGradoOral;
	private String carrera;
	private String facultad; 
		

	public TesisDocenteDTO() {
		super();
	}
	
	
	public TesisDocenteDTO(String nroTesis, String periodo, String tema, String tipoTesis,			
								String estudiante, String fechaGradoOral, String carrera, String facultad) {
		super();		
		this.nroTesis= nroTesis;;
		this.periodo= periodo;
		this.tema= tema;
		this.tipoTesis=tipoTesis;
		this.estudiante=estudiante;
		this.fechaGradoOral=fechaGradoOral;
		this.carrera=carrera;
		this.facultad=facultad; 
	}


	/**
	 * @return the nroTesis
	 */
	public String getNroTesis() {
		return nroTesis;
	}


	/**
	 * @param nroTesis the nroTesis to set
	 */
	public void setNroTesis(String nroTesis) {
		this.nroTesis = nroTesis;
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
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}


	/**
	 * @param tema the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}


	/**
	 * @return the tipoTesis
	 */
	public String getTipoTesis() {
		return tipoTesis;
	}


	/**
	 * @param tipoTesis the tipoTesis to set
	 */
	public void setTipoTesis(String tipoTesis) {
		this.tipoTesis = tipoTesis;
	}


	/**
	 * @return the estudiante
	 */
	public String getEstudiante() {
		return estudiante;
	}


	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}


	/**
	 * @return the fechaGradoOral
	 */
	public String getFechaGradoOral() {
		return fechaGradoOral;
	}


	/**
	 * @param fechaGradoOral the fechaGradoOral to set
	 */
	public void setFechaGradoOral(String fechaGradoOral) {
		this.fechaGradoOral = fechaGradoOral;
	}


	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}


	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	/**
	 * @return the facultad
	 */
	public String getFacultad() {
		return facultad;
	}


	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	
}
