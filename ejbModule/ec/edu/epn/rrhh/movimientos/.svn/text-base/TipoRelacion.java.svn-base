package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.TipoRelacionXcargo;

import java.util.List;


/**
 * The persistent class for the tipo_relacion database table.
 * 
 */
@Entity
@Table(name = "tipo_relacion", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="TipoRelacion.findAll", query="SELECT t FROM TipoRelacion t")
public class TipoRelacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tr")
	private Integer idTr;

	@Column(name="nombre_tr")
	private String nombreTr;
	
	private String descripcion;
	
	private String estado;

	//bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy="tipoRelacion")
	private List<HistoriaLaboral> historiaLaborals;
	
	//bi-directional many-to-one association to TipoRelacionXcargo
	@OneToMany(mappedBy="tipoRelacion")
	private List<TipoRelacionXcargo> tipoRelacionXcargos;

	public List<TipoRelacionXcargo> getTipoRelacionXcargos() {
		return tipoRelacionXcargos;
	}

	public void setTipoRelacionXcargos(List<TipoRelacionXcargo> tipoRelacionXcargos) {
		this.tipoRelacionXcargos = tipoRelacionXcargos;
	}
	
	public TipoRelacionXcargo addTipoRelacionXcargo(TipoRelacionXcargo tipoRelacionXcargo) {
		getTipoRelacionXcargos().add(tipoRelacionXcargo);
		tipoRelacionXcargo.setTipoRelacion(this);

		return tipoRelacionXcargo;
	}

	public TipoRelacionXcargo removeTipoRelacionXcargo(TipoRelacionXcargo tipoRelacionXcargo) {
		getTipoRelacionXcargos().remove(tipoRelacionXcargo);
		tipoRelacionXcargo.setTipoRelacion(null);

		return tipoRelacionXcargo;
	}

	public TipoRelacion() {
	}

	public Integer getIdTr() {
		return this.idTr;
	}

	public void setIdTr(Integer idTr) {
		this.idTr = idTr;
	}

	public String getNombreTr() {
		return this.nombreTr;
	}

	public void setNombreTr(String nombreTr) {
		this.nombreTr = nombreTr;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setTipoRelacion(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setTipoRelacion(null);

		return historiaLaboral;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}