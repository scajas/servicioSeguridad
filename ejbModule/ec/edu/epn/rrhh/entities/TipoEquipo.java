package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_equipo database table.
 * 
 */
@Entity
@Table(name="tipo_equipo", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="TipoEquipo.findAll", query="SELECT t FROM TipoEquipo t")
public class TipoEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo")
	private Integer idTipo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="tipoEquipo")
	private List<Equipo> equipos;

	public TipoEquipo() {
	}

	public Integer getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setTipoEquipo(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setTipoEquipo(null);

		return equipo;
	}

}