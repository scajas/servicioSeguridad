package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalleequipoproteccionpersonal database table.
 * 
 */
@Entity
@Table(name="detalleequipoproteccionpersonal", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Detalleequipoproteccionpersonal.findAll", query="SELECT d FROM Detalleequipoproteccionpersonal d")
public class Detalleequipoproteccionpersonal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_detalleepp")
	private Integer idDetalleepp;

	private String detalleepp;

	//bi-directional many-to-one association to Equipoproteccionpersonal
	@ManyToOne
	@JoinColumn(name="id_epp")
	private Equipoproteccionpersonal equipoproteccionpersonal;

	public Detalleequipoproteccionpersonal() {
	}

	public Integer getIdDetalleepp() {
		return this.idDetalleepp;
	}

	public void setIdDetalleepp(Integer idDetalleepp) {
		this.idDetalleepp = idDetalleepp;
	}

	public String getDetalleepp() {
		return this.detalleepp;
	}

	public void setDetalleepp(String detalleepp) {
		this.detalleepp = detalleepp;
	}

	public Equipoproteccionpersonal getEquipoproteccionpersonal() {
		return this.equipoproteccionpersonal;
	}

	public void setEquipoproteccionpersonal(Equipoproteccionpersonal equipoproteccionpersonal) {
		this.equipoproteccionpersonal = equipoproteccionpersonal;
	}

}