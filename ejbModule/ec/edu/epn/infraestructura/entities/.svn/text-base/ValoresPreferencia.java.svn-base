package ec.edu.epn.infraestructura.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the valores_preferencia database table.
 * 
 */
@Entity
@Table(name = "valores_preferencia", catalog = "bddcorpepn", schema = "`Infraestructura`")
public class ValoresPreferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_valor_preferencia")
	private Integer idValorPreferencia;

	@Column(name = "valor_preferencia")
	private String valorPreferencia;
	
	
	@Column(name = "descripcion_valor")
	private String descripcion;
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// bi-directional many-to-one association to PreferenciaHorario
	@OneToMany(mappedBy = "valoresPreferencia")
	private List<PreferenciaHorario> preferenciaHorarios;

	public ValoresPreferencia() {
	}

	public Integer getIdValorPreferencia() {
		return this.idValorPreferencia;
	}

	public void setIdValorPreferencia(Integer idValorPreferencia) {
		this.idValorPreferencia = idValorPreferencia;
	}

	public String getValorPreferencia() {
		return this.valorPreferencia;
	}

	public void setValorPreferencia(String valorPreferencia) {
		this.valorPreferencia = valorPreferencia;
	}

	public List<PreferenciaHorario> getPreferenciaHorarios() {
		return this.preferenciaHorarios;
	}

	public void setPreferenciaHorarios(
			List<PreferenciaHorario> preferenciaHorarios) {
		this.preferenciaHorarios = preferenciaHorarios;
	}

	public PreferenciaHorario addPreferenciaHorario(
			PreferenciaHorario preferenciaHorario) {
		getPreferenciaHorarios().add(preferenciaHorario);
		preferenciaHorario.setValoresPreferencia(this);

		return preferenciaHorario;
	}

	public PreferenciaHorario removePreferenciaHorario(
			PreferenciaHorario preferenciaHorario) {
		getPreferenciaHorarios().remove(preferenciaHorario);
		preferenciaHorario.setValoresPreferencia(null);

		return preferenciaHorario;
	}

}