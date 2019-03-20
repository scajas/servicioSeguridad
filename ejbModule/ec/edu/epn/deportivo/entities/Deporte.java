package ec.edu.epn.deportivo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the deporte database table.
 * 
 */
@Entity
@Table(name="deporte", catalog="`bddcorpepn`", schema="`Deportivo`")
@NamedQuery(name="Deporte.findAll", query="SELECT d FROM Deporte d")
public class Deporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_deporte")
	private Integer idDeporte;

	@Column(name="descripcion_deporte")
	private String descripcionDeporte;

	@Column(name="nombre_deporte")
	private String nombreDeporte;

	//bi-directional many-to-one association to Planificacion
	@OneToMany(mappedBy="deporte")
	private List<Planificacion> planificacions;

	public Deporte() {
	}

	public Integer getIdDeporte() {
		return this.idDeporte;
	}

	public void setIdDeporte(Integer idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getDescripcionDeporte() {
		return this.descripcionDeporte;
	}

	public void setDescripcionDeporte(String descripcionDeporte) {
		this.descripcionDeporte = descripcionDeporte;
	}

	public String getNombreDeporte() {
		return this.nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	public List<Planificacion> getPlanificacions() {
		return this.planificacions;
	}

	public void setPlanificacions(List<Planificacion> planificacions) {
		this.planificacions = planificacions;
	}

	public Planificacion addPlanificacion(Planificacion planificacion) {
		getPlanificacions().add(planificacion);
		planificacion.setDeporte(this);

		return planificacion;
	}

	public Planificacion removePlanificacion(Planificacion planificacion) {
		getPlanificacions().remove(planificacion);
		planificacion.setDeporte(null);

		return planificacion;
	}

}