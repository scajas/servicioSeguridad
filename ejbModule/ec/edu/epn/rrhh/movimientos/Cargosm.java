package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.TipoRelacionXcargo;

import java.util.List;


/**
 * The persistent class for the cargosm database table.
 * 
 */
@Entity
@Table(name = "cargosm", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="Cargosm.findAll", query="SELECT c FROM Cargosm c")
public class Cargosm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cargo")
	private Integer idCargo;

	private String dedicacion;

	private String estado;

	private String experiencia;

	private String funcion;

	private String grupo;

	@Column(name="nivel_estudios")
	private String nivelEstudios;

	@Column(name="nombre_cargo")
	private String nombreCargo;
	//wqeqweq
	
	@Column(name="horas")
	private Integer horas;

	private Double   remun;

	//bi-directional many-to-one association to HistoriaLaboral
	@OneToMany(mappedBy="cargosm")
	private List<HistoriaLaboral> historiaLaborals;
	
	//bi-directional many-to-one association to TipoRelacionXcargo
	@OneToMany(mappedBy="cargosm")
	private List<TipoRelacionXcargo> tipoRelacionXcargos;
	
	
	
	public List<TipoRelacionXcargo> getTipoRelacionXcargos() {
		return tipoRelacionXcargos;
	}

	public void setTipoRelacionXcargos(List<TipoRelacionXcargo> tipoRelacionXcargos) {
		this.tipoRelacionXcargos = tipoRelacionXcargos;
	}
	
	public TipoRelacionXcargo addTipoRelacionXcargo(TipoRelacionXcargo tipoRelacionXcargo) {
		getTipoRelacionXcargos().add(tipoRelacionXcargo);
		tipoRelacionXcargo.setCargosm(this);

		return tipoRelacionXcargo;
	}

	public TipoRelacionXcargo removeTipoRelacionXcargo(TipoRelacionXcargo tipoRelacionXcargo) {
		getTipoRelacionXcargos().remove(tipoRelacionXcargo);
		tipoRelacionXcargo.setCargosm(null);

		return tipoRelacionXcargo;
	}

	public Cargosm() {
	}

	public Integer getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getDedicacion() {
		return this.dedicacion;
	}

	public void setDedicacion(String dedicacion) {
		this.dedicacion = dedicacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getFuncion() {
		return this.funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNivelEstudios() {
		return this.nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public Double getRemun() {
		return this.remun;
	}

	public void setRemun(Double remun) {
		this.remun = remun;
	}
	

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public List<HistoriaLaboral> getHistoriaLaborals() {
		return this.historiaLaborals;
	}

	public void setHistoriaLaborals(List<HistoriaLaboral> historiaLaborals) {
		this.historiaLaborals = historiaLaborals;
	}

	public HistoriaLaboral addHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().add(historiaLaboral);
		historiaLaboral.setCargosm(this);

		return historiaLaboral;
	}

	public HistoriaLaboral removeHistoriaLaboral(HistoriaLaboral historiaLaboral) {
		getHistoriaLaborals().remove(historiaLaboral);
		historiaLaboral.setCargosm(null);

		return historiaLaboral;
	}

}