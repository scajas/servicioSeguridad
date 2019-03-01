package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_infraestructura database table.
 * 
 */
@Entity
@Table(name = "tipo_infraestructura", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class TipoInfraestructura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipoinfra")
	private Integer idTipoinfra;

	@Column(name = "nombre_infraestructura")
	private String nombreInfraestructura;

	@OneToMany(mappedBy = "tipoInfraestructura")
	private List<EdificioInfra> edificios;

	public List<EdificioInfra> getEdificios() {
		return edificios;
	}

	public void setEdificios(List<EdificioInfra> edificios) {
		this.edificios = edificios;
	}

	public TipoInfraestructura() {
	}

	public Integer getIdTipoinfra() {
		return this.idTipoinfra;
	}

	public void setIdTipoinfra(Integer idTipoinfra) {
		this.idTipoinfra = idTipoinfra;
	}

	public String getNombreInfraestructura() {
		return this.nombreInfraestructura;
	}

	public void setNombreInfraestructura(String nombreInfraestructura) {
		this.nombreInfraestructura = nombreInfraestructura;
	}

}