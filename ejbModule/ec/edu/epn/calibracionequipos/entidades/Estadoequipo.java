package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadoequipo database table.
 * 
 */
@Entity
@Table(name="estadoequipo", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Estadoequipo.findAll", query="SELECT e FROM Estadoequipo e")
public class Estadoequipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadoequipo")
	private Integer idEstadoequipo;

	@Column(name="descripcion_estadoequipo")
	private String descripcionEstadoequipo;

	@Column(name="nombre_estadoequipo")
	private String nombreEstadoequipo;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy="estadoequipo")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	public Estadoequipo() {
	}

	public Integer getIdEstadoequipo() {
		return this.idEstadoequipo;
	}

	public void setIdEstadoequipo(Integer idEstadoequipo) {
		this.idEstadoequipo = idEstadoequipo;
	}

	public String getDescripcionEstadoequipo() {
		return this.descripcionEstadoequipo;
	}

	public void setDescripcionEstadoequipo(String descripcionEstadoequipo) {
		this.descripcionEstadoequipo = descripcionEstadoequipo;
	}

	public String getNombreEstadoequipo() {
		return this.nombreEstadoequipo;
	}

	public void setNombreEstadoequipo(String nombreEstadoequipo) {
		this.nombreEstadoequipo = nombreEstadoequipo;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setEstadoequipo(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setEstadoequipo(null);

		return equiposcalibracionequipo;
	}

}