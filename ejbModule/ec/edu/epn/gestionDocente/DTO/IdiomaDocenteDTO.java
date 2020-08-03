package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;

public class IdiomaDocenteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4229717619849085587L;
	
	private String idIdiomaDoc;
	private String idIdiomaCat;
	private String nomIdiomaCat;
	private String nivelIdioma;
	private String sucesos = " ";

	// ESTADO Y VALIDACION
	private String estado;
	private String imagen;
	private String validacion;

	public IdiomaDocenteDTO() {
		super();
	}

	public IdiomaDocenteDTO(String idIdiomaDoc, String idIdiomaCat,
			String nomIdiomaCat, String nivelIdioma, String estado,
			String imagen, String validacion) {
		super();
		this.idIdiomaDoc = idIdiomaDoc;
		this.idIdiomaCat = idIdiomaCat;
		this.nomIdiomaCat = nomIdiomaCat;
		this.nivelIdioma = nivelIdioma;
		this.estado = estado;
		this.imagen = imagen;
		this.validacion = validacion;
	}

	
	/**GETTERS AND SETTERS*/
	public String getIdIdiomaDoc() {
		return idIdiomaDoc;
	}

	public void setIdIdiomaDoc(String idIdiomaDoc) {
		this.idIdiomaDoc = idIdiomaDoc;
	}

	public String getIdIdiomaCat() {
		return idIdiomaCat;
	}

	public void setIdIdiomaCat(String idIdiomaCat) {
		this.idIdiomaCat = idIdiomaCat;
	}

	public String getNomIdiomaCat() {
		return nomIdiomaCat;
	}

	public void setNomIdiomaCat(String nomIdiomaCat) {
		this.nomIdiomaCat = nomIdiomaCat;
	}

	public String getNivelIdioma() {
		return nivelIdioma;
	}

	public void setNivelIdioma(String nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}

	public String getSucesos() {
		return sucesos;
	}

	public void setSucesos(String sucesos) {
		this.sucesos = sucesos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

}
