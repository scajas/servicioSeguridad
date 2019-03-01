package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the incidentesaccidentes database table.
 * 
 */
@Entity
@Table(name="incidentesaccidentes", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Incidentesaccidente.findAll", query="SELECT i FROM Incidentesaccidente i")
public class Incidentesaccidente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_evento")
	private Integer idEvento;

	@Column(name="descripcion_evento")
	private String descripcionEvento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

	@Column(name="horariregularactividad_evento")
	private String horariregularactividadEvento;

	@Column(name="numeroafectados_evento")
	private Integer numeroafectadosEvento;

	//bi-directional many-to-one association to Laboratorioscalibracionequipo
	@ManyToOne
	@JoinColumn(name="id_laboratorio")
	private Laboratorioscalibracionequipo laboratorioscalibracionequipo;

	//bi-directional many-to-one association to Tipoevento
	@ManyToOne
	@JoinColumn(name="id_tipoevento")
	private Tipoevento tipoevento;

	//bi-directional many-to-one association to Involucrado
	@OneToMany(mappedBy="incidentesaccidente")
	private List<Involucrado> involucrados;

	public Incidentesaccidente() {
	}

	public Integer getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcionEvento() {
		return this.descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getHorariregularactividadEvento() {
		return this.horariregularactividadEvento;
	}

	public void setHorariregularactividadEvento(String horariregularactividadEvento) {
		this.horariregularactividadEvento = horariregularactividadEvento;
	}

	public Integer getNumeroafectadosEvento() {
		return this.numeroafectadosEvento;
	}

	public void setNumeroafectadosEvento(Integer numeroafectadosEvento) {
		this.numeroafectadosEvento = numeroafectadosEvento;
	}

	public Laboratorioscalibracionequipo getLaboratorioscalibracionequipo() {
		return this.laboratorioscalibracionequipo;
	}

	public void setLaboratorioscalibracionequipo(Laboratorioscalibracionequipo laboratorioscalibracionequipo) {
		this.laboratorioscalibracionequipo = laboratorioscalibracionequipo;
	}

	public Tipoevento getTipoevento() {
		return this.tipoevento;
	}

	public void setTipoevento(Tipoevento tipoevento) {
		this.tipoevento = tipoevento;
	}

	public List<Involucrado> getInvolucrados() {
		return this.involucrados;
	}

	public void setInvolucrados(List<Involucrado> involucrados) {
		this.involucrados = involucrados;
	}

	public Involucrado addInvolucrado(Involucrado involucrado) {
		getInvolucrados().add(involucrado);
		involucrado.setIncidentesaccidente(this);

		return involucrado;
	}

	public Involucrado removeInvolucrado(Involucrado involucrado) {
		getInvolucrados().remove(involucrado);
		involucrado.setIncidentesaccidente(null);

		return involucrado;
	}

}