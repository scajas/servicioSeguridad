package ec.edu.epn.rrhh.movimientos;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.rrhh.entities.Emp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the nominacion database table.
 * 
 */
@Entity
@Table(name = "habilitante_accion", catalog = "bddcorpepn", schema = "\"Rrhh\"")
@NamedQuery(name="HabilitanteAccion.findAll", query="SELECT n FROM HabilitanteAccion n")
public class HabilitanteAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_habilitante")
	private Integer idHabilitante;

	@Column(name="tipo_habilitante")
	private String tipoHabilitante;
	
	@Column(name="descripcion")
	private String descripcionHabilitante;

	@OneToMany(mappedBy = "habilitanteAccion")
	private List<AccionP> accionPs;

	
	public HabilitanteAccion() {
	}


	public Integer getIdHabilitante() {
		return idHabilitante;
	}


	public void setIdHabilitante(Integer idHabilitante) {
		this.idHabilitante = idHabilitante;
	}


	public String getTipoHabilitante() {
		return tipoHabilitante;
	}


	public void setTipoHabilitante(String tipoHabilitante) {
		this.tipoHabilitante = tipoHabilitante;
	}


	public String getDescripcionHabilitante() {
		return descripcionHabilitante;
	}


	public void setDescripcionHabilitante(String descripcionHabilitante) {
		this.descripcionHabilitante = descripcionHabilitante;
	}


	public List<AccionP> getAccionPs() {
		return accionPs;
	}


	public void setAccionPs(List<AccionP> accionPs) {
		this.accionPs = accionPs;
	}

	

}