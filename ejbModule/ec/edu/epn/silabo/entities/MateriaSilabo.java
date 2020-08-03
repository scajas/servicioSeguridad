package ec.edu.epn.silabo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the materia database table.
 * 
 */

@Entity(name = "MateriaSilabo")
@Table(name="materia", catalog = "`bddcorpepn`", schema = "`Silabo`" )
@NamedQuery(name="MateriaSilabo.findAll", query="SELECT m FROM MateriaSilabo m")
public class MateriaSilabo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String codigo;

	private String nombre;
	
	private String   grupo;

	public MateriaSilabo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}