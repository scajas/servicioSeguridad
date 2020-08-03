package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the informeobservaciones database table.
 * 
 */
@Entity
@Table(name = "informeobservaciones", catalog = "bddcorpepn", schema = "`Proyectos`")
public class Informeobservacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "id_proy")
	private ProyectoP proyecto;

	private String memo;

	private String observaciones;

	public Informeobservacione() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

}