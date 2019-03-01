package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dedicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Dedicacion.findAll", query="SELECT d FROM Dedicacion d")
public class Dedicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dedic")
	private String idDedic;

	@Column(name="nom_dedic")
	private String nomDedic;

	public Dedicacion() {
	}

	public String getIdDedic() {
		return this.idDedic;
	}

	public void setIdDedic(String idDedic) {
		this.idDedic = idDedic;
	}

	public String getNomDedic() {
		return this.nomDedic;
	}

	public void setNomDedic(String nomDedic) {
		this.nomDedic = nomDedic;
	}

}