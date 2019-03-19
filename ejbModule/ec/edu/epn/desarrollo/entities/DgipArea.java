package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dgip_area database table.
 * 
 */
@Entity
@Table(name="dgip_area", catalog="`bddcorpepn`", schema="`Desarrollo`")


@NamedQuery(name="DgipArea.findAll", query="SELECT d FROM DgipArea d")
public class DgipArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to PersonalArea
	@OneToMany(mappedBy="dgipArea")
	private List<PersonalArea> personalAreas;

	public DgipArea() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PersonalArea> getPersonalAreas() {
		return this.personalAreas;
	}

	public void setPersonalAreas(List<PersonalArea> personalAreas) {
		this.personalAreas = personalAreas;
	}

	public PersonalArea addPersonalArea(PersonalArea personalArea) {
		getPersonalAreas().add(personalArea);
		personalArea.setDgipArea(this);

		return personalArea;
	}

	public PersonalArea removePersonalArea(PersonalArea personalArea) {
		getPersonalAreas().remove(personalArea);
		personalArea.setDgipArea(null);

		return personalArea;
	}

}