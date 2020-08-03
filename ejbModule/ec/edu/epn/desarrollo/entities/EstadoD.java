package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado database table.
 * 
 */
@Entity(name="EstadoD")
@Table(name="estado", catalog="`bddcorpepn`", schema="`Desarrollo`")

@NamedQuery(name="EstadoD.findAll", query="SELECT e FROM EstadoD e")
public class EstadoD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	public EstadoD() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}