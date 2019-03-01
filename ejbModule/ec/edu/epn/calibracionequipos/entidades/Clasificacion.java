package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clasificacion database table.
 * 
 */
@Entity
@Table(name="clasificacion", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Clasificacion.findAll", query="SELECT c FROM Clasificacion c")
public class Clasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_clasificacion")
	private Integer idClasificacion;

	@Column(name="nombre_clasificacion")
	private String nombreClasificacion;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy="clasificacion")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	public Clasificacion() {
	}

	public Integer getIdClasificacion() {
		return this.idClasificacion;
	}

	public void setIdClasificacion(Integer idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	public String getNombreClasificacion() {
		return this.nombreClasificacion;
	}

	public void setNombreClasificacion(String nombreClasificacion) {
		this.nombreClasificacion = nombreClasificacion;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setClasificacion(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setClasificacion(null);

		return equiposcalibracionequipo;
	}

}