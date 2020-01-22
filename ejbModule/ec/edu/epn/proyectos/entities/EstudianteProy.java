package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the estudiante database table.
 * 
 */
@Entity
@Table(name="estudiante", catalog = "bddcorpepn", schema = "`Proyectos`")
@NamedQuery(name="EstudianteProy.findAll", query="SELECT e FROM EstudianteProy e")
public class EstudianteProy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String carrera;

	private String cedula;

	private String codigo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_desvincula")
	private Date fechaDesvincula;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vincula")
	private Date fechaVincula;
	
	//bi-directional many-to-one association to Proyecto
    @ManyToOne
	@JoinColumn(name="id_proy")
	private ProyectoP proyecto;

	

	private String nombre;

	//bi-directional many-to-one association to Avanceestud
	@OneToMany(mappedBy="estudiante")
	private List<Avanceestud> avanceestuds;

	public EstudianteProy() {
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

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaDesvincula() {
		return this.fechaDesvincula;
	}

	public void setFechaDesvincula(Date fechaDesvincula) {
		this.fechaDesvincula = fechaDesvincula;
	}

	public Date getFechaVincula() {
		return this.fechaVincula;
	}

	public void setFechaVincula(Date fechaVincula) {
		this.fechaVincula = fechaVincula;
	}



	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Avanceestud> getAvanceestuds() {
		return this.avanceestuds;
	}

	public void setAvanceestuds(List<Avanceestud> avanceestuds) {
		this.avanceestuds = avanceestuds;
	}

	public Avanceestud addAvanceestud(Avanceestud avanceestud) {
		getAvanceestuds().add(avanceestud);
		avanceestud.setEstudiante(this);

		return avanceestud;
	}

	public Avanceestud removeAvanceestud(Avanceestud avanceestud) {
		getAvanceestuds().remove(avanceestud);
		avanceestud.setEstudiante(null);

		return avanceestud;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}
	
	

}