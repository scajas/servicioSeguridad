package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cargo_administrativo database table.
 * 
 */
@Entity
@Table(name="cargo_administrativo")
@NamedQuery(name="CargoAdministrativo.findAll", query="SELECT c FROM CargoAdministrativo c")
public class CargoAdministrativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cargo_adm")
	private String idCargoAdm;

	@Column(name="cargo_adm")
	private String cargoAdm;

	public CargoAdministrativo() {
	}

	public String getIdCargoAdm() {
		return this.idCargoAdm;
	}

	public void setIdCargoAdm(String idCargoAdm) {
		this.idCargoAdm = idCargoAdm;
	}

	public String getCargoAdm() {
		return this.cargoAdm;
	}

	public void setCargoAdm(String cargoAdm) {
		this.cargoAdm = cargoAdm;
	}

}