package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the actividadescalibracionequipo database table.
 * 
 */
@Entity
@Table(name = "actividadescalibracionequipo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Actividadescalibracionequipo.findAll", query = "SELECT a FROM Actividadescalibracionequipo a")
public class Actividadescalibracionequipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_actividadlab")
	private Integer idActividadlab;

	@Column(name = "nombre_avtividadlab")
	private String nombreAvtividadlab;

	// bi-directional many-to-many association to Laboratorioscalibracionequipo
	@ManyToOne
	@JoinColumn(name = "id_laboratorio")
	private Laboratorioscalibracionequipo laboratorio;

	public Actividadescalibracionequipo() {
	}

	public Integer getIdActividadlab() {
		return this.idActividadlab;
	}

	public void setIdActividadlab(Integer idActividadlab) {
		this.idActividadlab = idActividadlab;
	}

	public String getNombreAvtividadlab() {
		return this.nombreAvtividadlab;
	}

	public void setNombreAvtividadlab(String nombreAvtividadlab) {
		this.nombreAvtividadlab = nombreAvtividadlab;
	}

	public Laboratorioscalibracionequipo getLaboratorioscalibracionequipos() {
		return this.laboratorio;
	}

	public void setLaboratorioscalibracionequipos(Laboratorioscalibracionequipo laboratorioscalibracionequipos) {
		this.laboratorio = laboratorioscalibracionequipos;
	}

}