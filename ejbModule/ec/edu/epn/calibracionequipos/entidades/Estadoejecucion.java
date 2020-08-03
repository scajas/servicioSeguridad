package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estadoejecucion database table.
 * 
 */
@Entity
@Table(name="estadoejecucion", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Estadoejecucion.findAll", query="SELECT e FROM Estadoejecucion e")
public class Estadoejecucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_estadoejecucion")
	private Integer idEstadoejecucion;

	@Column(name="descripcion_estadoejecucion")
	private String descripcionEstadoejecucion;

	@Column(name="nombre_estadoejecucion")
	private String nombreEstadoejecucion;

	//bi-directional many-to-one association to Detalleplan
	@OneToMany(mappedBy="estadoejecucion")
	private List<Detalleplan> detalleplans;

	public Estadoejecucion() {
	}

	public Integer getIdEstadoejecucion() {
		return this.idEstadoejecucion;
	}

	public void setIdEstadoejecucion(Integer idEstadoejecucion) {
		this.idEstadoejecucion = idEstadoejecucion;
	}

	public String getDescripcionEstadoejecucion() {
		return this.descripcionEstadoejecucion;
	}

	public void setDescripcionEstadoejecucion(String descripcionEstadoejecucion) {
		this.descripcionEstadoejecucion = descripcionEstadoejecucion;
	}

	public String getNombreEstadoejecucion() {
		return this.nombreEstadoejecucion;
	}

	public void setNombreEstadoejecucion(String nombreEstadoejecucion) {
		this.nombreEstadoejecucion = nombreEstadoejecucion;
	}

	public List<Detalleplan> getDetalleplans() {
		return this.detalleplans;
	}

	public void setDetalleplans(List<Detalleplan> detalleplans) {
		this.detalleplans = detalleplans;
	}

	public Detalleplan addDetalleplan(Detalleplan detalleplan) {
		getDetalleplans().add(detalleplan);
		detalleplan.setEstadoejecucion(this);

		return detalleplan;
	}

	public Detalleplan removeDetalleplan(Detalleplan detalleplan) {
		getDetalleplans().remove(detalleplan);
		detalleplan.setEstadoejecucion(null);

		return detalleplan;
	}

}