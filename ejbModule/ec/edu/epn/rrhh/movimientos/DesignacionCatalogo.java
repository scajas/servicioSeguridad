package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the designacion_catalogo database table.
 * 
 */
@Entity
@Table(name = "designacion_catalogo", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="DesignacionCatalogo.findAll", query="SELECT d FROM DesignacionCatalogo d")
public class DesignacionCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_catalogo")
	private Integer idCatalogo;

	private String descripcion;

	private String estado;

	private String nombre;

	@Column(name="rmu_designacion")
	private double rmuDesignacion;
	
	@Column(name="grupo_designacion")
	private String grupoDesignacion;

	//bi-directional many-to-one association to Designacion
	@OneToMany(mappedBy="designacionCatalogo")
	private List<Designacion> designacions;

	public DesignacionCatalogo() {
	}

	public Integer getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getRmuDesignacion() {
		return this.rmuDesignacion;
	}

	public void setRmuDesignacion(double rmuDesignacion) {
		this.rmuDesignacion = rmuDesignacion;
	}

	public List<Designacion> getDesignacions() {
		return this.designacions;
	}

	public void setDesignacions(List<Designacion> designacions) {
		this.designacions = designacions;
	}
	

	public String getGrupoDesignacion() {
		return grupoDesignacion;
	}

	public void setGrupoDesignacion(String grupoDesignacion) {
		this.grupoDesignacion = grupoDesignacion;
	}

	public Designacion addDesignacion(Designacion designacion) {
		getDesignacions().add(designacion);
		designacion.setDesignacionCatalogo(this);

		return designacion;
	}

	public Designacion removeDesignacion(Designacion designacion) {
		getDesignacions().remove(designacion);
		designacion.setDesignacionCatalogo(null);

		return designacion;
	}

}