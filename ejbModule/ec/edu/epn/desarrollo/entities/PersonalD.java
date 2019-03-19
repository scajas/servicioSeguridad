package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personal database table.
 * 
 */
@Entity(name= "PersonalD")
@Table(name="personal", catalog="`bddcorpepn`", schema="`Desarrollo`")

@NamedQuery(name="PersonalD.findAll", query="SELECT p FROM PersonalD p")
public class PersonalD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String activo;

	private String apellidos;

	private String area;

	private String nced;

	private String nombres;

	public PersonalD() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNced() {
		return this.nced;
	}

	public void setNced(String nced) {
		this.nced = nced;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

}