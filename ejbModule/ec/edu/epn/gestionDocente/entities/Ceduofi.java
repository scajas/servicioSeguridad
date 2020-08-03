package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ceduofi database table.
 * 
 */
@Entity
@NamedQuery(name="Ceduofi.findAll", query="SELECT c FROM Ceduofi c")
public class Ceduofi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nced;

	public Ceduofi() {
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

}