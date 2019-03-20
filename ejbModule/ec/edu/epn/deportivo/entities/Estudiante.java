package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estudiantes database table.
 * 
 */
@Entity
@Table(name="estudiantes", catalog="`bddcorpepn`", schema="`Deportivo`")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estudiantes")
	private Integer idEstudiantes;

	@Column(name="cedula_estudiantes")
	private String cedulaEstudiantes;

	@Column(name="cod_estudiantes")
	private String codEstudiantes;

	@Column(name="nombres_estudiantes")
	private String nombresEstudiantes;

	//bi-directional many-to-many association to Planificacion
	@ManyToMany(mappedBy="estudiantes")
	private List<Planificacion> planificacions;

	public Estudiante() {
	}

	public Integer getIdEstudiantes() {
		return this.idEstudiantes;
	}

	public void setIdEstudiantes(Integer idEstudiantes) {
		this.idEstudiantes = idEstudiantes;
	}

	public String getCedulaEstudiantes() {
		return this.cedulaEstudiantes;
	}

	public void setCedulaEstudiantes(String cedulaEstudiantes) {
		this.cedulaEstudiantes = cedulaEstudiantes;
	}

	public String getCodEstudiantes() {
		return this.codEstudiantes;
	}

	public void setCodEstudiantes(String codEstudiantes) {
		this.codEstudiantes = codEstudiantes;
	}

	public String getNombresEstudiantes() {
		return this.nombresEstudiantes;
	}

	public void setNombresEstudiantes(String nombresEstudiantes) {
		this.nombresEstudiantes = nombresEstudiantes;
	}

	public List<Planificacion> getPlanificacions() {
		return this.planificacions;
	}

	public void setPlanificacions(List<Planificacion> planificacions) {
		this.planificacions = planificacions;
	}

}