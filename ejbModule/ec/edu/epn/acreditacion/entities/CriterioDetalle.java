package ec.edu.epn.acreditacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the criterio_detalle database table.
 * 
 */
@Entity
@Table(name="criterio_detalle", catalog="`bddcorpepn`", schema="`Acreditacion`")
@NamedQuery(name="CriterioDetalle.findAll", query="SELECT c FROM CriterioDetalle c")
public class CriterioDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"Acreditacion\".sec_criterio_detalle")
	@SequenceGenerator(name = "\"Acreditacion\".sec_criterio_detalle", sequenceName = "\"Acreditacion\".sec_criterio_detalle", allocationSize = 1)
	@Column(name="id_criterio_detalle")
	private Integer idCriterioDetalle;

	private double calificacion;

	@Column(name="id_carrera")
	private String idCarrera;

	@Column(name="id_criterio")
	private Integer idCriterio;

	@Column(name="id_pensum")
	private Integer idPensum;

	//bi-directional many-to-one association to SubcriterioDetalle
	@OneToMany(mappedBy="criterioDetalle")
	private List<SubcriterioDetalle> subcriterioDetalles;

	public CriterioDetalle() {
	}

	public Integer getIdCriterioDetalle() {
		return this.idCriterioDetalle;
	}

	public void setIdCriterioDetalle(Integer idCriterioDetalle) {
		this.idCriterioDetalle = idCriterioDetalle;
	}

	public double getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public String getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Integer getIdCriterio() {
		return this.idCriterio;
	}

	public void setIdCriterio(Integer idCriterio) {
		this.idCriterio = idCriterio;
	}

	public Integer getIdPensum() {
		return this.idPensum;
	}

	public void setIdPensum(Integer idPensum) {
		this.idPensum = idPensum;
	}

	public List<SubcriterioDetalle> getSubcriterioDetalles() {
		return this.subcriterioDetalles;
	}

	public void setSubcriterioDetalles(List<SubcriterioDetalle> subcriterioDetalles) {
		this.subcriterioDetalles = subcriterioDetalles;
	}

	public SubcriterioDetalle addSubcriterioDetalle(SubcriterioDetalle subcriterioDetalle) {
		getSubcriterioDetalles().add(subcriterioDetalle);
		subcriterioDetalle.setCriterioDetalle(this);

		return subcriterioDetalle;
	}

	public SubcriterioDetalle removeSubcriterioDetalle(SubcriterioDetalle subcriterioDetalle) {
		getSubcriterioDetalles().remove(subcriterioDetalle);
		subcriterioDetalle.setCriterioDetalle(null);

		return subcriterioDetalle;
	}

}