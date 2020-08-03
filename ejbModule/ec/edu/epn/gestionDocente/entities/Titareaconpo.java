package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the titareaconpos database table.
 * 
 */
@Entity
@Table(name="titareaconpos")
@NamedQuery(name="Titareaconpo.findAll", query="SELECT t FROM Titareaconpo t")
public class Titareaconpo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codarea1;

	private String codarea2;

	@Id
	private String id;

	private String nced;

	private String nombre;

	private String s1;

	private String si2;

	public Titareaconpo() {
	}

	public String getCodarea1() {
		return this.codarea1;
	}

	public void setCodarea1(String codarea1) {
		this.codarea1 = codarea1;
	}

	public String getCodarea2() {
		return this.codarea2;
	}

	public void setCodarea2(String codarea2) {
		this.codarea2 = codarea2;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getS1() {
		return this.s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getSi2() {
		return this.si2;
	}

	public void setSi2(String si2) {
		this.si2 = si2;
	}

}