package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the relacion_dedicacion database table.
 * 
 */
@Embeddable
public class RelacionDedicacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_relacion")
	private Integer idRelacion;

	@Column(name="id_dedicacion")
	private Integer idDedicacion;

    public RelacionDedicacionPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RelacionDedicacionPK)) {
			return false;
		}
		RelacionDedicacionPK castOther = (RelacionDedicacionPK)other;
		return 
			this.idRelacion.equals(castOther.idRelacion)
			&& this.idDedicacion.equals(castOther.idDedicacion);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRelacion.hashCode();
		hash = hash * prime + this.idDedicacion.hashCode();
		
		return hash;
    }
}