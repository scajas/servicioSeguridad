package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the responsable_ext_conv database table.
 * 
 */
@Embeddable
public class ResponsableExtConvPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="cod_perx")
	private Integer codPerx;

	@Column(name="id_conv")
	private String idConv;

	private Integer signa;

    public ResponsableExtConvPK() {
    }
	public Integer getCodPerx() {
		return this.codPerx;
	}
	public void setCodPerx(Integer codPerx) {
		this.codPerx = codPerx;
	}
	public String getIdConv() {
		return this.idConv;
	}
	public void setIdConv(String idConv) {
		this.idConv = idConv;
	}
	public Integer getSigna() {
		return this.signa;
	}
	public void setSigna(Integer signa) {
		this.signa = signa;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResponsableExtConvPK)) {
			return false;
		}
		ResponsableExtConvPK castOther = (ResponsableExtConvPK)other;
		return 
			this.codPerx.equals(castOther.codPerx)
			&& this.idConv.equals(castOther.idConv)
			&& this.signa.equals(castOther.signa);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codPerx.hashCode();
		hash = hash * prime + this.idConv.hashCode();
		hash = hash * prime + this.signa.hashCode();
		
		return hash;
    }
}