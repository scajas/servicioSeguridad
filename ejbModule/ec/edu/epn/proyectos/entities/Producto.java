package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name = "producto", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String carrera;

	private String codtesis;

	private String estado;

	private String estuadiante;

	private Integer idpensum;



	private String meses;

	private String titulo;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idproyecto")
	private ProyectoP proyecto;

	public Producto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCodtesis() {
		return this.codtesis;
	}

	public void setCodtesis(String codtesis) {
		this.codtesis = codtesis;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstuadiante() {
		return this.estuadiante;
	}

	public void setEstuadiante(String estuadiante) {
		this.estuadiante = estuadiante;
	}

	public Integer getIdpensum() {
		return this.idpensum;
	}

	public void setIdpensum(Integer idpensum) {
		this.idpensum = idpensum;
	}

	

	public String getMeses() {
		return this.meses;
	}

	public void setMeses(String meses) {
		this.meses = meses;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	

}