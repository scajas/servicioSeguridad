package ec.edu.epn.convenios.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the autoridad database table.
 * 
 */
@Entity
@Table(name="autoridad", catalog = "`bddcorpepn`", schema = "`Convenios`")
public class Autoridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_autoridad")
	private Integer idAutoridad;

	@Column(name="cargo_au")
	private String cargoAu;

	@Column(name="estado_au")
	private String estadoAu;

	@Column(name="mail_au")
	private String mailAu;

	@Column(name="nombre_au")
	private String nombreAu;

	@Column(name="telefono_au")
	private String telefonoAu;

	//bi-directional many-to-one association to Convenio
	@OneToMany(mappedBy="autoridad")
	private List<Convenio> convenios;

    public Autoridad() {
    }

	public Integer getIdAutoridad() {
		return this.idAutoridad;
	}

	public void setIdAutoridad(Integer idAutoridad) {
		this.idAutoridad = idAutoridad;
	}

	public String getCargoAu() {
		return this.cargoAu;
	}

	public void setCargoAu(String cargoAu) {
		this.cargoAu = cargoAu;
	}

	public String getEstadoAu() {
		return this.estadoAu;
	}

	public void setEstadoAu(String estadoAu) {
		this.estadoAu = estadoAu;
	}

	public String getMailAu() {
		return this.mailAu;
	}

	public void setMailAu(String mailAu) {
		this.mailAu = mailAu;
	}

	public String getNombreAu() {
		return this.nombreAu;
	}

	public void setNombreAu(String nombreAu) {
		this.nombreAu = nombreAu;
	}

	public String getTelefonoAu() {
		return this.telefonoAu;
	}

	public void setTelefonoAu(String telefonoAu) {
		this.telefonoAu = telefonoAu;
	}

	public List<Convenio> getConvenios() {
		return this.convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}
	
}