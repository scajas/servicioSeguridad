package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the responsables_int database table.
 * 
 */
@Entity
@Table(name="responsables_int", catalog = "`bddcorpepn`", schema = "`Convenios`")

public class ResponsablesInt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_respoint")
	private Integer idRespoint;

	private String nced;

	private String nombres;

    public ResponsablesInt() {
    }

	public Integer getIdRespoint() {
		return this.idRespoint;
	}

	public void setIdRespoint(Integer idRespoint) {
		this.idRespoint = idRespoint;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

}