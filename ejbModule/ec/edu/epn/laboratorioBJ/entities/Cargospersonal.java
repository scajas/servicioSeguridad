package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargospersonal database table.
 * 
 */
@Entity
@NamedQuery(name="Cargospersonal.findAll", query="SELECT c FROM Cargospersonal c")
public class Cargospersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cargo")
	private String idCargo;

	@Column(name="descr_cp")
	private String descrCp;

	@Column(name="nombre_cp")
	private String nombreCp;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="cargospersonal")
	private List<PersonalLab> personals;

	public Cargospersonal() {
	}

	public String getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(String idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescrCp() {
		return this.descrCp;
	}

	public void setDescrCp(String descrCp) {
		this.descrCp = descrCp;
	}

	public String getNombreCp() {
		return this.nombreCp;
	}

	public void setNombreCp(String nombreCp) {
		this.nombreCp = nombreCp;
	}

	public List<PersonalLab> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<PersonalLab> personals) {
		this.personals = personals;
	}

	public PersonalLab addPersonal(PersonalLab personal) {
		getPersonals().add(personal);
		personal.setCargospersonal(this);

		return personal;
	}

	public PersonalLab removePersonal(PersonalLab personal) {
		getPersonals().remove(personal);
		personal.setCargospersonal(null);

		return personal;
	}

}