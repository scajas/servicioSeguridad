package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cdetallado database table.
 * 
 */
@Entity
@Table(name="cdetallado", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Cdetallado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Cespecifico
    @ManyToOne
	@JoinColumn(name="id_cespecifico")
	private Cespecifico cespecifico;

    public Cdetallado() {
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

	public Cespecifico getCespecifico() {
		return this.cespecifico;
	}

	public void setCespecifico(Cespecifico cespecifico) {
		this.cespecifico = cespecifico;
	}
	
}