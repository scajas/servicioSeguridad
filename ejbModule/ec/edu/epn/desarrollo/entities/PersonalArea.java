package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Emp;


/**
 * The persistent class for the personal_area database table.
 * 
 */
@Entity
@Table(name="personal_area", catalog="`bddcorpepn`", schema="`Desarrollo`")


@NamedQuery(name="PersonalArea.findAll", query="SELECT p FROM PersonalArea p")
public class PersonalArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String activo;

	
	
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp empleado;

	//bi-directional many-to-one association to DgipArea
	@ManyToOne
	@JoinColumn(name="id_area")
	private DgipArea dgipArea;

	public PersonalArea() {
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

	

	public DgipArea getDgipArea() {
		return this.dgipArea;
	}

	public void setDgipArea(DgipArea dgipArea) {
		this.dgipArea = dgipArea;
	}

	public Emp getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Emp empleado) {
		this.empleado = empleado;
	}
	

}