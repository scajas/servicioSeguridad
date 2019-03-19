package ec.edu.epn.desarrollo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_requerimiento database table.
 * 
 */
@Entity
@Table(name="detalle_requerimiento", catalog="`bddcorpepn`", schema="`Desarrollo`")

@NamedQuery(name="DetalleRequerimiento.findAll", query="SELECT d FROM DetalleRequerimiento d")
public class DetalleRequerimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="f_entrega")
	private Date fEntrega;

	private Integer prioridad;

	@Column(name="tiempo_estimado")
	private String tiempoEstimado;

	private String tipo;

	//bi-directional many-to-one association to Requerimiento
	@ManyToOne
	@JoinColumn(name="id_req")
	private Requerimiento requerimiento;

	public DetalleRequerimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFEntrega() {
		return this.fEntrega;
	}

	public void setFEntrega(Date fEntrega) {
		this.fEntrega = fEntrega;
	}

	public Integer getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	public String getTiempoEstimado() {
		return this.tiempoEstimado;
	}

	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Requerimiento getRequerimiento() {
		return this.requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

}