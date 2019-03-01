package ec.edu.epn.rrhh.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_solicitud database table.
 * 
 */
@Entity
@Table(name="estado_solicitud")
@NamedQuery(name="EstadoSolicitud.findAll", query="SELECT e FROM EstadoSolicitud e")
public class EstadoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to SolicitudEquipo
	@OneToMany(mappedBy="estadoSolicitud")
	private List<SolicitudEquipo> solicitudEquipos;

	public EstadoSolicitud() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SolicitudEquipo> getSolicitudEquipos() {
		return this.solicitudEquipos;
	}

	public void setSolicitudEquipos(List<SolicitudEquipo> solicitudEquipos) {
		this.solicitudEquipos = solicitudEquipos;
	}

	public SolicitudEquipo addSolicitudEquipo(SolicitudEquipo solicitudEquipo) {
		getSolicitudEquipos().add(solicitudEquipo);
		solicitudEquipo.setEstadoSolicitud(this);

		return solicitudEquipo;
	}

	public SolicitudEquipo removeSolicitudEquipo(SolicitudEquipo solicitudEquipo) {
		getSolicitudEquipos().remove(solicitudEquipo);
		solicitudEquipo.setEstadoSolicitud(null);

		return solicitudEquipo;
	}

}