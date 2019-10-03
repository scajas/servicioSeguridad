package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subactividad_preplanificacion database table.
 * 
 */
@Entity
@Table(name="subactividad_preplanificacion",catalog = "`bddcorpepn`", schema = "`GestionDocente`")
@NamedQuery(name="SubactividadPreplanificacion.findAll", query="SELECT s FROM SubactividadPreplanificacion s")
public class SubactividadPreplanificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_subactividad_preplanif")
	private Integer idSubactividadPreplanif;

	@Column(name="horas_preplanif")
	private double horasPreplanif;

	@Column(name="nombre_subactividad")
	private String nombreSubactividad;

	//bi-directional many-to-one association to ActividadPreplanificacion
	@ManyToOne
	@JoinColumn(name="id_actividad_preplanif")
	private ActividadPreplanificacion actividadPreplanificacion;

	public SubactividadPreplanificacion() {
	}

	public Integer getIdSubactividadPreplanif() {
		return this.idSubactividadPreplanif;
	}

	public void setIdSubactividadPreplanif(Integer idSubactividadPreplanif) {
		this.idSubactividadPreplanif = idSubactividadPreplanif;
	}

	public double getHorasPreplanif() {
		return this.horasPreplanif;
	}

	public void setHorasPreplanif(double horasPreplanif) {
		this.horasPreplanif = horasPreplanif;
	}

	public String getNombreSubactividad() {
		return this.nombreSubactividad;
	}

	public void setNombreSubactividad(String nombreSubactividad) {
		this.nombreSubactividad = nombreSubactividad;
	}

	public ActividadPreplanificacion getActividadPreplanificacion() {
		return this.actividadPreplanificacion;
	}

	public void setActividadPreplanificacion(ActividadPreplanificacion actividadPreplanificacion) {
		this.actividadPreplanificacion = actividadPreplanificacion;
	}

}