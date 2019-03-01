package ec.edu.epn.proyectos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the monto_ejecutado database table.
 * 
 */
@Entity

@Table(name = "monto_ejecutado",catalog = "bddcorpepn", schema = "`Proyectos`")
public class MontoEjecutado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer anio;

	@ManyToOne
	@JoinColumn(name = "id_proy")
	private ProyectoP proyecto;

	private double monto,planificado;
	
	public MontoEjecutado() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public ProyectoP getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoP proyecto) {
		this.proyecto = proyecto;
	}

	public double getPlanificado() {
		return planificado;
	}

	public void setPlanificado(double planificado) {
		this.planificado = planificado;
	}

}