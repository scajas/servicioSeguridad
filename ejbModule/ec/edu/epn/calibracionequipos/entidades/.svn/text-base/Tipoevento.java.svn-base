package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoevento database table.
 * 
 */
@Entity
@Table(name="tipoevento", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name="Tipoevento.findAll", query="SELECT t FROM Tipoevento t")
public class Tipoevento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipoevento")
	private Integer idTipoevento;

	@Column(name="descripcion_tipoevento")
	private String descripcionTipoevento;

	@Column(name="nombre_tipoevento")
	private String nombreTipoevento;

	//bi-directional many-to-one association to Incidentesaccidente
	@OneToMany(mappedBy="tipoevento")
	private List<Incidentesaccidente> incidentesaccidentes;

	public Tipoevento() {
	}

	public Integer getIdTipoevento() {
		return this.idTipoevento;
	}

	public void setIdTipoevento(Integer idTipoevento) {
		this.idTipoevento = idTipoevento;
	}

	public String getDescripcionTipoevento() {
		return this.descripcionTipoevento;
	}

	public void setDescripcionTipoevento(String descripcionTipoevento) {
		this.descripcionTipoevento = descripcionTipoevento;
	}

	public String getNombreTipoevento() {
		return this.nombreTipoevento;
	}

	public void setNombreTipoevento(String nombreTipoevento) {
		this.nombreTipoevento = nombreTipoevento;
	}

	public List<Incidentesaccidente> getIncidentesaccidentes() {
		return this.incidentesaccidentes;
	}

	public void setIncidentesaccidentes(List<Incidentesaccidente> incidentesaccidentes) {
		this.incidentesaccidentes = incidentesaccidentes;
	}

	public Incidentesaccidente addIncidentesaccidente(Incidentesaccidente incidentesaccidente) {
		getIncidentesaccidentes().add(incidentesaccidente);
		incidentesaccidente.setTipoevento(this);

		return incidentesaccidente;
	}

	public Incidentesaccidente removeIncidentesaccidente(Incidentesaccidente incidentesaccidente) {
		getIncidentesaccidentes().remove(incidentesaccidente);
		incidentesaccidente.setTipoevento(null);

		return incidentesaccidente;
	}

}