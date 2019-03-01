package ec.edu.epn.calibracionequipos.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tiposlaboratorios database table.
 * 
 */
@Entity
@Table(name = "tiposlaboratorios", catalog = "bddcorpepn", schema = "`CalibracionEquipos`")
@NamedQuery(name = "Tiposlaboratorio.findAll", query = "SELECT t FROM Tiposlaboratorio t")
public class Tiposlaboratorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tipolab")
	private Integer idTipolab;

	@Column(name = "descripcion_tipolab")
	private String descripcionTipolab;

	@Column(name = "nombre_tipolab")
	private String nombreTipolab;

	// bi-directional many-to-one association to Laboratorioscalibracionequipo
	/*
	 * @OneToMany(mappedBy="tiposlaboratorio") private
	 * List<Laboratorioscalibracionequipo> laboratorioscalibracionequipos;
	 */

	@OneToMany(mappedBy = "tipoLabo")
	private List<TipoLaboLaboratorios> tipoLaboLaboratorio;

	public Tiposlaboratorio() {
	}

	public Integer getIdTipolab() {
		return this.idTipolab;
	}

	public void setIdTipolab(Integer idTipolab) {
		this.idTipolab = idTipolab;
	}

	public String getDescripcionTipolab() {
		return this.descripcionTipolab;
	}

	public void setDescripcionTipolab(String descripcionTipolab) {
		this.descripcionTipolab = descripcionTipolab;
	}

	public String getNombreTipolab() {
		return this.nombreTipolab;
	}

	public void setNombreTipolab(String nombreTipolab) {
		this.nombreTipolab = nombreTipolab;
	}

	/*
	 * public List<Laboratorioscalibracionequipo>
	 * getLaboratorioscalibracionequipos() { return
	 * this.laboratorioscalibracionequipos; }
	 * 
	 * public void
	 * setLaboratorioscalibracionequipos(List<Laboratorioscalibracionequipo>
	 * laboratorioscalibracionequipos) { this.laboratorioscalibracionequipos =
	 * laboratorioscalibracionequipos; }
	 * 
	 * public Laboratorioscalibracionequipo
	 * addLaboratorioscalibracionequipo(Laboratorioscalibracionequipo
	 * laboratorioscalibracionequipo) {
	 * getLaboratorioscalibracionequipos().add(laboratorioscalibracionequipo);
	 * laboratorioscalibracionequipo.setTiposlaboratorio(this);
	 * 
	 * return laboratorioscalibracionequipo; }
	 * 
	 * public Laboratorioscalibracionequipo
	 * removeLaboratorioscalibracionequipo(Laboratorioscalibracionequipo
	 * laboratorioscalibracionequipo) {
	 * getLaboratorioscalibracionequipos().remove(laboratorioscalibracionequipo)
	 * ; laboratorioscalibracionequipo.setTiposlaboratorio(null);
	 * 
	 * return laboratorioscalibracionequipo; }
	 */

}