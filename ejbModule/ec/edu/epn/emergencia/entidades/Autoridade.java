package ec.edu.epn.emergencia.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the autoridades database table.
 * 
 */

@Entity
@Table(name="autoridades", catalog = "bddcorpepn", schema = "\"Emergencia\"")
@NamedQuery(name="Autoridade.findAll", query="SELECT a FROM Autoridade a")
public class Autoridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cargo_autoridad")
	private String cargoAutoridad;

	private String estado;
	
	@Id
	@Column(name="id_autoridad")
	private Integer idAutoridad;

	@Column(name="nombre_autoridad")
	private String nombreAutoridad;

	private String identificacion;
	
	public Autoridade() {
	}

	public String getCargoAutoridad() {
		return this.cargoAutoridad;
	}

	public void setCargoAutoridad(String cargoAutoridad) {
		this.cargoAutoridad = cargoAutoridad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdAutoridad() {
		return this.idAutoridad;
	}

	public void setIdAutoridad(Integer idAutoridad) {
		this.idAutoridad = idAutoridad;
	}

	public String getNombreAutoridad() {
		return this.nombreAutoridad;
	}

	public void setNombreAutoridad(String nombreAutoridad) {
		this.nombreAutoridad = nombreAutoridad;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
}