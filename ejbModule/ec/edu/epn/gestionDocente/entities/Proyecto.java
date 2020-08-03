package ec.edu.epn.gestionDocente.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proy")
	private String idProy;

	@Column(name="descripcion_proy")
	private String descripcionProy;

	@Column(name="estado_proy")
	private String estadoProy;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_proy")
	private Date fechaFinProy;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_proy")
	private Date fechaInicioProy;

	@Column(name="horas_semestre_proy")
	private Integer horasSemestreProy;

	@Column(name="id_tipo_proy")
	private String idTipoProy;

	@Column(name="presupuesto_proy")
	private double presupuestoProy;

	@Column(name="titulo_proy")
	private String tituloProy;

	public Proyecto() {
	}

	public String getIdProy() {
		return this.idProy;
	}

	public void setIdProy(String idProy) {
		this.idProy = idProy;
	}

	public String getDescripcionProy() {
		return this.descripcionProy;
	}

	public void setDescripcionProy(String descripcionProy) {
		this.descripcionProy = descripcionProy;
	}

	public String getEstadoProy() {
		return this.estadoProy;
	}

	public void setEstadoProy(String estadoProy) {
		this.estadoProy = estadoProy;
	}

	public Date getFechaFinProy() {
		return this.fechaFinProy;
	}

	public void setFechaFinProy(Date fechaFinProy) {
		this.fechaFinProy = fechaFinProy;
	}

	public Date getFechaInicioProy() {
		return this.fechaInicioProy;
	}

	public void setFechaInicioProy(Date fechaInicioProy) {
		this.fechaInicioProy = fechaInicioProy;
	}

	public Integer getHorasSemestreProy() {
		return this.horasSemestreProy;
	}

	public void setHorasSemestreProy(Integer horasSemestreProy) {
		this.horasSemestreProy = horasSemestreProy;
	}

	public String getIdTipoProy() {
		return this.idTipoProy;
	}

	public void setIdTipoProy(String idTipoProy) {
		this.idTipoProy = idTipoProy;
	}

	public double getPresupuestoProy() {
		return this.presupuestoProy;
	}

	public void setPresupuestoProy(double presupuestoProy) {
		this.presupuestoProy = presupuestoProy;
	}

	public String getTituloProy() {
		return this.tituloProy;
	}

	public void setTituloProy(String tituloProy) {
		this.tituloProy = tituloProy;
	}

}