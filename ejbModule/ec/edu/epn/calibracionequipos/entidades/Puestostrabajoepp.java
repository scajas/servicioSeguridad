package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puestostrabajoepp database table.
 * 
 */
@Entity
@Table(name="puestostrabajoepp", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Puestostrabajoepp.findAll", query="SELECT p FROM Puestostrabajoepp p")
public class Puestostrabajoepp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_puestotrabajoepp")
	private Integer idPuestotrabajoepp;

	@Column(name="nombre_puestotrabajoepp")
	private String nombrePuestotrabajoepp;

	//bi-directional many-to-one association to Gestionepp
	@ManyToOne
	@JoinColumn(name="id_gestionepp")
	private Gestionepp gestionepp;

	public Puestostrabajoepp() {
	}

	public Integer getIdPuestotrabajoepp() {
		return this.idPuestotrabajoepp;
	}

	public void setIdPuestotrabajoepp(Integer idPuestotrabajoepp) {
		this.idPuestotrabajoepp = idPuestotrabajoepp;
	}

	public String getNombrePuestotrabajoepp() {
		return this.nombrePuestotrabajoepp;
	}

	public void setNombrePuestotrabajoepp(String nombrePuestotrabajoepp) {
		this.nombrePuestotrabajoepp = nombrePuestotrabajoepp;
	}

	public Gestionepp getGestionepp() {
		return this.gestionepp;
	}

	public void setGestionepp(Gestionepp gestionepp) {
		this.gestionepp = gestionepp;
	}

}