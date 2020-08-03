package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the universidad database table.
 * 
 */
@Entity
@Table(name = "universidad", catalog = "bddcorpepn", schema = "`GestionDocente`")
@NamedQuery(name = "Universidad.findAll", query = "SELECT u FROM Universidad u")
public class Universidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_universid")
	private String idUniversid;

	// bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;

	@Column(name = "nom_universid")
	private String nomUniversid;

	

	public Universidad() {
	}

	public String getIdUniversid() {
		return this.idUniversid;
	}

	public void setIdUniversid(String idUniversid) {
		this.idUniversid = idUniversid;
	}

	

	public String getNomUniversid() {
		return this.nomUniversid;
	}

	public void setNomUniversid(String nomUniversid) {
		this.nomUniversid = nomUniversid;
	}

	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	

}