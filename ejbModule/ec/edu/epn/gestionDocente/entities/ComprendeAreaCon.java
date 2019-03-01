package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comprende_area_con database table.
 * 
 */
@Entity
@Table(name="comprende_area_con")
@NamedQuery(name="ComprendeAreaCon.findAll", query="SELECT c FROM ComprendeAreaCon c")
public class ComprendeAreaCon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_comprende_ac")
	private String idComprendeAc;

	@Column(name="comprende_ac")
	private String comprendeAc;

	@Column(name="id_area_con")
	private String idAreaCon;

	public ComprendeAreaCon() {
	}

	public String getIdComprendeAc() {
		return this.idComprendeAc;
	}

	public void setIdComprendeAc(String idComprendeAc) {
		this.idComprendeAc = idComprendeAc;
	}

	public String getComprendeAc() {
		return this.comprendeAc;
	}

	public void setComprendeAc(String comprendeAc) {
		this.comprendeAc = comprendeAc;
	}

	public String getIdAreaCon() {
		return this.idAreaCon;
	}

	public void setIdAreaCon(String idAreaCon) {
		this.idAreaCon = idAreaCon;
	}

}