package ec.edu.epn.silabo.dto;

import java.io.Serializable;

public class BibliografiaSilaboDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8018716022058548779L;
	private int idSilabo;
	private String cedula;
	private String nombres;
	private String pensum;
	private String facultad;
	private String carrera;
	private String asignatura;
	private String titulo;
	private String autor;
	private String editorial;
	private String ano;
	private String edicion;
	private String isbn;
	private String tipoB;
	private String codmat;
	private Integer idbibliografia;

	public BibliografiaSilaboDTO() {

	}

	public BibliografiaSilaboDTO(int idSilabo, String cedula, String nombres, String pensum, String facultad,
			String carrera, String asignatura, String titulo, String autor, String editorial, String ano,
			String edicion, String isbn, String tipoB, String codmat, Integer idbibliografia) {
		super();
		this.idSilabo = idSilabo;
		this.cedula = cedula;
		this.nombres = nombres;
		this.pensum = pensum;
		this.facultad = facultad;
		this.carrera = carrera;
		this.asignatura = asignatura;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.ano = ano;
		this.edicion = edicion;
		this.isbn = isbn;
		this.tipoB = tipoB;
		this.codmat = codmat;
		this.idbibliografia= idbibliografia;
	}

	/**
	 * @return the idSilabo
	 */
	public int getIdSilabo() {
		return idSilabo;
	}

	/**
	 * @param idSilabo
	 *            the idSilabo to set
	 */
	public void setIdSilabo(int idSilabo) {
		this.idSilabo = idSilabo;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres
	 *            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the pensum
	 */
	public String getPensum() {
		return pensum;
	}

	/**
	 * @param pensum
	 *            the pensum to set
	 */
	public void setPensum(String pensum) {
		this.pensum = pensum;
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
	 * @return the asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura
	 *            the asignatura to set
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial
	 *            the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * @param ano
	 *            the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}

	/**
	 * @return the edicion
	 */
	public String getEdicion() {
		return edicion;
	}

	/**
	 * @param edicion
	 *            the edicion to set
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the tipoB
	 */
	public String getTipoB() {
		return tipoB;
	}

	/**
	 * @param tipoB
	 *            the tipoB to set
	 */
	public void setTipoB(String tipoB) {
		this.tipoB = tipoB;
	}

	public String getCodmat() {
		return codmat;
	}

	public void setCodmat(String codmat) {
		this.codmat = codmat;
	}

	public Integer getIdbibliografia() {
		return idbibliografia;
	}

	public void setIdbibliografia(Integer idbibliografia) {
		this.idbibliografia = idbibliografia;
	}

}
