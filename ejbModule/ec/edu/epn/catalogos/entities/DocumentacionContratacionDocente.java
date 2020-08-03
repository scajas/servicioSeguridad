package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documentacion_contratacion_docente database table.
 * 
 */
@Entity
@Table(name = "documentacion_contratacion_docente", catalog = "bddcorpepn", schema = "\"Catalogos\"")
@NamedQuery(name="DocumentacionContratacionDocente.findAll", query="SELECT d FROM DocumentacionContratacionDocente d")
public class DocumentacionContratacionDocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_documentacion_contratacion_docente")
	private Integer idDocumentacionContratacionDocente;

	@Column(name="nombre_documento")
	private String nombreDocumento;

	@Column(name="tipo_doc")
	private String tipoDoc;

	public DocumentacionContratacionDocente() {
	}

	public Integer getIdDocumentacionContratacionDocente() {
		return this.idDocumentacionContratacionDocente;
	}

	public void setIdDocumentacionContratacionDocente(Integer idDocumentacionContratacionDocente) {
		this.idDocumentacionContratacionDocente = idDocumentacionContratacionDocente;
	}

	public String getNombreDocumento() {
		return this.nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getTipoDoc() {
		return this.tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

}