package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the responsable_ext_conv database table.
 * 
 */
@Entity
@Table(name="responsable_ext_conv", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class ResponsableExtConv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResponsableExtConvPK id;

    public ResponsableExtConv() {
    }

	public ResponsableExtConvPK getId() {
		return this.id;
	}

	public void setId(ResponsableExtConvPK id) {
		this.id = id;
	}
	
}