package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidadepp database table.
 * 
 */
@Entity
@Table(name="unidadepp", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Unidadepp.findAll", query="SELECT u FROM Unidadepp u")
public class Unidadepp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_unidadepp")
	private Integer idUnidadepp;

	@Column(name="nombre_unidadepp")
	private String nombreUnidadepp;

	//bi-directional many-to-one association to Equipoproteccionpersonal
	@OneToMany(mappedBy="unidadepp")
	private List<Equipoproteccionpersonal> equipoproteccionpersonals;

	public Unidadepp() {
	}

	public Integer getIdUnidadepp() {
		return this.idUnidadepp;
	}

	public void setIdUnidadepp(Integer idUnidadepp) {
		this.idUnidadepp = idUnidadepp;
	}

	public String getNombreUnidadepp() {
		return this.nombreUnidadepp;
	}

	public void setNombreUnidadepp(String nombreUnidadepp) {
		this.nombreUnidadepp = nombreUnidadepp;
	}

	public List<Equipoproteccionpersonal> getEquipoproteccionpersonals() {
		return this.equipoproteccionpersonals;
	}

	public void setEquipoproteccionpersonals(List<Equipoproteccionpersonal> equipoproteccionpersonals) {
		this.equipoproteccionpersonals = equipoproteccionpersonals;
	}

	public Equipoproteccionpersonal addEquipoproteccionpersonal(Equipoproteccionpersonal equipoproteccionpersonal) {
		getEquipoproteccionpersonals().add(equipoproteccionpersonal);
		equipoproteccionpersonal.setUnidadepp(this);

		return equipoproteccionpersonal;
	}

	public Equipoproteccionpersonal removeEquipoproteccionpersonal(Equipoproteccionpersonal equipoproteccionpersonal) {
		getEquipoproteccionpersonals().remove(equipoproteccionpersonal);
		equipoproteccionpersonal.setUnidadepp(null);

		return equipoproteccionpersonal;
	}

}