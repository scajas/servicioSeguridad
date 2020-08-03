package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the responsable_int_conv database table.
 * 
 */
@Embeddable
public class ResponsableIntConvPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_respoint")
	private Integer idRespoint;

	@Column(name="id_conv")
	private String idConv;

    public ResponsableIntConvPK() {
    }
	public Integer getIdRespoint() {
		return this.idRespoint;
	}
	public void setIdRespoint(Integer idRespoint) {
		this.idRespoint = idRespoint;
	}
	public String getIdConv() {
		return this.idConv;
	}
	public void setIdConv(String idConv) {
		this.idConv = idConv;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResponsableIntConvPK)) {
			return false;
		}
		ResponsableIntConvPK castOther = (ResponsableIntConvPK)other;
		return 
			this.idRespoint.equals(castOther.idRespoint)
			&& this.idConv.equals(castOther.idConv);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRespoint.hashCode();
		hash = hash * prime + this.idConv.hashCode();
		
		return hash;
    }
}