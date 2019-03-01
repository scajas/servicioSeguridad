package ec.edu.epn.catalogos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the areas_unesco database table.
 * 
 */
@Entity
@Table(name="areas_unesco")
@NamedQuery(name="AreasUnesco.findAll", query="SELECT a FROM AreasUnesco a")
public class AreasUnesco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_area")
	private String idArea;

	@Column(name="nombre_area")
	private String nombreArea;

	//bi-directional many-to-one association to SubareaUnesco
	@OneToMany(mappedBy="areasUnesco")
	private List<SubareaUnesco> subareaUnescos;

	public AreasUnesco() {
	}

	public String getIdArea() {
		return this.idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return this.nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public List<SubareaUnesco> getSubareaUnescos() {
		return this.subareaUnescos;
	}

	public void setSubareaUnescos(List<SubareaUnesco> subareaUnescos) {
		this.subareaUnescos = subareaUnescos;
	}

	public SubareaUnesco addSubareaUnesco(SubareaUnesco subareaUnesco) {
		getSubareaUnescos().add(subareaUnesco);
		subareaUnesco.setAreasUnesco(this);

		return subareaUnesco;
	}

	public SubareaUnesco removeSubareaUnesco(SubareaUnesco subareaUnesco) {
		getSubareaUnescos().remove(subareaUnesco);
		subareaUnesco.setAreasUnesco(null);

		return subareaUnesco;
	}

}