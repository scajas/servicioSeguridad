package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nominacion_catalogo database table.
 * 
 */
@Entity
@Table(name="nominacion_catalogo",catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="NominacionCatalogo.findAll", query="SELECT n FROM NominacionCatalogo n")
public class NominacionCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Nominacion
	@OneToMany(mappedBy="nominacionCatalogo")
	private List<Nominacion> nominacions;

	public NominacionCatalogo() {
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

	public List<Nominacion> getNominacions() {
		return this.nominacions;
	}

	public void setNominacions(List<Nominacion> nominacions) {
		this.nominacions = nominacions;
	}

	public Nominacion addNominacion(Nominacion nominacion) {
		getNominacions().add(nominacion);
		nominacion.setNominacionCatalogo(this);

		return nominacion;
	}

	public Nominacion removeNominacion(Nominacion nominacion) {
		getNominacions().remove(nominacion);
		nominacion.setNominacionCatalogo(null);

		return nominacion;
	}

}