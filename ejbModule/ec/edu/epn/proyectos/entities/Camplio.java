package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the camplio database table.
 * 
 */
@Entity
@Table(name="camplio", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Camplio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Cespecifico
	@OneToMany(mappedBy="camplio")
	private List<Cespecifico> cespecificos;

    public Camplio() {
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

	public List<Cespecifico> getCespecificos() {
		return this.cespecificos;
	}

	public void setCespecificos(List<Cespecifico> cespecificos) {
		this.cespecificos = cespecificos;
	}
	
}