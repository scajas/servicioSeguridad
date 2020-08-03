package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rangofuncionamiento database table.
 * 
 */
@Entity
@Table(name="rangofuncionamiento", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Rangofuncionamiento.findAll", query="SELECT r FROM Rangofuncionamiento r")
public class Rangofuncionamiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rangofunc")
	private Integer idRangofunc;

	@Column(name="unidad_rangofunc")
	private String unidadRangofunc;

	@Column(name="valormaximo_rangofunc")
	private Integer valormaximoRangofunc;

	@Column(name="valorminimo_rangofunc")
	private Integer valorminimoRangofunc;

	//bi-directional many-to-one association to Equiposcalibracionequipo
	@OneToMany(mappedBy="rangofuncionamiento")
	private List<Equiposcalibracionequipo> equiposcalibracionequipos;

	public Rangofuncionamiento() {
	}

	public Integer getIdRangofunc() {
		return this.idRangofunc;
	}

	public void setIdRangofunc(Integer idRangofunc) {
		this.idRangofunc = idRangofunc;
	}

	public String getUnidadRangofunc() {
		return this.unidadRangofunc;
	}

	public void setUnidadRangofunc(String unidadRangofunc) {
		this.unidadRangofunc = unidadRangofunc;
	}

	public Integer getValormaximoRangofunc() {
		return this.valormaximoRangofunc;
	}

	public void setValormaximoRangofunc(Integer valormaximoRangofunc) {
		this.valormaximoRangofunc = valormaximoRangofunc;
	}

	public Integer getValorminimoRangofunc() {
		return this.valorminimoRangofunc;
	}

	public void setValorminimoRangofunc(Integer valorminimoRangofunc) {
		this.valorminimoRangofunc = valorminimoRangofunc;
	}

	public List<Equiposcalibracionequipo> getEquiposcalibracionequipos() {
		return this.equiposcalibracionequipos;
	}

	public void setEquiposcalibracionequipos(List<Equiposcalibracionequipo> equiposcalibracionequipos) {
		this.equiposcalibracionequipos = equiposcalibracionequipos;
	}

	public Equiposcalibracionequipo addEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().add(equiposcalibracionequipo);
		equiposcalibracionequipo.setRangofuncionamiento(this);

		return equiposcalibracionequipo;
	}

	public Equiposcalibracionequipo removeEquiposcalibracionequipo(Equiposcalibracionequipo equiposcalibracionequipo) {
		getEquiposcalibracionequipos().remove(equiposcalibracionequipo);
		equiposcalibracionequipo.setRangofuncionamiento(null);

		return equiposcalibracionequipo;
	}

}