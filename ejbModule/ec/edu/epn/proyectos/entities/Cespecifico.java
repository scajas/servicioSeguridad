package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the cespecifico database table.
 * 
 */
@Entity
@Table(name="cespecifico", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Cespecifico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Cdetallado
	@OneToMany(mappedBy="cespecifico")
	private List<Cdetallado> cdetallados;

	//bi-directional many-to-one association to Camplio
    @ManyToOne
	@JoinColumn(name="id_camplio")
	private Camplio camplio;

    public Cespecifico() {
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

	public List<Cdetallado> getCdetallados() {
		return this.cdetallados;
	}

	public void setCdetallados(List<Cdetallado> cdetallados) {
		this.cdetallados = cdetallados;
	}
	
	public Camplio getCamplio() {
		return this.camplio;
	}

	public void setCamplio(Camplio camplio) {
		this.camplio = camplio;
	}
	
}