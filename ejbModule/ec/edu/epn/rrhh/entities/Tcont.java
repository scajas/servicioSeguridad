package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tcont database table.
 * 
 */
@Entity
@Table(name="tcont", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="Tcont.findAll", query="SELECT t FROM Tcont t")
public class Tcont implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tcont;

	@Column(name="desc_tcont")
	private String descTcont;

	@Column(name="est_tcont")
	private String estTcont;	

	public Tcont() {
	}

	public String getTcont() {
		return this.tcont;
	}

	public void setTcont(String tcont) {
		this.tcont = tcont;
	}

	public String getDescTcont() {
		return this.descTcont;
	}

	public void setDescTcont(String descTcont) {
		this.descTcont = descTcont;
	}

	public String getEstTcont() {
		return this.estTcont;
	}

	public void setEstTcont(String estTcont) {
		this.estTcont = estTcont;
	}

	
}