package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SubtipoCargo
 *
 */
@Entity
@Table(name = "subtipo_cargo", catalog = "bddcorpepn", schema = "\"Rrhh\"")
public class SubtipoCargo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idsubtipo")
	private Integer idSubtipoCargo;

	@Column(name = "nombre_subtipo")
	private String nombreSubtipoCargo;

	private String descripcion;

	// bi-directional many-to-one association to Cargosm
	@OneToMany(mappedBy = "subtipoCargo")
	private List<Cargosm> cargos;

	public Integer getIdSubtipoCargo() {
		return idSubtipoCargo;
	}

	public void setIdSubtipoCargo(Integer idSubtipoCargo) {
		this.idSubtipoCargo = idSubtipoCargo;
	}

	public String getNombreSubtipoCargo() {
		return nombreSubtipoCargo;
	}

	public void setNombreSubtipoCargo(String nombreSubtipoCargo) {
		this.nombreSubtipoCargo = nombreSubtipoCargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cargosm> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargosm> cargos) {
		this.cargos = cargos;
	}

	
}
