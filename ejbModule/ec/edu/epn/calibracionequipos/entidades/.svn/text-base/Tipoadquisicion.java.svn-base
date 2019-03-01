package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoadquisicion database table.
 * 
 */
@Entity
@Table(name="tipoadquisicion", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipoadquisicion.findAll", query="SELECT t FROM Tipoadquisicion t")
public class Tipoadquisicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoadquisicion")
	private Integer idTipoadquisicion;

	@Column(name="nombre_tipoadquisicion")
	private String nombreTipoadquisicion;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy="tipoadquisicion")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	public Tipoadquisicion() {
	}

	public Integer getIdTipoadquisicion() {
		return this.idTipoadquisicion;
	}

	public void setIdTipoadquisicion(Integer idTipoadquisicion) {
		this.idTipoadquisicion = idTipoadquisicion;
	}

	public String getNombreTipoadquisicion() {
		return this.nombreTipoadquisicion;
	}

	public void setNombreTipoadquisicion(String nombreTipoadquisicion) {
		this.nombreTipoadquisicion = nombreTipoadquisicion;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setTipoadquisicion(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setTipoadquisicion(null);

		return equiposcalibracionequipo;
	}

}