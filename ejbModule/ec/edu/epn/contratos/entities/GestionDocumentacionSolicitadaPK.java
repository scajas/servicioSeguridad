package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the gestion_documentacion_solicitada database table.
 * 
 */
@Embeddable
public class GestionDocumentacionSolicitadaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_relacion")
	private Integer idRelacion;

	@Column(name="id_dedicacion")
	private Integer idDedicacion;

	@Column(name="id_documento")
	private Integer idDocumento;

    public GestionDocumentacionSolicitadaPK() {
    }
	public Integer getIdRelacion() {
		return this.idRelacion;
	}
	public void setIdRelacion(Integer idRelacion) {
		this.idRelacion = idRelacion;
	}
	public Integer getIdDedicacion() {
		return this.idDedicacion;
	}
	public void setIdDedicacion(Integer idDedicacion) {
		this.idDedicacion = idDedicacion;
	}
	public Integer getIdDocumento() {
		return this.idDocumento;
	}
	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GestionDocumentacionSolicitadaPK)) {
			return false;
		}
		GestionDocumentacionSolicitadaPK castOther = (GestionDocumentacionSolicitadaPK)other;
		return 
			this.idRelacion.equals(castOther.idRelacion)
			&& this.idDedicacion.equals(castOther.idDedicacion)
			&& this.idDocumento.equals(castOther.idDocumento);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRelacion.hashCode();
		hash = hash * prime + this.idDedicacion.hashCode();
		hash = hash * prime + this.idDocumento.hashCode();
		
		return hash;
    }
}