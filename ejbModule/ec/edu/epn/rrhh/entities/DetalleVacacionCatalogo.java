package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detalle_vacacion_catalogo database table.
 * 
 */
@Entity
@Table(name="detalle_vacacion_catalogo",catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="DetalleVacacionCatalogo.findAll", query="SELECT d FROM DetalleVacacionCatalogo d")
public class DetalleVacacionCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	private String estado;

	private String nombre;

	@OneToMany(mappedBy="iddetalleVacacionCatalogo")
	private List<Vaca> vacas;

	public DetalleVacacionCatalogo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Vaca> getVacas() {
		return this.vacas;
	}

	public void setVacas(List<Vaca> vacas) {
		this.vacas = vacas;
	}

	public Vaca addVaca(Vaca vaca) {
		getVacas().add(vaca);
		vaca.setIddetalleVacacionCatalogo(this);

		return vaca;
	}

	public Vaca removeVaca(Vaca vaca) {
		getVacas().remove(vaca);
		vaca.setIddetalleVacacionCatalogo(this);

		return vaca;
	}

}