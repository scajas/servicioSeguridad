package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medidacontrol database table.
 * 
 */
@Entity
@Table(name="medidacontrol", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Medidacontrol.findAll", query="SELECT m FROM Medidacontrol m")
public class Medidacontrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_medidacontrol")
	private Integer idMedidacontrol;

	@Column(name="nombre_medidacontrol")
	private String nombreMedidacontrol;

	//bi-directional many-to-many association to Indicepotencial
	@ManyToMany
	@JoinTable(
		name="indpmedidac"
		, joinColumns={
			@JoinColumn(name="id_medidacontrol")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_indicepotencial")
			}
		)
	private List<Indicepotencial> indicepotencials;

	public Medidacontrol() {
	}

	public Integer getIdMedidacontrol() {
		return this.idMedidacontrol;
	}

	public void setIdMedidacontrol(Integer idMedidacontrol) {
		this.idMedidacontrol = idMedidacontrol;
	}

	public String getNombreMedidacontrol() {
		return this.nombreMedidacontrol;
	}

	public void setNombreMedidacontrol(String nombreMedidacontrol) {
		this.nombreMedidacontrol = nombreMedidacontrol;
	}

	public List<Indicepotencial> getIndicepotencials() {
		return this.indicepotencials;
	}

	public void setIndicepotencials(List<Indicepotencial> indicepotencials) {
		this.indicepotencials = indicepotencials;
	}

}