package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the lineasinvestigacion database table.
 * 
 */
@Entity
@Table(name = "lineasinvestigacion", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Lineasinvestigacion.findAll", query = "SELECT l FROM Lineasinvestigacion l")
public class Lineasinvestigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_lineainvestigacion")
	private Integer idLineainvestigacion;

	@Column(name = "nombre_lineainvestigacion")
	private String nombreLineainvestigacion;

	// bi-directional many-to-many association to Laboratorioscalibracionequipo
	@OneToMany(mappedBy = "linInvs")
	private List<LabLinInv> lablinv;

	public List<LabLinInv> getLablinv() {
		return lablinv;
	}

	public void setLablinv(List<LabLinInv> lablinv) {
		this.lablinv = lablinv;
	}

	public Lineasinvestigacion() {
	}

	public Integer getIdLineainvestigacion() {
		return this.idLineainvestigacion;
	}

	public void setIdLineainvestigacion(Integer idLineainvestigacion) {
		this.idLineainvestigacion = idLineainvestigacion;
	}

	public String getNombreLineainvestigacion() {
		return this.nombreLineainvestigacion;
	}

	public void setNombreLineainvestigacion(String nombreLineainvestigacion) {
		this.nombreLineainvestigacion = nombreLineainvestigacion;
	}

}