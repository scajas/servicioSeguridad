package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the solicitud_equipo database table.
 * 
 */
@Entity
@Table(name="solicitud_equipo")
@NamedQuery(name="SolicitudEquipo.findAll", query="SELECT s FROM SolicitudEquipo s")
public class SolicitudEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String ssolicitud;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="nced")
	private Emp emp;

	//bi-directional many-to-one association to EstadoSolicitud
	@ManyToOne
	@JoinColumn(name="id_estado")
	private EstadoSolicitud estadoSolicitud;

	public SolicitudEquipo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsolicitud() {
		return this.ssolicitud;
	}

	public void setSsolicitud(String ssolicitud) {
		this.ssolicitud = ssolicitud;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public EstadoSolicitud getEstadoSolicitud() {
		return this.estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

}