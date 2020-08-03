package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_espacio database table.
 * 
 */
@Entity
@Table(name = "tipo_espacio", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class TipoEspacio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipo_espacio")
	private Integer idTipoEspacio;

	@Column(name = "costo_t_espacio")
	private double costoTEspacio;

	@Column(name = "descripcion_t_espacio")
	private String descripcionTEspacio;

	@Column(name = "nom_tipo_espacio")
	private String nomTipoEspacio;

	@OneToMany(mappedBy = "tipoEspacio")
	private List<Sesione> sesiones;

	public List<Sesione> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesione> sesiones) {
		this.sesiones = sesiones;
	}

	// bi-directional many-to-one association to Espacio
	@OneToMany(mappedBy = "tipoEspacio")
	private Set<Espacio> espacios;

	public TipoEspacio() {
	}

	public Integer getIdTipoEspacio() {
		return this.idTipoEspacio;
	}

	public void setIdTipoEspacio(Integer idTipoEspacio) {
		this.idTipoEspacio = idTipoEspacio;
	}

	public double getCostoTEspacio() {
		return this.costoTEspacio;
	}

	public void setCostoTEspacio(double costoTEspacio) {
		this.costoTEspacio = costoTEspacio;
	}

	public String getDescripcionTEspacio() {
		return this.descripcionTEspacio;
	}

	public void setDescripcionTEspacio(String descripcionTEspacio) {
		this.descripcionTEspacio = descripcionTEspacio;
	}

	public String getNomTipoEspacio() {
		return this.nomTipoEspacio;
	}

	public void setNomTipoEspacio(String nomTipoEspacio) {
		this.nomTipoEspacio = nomTipoEspacio;
	}

	public Set<Espacio> getEspacios() {
		return this.espacios;
	}

	public void setEspacios(Set<Espacio> espacios) {
		this.espacios = espacios;
	}

}