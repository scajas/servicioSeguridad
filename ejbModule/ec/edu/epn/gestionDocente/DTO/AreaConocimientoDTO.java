package ec.edu.epn.gestionDocente.DTO;

import java.io.Serializable;


public class AreaConocimientoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3512619350103149985L;
	private String idAreaConDoc;
	private String idAreaConCatalog;
	private String nomAreaConCatalog;
	private String nombre_subindice;

	// estado y validacion
	private String estado;
	private String validacion;
	private String imagen;
	

	public AreaConocimientoDTO() {
		super();
	}

	public AreaConocimientoDTO(String idAreaConDoc, String idAreaConCatalog,
			String nomAreaConCatalog, String estado, String validacion,
			String imagen, String nombre_subindice) {
		super();
		this.idAreaConDoc = idAreaConDoc;
		this.idAreaConCatalog = idAreaConCatalog;
		this.nomAreaConCatalog = nomAreaConCatalog;
		this.estado = estado;
		this.validacion = validacion;
		this.imagen = imagen;
		this.nombre_subindice= nombre_subindice;
	}

	public String getIdAreaConDoc() {
		return idAreaConDoc;
	}

	public void setIdAreaConDoc(String idAreaConDoc) {
		this.idAreaConDoc = idAreaConDoc;
	}

	public String getIdAreaConCatalog() {
		return idAreaConCatalog;
	}

	public void setIdAreaConCatalog(String idAreaConCatalog) {
		this.idAreaConCatalog = idAreaConCatalog;
	}

	public String getNomAreaConCatalog() {
		return nomAreaConCatalog;
	}

	public void setNomAreaConCatalog(String nomAreaConCatalog) {
		this.nomAreaConCatalog = nomAreaConCatalog;
	}

	public String getNombre_subindice() {
		return nombre_subindice;
	}

	public void setNombre_subindice(String nombre_subindice) {
		this.nombre_subindice = nombre_subindice;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
}
