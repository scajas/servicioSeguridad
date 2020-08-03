package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puestostrabajoinvolucrados database table.
 * 
 */
@Entity
@Table(name="puestostrabajoinvolucrados", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Puestostrabajoinvolucrado.findAll", query="SELECT p FROM Puestostrabajoinvolucrado p")
public class Puestostrabajoinvolucrado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_puestotrabajoinv")
	private Integer idPuestotrabajoinv;

	@Column(name="nombre_puestotrabajoinv")
	private String nombrePuestotrabajoinv;

	//bi-directional many-to-one association to Gestionsoo
	@ManyToOne
	@JoinColumn(name="id_proceso")
	private Gestionsoo gestionsoo;

	public Puestostrabajoinvolucrado() {
	}

	public Integer getIdPuestotrabajoinv() {
		return this.idPuestotrabajoinv;
	}

	public void setIdPuestotrabajoinv(Integer idPuestotrabajoinv) {
		this.idPuestotrabajoinv = idPuestotrabajoinv;
	}

	public String getNombrePuestotrabajoinv() {
		return this.nombrePuestotrabajoinv;
	}

	public void setNombrePuestotrabajoinv(String nombrePuestotrabajoinv) {
		this.nombrePuestotrabajoinv = nombrePuestotrabajoinv;
	}

	public Gestionsoo getGestionsoo() {
		return this.gestionsoo;
	}

	public void setGestionsoo(Gestionsoo gestionsoo) {
		this.gestionsoo = gestionsoo;
	}

}