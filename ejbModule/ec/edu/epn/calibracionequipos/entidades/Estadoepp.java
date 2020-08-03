package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadoepp database table.
 * 
 */
@Entity
@Table(name="estadoepp", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Estadoepp.findAll", query="SELECT e FROM Estadoepp e")
public class Estadoepp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadoepp")
	private Integer idEstadoepp;

	@Column(name="nombre_esatdoepp")
	private String nombreEsatdoepp;

	//bi-directional many-to-one association to Equipoproteccionpersonal
	@OneToMany(mappedBy="estadoepp")
	private List<Equipoproteccionpersonal> equipoproteccionpersonals;

	public Estadoepp() {
	}

	public Integer getIdEstadoepp() {
		return this.idEstadoepp;
	}

	public void setIdEstadoepp(Integer idEstadoepp) {
		this.idEstadoepp = idEstadoepp;
	}

	public String getNombreEsatdoepp() {
		return this.nombreEsatdoepp;
	}

	public void setNombreEsatdoepp(String nombreEsatdoepp) {
		this.nombreEsatdoepp = nombreEsatdoepp;
	}

	public List<Equipoproteccionpersonal> getEquipoproteccionpersonals() {
		return this.equipoproteccionpersonals;
	}

	public void setEquipoproteccionpersonals(List<Equipoproteccionpersonal> equipoproteccionpersonals) {
		this.equipoproteccionpersonals = equipoproteccionpersonals;
	}

	public Equipoproteccionpersonal addEquipoproteccionpersonal(Equipoproteccionpersonal equipoproteccionpersonal) {
		getEquipoproteccionpersonals().add(equipoproteccionpersonal);
		equipoproteccionpersonal.setEstadoepp(this);

		return equipoproteccionpersonal;
	}

	public Equipoproteccionpersonal removeEquipoproteccionpersonal(Equipoproteccionpersonal equipoproteccionpersonal) {
		getEquipoproteccionpersonals().remove(equipoproteccionpersonal);
		equipoproteccionpersonal.setEstadoepp(null);

		return equipoproteccionpersonal;
	}

}