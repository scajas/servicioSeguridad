package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ekey database table.
 * 
 */
@Embeddable
public class EkeyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String codigouser;

    public EkeyPK() {
    }
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigouser() {
		return this.codigouser;
	}
	public void setCodigouser(String codigouser) {
		this.codigouser = codigouser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EkeyPK)) {
			return false;
		}
		EkeyPK castOther = (EkeyPK)other;
		return 
			this.id.equals(castOther.id)
			&& this.codigouser.equals(castOther.codigouser);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id.hashCode();
		hash = hash * prime + this.codigouser.hashCode();
		
		return hash;
    }
}