package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subarea_unesco database table.
 * 
 */
@Entity
@Table(name="subarea_unesco")
@NamedQuery(name="SubareaUnesco.findAll", query="SELECT s FROM SubareaUnesco s")
public class SubareaUnesco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_subarea")
	private String idSubarea;

	@Column(name="nom_subarea")
	private String nomSubarea;

	//bi-directional many-to-one association to AreasUnesco
	@ManyToOne
	@JoinColumn(name="id_area")
	private AreasUnesco areasUnesco;

	public SubareaUnesco() {
	}

	public String getIdSubarea() {
		return this.idSubarea;
	}

	public void setIdSubarea(String idSubarea) {
		this.idSubarea = idSubarea;
	}

	public String getNomSubarea() {
		return this.nomSubarea;
	}

	public void setNomSubarea(String nomSubarea) {
		this.nomSubarea = nomSubarea;
	}

	public AreasUnesco getAreasUnesco() {
		return this.areasUnesco;
	}

	public void setAreasUnesco(AreasUnesco areasUnesco) {
		this.areasUnesco = areasUnesco;
	}

}