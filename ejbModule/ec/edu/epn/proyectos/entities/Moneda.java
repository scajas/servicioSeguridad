package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the moneda database table.
 * 
 */
@Entity
@Table(name="moneda",catalog = "bddcorpepn", schema = "`Proyectos`")
public class Moneda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private double cambio;

	private String nombre;

	private String pais;

	private String sigla;

	//bi-directional many-to-one association to Fondoadicional
	@OneToMany(mappedBy="moneda")
	private List<Fondoadicional> fondoadicionals;

    public Moneda() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCambio() {
		return this.cambio;
	}

	public void setCambio(double cambio) {
		this.cambio = cambio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Fondoadicional> getFondoadicionals() {
		return this.fondoadicionals;
	}

	public void setFondoadicionals(List<Fondoadicional> fondoadicionals) {
		this.fondoadicionals = fondoadicionals;
	}
	
}