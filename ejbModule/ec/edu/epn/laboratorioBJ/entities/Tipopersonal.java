package ec.edu.epn.laboratorioBJ.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipopersonal database table.
 * 
 */
@Entity
@Table(name = "tipopersonal", catalog = "bddcorpepn", schema = "`Laboratorios`")
@NamedQuery(name="Tipopersonal.findAll", query="SELECT t FROM Tipopersonal t")
public class Tipopersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipopersonal")
	private String idTipopersonal;

	@Column(name="descr_tp")
	private String descrTp;

	@Column(name="nombre_tp")
	private String nombreTp;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="tipopersonal")
	private List<PersonalLab> personals;

	public Tipopersonal() {
	}

	public String getIdTipopersonal() {
		return this.idTipopersonal;
	}

	public void setIdTipopersonal(String idTipopersonal) {
		this.idTipopersonal = idTipopersonal;
	}

	public String getDescrTp() {
		return this.descrTp;
	}

	public void setDescrTp(String descrTp) {
		this.descrTp = descrTp;
	}

	public String getNombreTp() {
		return this.nombreTp;
	}

	public void setNombreTp(String nombreTp) {
		this.nombreTp = nombreTp;
	}

	public List<PersonalLab> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<PersonalLab> personals) {
		this.personals = personals;
	}

	public PersonalLab addPersonal(PersonalLab personal) {
		getPersonals().add(personal);
		personal.setTipopersonal(this);

		return personal;
	}

	public PersonalLab removePersonal(PersonalLab personal) {
		getPersonals().remove(personal);
		personal.setTipopersonal(null);

		return personal;
	}

}