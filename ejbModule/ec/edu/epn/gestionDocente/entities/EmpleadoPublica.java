package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Emp;




/**
 * The persistent class for the empleado_publica database table.
 * 
 */
@Entity
@Table(name="empleado_publica", catalog = "bddcorpepn", schema = "`GestionDocente`")
public class EmpleadoPublica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String tipo;

	@ManyToOne
	@JoinColumn(name = "nced")
	private Emp emp;
	
	
	@ManyToOne
	@JoinColumn(name = "idpub")
	private Publicacione pub;
	
	
	
	public EmpleadoPublica() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Publicacione getPub() {
		return pub;
	}

	public void setPub(Publicacione pub) {
		this.pub = pub;
	}

}