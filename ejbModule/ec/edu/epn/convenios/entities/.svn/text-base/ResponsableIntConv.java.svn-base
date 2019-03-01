package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the responsable_int_conv database table.
 * 
 */
@Entity

@Table(name="responsable_int_conv", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class ResponsableIntConv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResponsableIntConvPK id;

    public ResponsableIntConv() {
    }

	public ResponsableIntConvPK getId() {
		return this.id;
	}

	public void setId(ResponsableIntConvPK id) {
		this.id = id;
	}
	
}