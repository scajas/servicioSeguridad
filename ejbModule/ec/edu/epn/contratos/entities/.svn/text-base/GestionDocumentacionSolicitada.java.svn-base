package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.catalogos.entities.DocumentacionContratacionDocente;



/**
 * The persistent class for the gestion_documentacion_solicitada database table.
 * 
 */
@Entity
@Table(name = "gestion_documentacion_solicitada", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class GestionDocumentacionSolicitada implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GestionDocumentacionSolicitadaPK id;

	private String activo;
	private String renovacion;

	@ManyToOne
	@JoinColumn(name = "id_relacion", insertable = false, updatable = false)
	private RelacionActual relacionActual;

	@ManyToOne
	@JoinColumn(name = "id_dedicacion", insertable = false, updatable = false)
	private DedicacionContratos dedicacion;

	@ManyToOne
	@JoinColumn(name = "id_documento", insertable = false, updatable = false)
	private DocumentacionContratacionDocente documentacion;

	public RelacionActual getRelacionActual() {
		return relacionActual;
	}

	public void setRelacionActual(RelacionActual relacionActual) {
		this.relacionActual = relacionActual;
	}

	public DedicacionContratos getDedicacion() {
		return dedicacion;
	}

	public void setDedicacion(DedicacionContratos dedicacion) {
		this.dedicacion = dedicacion;
	}

	public DocumentacionContratacionDocente getDocumentacion() {
		return documentacion;
	}

	public void setDocumentacion(DocumentacionContratacionDocente documentacion) {
		this.documentacion = documentacion;
	}

	public GestionDocumentacionSolicitada() {
	}

	public GestionDocumentacionSolicitadaPK getId() {
		return this.id;
	}

	public void setId(GestionDocumentacionSolicitadaPK id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getRenovacion() {
		return renovacion;
	}

	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

}