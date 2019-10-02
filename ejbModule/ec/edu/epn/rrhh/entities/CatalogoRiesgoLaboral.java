package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogo_riesgo_laboral database table.
 * 
 */
@Entity
@Table(name="catalogo_riesgo_laboral", catalog = "bddcorpepn", schema = "`Rrhh`")
@NamedQuery(name="CatalogoRiesgoLaboral.findAll", query="SELECT c FROM CatalogoRiesgoLaboral c")
public class CatalogoRiesgoLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	private String estado;

	private String nombre;

	private String tipo;

	//bi-directional many-to-many association to RiesgosLaborale
	@ManyToMany(mappedBy="catalogoRiesgoLaborals")
	private List<RiesgosLaborale> riesgosLaborales;

	public CatalogoRiesgoLaboral() {
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<RiesgosLaborale> getRiesgosLaborales() {
		return this.riesgosLaborales;
	}

	public void setRiesgosLaborales(List<RiesgosLaborale> riesgosLaborales) {
		this.riesgosLaborales = riesgosLaborales;
	}

}