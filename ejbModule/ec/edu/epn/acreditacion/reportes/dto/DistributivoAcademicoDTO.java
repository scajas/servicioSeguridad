package ec.edu.epn.acreditacion.reportes.dto;

public class DistributivoAcademicoDTO {

	private String codProf;
	private String nomProf;
	private String dedicacion;
	private String materia;
	private String paralelo;
	private int horas;
	private int numEstud;
	private String tipoContrat;
	private String carrera;
	private String facultad;

	public DistributivoAcademicoDTO() {

	}

	public DistributivoAcademicoDTO(String codProf, String nomProf, String dedicacion, String materia, String paralelo,
			int horas, int numEstud, String tipoContrat, String carrera, String facultad) {

		this.codProf = codProf;
		this.nomProf = nomProf;
		this.dedicacion = dedicacion;
		this.materia = materia;
		this.paralelo = paralelo;
		this.horas = horas;
		this.numEstud = numEstud;
		this.tipoContrat = tipoContrat;
		this.carrera = carrera;
		this.facultad = facultad;
	}

	/**
	 * @return the codProf
	 */
	public String getCodProf() {
		return codProf;
	}

	/**
	 * @param codProf
	 *            the codProf to set
	 */
	public void setCodProf(String codProf) {
		this.codProf = codProf;
	}

	/**
	 * @return the nomProf
	 */
	public String getNomProf() {
		return nomProf;
	}

	/**
	 * @param nomProf
	 *            the nomProf to set
	 */
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	/**
	 * @return the dedicacion
	 */
	public String getDedicacion() {
		return dedicacion;
	}

	/**
	 * @param dedicacion
	 *            the dedicacion to set
	 */
	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	/**
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia
	 *            the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	/**
	 * @return the paralelo
	 */
	public String getParalelo() {
		return paralelo;
	}

	/**
	 * @param paralelo
	 *            the paralelo to set
	 */
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	/**
	 * @return the numEstud
	 */
	public int getNumEstud() {
		return numEstud;
	}

	/**
	 * @param numEstud
	 *            the numEstud to set
	 */
	public void setNumEstud(int numEstud) {
		this.numEstud = numEstud;
	}

	/**
	 * @return the tipoContrat
	 */
	public String getTipoContrat() {
		return tipoContrat;
	}

	/**
	 * @param tipoContrat
	 *            the tipoContrat to set
	 */
	public void setTipoContrat(String tipoContrat) {
		this.tipoContrat = tipoContrat;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas
	 *            the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera
	 *            the carrera to set
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
	 * @param facultad
	 *            the facultad to set
	 */
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

}
