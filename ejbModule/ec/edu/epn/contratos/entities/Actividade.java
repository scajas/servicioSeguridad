package ec.edu.epn.contratos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividades database table.
 * 
 */
@Entity
@Table(name="actividades", catalog = "`bddcorpepn`", schema = "`Contratos`")
public class Actividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_actividad")
	private Integer idActividad;

	@Column(name="nombre_actividad")
	private String nombreActividad;

	@Column(name="num_horas_semana")
	private Integer numHorasSemana;
	
	
	private String nombreActividadCatedra;
	private Integer numHorasSemanaCatedra;
	
	

	public String getNombreActividadCatedra() {
		return nombreActividadCatedra;
	}

	public void setNombreActividadCatedra(String nombreActividadCatedra) {
		this.nombreActividadCatedra = nombreActividadCatedra;
	}

	public Integer getNumHorasSemanaCatedra() {
		return numHorasSemanaCatedra;
	}

	public void setNumHorasSemanaCatedra(Integer numHorasSemanaCatedra) {
		this.numHorasSemanaCatedra = numHorasSemanaCatedra;
	}

	//bi-directional many-to-one association to Pedido
    @ManyToOne
	@JoinColumn(name="id_pedido")
	private Pedido pedido;
    
    @Column(name = "carrera")
	private String carrera;

    public Actividade() {
    }

	public Integer getIdActividad() {
		return this.idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public Integer getNumHorasSemana() {
		return this.numHorasSemana;
	}

	public void setNumHorasSemana(Integer numHorasSemana) {
		this.numHorasSemana = numHorasSemana;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
}