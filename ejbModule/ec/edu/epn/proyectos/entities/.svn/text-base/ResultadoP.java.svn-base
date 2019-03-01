package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the resultados database table.
 * 
 */
@Entity
@Table(name="resultados", catalog = "bddcorpepn", schema = "`Proyectos`")
public class ResultadoP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resultado")
	private Integer idResultado;

	private String cumplio;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

    public ResultadoP() {
    }

	public Integer getIdResultado() {
		return this.idResultado;
	}

	public void setIdResultado(Integer idResultado) {
		this.idResultado = idResultado;
	}

	public String getCumplio() {
		return this.cumplio;
	}

	public void setCumplio(String cumplio) {
		this.cumplio = cumplio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProyectoP getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
}