package ec.edu.epn.proyectos.DTO;

public class ProyectoDTO {

	private Integer idProyecto;
	private String nombreProyecto;
	private String estado;
	private String codidoProy;
	private String rol;
	private String horas;
	private String fechaInicio;
	private String tiempoEstimado;
	private Integer idPensum;
	private String pensum; 

	public ProyectoDTO() {

	}

	public ProyectoDTO(Integer idProyecto, String nombreProyecto, String estado, String codidoProy) {
		super();

		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.estado = estado;
		this.codidoProy = codidoProy;
	}

	/**
	 * @return the idProyecto
	 */
	public Integer getIdProyecto() {
		return idProyecto;
	}

	/**
	 * @param idProyecto
	 *            the idProyecto to set
	 */
	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	/**
	 * @return the nombreProyecto
	 */
	public String getNombreProyecto() {
		return nombreProyecto;
	}

	/**
	 * @param nombreProyecto
	 *            the nombreProyecto to set
	 */
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the codidoProy
	 */
	public String getCodidoProy() {
		return codidoProy;
	}

	/**
	 * @param codidoProy
	 *            the codidoProy to set
	 */
	public void setCodidoProy(String codidoProy) {
		this.codidoProy = codidoProy;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the horas
	 */
	public String getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(String horas) {
		this.horas = horas;
	}

	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the tiempoEstimado
	 */
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	/**
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	/**
	 * @return the idPensum
	 */
	public Integer getIdPensum() {
		return idPensum;
	}

	/**
	 * @param idPensum the idPensum to set
	 */
	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	/**
	 * @return the pensum
	 */
	public String getPensum() {
		return pensum;
	}

	/**
	 * @param pensum the pensum to set
	 */
	public void setPensum(String pensum) {
		this.pensum = pensum;
	}

}